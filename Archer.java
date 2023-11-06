import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;

/**
 * The archer is a tower that fires at enemies anywhere.
 * 
 * @author SJonas
 * @version 2023-11-06
 */
public class Archer extends Tower
{
    // Constants for gameplay
    private static final int ATTACK_RANGE_X = 1000;
    private static final int ATTACK_RANGE_Y = 1000;
    private static final int ATTACK_COOLDOWN = 150;
    private static final int PROJECTILE_SPEED = 15;
    private static final int ATTACK_BOOST = 4;
    private static final int SPEED_BOOST = 25;
    private static final int PROJECTILE_SPEED_BOOST = 10;
    private static final Enemy[] IMMUNE_ENEMIES = {
            new Ghost(),
            new EnragedGhost()
        };

    // Constants for the shop/upgrade menu
    private static final GreenfootImage TITLE_IMAGE = new GreenfootImage("Title-archer.png");
    private static final int[] STATS = {5, 1, 5, 1};
    private static final int PRICE = 300;
    private static final String DESCRIPTION = "The Marksman, a master archer. Uses it's bow to shoot down it's enemies anywhere on the map.";
    private static final int BASE_DISPLACEMENT_X = 3;
    private static final int BASE_DISPLACEMENT_Y = -17;
    private static final int SHOP_DISPLACEMENT_X = 14;
    private static final int SHOP_DISPLACEMENT_Y = 0;
    private static final int UPGRADE_MENU_TYPE = 1;

    private int attackTimer = 0;
    private int[] upgradeLevels = {0, 0, 0};

    /**
     * Checks whether it's time to attack then if there are any enemies in the towers range and attacks them if there are.
     */
    public void act()
    {
        attack();
        clicked();
    }

    /**
     * Advances the attack timer and when it's time fires an arrow towards an enemy in range of the archer.
     */
    private void attack()
    {
        if (attackTimer >= ATTACK_COOLDOWN - (SPEED_BOOST * upgradeLevels[1]))
        {
            Enemy enemy = checkRange();
            if (enemy != null)
            {
                Greenfoot.playSound("Archer.mp3");
                
                int rotation = getAttackDirection(enemy);
                Arrow arrow = new Arrow(this, new Vector(rotation, PROJECTILE_SPEED + (PROJECTILE_SPEED_BOOST * upgradeLevels[2])), getX(), getY());
                getWorld().addObject(arrow, 0, 0);
                arrow.setRotation(rotation);
                arrow.move();
                
                attackTimer = 0;
            }
        }
        else
        {
            attackTimer++;
        }
    }

    /**
     * Returns the x attack range of the archer.
     */
    @Override
    public int getAttackRangeX() { return ATTACK_RANGE_X; }

    /**
     * Returns the y attack range of the archer.
     */
    @Override
    public int getAttackRangeY() { return ATTACK_RANGE_Y; }

    /**
     * Returns the upgrade levels of the archer.
     */
    @Override
    public int[] getUpgradeLevels() { return upgradeLevels; }

    /**
     * Returns the attack boost of the archer.
     */
    @Override
    public int getAttackBoost() { return ATTACK_BOOST; }

    /**
     * Returns the area of attack of the rogue.
     */
    @Override
    public int getAoeBoost() { return 0; }

    /**
     * Returns the immune enemies of the archer.
     */
    public Enemy[] getImmuneEnemies() { return IMMUNE_ENEMIES; }

    /**
     * Returns the title image of the archer.
     */
    @Override
    public GreenfootImage getTitleImage() { return TITLE_IMAGE; }

    /**
     * Returns the stats of the archer.
     */
    @Override
    public int[] getStats() { return STATS; }

    /**
     * Returns the price of the archer.
     */
    @Override
    public int getPrice() { return PRICE; }

    /**
     * Returns the description of the archer.
     */
    @Override
    public String getDescription() { return DESCRIPTION; }

    /**
     * Returns the x base displacement of the archer.
     */
    @Override
    public int getBaseDisplacementX() { return BASE_DISPLACEMENT_X; }

    /**
     * Returns the y base displacement of the archer.
     */
    @Override

    public int getBaseDisplacementY() { return BASE_DISPLACEMENT_Y; }

    /**
     * Returns the x shop displacement of the archer.
     */
    @Override
    public int getShopDisplacementX() { return SHOP_DISPLACEMENT_X; }

    /**
     * Returns the y shop displacement of the archer.
     */
    @Override

    public int getShopDisplacementY() { return SHOP_DISPLACEMENT_Y; }

    /**
     * Returns the upgrade menu type of the archer.
     */
    @Override
    public int getUpgradeMenuType() { return UPGRADE_MENU_TYPE; }
}
