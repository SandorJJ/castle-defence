import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * A more powerful version of the bat.
 * 
 * @author SJonas 
 * @version 2023-11-05
 */
public class EnragedBat extends Bat
{
    // Constants for gameplay
    private static final int HEALTH = 24;
    private static final int ATTACK = 16;
    private static final String[] IMAGES = {"EnragedBat-0.png", "EnragedBat-1.png", "EnragedBat-2.png", "EnragedBat-3.png", "EnragedBat-4.png", "EnragedBat-5.png",
            "EnragedBat-6.png", "EnragedBat-7.png", "EnragedBat-8.png", "EnragedBat-9.png", "EnragedBat-10.png", "EnragedBat-11.png", "EnragedBat-12.png", "EnragedBat-12.png",
            "EnragedBat-11.png", "EnragedBat-10.png", "EnragedBat-9.png", "EnragedBat-8.png", "EnragedBat-7.png", "EnragedBat-6.png", "EnragedBat-5.png", "EnragedBat-4.png",
            "EnragedBat-3.png", "EnragedBat-2.png", "EnragedBat-1.png", "EnragedBat-0.png"};
    
    /**
     * Constantly moves and animates the bat, also checks if it's still alive.
     */
    public void act()
    {
        move();
        animate();
        isAlive();
    }
    
    /**
     * Returns the health of the bat.
     */
    @Override
    public int getHealth() { return HEALTH; }
    
    /**
     * Returns the attack of the bat.
     */
    @Override
    public int getAttack() { return ATTACK; }
    
    /**
     * Returns the images of the bat.
     */    
    @Override
    public String[] getImages() { return IMAGES; }
}
