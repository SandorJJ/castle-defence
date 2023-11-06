import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * A more powerful version of the slime.
 * 
 * @author SJonas 
 * @version 2023-11-05
 */
public class EnragedSlime extends Slime
{
    // Constants for gameplay
    private static final int HEALTH = 10;
    private static final int ATTACK = 10;
    private static final String[] IMAGES = {"EnragedSlime-0.png", "EnragedSlime-1.png", "EnragedSlime-2.png", "EnragedSlime-3.png", "EnragedSlime-4.png",
            "EnragedSlime-5.png", "EnragedSlime-6.png", "EnragedSlime-5.png", "EnragedSlime-4.png", "EnragedSlime-3.png", "EnragedSlime-2.png", "EnragedSlime-1.png", "EnragedSlime-0.png"};
    
    /**
     * Constantly moves and animates the slime, also checks if it's still alive.
     */
    public void act()
    {
        move();
        isAlive();
    }
    
    /**
     * Returns the health of the slime.
     */
    @Override
    public int getHealth() { return HEALTH; }
    
    /**
     * Returns the attack of the slime.
     */
    @Override
    public int getAttack() { return ATTACK; }
    
    /**
     * Returns the images of the slime.
     */    
    @Override
    public String[] getImages() { return IMAGES; }
}
