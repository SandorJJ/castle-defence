import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * A more powerful version of the wolf.
 * 
 * @author SJonas 
 * @version 2023-11-05
 */
public class EnragedWolf extends Wolf
{
    // Constants for gameplay
    private static final int HEALTH = 20;
    private static final int ATTACK = 30;
    private static final String[] IMAGES = {"EnragedWolf-0.png", "EnragedWolf-1.png", "EnragedWolf-2.png", "EnragedWolf-3.png", "EnragedWolf-4.png", "EnragedWolf-5.png",
            "EnragedWolf-6.png", "EnragedWolf-7.png"};
    
    /**
     * Constantly moves and animates the wolf, also checks if it's still alive.
     */
    public void act()
    {
        move();
        animate();
        isAlive();
    }
    
    /**
     * Returns the health of the wolf.
     */
    @Override
    public int getHealth() { return HEALTH; }
    
    /**
     * Returns the attack of the wolf.
     */
    @Override
    public int getAttack() { return ATTACK; }
    
    /**
     * Returns the images of the wolf.
     */    
    @Override
    public String[] getImages() { return IMAGES; }
}
