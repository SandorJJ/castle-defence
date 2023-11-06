import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;

/**
 * A tower that shoots an exploding fireball.
 * 
 * @author SJonas
 * @version 2023-11-06
 */
public class Mage extends Tower
{
    // Constants for gameplay
    private static final int ATTACK_RANGE_X = 75;
    private static final int ATTACK_RANGE_Y = 100;
    private static final int ATTACK_COOLDOWN = 100;
    private static final int PROJECTILE_SPEED = 3;
    private static final int ATTACK_BOOST = 3;
    private static final int SPEED_BOOST = 15;
    private static final int AOE_BOOST = 1;
    private static final Enemy[] IMMUNE_ENEMIES = {};

    // Constants for the shop/upgrade menu
    private static final GreenfootImage TITLE_IMAGE = new GreenfootImage("Title-mage.png");
    private static final int[] STATS = {4, 2, 3, 4};
    private static final int PRICE = 400;
    private static final String DESCRIPTION = "The Mage, a master spellcaster. Uses it's spells to blast down it's enemies which explode on impact hitting more enemies.";
    private static final int BASE_DISPLACEMENT_X = 0;
    private static final int BASE_DISPLACEMENT_Y = -13;
    private static final int SHOP_DISPLACEMENT_X = 0;
    private static final int SHOP_DISPLACEMENT_Y = 8;
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
     * Advances the attack timer and when it's time throws a fireball towards an enemy in range of the mage.
     */
    private void attack()
    {
        if (attackTimer >= ATTACK_COOLDOWN - (SPEED_BOOST * upgradeLevels[1]))
        {
            Enemy enemy = checkRange();
            if (enemy != null)
            {
                Greenfoot.playSound("Mage.mp3");
                
                int rotation = getAttackDirection(enemy);
                Fireball fireball = new Fireball(this, new Vector(rotation, PROJECTILE_SPEED), getX(), getY());
                getWorld().addObject(fireball, 0, 0);
                fireball.setRotation(rotation);
                fireball.move();
                
                attackTimer = 0;
            }
        }
        else
        {
            attackTimer++;
        }
    }

    /**
     * Returns the x attack range of the mage.
     */
    @Override
    public int getAttackRangeX() { return ATTACK_RANGE_X; }

    /**
     * Returns the y attack range of the mage.
     */
    @Override
    public int getAttackRangeY() { return ATTACK_RANGE_Y; }

    /**
     * Returns the upgrade levels of the mage.
     */
    @Override
    public int[] getUpgradeLevels() { return upgradeLevels; }

    /**
     * Returns the attack boost of the mage.
     */
    @Override
    public int getAttackBoost() { return ATTACK_BOOST; }

    /**
     * Returns the area of effect boost of the mage.
     */
    public int getAoeBoost() { return AOE_BOOST; }

    /**
     * Returns the immune enemies of the mage.
     */
    public Enemy[] getImmuneEnemies() { return IMMUNE_ENEMIES; }

    /**
     * Returns the title image of the mage.
     */
    @Override
    public GreenfootImage getTitleImage() { return TITLE_IMAGE; }

    /**
     * Returns the stats of the mage.
     */
    @Override
    public int[] getStats() { return STATS; }

    /**
     * Returns the price of the mage.
     */
    @Override
    public int getPrice() { return PRICE; }

    /**
     * Returns the description of the mage.
     */
    @Override
    public String getDescription() { return DESCRIPTION; }

    /**
     * Returns the x base displacement of the mage.
     */
    @Override
    public int getBaseDisplacementX() { return BASE_DISPLACEMENT_X; }

    /**
     * Returns the y base displacement of the mage.
     */
    @Override
    public int getBaseDisplacementY() { return BASE_DISPLACEMENT_Y; }

    /**
     * Returns the x shop displacement of the mage.
     */
    @Override
    public int getShopDisplacementX() { return SHOP_DISPLACEMENT_X; }

    /**
     * Returns the y shop displacement of the mage.
     */
    @Override
    public int getShopDisplacementY() { return SHOP_DISPLACEMENT_Y; }

    /**
     * Returns the upgrade menu type of the mage.
     */
    @Override
    public int getUpgradeMenuType() { return UPGRADE_MENU_TYPE; }
}
