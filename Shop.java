import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;
import java.util.ArrayList;
import java.util.Map;

/**
 * The shop where towers are purchased.
 * 
 * @author SJonas
 * @version 2023-11-01
 */
public class Shop extends Actor
{
    // A map to determine the tower based on the open page
    private static final Map<Integer, Tower> PAGE_TO_TOWER = Map.of(
        0, new Rogue(),
        1, new Knight(),
        2, new Archer(),
        3, new Mage()
    );
    // A list of all stat types
    private static final String[] STAT_TYPES = {"ATK", "SPD", "RNG", "AoE"};
    // The max length of the tower description lines
    private static final int LINE_LENGTH = 30;
    
    private int page = 0;
    private Base activeBase;
    
    /**
     * Constructs the shop and loads the information on the first page.
     */
    public Shop(Base activeBase)
    {
        this.activeBase = activeBase;
        loadPageInfo();
    }
    
    /**
     * Constantly renders the shop on top of all other objects and checks if it was clicked.
     */
    public void act()
    {
        renderOnTop();
        clicked();
    }

    /**
     * Checks whether the shop was clicked and then what button was clicked.
     */
    private void clicked()
    {
        if (Greenfoot.mouseClicked(this))
        {
            World world = getWorld();

            int mouseX = Greenfoot.getMouseInfo().getX();
            int mouseY = Greenfoot.getMouseInfo().getY();

            if (mouseX >= 510 && mouseX <= 534 && mouseY >= 126 && mouseY <= 148) // Clicked CLOSE button
            {
                activeBase.setActive(false);
                world.removeObject(this);
            }
            else if (mouseX >= 453 && mouseX <= 514 && // Clicked BUY button
            mouseY >= 305 && mouseY <= 334) 
            {
                if (canAfford())
                {                    
                    buildTower(activeBase);
                    activeBase.setActive(false);
                    activeBase.setTaken(true);
                    world.removeObject(this);
                }
            }
            else if (mouseX >= 515 && mouseX <= 534 && mouseY >= 229 && mouseY <= 250) // Clicked NEXT button
            {
                if (page + 1 == PAGE_TO_TOWER.size())
                {
                    page = 0; 
                }
                else
                {
                    page++;
                }
                loadPageInfo();
            } 
            else if (mouseX <= 205 && mouseX >= 185 && mouseY >= 229 && mouseY <= 249) // Clicked PREVIOUS button
            {
                if (page - 1 == -1)
                {
                    page = PAGE_TO_TOWER.size() - 1;
                }
                else
                {
                    page--;
                }
                loadPageInfo();
            }
        }
    }

    /**
     * Loads the info of the shop page, tower image, stat bars and stat names, price.
     */
    private void loadPageInfo()
    {
        // Resets the image so there is no overlap of information
        setImage("Shop.png");
        
        // Chooses which tower's information to load
        Tower tower = PAGE_TO_TOWER.get(page);
        
        GreenfootImage image = getImage();
        
        // Load tower image to the page
        GreenfootImage towerImage = new GreenfootImage(tower.getImage());
        int scaleX = tower.getImage().getWidth() * 3 / 2;
        int scaleY = tower.getImage().getHeight() * 3 / 2;
        towerImage.scale(scaleX, scaleY);
        image.drawImage(towerImage, 54 + tower.getShopDisplacementX(), 54 + tower.getShopDisplacementY());
        // Load tower name to the page
        image.drawImage(tower.getTitleImage(), 40, 20);
        // Load price to the page
        image.drawString("" + tower.getPrice(), 245, 205);
        // Load coin to the page
        image.drawImage(new GreenfootImage("Coin.png"), 228, 193);
        // Load stat bars to the page
        for (int i = 0; i < tower.getStats().length; i++)
        {
            image.drawImage(new GreenfootImage("Bar-" + tower.getStats()[i] + ".png"), 75, 128 + (20 * i));
        }
        // Load stat types to the page
        for (int i = 0; i < STAT_TYPES.length; i++)
        {
            image.drawString(STAT_TYPES[i] + ":", 43, 140 + (20 * i));
        }
        // Load tower description to the page
        for (int i = 0; i < formatText(tower.getDescription()).size(); i++)
        {
            getImage().drawString(formatText(tower.getDescription()).get(i), 138, 50 + (15 * i));
        }
    }

    /**
     * Determines which tower to build and builds it on top of the base that opened the shop.
     */
    private void buildTower(Base base)
    {
        Coins coins = getWorld().getObjects(Coins.class).get(0);
        
        Tower tower = null;
        try{
            tower = PAGE_TO_TOWER.get(page).getClass().newInstance();
        } catch(Exception e)
        {
            e.printStackTrace();
        }
        
        getWorld().addObject(tower, base.getX() + tower.getBaseDisplacementX(), base.getY() + tower.getBaseDisplacementY());
        coins.remove(tower.getPrice());     
    }
    
    /**
     * Formats the text passed in to be split into lines that can fit onto the shop.
     */
    private ArrayList<String> formatText(String text)
    {
        ArrayList<String> lines = new ArrayList<>();
        
        String[] words = text.split(" ");
        String line = "";
        for (int i = 0; i < words.length; i++)
        {
            if ((line + words[i]).length() < LINE_LENGTH)
            {
                line += words[i] + " ";
            }
            else
            {
                lines.add(line.trim());
                line = "";
                i--;
            }
        }
        lines.add(line.trim());
        
        return lines;
    }
    
    /**
     * Determines whether the player can afford to buy the tower, returns true if yes and false if not.
     */
    private boolean canAfford()
    {
        int coins = getWorld().getObjects(Coins.class).get(0).getCoins();
        int price = PAGE_TO_TOWER.get(page).getPrice();    
        return coins >= price;
    }
    
    /**
     * Renders the shop on top of all other objects.
     */
    private void renderOnTop()
    {
        int x = getX();
        int y = getY();
        World world = getWorld();
        world.removeObject(this);
        world.addObject(this, x, y);
        loadPageInfo();
    }
}