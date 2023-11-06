import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;
import java.util.ArrayList;

/**
 * The knight is a tower that slashes at multiple enemies.
 * 
 * @author SJonas
 * @version 2023-11-06
 */
public class Knight extends Tower
{
    // Constants for gameplay
    private static final int ATTACK_RANGE_X = 75;
    private static final int ATTACK_RANGE_Y = 40;
    private static final int ATTACK_COOLDOWN = 75;
    private static final int PROJECTILE_SPEED = 2;
    private static final int ATTACK_BOOST = 2;
    private static final int SPEED_BOOST = 10;
    private static final int AOE_BOOST = 1;
    private static final int RANGE_BOOST = 15;
    private static final Enemy[] IMMUNE_ENEMIES = {
            new Bat(),
            new EnragedBat(),
            new Ghost(),
            new EnragedGhost()
        };

    // Constants for the shop/upgrade menu
    private static final GreenfootImage TITLE_IMAGE = new GreenfootImage("Title-knight.png");
    private static final int[] STATS = {3, 3, 1, 3};
    private static final int PRICE = 200;
    private static final String DESCRIPTION = "The Knight, a master swordsman. Uses it's sword to slash down it's enemies in a large area.";
    private static final int BASE_DISPLACEMENT_X = 0;
    private static final int BASE_DISPLACEMENT_Y = -15;
    private static final int SHOP_DISPLACEMENT_X = 0;
    private static final int SHOP_DISPLACEMENT_Y = 0;
    private static final int UPGRADE_MENU_TYPE = 2;

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
     * Advances the attack timer and when it's time slashes towards an enemy in range of the knight.
     */
    private void attack()
    {
        if (attackTimer >= ATTACK_COOLDOWN - (SPEED_BOOST * upgradeLevels[1]))
        {
            Enemy enemy = checkRange();
            if (enemy != null)
            {
                Greenfoot.playSound("Knight.mp3");
                
                int rotation = getAttackDirection(enemy);
                Slash slash = new Slash(this, new Vector(rotation, PROJECTILE_SPEED), getX(), getY());
                getWorld().addObject(slash, getX(), getY());
                slash.setRotation(rotation);
                slash.move();
                
                attackTimer = 0;
            }
        }
        else
        {
            attackTimer++;
        }
    }
    
    /**
     * Returns the direction, in degrees, in which the knight has to attack.
     */
    @Override
    public int getAttackDirection(Enemy enemy)
    {
        return (enemy.getX() < getX()) ? 180 : 0;
    }

    /**
     * Returns the x attack range of the knight.
     */
    @Override
    public int getAttackRangeX() { return ATTACK_RANGE_X; }

    /**
     * Returns the y attack range of the knight.
     */
    @Override
    public int getAttackRangeY() { return ATTACK_RANGE_Y + (RANGE_BOOST * upgradeLevels[2]); }

    /**
     * Returns the upgrade levels of the knight.
     */
    @Override
    public int[] getUpgradeLevels() { return upgradeLevels; }

    /**
     * Returns the attack boost of the knight.
     */
    @Override
    public int getAttackBoost() { return ATTACK_BOOST; }

    /**
     * Returns the area of effect boost of the knight.
     */
    public int getAoeBoost() { return AOE_BOOST; }

    /**
     * Returns the immune enemies of the knight.
     */
    public Enemy[] getImmuneEnemies() { return IMMUNE_ENEMIES; }

    /**
     * Returns the title image of the knight.
     */
    @Override
    public GreenfootImage getTitleImage() { return TITLE_IMAGE; }

    /**
     * Returns the stats of the knight.
     */
    @Override
    public int[] getStats() { return STATS; }

    /**
     * Returns the price of the knight.
     */
    @Override
    public int getPrice() { return PRICE; }

    /**
     * Returns the description of the knight.
     */
    @Override
    public String getDescription() { return DESCRIPTION; }

    /**
     * Returns the x base displacement of the knight.
     */
    @Override
    public int getBaseDisplacementX() { return BASE_DISPLACEMENT_X; }

    /**
     * Returns the y base displacement of the knight.
     */
    @Override
    public int getBaseDisplacementY() { return BASE_DISPLACEMENT_Y; }

    /**
     * Returns the x shop displacement of the knight.
     */
    @Override
    public int getShopDisplacementX() { return SHOP_DISPLACEMENT_X; }

    /**
     * Returns the y shop displacement of the knight.
     */
    @Override
    public int getShopDisplacementY() { return SHOP_DISPLACEMENT_Y; }

    /**
     * Returns the upgrade menu type of the knight.
     */
    @Override
    public int getUpgradeMenuType() { return UPGRADE_MENU_TYPE; }
}