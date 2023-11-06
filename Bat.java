import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * The bat is an enemy that quickly flies towards the castle.
 * 
 * @author SJonas
 * @version 2023-11-06
 */
public class Bat extends Enemy
{
    // Constants for gameplay
    private static final int HEALTH = 12;
    private static final int ATTACK = 8;
    private static final int COIN_DROP = 9;
    private static final int ANIMATION_DELAY = 1;
    private static final String[] IMAGES = {"Bat-0.png", "Bat-1.png", "Bat-2.png", "Bat-3.png", "Bat-4.png", "Bat-5.png",
            "Bat-6.png", "Bat-7.png", "Bat-8.png", "Bat-9.png", "Bat-10.png", "Bat-11.png", "Bat-12.png", "Bat-12.png",
            "Bat-11.png", "Bat-10.png", "Bat-9.png", "Bat-8.png", "Bat-7.png", "Bat-6.png", "Bat-5.png", "Bat-4.png",
            "Bat-3.png", "Bat-2.png", "Bat-1.png", "Bat-0.png"};
    private static final int MOVEMENT_SPEED = 2;
            
    // Constants for the monster book
    private static final GreenfootImage TITLE_IMAGE = new GreenfootImage("Title-bat.png");
    private static final String DESCRIPTION = "The bat is the fastest of all enemies. The bat quickly flies towards the castle and deals damage to the castle. The bat can only hit by the fastest of flying projectiles.";
    private static final int[] STATS = {3, 2, 5};
    private static final int MONSTER_BOOK_DISPLACEMENT_X = -1;
    private static final int MONSTER_BOOK_DISPLACEMENT_Y = 7;

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
     * Returns the coin drop of the bat.
     */
    @Override
    public int getCoinDrop() { return COIN_DROP; }
    
    /**
     * Returns the animation delay of the bat.
     */
    @Override
    public int getAnimationDelay() { return ANIMATION_DELAY; }
    
    /**
     * Returns the images of the bat.
     */    
    @Override
    public String[] getImages() { return IMAGES; }
    
    /**
     * Returns the movement speed of the bat.
     */
    public int getMovementSpeed() { return MOVEMENT_SPEED; }

    /**
     * Returns the title image of the bat.
     */
    @Override
    public GreenfootImage getTitleImage() { return TITLE_IMAGE; }

    /**
     * Returns the stats of the bat.
     */
    @Override
    public int[] getStats() { return STATS; }

    /**
     * Returns the description of the bat.
     */
    @Override
    public String getDescription() { return DESCRIPTION; }
    
    /**
     * Returns the x monster book displacement of the bat.
     */
    @Override
    public int getMonsterBookDisplacementX() { return MONSTER_BOOK_DISPLACEMENT_X; }
    
    /**
     * Returns the y monster book displacement of the bat.
     */
    @Override
    public int getMonsterBookDisplacementY() { return MONSTER_BOOK_DISPLACEMENT_Y; }
}
