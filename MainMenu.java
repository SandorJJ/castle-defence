import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * The main menu of Castle Defence.
 * 
 * @author SJonas
 * @version 2023-11-01
 */
public class MainMenu extends World
{
    /**
     * Creates the main menu space.
     */
    public MainMenu()
    {    
        super(720, 480, 1);
    }
    
    /**
     * Constantly checks if the background was clicked and then if a button was clicked.
     */
    public void act()
    {
        clicked();
    }
    
    /**
     * Checks if the background was clicked and then if a button was clicked.
     */
    private void clicked()
    {
        if (Greenfoot.mouseClicked(this))
        {
            int mouseX = Greenfoot.getMouseInfo().getX();
            int mouseY = Greenfoot.getMouseInfo().getY();  
            
            World world = null;
            if (mouseX > 134 && mouseX < 258 && mouseY > 181 && mouseY < 226) // Clicked START button
            {
                world = new Map();
            }
            else if (mouseX > 419 && mouseX < 610 && mouseY > 181 && mouseY < 226) // Clicked TUTORIAL button
            {
                world = new Tutorial();
            }
            else
            {
                return;
            }
            
            Greenfoot.setWorld(new LoadScreen(getBackground(), world));
        }
    }
}