import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * The base behaviour for all enemies.
 * 
 * @author SJonas
 * @version 2023-11-06
 */
public abstract class Enemy extends Actor
{
    // Getters for the constants for gameplay
    public abstract int getHealth();
    public abstract int getAttack();
    public abstract int getCoinDrop();
    public abstract int getAnimationDelay();
    public abstract String[] getImages();
    public abstract int getMovementSpeed();
    
    // Getters for the constants for the monster book
    public abstract GreenfootImage getTitleImage();
    public abstract int[] getStats();
    public abstract String getDescription();
    public abstract int getMonsterBookDisplacementX();
    public abstract int getMonsterBookDisplacementY();
    
    private int animationTimer = 0;
    private int imageIndex = 0;
    private int health;
    
    /**
     * Constructs the base of the enemy object.
     */
    public Enemy()
    {
        this.health = getHealth();
    }
    
    /**
     * Moves the enemy based on its movement speed. Also checks if the enemy has moved out of bounds.
     */
    public void move()
    {
        setLocation(getX(), getY() + getMovementSpeed());
        outOfBounds();
    }
    
    /**
     * Checks if the enemy is out of bounds or reaches the castle.
     */
    public void outOfBounds()
    {
        if (getY() + 1 == 480)
        {
            if (getX() == 165)
            {
                getWorld().getObjects(Health.class).get(0).remove(getAttack());
                getWorld().removeObject(this);
            }
            else
            {
                setLocation(getX() - 195, 0);
            }
        }
    }
    
    /**
     * Animates the enemy.
     */
    public void animate()
    {
        if (animationTimer == getAnimationDelay())
        {
            if (imageIndex == getImages().length)
            {
                imageIndex = 0;
            }
            else 
            {
                setImage(getImages()[imageIndex]);
                imageIndex++;
            }
            animationTimer = 0;
        }
        else
        {
            animationTimer++;
        }
    }
    
    /**
     * Checks if the enemy is alive, it if isn't then adds coin drop to player and removes the enemy.
     */
    public void isAlive()
    {
        if (health <= 0)
        {
            getWorld().getObjects(Coins.class).get(0).add(getCoinDrop());
            getWorld().removeObject(this);
        }
    }
    
    /**
     * Hits the enemy for a certain amount of damage removing it from its health.
     */
    public void hit(int damage)
    {
        health -= damage;
    }
}