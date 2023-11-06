import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * A base on which towers are placed.
 * 
 * @author SJonas
 * @version 2023-11-01
 */
public class Base extends Actor
{
    private static final int Y_OFFSET = 2;
    
    // A boolean value to determine whether any base is actively selected
    private static boolean active = false;
    // A boolean value to determine whether the base is taken or empty
    private boolean taken = false;
    
    /**
     * Constantly checks if the base was clicked.
     */
    public void act()
    {
        clicked();
    }
    
    /**
     * Checks whether the base is clicked, no other base is currently active, and the base isn't taken, then opens the shop.
     */
    private void clicked() 
    {
        if (Greenfoot.mouseClicked(this) && !active && !taken)
        {
            active = true;
            setImage("Base-active.png");
            setLocation(getX(), getY() - Y_OFFSET);
            
            World world = getWorld();
            world.addObject(new Shop(this), world.getWidth() / 2, world.getHeight() / 2);
        }
    }
    
    /**
     * Sets the active static value to true or false, if false then sets the image to the inactive base image.
     */
    public void setActive(boolean active)
    {
        this.active = active;
        
        if (!active)
        {
            setImage("Base.png");
            setLocation(getX(), getY() + Y_OFFSET);
        }
    }
    
    /**
     * Sets the taken instance value to true or false.
     */
    public void setTaken(boolean empty)
    {
        this.taken = taken;
    }
}
