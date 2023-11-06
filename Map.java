import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;
import java.util.ArrayList;

/**
 * The map of the Castle Defence game.
 * 
 * @author SJonas 
 * @version 2023-11-01
 */
public class Map extends World
{
    private Health health;
    private Coins coins;
    private Summoner summoner;  

    /**
     * Creates the world and initializes castle health, player money, tower bases, enemy waves and background music.
     */
    public Map()
    {    
        super(720, 480, 1);
        health = new Health(100);
        coins = new Coins(300);
        addObject(health, 36, 12); 
        addObject(coins, 36, 34);
        initializeBases();

        Summoner summoner = new Summoner();
        this.summoner = summoner;
        addObject(summoner, 684, 468);
        GreenfootImage image = new GreenfootImage("Board.png");
        getBackground().drawImage(image, 648, 434);
        getBackground().drawString("Wave 0/" + summoner.getWaves().size(), 655, 451);

        GreenfootSound backgroundMusic = new GreenfootSound("BackgroundMusic.mp3");
        backgroundMusic.setVolume(30);
        backgroundMusic.playLoop();
    }

    /**
     * Constantly checks if the game is over or if the monster book or exit buttons were clicked.
     */
    public void act()
    {
        gameOver();
        gameWin();

        if (Greenfoot.mouseClicked(this))
        {
            monsterBook();
            exit();
        }
    }

    /**
     * Initializes the bases in the game by adding them to the map.
     */
    private void initializeBases()
    {
        // Top row
        addObject(new Base(), 114, 115);
        addObject(new Base(), 606, 115);

        // Midle row
        addObject(new Base(), 309, 235);
        addObject(new Base(), 411, 235);

        // Bottom row
        addObject(new Base(), 216, 355);
        addObject(new Base(), 504, 355);
    }

    /**
     * Exits the map and returns to the main menu.
     */
    private void exit()
    {
        if (Greenfoot.getMouseInfo().getX() > 695 && Greenfoot.getMouseInfo().getY() < 24)
        {
            Greenfoot.setWorld(new LoadScreen(getBackground(),new MainMenu()));
        }
    }
    
    /**
     * Opens the monster book.
     */
    private void monsterBook()
    {
        if (Greenfoot.getMouseInfo().getX() > 670 && Greenfoot.getMouseInfo().getX() < 695 &&
        Greenfoot.getMouseInfo().getY() < 24)
        {
            addObject(new MonsterBook(), getWidth() / 2, getHeight() / 2);
        }
    }

    /**
     * Checks if the game has been lost, if yes then goes to game over scene.
     */
    private void gameOver()
    {
        if (getObjects(Health.class).get(0).getHealth() <= 0)
        {
            Greenfoot.setWorld(new LoadScreen(getBackground(), new EndMenu(0)));
        }
    }

    /**
     * Checks if the game has been won, if yes goes to victory scene.
     */
    private void gameWin()
    {
        if (summoner.getWaves().size() == summoner.getWaveNumber() && summoner.getActiveWave().done() && getObjects(Enemy.class).size() == 0)
        {
            Greenfoot.setWorld(new LoadScreen(getBackground(), new EndMenu(1)));
        }
    }
    
    /**
     * Returns the coins object.
     */
    public Coins getCoins()
    {
        return coins;
    }
}