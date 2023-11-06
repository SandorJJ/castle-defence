import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * The amount of health the Great Castle has.
 * 
 * @author SJonas
 * @version 2023-11-01
 */
public class Health extends Actor
{
    private int health;
    
    /**
     * Constructs the object and displays the castle health in the top left.
     */
    public Health(int health)
    {
        this.health = health;
        display();
    }
    
    /**
     * Constantly updates the displayed health amount.
     */
    public void act()
    {
        display();
    }
    
    /**
     * Displays the amount of health the Great Castle has in the top left.
     */
    private void display()
    {
        setImage("Board.png");
        getImage().drawImage(new GreenfootImage("Heart.png"), 7, 6);
        getImage().drawString("" + health, 25, 17);
    }
    
    /**
     * Get the amount of health the player's castle has.
     */
    public int getHealth()
    {
        return health;
    }
    
    /**
     * Remove a certain amount of health from the player's castle.
     */ 
    public void remove(int amount)
    {
        health -= amount;
    }
}