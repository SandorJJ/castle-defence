import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;
import java.util.stream.Collectors;

/**
 * The base behaviour for all towers.
 * 
 * @author SJonas
 * @version 2023-11-06
 */
public abstract class Tower extends Actor
{    
    // Getters for the constants/variables for gameplay
    public abstract int getAttackRangeX();
    public abstract int getAttackRangeY();
    public abstract int[] getUpgradeLevels();
    public abstract int getAttackBoost();
    public abstract int getAoeBoost();
    public abstract Enemy[] getImmuneEnemies();

    // Getters for the constants for the shop/upgrade menu
    public abstract GreenfootImage getTitleImage();
    public abstract int[] getStats();
    public abstract int getPrice();
    public abstract String getDescription();
    public abstract int getBaseDisplacementX();
    public abstract int getBaseDisplacementY();
    public abstract int getShopDisplacementX();
    public abstract int getShopDisplacementY();
    public abstract int getUpgradeMenuType();

    private static boolean active = false;

    /**
     * Checks whether there are any valid enemies in the tower's attack radius. Returns the enemy if there is and returns null if there isn't.
     */
    public Enemy checkRange()
    {
        List<Enemy> enemies = getWorld().getObjects(Enemy.class).stream()
            .filter(enemy -> filterEnemies(enemy)).collect(Collectors.toList());
        for (Enemy enemy : enemies)
        {
            if (Math.abs(enemy.getX() - getX()) < getAttackRangeX() && Math.abs(enemy.getY() - getY()) < getAttackRangeY())
            {
                return enemy;
            }
        }

        return null;
    }

    /**
     * Filters out the enemy that can be attacked by the tower.
     */
    public boolean filterEnemies(Enemy enemy)
    {
        for (Enemy immuneEnemy : getImmuneEnemies())
        {
            if (enemy.getClass() == immuneEnemy.getClass())
            {
                return false;
            }
        }
        return true;
    }

    /**
     * Returns the direction, in degrees, in which the tower has to attack.
     */
    public int getAttackDirection(Enemy enemy)
    {
        return (int) Math.round(Math.toDegrees(Math.atan2(enemy.getY() - getY(), enemy.getX() - getX())));
    }

    /**
     * Checks if the tower was clicked, if yes then opens the upgrade menu.
     */
    public void clicked()
    {
        if (Greenfoot.mouseClicked(this) && !active)
        {
            active = true;

            World world = getWorld();
            world.addObject(new UpgradeMenu(this), world.getWidth() / 2, world.getHeight() / 2);
        }
    }

    /**
     * Setter for active variable.
     */
    public void setActive(boolean active)
    {
        this.active = active;
    }
}
