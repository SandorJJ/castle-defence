import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;

/**
 * The tutorial of the game.
 * 
 * @author SJonas
 * @version 2023-11-01
 */
public class Tutorial extends World
{
    private static final int SCENE_COUNT = 15;
    private static final String[] SCENE_INFORMATION = {
        "Hello! My name is Grook and I'll be your guide today. (Left click to go to the next scene, right click to go to the previous scene, click X to exit)",
        "The Great Castle is under attack from monsters from the neighbouring Monster Kingdom. The King has tasked you with the job to protect the Great Castle and its citizens at all cost!",
        "Your goal is to stop incoming enemies from entering the Great Castle by building and upgrading towers. The health of the Great Castle can be seen in the top left of the screen.",
        "You can build towers by buying them from the shop which can be opened by clicking on empty bases. The amount of coins you have can be seen in the top left of the screen.",
        "Each tower has four stats: ATK, SPD, RNG, AoE.",
        "Attack (ATK) signifies how much damage a tower does to enemies.",
        "Speed (SPD) signifies how fast a tower attacks enemies.",
        "Range (RNG) signifies how far a tower can attack enemies from.",
        "Area of Effect (AoE) signifies how many enemies a tower can hit with one attack.",
        "You can also upgrade towers by clicking on towers and buying upgrades from the opened upgrade menu. Each tower has three upgrades, each of which can be upgraded three times.",
        "You can start the next wave of enemies by the clicking on the Next Wave button in the bottom right of the screen.",
        "You can also see how many waves your have completed and how many waves you have left in the bottom right of the screen.",
        "After a half the rounds are over more powerful version of the enemies will start appearing.",
        "You can see information about each enemy in the monster book which can be opened by clicking the M button in the top right of the screen.",
        "There are a few more gameplay mechanics but I'll let you discover them on your own. Good Luck!"
    };
    private static final int LINE_LENGTH = 70;
    private int scene = -1;
    
    public Tutorial()
    {    
        super(720, 480, 1);
        changeScene();
    }
    
    /**
     * Constantly checks if there have been any clicks, if there were then it checks if it was a click on the close button or to change scene.
     */ 
    public void act()
    {
        if (Greenfoot.mouseClicked(this))
        {
            exit();
            changeScene();  
        }
    }
    
    /**
     * Changes the current scene, either to the next scene or the previous scene, left and right click.
     */
    public void changeScene()
    {
        // Gets which mouse button was clicked and handles the error thrown when the mouse moves off the screen.
        int buttonClicked = 0;
        try {
            buttonClicked = Greenfoot.getMouseInfo().getButton();
        } catch (Exception e)
        {
            return;
        }

        if (buttonClicked == 1) // NEXT scene
        {
            scene++;
            if (scene > SCENE_COUNT - 1)
            {
                scene = 0;
            }
        }
        else if (buttonClicked == 3) // PREVIOUS scene
        {
            scene--;
            if (scene < 0)
            {
                scene = SCENE_COUNT - 1;
            }
        }
        
        GreenfootImage nextScene = new GreenfootImage("Tutorial-" + scene + ".png");
        nextScene.setFont(nextScene.getFont().deriveFont(15f));
        ArrayList<String> lines = formatText(SCENE_INFORMATION[scene]);
        for (int i = 0; i < lines.size(); i++)
        {
            nextScene.drawString(lines.get(i), 160, 390 + (i * 17));
        }
        setBackground(nextScene);
    }
    
    /**
     * Exits the tutorial and returns to the main menu.
     */
    private void exit()
    {
        if (Greenfoot.getMouseInfo().getX() > 688 && Greenfoot.getMouseInfo().getY() < 32)
        {
            Greenfoot.setWorld(new LoadScreen(getBackground(), new MainMenu()));
        }
    }
    
    /**
     * Formats the text passed in to be split into lines that can fit onto the tutorial dialogue box.
     */
    private ArrayList<String> formatText(String text)
    {
        ArrayList<String> lines = new ArrayList<>();
        
        String[] words = text.split(" ");
        String line = "";
        for (int i = 0; i < words.length; i++)
        {
            if ((line + words[i]).length() < LINE_LENGTH)
            {
                line += words[i] + " ";
            }
            else
            {
                lines.add(line.trim());
                line = "";
                i--;
            }
        }
        lines.add(line.trim());
        
        return lines;
    }
}
