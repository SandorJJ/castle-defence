import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;
import java.util.Map;

/**
 * A book that contains information about each enemy.
 * 
 * @author SJonas
 * @version 2023-11-01
 */
public class MonsterBook extends Actor
{
    // A map to determine the monster based on the open page
    private static final Map<Integer, Enemy> PAGE_TO_ENEMY = Map.of(
        0, new Slime(),
        1, new Wolf(),
        2, new Bat(),
        3, new Ghost()
    );
    // A list of all stat types
    private static final String[] STAT_TYPES = {"HP", "ATK", "SPD"};
    // The max length of the tower description lines
    private static final int LINE_LENGTH = 30;
    
    private int page = 0;
    
    /**
     * Constructs the object and loads the information of the first page.
     */
    public MonsterBook()
    {
        loadPageInfo();
    }
    
    /**
     * Constantly renders the monster book on top of all other objects and checks if it was clicked and then what button was clicked.
     */
    public void act()
    {
        renderOnTop();
        clicked();
    }
    
    /**
     * Checks whether the monster book was clicked and then what button was clicked.
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
                world.removeObject(this);
            }
            else if (mouseX >= 515 && mouseX <= 534 && mouseY >= 229 && mouseY <= 250) // Clicked NEXT button
            {
                if (page + 1 == PAGE_TO_ENEMY.size())
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
                    page = PAGE_TO_ENEMY.size() - 1;
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
        setImage("MonsterBook.png");
        
        // Chooses which tower's information to load
        Enemy enemy = PAGE_TO_ENEMY.get(page);
        
        GreenfootImage image = getImage();
        
        // Load tower image to the page
        GreenfootImage enemyImage = new GreenfootImage(enemy.getImage());
        int scaleX = enemy.getImage().getWidth() * 3 / 2;
        int scaleY = enemy.getImage().getHeight() * 3 / 2;
        enemyImage.scale(scaleX, scaleY);
        image.drawImage(enemyImage, 54 + enemy.getMonsterBookDisplacementX(), 54 + enemy.getMonsterBookDisplacementY());
        
        // Load tower name to the page
        image.drawImage(enemy.getTitleImage(), 40, 20);
        
        // Load price to the page
        image.drawString("" + enemy.getCoinDrop(), 320, 215);
        
        // Load coin to the page
        image.drawImage(new GreenfootImage("Coin.png"), 303, 203);
        
        // Load stat types to the page
        for (int i = 0; i < STAT_TYPES.length; i++)
        {
            image.drawString(STAT_TYPES[i] + ":", 43, 140 + (20 * i));
        }
        
        // Load stat bars to the page
        for (int i = 0; i < enemy.getStats().length; i++)
        {
            image.drawImage(new GreenfootImage("Bar-" + enemy.getStats()[i] + ".png"), 75, 128 + (20 * i));
        }
        
        // Load tower description to the page
        for (int i = 0; i < formatText(enemy.getDescription()).size(); i++)
        {
            getImage().drawString(formatText(enemy.getDescription()).get(i), 138, 50 + (15 * i));
        }
    }
    
    /**
     * Renders the monster book on top of all other objects.
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
}