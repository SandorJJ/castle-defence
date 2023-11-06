import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * The rock is a projectile that hits an enemy.
 * 
 * @author SJonas
 * @version 2023-11-06
 */
public class Rock extends Projectile
{
    // Constants for gameplay
    private static final int DAMAGE = 2;
    private static final Enemy[] IMMUNE_ENEMIES = {
        new Ghost(),
        new EnragedGhost()
    };
    
    /**
     * Constructs the rock object.
     */
    public Rock(Rogue rogue, Vector velocity, int startingX, int startingY)
    {
        super(rogue, velocity, startingX, startingY);
    }
    
    /**
     * Constantly checks if the rock hit an enemy and moves the rock.
     */
    public void act()
    {
        checkEnemyHit();
        move();
    }
    
    /**
     * Returns the damage of the rock.
     */
    @Override
    public int getDamage() { return DAMAGE; }
    
    /**
     * Returns the immune enemies of the rock.
     */
    @Override
    public Enemy[] getImmuneEnemies() { return IMMUNE_ENEMIES; }
}