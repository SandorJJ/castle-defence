import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * A more powerful version of the ghost.
 * 
 * @author SJonas 
 * @version 2023-11-05
 */
public class EnragedGhost extends Ghost
{
    // Constants for gameplay
    private static final int HEALTH = 40;
    private static final int ATTACK = 20;
    private static final String[] IMAGES = {"EnragedGhost-0.png", "EnragedGhost-1.png"};
    
    /**
     * Constantly moves and animates the ghost, also checks if it's still alive.
     */
    public void act()
    {
        move();
        animate();
        isAlive();
    }
    
    /**
     * Returns the health of the ghost.
     */
    @Override
    public int getHealth() { return HEALTH; }
    
    /**
     * Returns the attack of the ghost.
     */
    @Override
    public int getAttack() { return ATTACK; }
    
    /**
     * Returns the images of the ghost.
     */    
    @Override
    public String[] getImages() { return IMAGES; }
}
