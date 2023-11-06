import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Displays the ending screen, either victory or game over.
 * 
 * @author SJonas
 * @version 2023-11-04
 */
public class EndMenu extends World
{
    /**
     * Constructs the ending scene, 1 for victory, 0 for game over.
     */
    public EndMenu(int scene)
    {    
        super(720, 480, 1);
        
        if (scene == 1)
        {
            setBackground("Victory.png");
        }
        else
        {
            setBackground("GameOver.png");  
        }
    }
    
    /**
     * Constantly checks if the end menu was clicked, if yes then returns to the main menu.
     */
    public void act()
    {
        if (Greenfoot.mouseClicked(this))
        {
            Greenfoot.setWorld(new LoadScreen(getBackground(), new MainMenu()));
        }
    }
}
