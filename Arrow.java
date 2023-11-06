import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * The arrow is a projectile that hits an enemy.
 * 
 * @author SJonas
 * @version 2023-11-06
 */
public class Arrow extends Projectile
{
    // Constants for gameplay
    private static final int DAMAGE = 8;
    private static final Enemy[] IMMUNE_ENEMIES = {
        new Ghost(),
        new EnragedGhost()
    };
    
    /**
     * Constructs the arrow object.
     */
    public Arrow(Archer archer, Vector velocity, int startingX, int startingY)
    {
        super(archer, velocity, startingX, startingY);
    }
    
    /**
     * Constantly checks if the arrow hit an enemy and moves the arrow.
     */
    public void act()
    {
        checkEnemyHit();
        move();
    }
    
    /**
     * Returns the damage of the arrow.
     */
    @Override
    public int getDamage() { return DAMAGE; }
    
    /**
     * Returns the immune enemies of the arrow.
     */
    @Override
    public Enemy[] getImmuneEnemies() { return IMMUNE_ENEMIES; }
}