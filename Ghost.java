import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * The ghost is an enemy that floats towards the castle.
 * 
 * @author SJonas
 * @version 2023-11-06
 */
public class Ghost extends Enemy
{
    // Constants for gameplay
    private static final int HEALTH = 20;
    private static final int ATTACK = 10;
    private static final int COIN_DROP = 12;
    private static final int ANIMATION_DELAY = 10;
    private static final String[] IMAGES = {"Ghost-0.png", "Ghost-1.png"};
    private static final int MOVEMENT_SPEED = 1;
    
    // Constants for the monster book
    private static final GreenfootImage TITLE_IMAGE = new GreenfootImage("Title-ghost.png");
    private static final String DESCRIPTION = "The ghost is the scariest of all enemies. The ghost floats towards the castle and deals damage to the castle. The ghost can only be hit by non physicial attacks.";
    private static final int[] STATS = {5, 3, 3};
    private static final int MONSTER_BOOK_DISPLACEMENT_X = 2;
    private static final int MONSTER_BOOK_DISPLACEMENT_Y = 0;

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
     * Returns the attack of the Ghost.
     */
    @Override
    public int getAttack() { return ATTACK; }

    /**
     * Returns the coin drop of the ghost.
     */
    @Override
    public int getCoinDrop() { return COIN_DROP; }
    
    /**
     * Returns the animation delay of the ghost.
     */
    @Override
    public int getAnimationDelay() { return ANIMATION_DELAY; }
    
    /**
     * Returns the images of the ghost.
     */    
    @Override
    public String[] getImages() { return IMAGES; }
    
    /**
     * Returns the movement speed of the ghost.
     */
    public int getMovementSpeed() { return MOVEMENT_SPEED; }

    /**
     * Returns the title image of the ghost.
     */
    @Override
    public GreenfootImage getTitleImage() { return TITLE_IMAGE; }

    /**
     * Returns the stats of the ghost.
     */
    @Override
    public int[] getStats() { return STATS; }

    /**
     * Returns the description of the ghost.
     */
    @Override
    public String getDescription() { return DESCRIPTION; }
    
    /**
     * Returns the x monster book displacement of the ghost.
     */
    @Override
    public int getMonsterBookDisplacementX() { return MONSTER_BOOK_DISPLACEMENT_X; }
    
    /**
     * Returns the y monster book displacement of the ghost.
     */
    @Override
    public int getMonsterBookDisplacementY() { return MONSTER_BOOK_DISPLACEMENT_Y; }
}
