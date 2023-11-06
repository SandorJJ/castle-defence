import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * A subwave made up of enemies.
 * 
 * @author SJonas
 * @version 2023-11-02
 */
public class SubWave extends Actor
{
    private int timer = 0;
    private int spawned = 0;
    private boolean complete = false;
    
    private Enemy enemy;
    private int amount;
    private int time;
    
    /**
     * Constructs the subwave object with an enemy, amount and time. Also hides image.
     */
    public SubWave(Enemy enemy, int amount, int time)
    {
        this.enemy = enemy;
        this.amount = amount;
        this.time = time;
        
        setImage((GreenfootImage) null);
    }
    
    /**
     * Constantly summons the next enemy in the subwave.
     */
    public void act()
    {
        if (timer == time && spawned < amount)
        {
            try {
                getWorld().addObject(enemy.getClass().newInstance(), 555, 0);
            } catch (Exception e)
            {
                e.printStackTrace();
            }
            spawned++;
            timer = 0;
        }
        else if (spawned == amount)
        {
            complete = true;
        }
        else
        {
            timer++;
        }
    }
    
    /**
     * Returns true if the subwave is done summoning and false otherwise.
     */
    public boolean getComplete()
    {
        return complete;
    }
}
