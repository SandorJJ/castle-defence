import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Base behaviour for all projectiles
 * 
 * @author SJonas
 * @version 2023-11-06
 */
public abstract class Projectile extends Actor
{
    // Getters for the constants for gameplay
    public abstract int getDamage();
    public abstract Enemy[] getImmuneEnemies();

    public Tower tower;
    private Vector velocity;
    private double exactX;
    private double exactY;

    /**
     * Constructs the base of the projectile.
     */
    public Projectile(Tower tower, Vector velocity, int startingX, int startingY)
    {
        this.tower = tower;
        this.velocity = velocity;
        exactX = startingX;
        exactY = startingY;
    }

    /**
     * Moves the projectile based on its velocity.
     */
    public void move() 
    {
        exactX = exactX + velocity.getX();
        exactY = exactY + velocity.getY();

        if (getWorld() != null)
        {
            outOfBounds();
            super.setLocation((int) exactX, (int) exactY);
        }
    }

    /**
     * Checks if the projectile is out of bounds and removes it if it is.
     */
    private void outOfBounds()
    {
        if (exactX < 0 || exactY < 0)
        {
            getWorld().removeObject(this);
        }
        else if (exactX > getWorld().getWidth() || exactY > getWorld().getHeight())
        {
            getWorld().removeObject(this);
        }
    }

    /**
     * Checks if the rock hit an enemy.
     */
    public void checkEnemyHit()
    {
        Enemy enemy = (Enemy) getOneIntersectingObject(Enemy.class);
        if (enemy != null && canHit(enemy))
        {
            getWorld().removeObject(this);
            enemy.hit(getDamage() + (tower.getAttackBoost() * tower.getUpgradeLevels()[0]));
        }
    }

    /**
     * Checks if the projectile can hit an enemy, if it can returns true otherwise false.
     */
    public boolean canHit(Enemy enemy)
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
}