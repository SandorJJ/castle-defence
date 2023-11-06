import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;

/**
 * The rogue is a tower that quickly shoots rocks at enemies.
 * 
 * @author SJonas
 * @version 2023-11-06
 */
public class Rogue extends Tower
{
    // Constants for gameplay
    private static final int ATTACK_RANGE_X = 75;
    private static final int ATTACK_RANGE_Y = 50;
    private static final int ATTACK_COOLDOWN = 50;
    private static final int PROJECTILE_SPEED = 3;
    private static final int ATTACK_BOOST = 1;
    private static final int SPEED_BOOST = 6;
    private static final int RANGE_BOOST = 15;
    private static final Enemy[] IMMUNE_ENEMIES = {
            new Ghost(),
            new EnragedGhost()
        };

    // Constants for the shop/upgrade menu
    private static final GreenfootImage TITLE_IMAGE = new GreenfootImage("Title-rogue.png");
    private static final int[] STATS = {2, 5, 2, 1};
    private static final int PRICE = 100;
    private static final String DESCRIPTION = "The Rogue, a master thief. Uses it's slingshot to fire at it's enemies quickly.";
    private static final int BASE_DISPLACEMENT_X = 0;
    private static final int BASE_DISPLACEMENT_Y = -17;
    private static final int SHOP_DISPLACEMENT_X = 7;
    private static final int SHOP_DISPLACEMENT_Y = 1;
    private static final int UPGRADE_MENU_TYPE = 0;

    private int[] upgradeLevels = {0, 0, 0};
    private int attackTimer = 0;

    /**
     * Checks whether it's time to attack then tries to attack an enemy in range.
     */
    public void act()
    {
        attack();
        clicked();
    }

    /**
     * Advances the attack timer and when it's time shoots a rock towards an enemy in range of the rogue.
     */
    private void attack()
    {
        if (attackTimer >= ATTACK_COOLDOWN - (SPEED_BOOST * upgradeLevels[1]))
        {
            Enemy enemy = checkRange();
            if (enemy != null)
            {
                Greenfoot.playSound("Rogue.mp3");
                
                int rotation = getAttackDirection(enemy);
                Rock rock = new Rock(this, new Vector(rotation, PROJECTILE_SPEED), getX(), getY());
                getWorld().addObject(rock, 0, 0);
                rock.setRotation(rotation);
                rock.move();
                
                attackTimer = 0;
            }
        }
        else
        {
            attackTimer++;
        }
    }

    /**
     * Returns the x attack range of the rogue.
     */
    @Override
    public int getAttackRangeX() { return ATTACK_RANGE_X; }

    /**
     * Returns the y attack range of the rogue.
     */
    @Override
    public int getAttackRangeY() { return ATTACK_RANGE_Y + (RANGE_BOOST * upgradeLevels[2]); }

    /**
     * Returns the upgrade levels of the rogue.
     */
    @Override
    public int[] getUpgradeLevels() { return upgradeLevels; }

    /**
     * Returns the attack boost of the rogue.
     */
    @Override
    public int getAttackBoost() { return ATTACK_BOOST; }

    /**
     * Returns the area of attack of the rogue.
     */
    @Override
    public int getAoeBoost() { return 0; }

    /**
     * Returns the immune enemies of the rogue.
     */
    public Enemy[] getImmuneEnemies() { return IMMUNE_ENEMIES; }

    /**
     * Returns the title image of the rogue.
     */
    @Override
    public GreenfootImage getTitleImage() { return TITLE_IMAGE; }

    /**
     * Returns the stats of the rogue.
     */
    @Override
    public int[] getStats() { return STATS; }

    /**
     * Returns the price of the rogue.
     */
    @Override
    public int getPrice() { return PRICE; }

    /**
     * Returns the description of the rogue.
     */
    @Override
    public String getDescription() { return DESCRIPTION; }

    /**
     * Returns the x base displacement of the rogue.
     */
    @Override
    public int getBaseDisplacementX() { return BASE_DISPLACEMENT_X; }

    /**
     * Returns the y base displacement of the rogue.
     */
    @Override
    public int getBaseDisplacementY() { return BASE_DISPLACEMENT_Y; }

    /**
     * Returns the x shop displacement of the rogue.
     */
    @Override
    public int getShopDisplacementX() { return SHOP_DISPLACEMENT_X; }

    /**
     * Returns the y shop displacement of the rogue.
     */
    @Override
    public int getShopDisplacementY() { return SHOP_DISPLACEMENT_Y; }

    /**
     * Returns the upgrade menu type of the rogue.
     */
    @Override
    public int getUpgradeMenuType() { return UPGRADE_MENU_TYPE; }
}