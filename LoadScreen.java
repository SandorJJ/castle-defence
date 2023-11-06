import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * A load screen to load between different scenes.
 * 
 * @author SJonas
 * @version 2023-11-01
 */
public class LoadScreen extends World
{
    private static final int TRANSITION_SPEED = 10;
    
    private GreenfootImage previousBackground;
    private World nextWorld;
    private int timer = 0;
    

    /**
     * Creates the load screen object.
     */
    public LoadScreen(GreenfootImage previousBackground, World nextWorld)
    {
        super(720, 480, 1);
        setBackground(previousBackground);
        
        this.previousBackground = previousBackground;
        this.nextWorld = nextWorld;
    }

    /**
     * Constantly loads the next part of the transition.
     */
    public void act()
    {
        load();
    }
    
    /**
     * Loads the next part of the transition.
     */
    public void load()
    {
        if (timer <= 255 / TRANSITION_SPEED)
        {
            GreenfootImage background = previousBackground;
            background.setColor(new Color(0, 0, 0, timer * TRANSITION_SPEED));
            background.fillRect(0, 0, getWidth(), getHeight());
            setBackground(background);
            timer++;
        }
        else if (timer > 255 / TRANSITION_SPEED && timer <= 510 / TRANSITION_SPEED)
        {
            GreenfootImage background = new GreenfootImage(nextWorld.getBackground());
            background.setColor(new Color(0, 0, 0, 510 - (timer * TRANSITION_SPEED)));
            background.fillRect(0, 0, getWidth(), getHeight());
            setBackground(background);
            timer++;
        }
        else
        {
            Greenfoot.setWorld(nextWorld);
        }
    }
}

