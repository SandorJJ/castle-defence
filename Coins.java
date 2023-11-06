import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * The amount of coins the player has.
 * 
 * @author SJonas
 * @version 2023-11-01
 */
public class Coins extends Actor
{
    private int coins;
    
    /**
     * Constructs the object and displays the coin amount in the top left.
     */
    public Coins(int coins)
    {
        this.coins = coins;
        display();
    }
    
    /**
     * Constantly updates the displayed coin amount.
     */
    public void act()
    {
        display();
    }
    
    /**
     * Displays the amount of coins the player has in the top left.
     */
    private void display()
    {
        setImage("Board.png");
        getImage().drawImage(new GreenfootImage("Coin.png"), 7, 5);
        getImage().drawString("" + coins, 25, 17);
    }
    
    /**
     * Add a certain amount of coins to the players coin amount.
     */
    public void add(int amount)
    {
        coins += amount;
    }
    
    /**
     * Remove a certain amount of coins from the player's coin amount.
     */    
    public void remove(int amount)
    {
        coins -= amount;
    }
    
    /**
     * Get the amount of coins the player has.
     */
    public int getCoins()
    {
        return coins;
    }
}
