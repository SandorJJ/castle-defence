import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * The slime is an enemy that slowly bounces towards the castle.
 * 
 * @author SJonas
 * @version 2023-11-06
 */
public class Slime extends Enemy
{
    // Constants for gameplay
    private static final int HEALTH = 5;
    private static final int ATTACK = 5;
    private static final int COIN_DROP = 4;
    private static final int MOVE_DELAY = 75; 
    private static final int ANIMATION_DELAY = 0;
    private static final String[] IMAGES = {"Slime-0.png", "Slime-1.png", "Slime-2.png", "Slime-3.png", "Slime-4.png",
            "Slime-5.png", "Slime-6.png", "Slime-5.png", "Slime-4.png", "Slime-3.png", "Slime-2.png", "Slime-1.png", "Slime-0.png"};
    private static final int MOVEMENT_SPEED = 1;
            
    // Constants for the monster book
    private static final GreenfootImage TITLE_IMAGE = new GreenfootImage("Title-slime.png");
    private static final String DESCRIPTION = "The slime is the weakest of all enemies. The slime slowly bounces towards the castle and dealing little damage to the castle.";
    private static final int[] STATS = {1, 1, 1};
    private static final int MONSTER_BOOK_DISPLACEMENT_X = 5;
    private static final int MONSTER_BOOK_DISPLACEMENT_Y = -4;
    
    private int imageIndex = 0;
    private int moveTimer = 0;

    /**
     * Constantly moves and animates the slime, also checks if it's still alive.
     */
    public void act()
    {
        move();
        isAlive();
    }

    /**
     * Moves the slime based on its movement speed. Also animates the slime and checks if it has move out of bounds.
     */
    @Override
    public void move()
    {
        if (moveTimer < IMAGES.length * 3 + 1)
        {
            setLocation(getX(), getY() + MOVEMENT_SPEED);
            outOfBounds();
            animate();
        }

        if (moveTimer == MOVE_DELAY)
        {
            moveTimer = 0;
        }
        else
        {
            moveTimer++;
        }
    }

    /**
     * Animates the slime.
     */
    @Override
    public void animate()
    {
        if (moveTimer % 3 == 0)
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
        }
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
     * Returns the coin drop of the slime.
     */
    @Override
    public int getCoinDrop() { return COIN_DROP; }
    
    /**
     * Returns the animation delay of the slime.
     */
    @Override
    public int getAnimationDelay() { return ANIMATION_DELAY; }
    
    /**
     * Returns the images of the slime.
     */    
    @Override
    public String[] getImages() { return IMAGES; }
    
    /**
     * Returns the movement speed of the slime.
     */
    public int getMovementSpeed() { return MOVEMENT_SPEED; }
    
    /**
     * Returns the title image of the slime.
     */
    @Override
    public GreenfootImage getTitleImage() { return TITLE_IMAGE; }

    /**
     * Returns the stats of the slime.
     */
    @Override
    public int[] getStats() { return STATS; }

    /**
     * Returns the description of the slime.
     */
    @Override
    public String getDescription() { return DESCRIPTION; }
    
    /**
     * Returns the x monster book displacement of the slime.
     */
    @Override
    public int getMonsterBookDisplacementX() { return MONSTER_BOOK_DISPLACEMENT_X; }
    
    /**
     * Returns the y monster book displacement of the slime.
     */
    @Override
    public int getMonsterBookDisplacementY() { return MONSTER_BOOK_DISPLACEMENT_Y; }
}