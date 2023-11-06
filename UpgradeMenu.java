import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Upgrade menu for towers.
 * 
 * @author SJonas
 * @version 2023-11-04
 */
public class UpgradeMenu extends Actor
{
    private static final int[] UPGRADE_PRICES = {100, 250, 500};
    private Tower activeTower;

    /**
     * Constructs the upgrade menu and dispays the correct upgrade menu type.
     */
    public UpgradeMenu(Tower activeTower)
    {
        this.activeTower = activeTower;
        setImage("UpgradeMenu-" + activeTower.getUpgradeMenuType() + ".png");
    }

    /**
     * Constantly renders the upgrade menu on top of all other objects and checks if it has been clicked.
     */
    public void act()
    {
        loadMenuInfo();
        clicked();
    }

    /**
     * Checks whether the upgrade menu was clicked and then what button was clicked.
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
                activeTower.setActive(false);
                world.removeObject(this);
            }
            else if (mouseX >= 473 && mouseX <= 519 && mouseY >= 317 && mouseY <= 339) // Clicked SELL button
            {
                sell();
            }
            else // Clicked UPGRADE ONE, TWO, or THREE button
            {
                for (int i = 0; i < activeTower.getUpgradeLevels().length; i++) {
                    if (mouseX >= 216 && mouseX <= 238 && mouseY >= 169 + (i * 58) && mouseY <= 191 + (i * 58) && activeTower.getUpgradeLevels()[i] < 3 && canAfford(i))
                    {
                        Coins coins = getWorld().getObjects(Coins.class).get(0);
                        coins.remove(UPGRADE_PRICES[activeTower.getUpgradeLevels()[i]]);
                        activeTower.getUpgradeLevels()[i]++;
                        activeTower.setActive(false);
                        world.removeObject(this);
                    }
                }
            }
        }
    }

    /**
     * Loads the information of the upgrade menu.
     */
    private void loadMenuInfo() 
    {
        GreenfootImage image = new GreenfootImage("UpgradeMenu-" + activeTower.getUpgradeMenuType() + ".png");

        for (int i = 0; i < activeTower.getUpgradeLevels().length; i++) {
            if (activeTower.getUpgradeLevels()[i] < 3)
            {
                image.drawImage(new GreenfootImage("Coin.png"), 300, 54 + (i * 59));
                image.drawString("" + UPGRADE_PRICES[activeTower.getUpgradeLevels()[i]], 317, 66 + (i * 59));
            }
            else
            {
                image.drawImage(new GreenfootImage("Maxed.png"), 35, 49 + (i * 59));
            }
        }
        setImage(image);
    }

    /**
     * Determines whether the player can afford to buy the tower, returns true if yes and false if not.
     */
    private boolean canAfford(int upgradeIndex)
    {
        int coins = getWorld().getObjects(Coins.class).get(0).getCoins();
        int price = UPGRADE_PRICES[activeTower.getUpgradeLevels()[upgradeIndex]];    
        return coins >= price;
    }

    /**
     * Sells the active tower.
     */
    private void sell() 
    {
        Coins coins = getWorld().getObjects(Coins.class).get(0);
        int cost = activeTower.getPrice();
        for (int level : activeTower.getUpgradeLevels())
        {
            switch (level)
            {
                case 3:
                    cost += UPGRADE_PRICES[2];
                case 2:
                    cost += UPGRADE_PRICES[1];
                case 1:
                    cost += UPGRADE_PRICES[0];
            }
        }

        coins.add(Math.round(cost * 3 / 4));
        activeTower.setActive(false); 
        getWorld().removeObject(activeTower);
        getWorld().removeObject(this);
    }
    
    /**
     * Renders the upgrade menu on top of all other objects.
     */
    private void renderOnTop()
    {
        int x = getX();
        int y = getY();
        World world = getWorld();
        world.removeObject(this);
        world.addObject(this, x, y);
        loadMenuInfo();
    }
}