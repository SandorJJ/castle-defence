import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;
import java.util.ArrayList;

/**
 * The summoner summons each enemy wave.
 * 
 * @author SJonas 
 * @version 2023-11-02
 */
public class Summoner extends Actor
{
    private List<Wave> waves = initializeWaves();
    private int waveNumber = 0;
    private Wave activeWave;
    
    /**
     * Constructs the summoner object and loads the next wave button.
     */
    public Summoner()
    {
        nextWaveButton();
    }
    
    /**
     * Constantly updates the next wave button and checks if it was clicked, if it was then summons the next wave.
     */
    public void act()
    {
        nextWaveButton();
        if (Greenfoot.mouseClicked(this))
        {
            summonWave();
        }
    }
    
    /**
     * Initializes all the waves into an ArrayList and returns it.
     */
    private ArrayList<Wave> initializeWaves()
    {
        ArrayList<Wave> waves = new ArrayList<>();
        ArrayList<SubWave> subWaves = new ArrayList<>();
        
        // Wave 1
        subWaves.add(new SubWave(new Slime(), 1, 100));
        waves.add(new Wave(subWaves));
        subWaves = new ArrayList<>();

        // Wave 2
        subWaves.add(new SubWave(new Slime(), 3, 100));
        waves.add(new Wave(subWaves));
        subWaves = new ArrayList<>();

        // Wave 3
        subWaves.add(new SubWave(new Slime(), 5, 85));
        waves.add(new Wave(subWaves));
        subWaves = new ArrayList<>();

        // Wave 4
        subWaves.add(new SubWave(new Slime(), 5, 100));
        subWaves.add(new SubWave(new Slime(), 5, 85));
        waves.add(new Wave(subWaves));
        subWaves = new ArrayList<>();

        // Wave 5
        subWaves.add(new SubWave(new Slime(), 7, 75));
        waves.add(new Wave(subWaves));
        subWaves = new ArrayList<>();

        // Wave 6
        subWaves.add(new SubWave(new Slime(), 3, 100));
        subWaves.add(new SubWave(new Slime(), 3, 85));
        subWaves.add(new SubWave(new Slime(), 3, 75));
        waves.add(new Wave(subWaves));
        subWaves = new ArrayList<>();

        // Wave 7
        subWaves.add(new SubWave(new Slime(), 5, 50));
        waves.add(new Wave(subWaves));
        subWaves = new ArrayList<>();

        // Wave 8
        subWaves.add(new SubWave(new Slime(), 4, 60));
        subWaves.add(new SubWave(new Slime(), 7, 100));
        subWaves.add(new SubWave(new Slime(), 4, 60));
        waves.add(new Wave(subWaves));
        subWaves = new ArrayList<>();

        // Wave 9
        subWaves.add(new SubWave(new Slime(), 5, 100));
        subWaves.add(new SubWave(new Slime(), 5, 85));
        subWaves.add(new SubWave(new Slime(), 5, 75));
        subWaves.add(new SubWave(new Slime(), 5, 50));
        waves.add(new Wave(subWaves));
        subWaves = new ArrayList<>();

        // Wave 10
        subWaves.add(new SubWave(new Wolf(), 1, 100));
        waves.add(new Wave(subWaves));
        subWaves = new ArrayList<>();

        // Wave 11
        subWaves.add(new SubWave(new Slime(), 10, 50));
        waves.add(new Wave(subWaves));
        subWaves = new ArrayList<>();
        
        // Wave 12
        subWaves.add(new SubWave(new Wolf(), 2, 100));
        subWaves.add(new SubWave(new Slime(), 5, 75));
        waves.add(new Wave(subWaves));
        subWaves = new ArrayList<>();

        // Wave 13
        subWaves.add(new SubWave(new Slime(), 4, 85));
        subWaves.add(new SubWave(new Wolf(), 1, 50));
        subWaves.add(new SubWave(new Slime(), 7, 60));
        waves.add(new Wave(subWaves));
        subWaves = new ArrayList<>();

        // Wave 14
        subWaves.add(new SubWave(new Slime(), 7, 80));
        subWaves.add(new SubWave(new Wolf(), 3, 150));
        subWaves.add(new SubWave(new Slime(), 5, 75));
        subWaves.add(new SubWave(new Slime(), 3, 50));
        waves.add(new Wave(subWaves));
        subWaves = new ArrayList<>();

        // Wave 15
        subWaves.add(new SubWave(new Slime(), 4, 60));
        subWaves.add(new SubWave(new Slime(), 6, 45));
        waves.add(new Wave(subWaves));
        subWaves = new ArrayList<>();

        // Wave 16
        subWaves.add(new SubWave(new Slime(), 5, 75));
        subWaves.add(new SubWave(new Wolf(), 1, 25));
        subWaves.add(new SubWave(new Slime(), 12, 45));
        subWaves.add(new SubWave(new Wolf(), 2, 75));
        waves.add(new Wave(subWaves));
        subWaves = new ArrayList<>();

        // Wave 17
        subWaves.add(new SubWave(new Slime(), 5, 50));
        subWaves.add(new SubWave(new Slime(), 6, 40));
        waves.add(new Wave(subWaves));
        subWaves = new ArrayList<>();
        
        // Wave 18
        subWaves.add(new SubWave(new Wolf(), 1, 100));
        subWaves.add(new SubWave(new Slime(), 8, 60));
        subWaves.add(new SubWave(new Wolf(), 2, 75));
        subWaves.add(new SubWave(new Slime(), 5, 50));
        subWaves.add(new SubWave(new Wolf(), 1, 25));
        waves.add(new Wave(subWaves));
        subWaves = new ArrayList<>();

        // Wave 19
        subWaves.add(new SubWave(new Wolf(), 2, 80));
        subWaves.add(new SubWave(new Slime(), 10, 75));
        subWaves.add(new SubWave(new Wolf(), 1, 35));
        subWaves.add(new SubWave(new Slime(), 12, 55));
        subWaves.add(new SubWave(new Wolf(), 2, 70));
        waves.add(new Wave(subWaves));
        subWaves = new ArrayList<>();

        // Wave 20
        subWaves.add(new SubWave(new Bat(), 1, 100));
        waves.add(new Wave(subWaves));
        subWaves = new ArrayList<>();
        
        // Wave 21
        subWaves.add(new SubWave(new Slime(), 7, 80));
        subWaves.add(new SubWave(new Wolf(), 2, 150));
        subWaves.add(new SubWave(new Slime(), 5, 75));
        subWaves.add(new SubWave(new Wolf(), 1, 50));
        waves.add(new Wave(subWaves));
        subWaves = new ArrayList<>();
        
        // Wave 22
        subWaves.add(new SubWave(new Wolf(), 1, 100));
        subWaves.add(new SubWave(new Slime(), 10, 80));
        subWaves.add(new SubWave(new Slime(), 6, 50));
        subWaves.add(new SubWave(new Wolf(), 4, 50));
        subWaves.add(new SubWave(new Wolf(), 2, 100));
        waves.add(new Wave(subWaves));
        subWaves = new ArrayList<>();
        
        // Wave 23
        subWaves.add(new SubWave(new Bat(), 1, 100));
        subWaves.add(new SubWave(new Wolf(), 1, 100));
        subWaves.add(new SubWave(new Slime(), 6, 50));
        subWaves.add(new SubWave(new Wolf(), 4, 50));
        waves.add(new Wave(subWaves));
        subWaves = new ArrayList<>();
        
        // Wave 24
        subWaves.add(new SubWave(new Bat(), 1, 100));
        subWaves.add(new SubWave(new Wolf(), 3, 75));
        subWaves.add(new SubWave(new Slime(), 10, 60));
        subWaves.add(new SubWave(new Bat(), 1, 100));
        waves.add(new Wave(subWaves));
        subWaves = new ArrayList<>();
        
        // Wave 25
        subWaves.add(new SubWave(new Bat(), 2, 150));
        subWaves.add(new SubWave(new Wolf(), 3, 70));
        subWaves.add(new SubWave(new Slime(), 15, 50));
        waves.add(new Wave(subWaves));
        subWaves = new ArrayList<>();
        
        // Wave 26
        subWaves.add(new SubWave(new Wolf(), 3, 70));
        subWaves.add(new SubWave(new Slime(), 15, 50));
        subWaves.add(new SubWave(new Wolf(), 5, 85));
        subWaves.add(new SubWave(new Slime(), 15, 60));
        waves.add(new Wave(subWaves));
        subWaves = new ArrayList<>();
        
        // Wave 27
        subWaves.add(new SubWave(new Bat(), 2, 100));
        subWaves.add(new SubWave(new Wolf(), 3, 60));
        subWaves.add(new SubWave(new Slime(), 10, 60));
        subWaves.add(new SubWave(new Slime(), 6, 75));
        subWaves.add(new SubWave(new Bat(), 1, 100));
        waves.add(new Wave(subWaves));
        subWaves = new ArrayList<>();
        
        // Wave 28
        subWaves.add(new SubWave(new Bat(), 2, 100));
        subWaves.add(new SubWave(new Slime(), 10, 60));
        subWaves.add(new SubWave(new Bat(), 2, 100));
        waves.add(new Wave(subWaves));
        subWaves = new ArrayList<>();
        
        // Wave 29
        subWaves.add(new SubWave(new Slime(), 6, 75));
        subWaves.add(new SubWave(new Bat(), 2, 100));
        subWaves.add(new SubWave(new Slime(), 8, 50));
        subWaves.add(new SubWave(new Wolf(), 1, 25));
        subWaves.add(new SubWave(new Bat(), 2, 100));
        subWaves.add(new SubWave(new Slime(), 10, 60));
        subWaves.add(new SubWave(new Wolf(), 2, 60));
        waves.add(new Wave(subWaves));
        subWaves = new ArrayList<>();
        
        // Wave 30
        subWaves.add(new SubWave(new Ghost(), 1, 100));
        waves.add(new Wave(subWaves));
        subWaves = new ArrayList<>();
        
        // Wave 31
        subWaves.add(new SubWave(new Wolf(), 2, 70));
        subWaves.add(new SubWave(new Slime(), 10, 50));
        subWaves.add(new SubWave(new Wolf(), 6, 85));
        subWaves.add(new SubWave(new Slime(), 18, 60));
        subWaves.add(new SubWave(new Slime(), 5, 40));
        waves.add(new Wave(subWaves));
        subWaves = new ArrayList<>();

        // Wave 32
        subWaves.add(new SubWave(new Bat(), 2, 100));
        subWaves.add(new SubWave(new Slime(), 15, 60));
        subWaves.add(new SubWave(new Wolf(), 6, 85));
        subWaves.add(new SubWave(new Wolf(), 3, 50));
        waves.add(new Wave(subWaves));
        subWaves = new ArrayList<>();
        
        // Wave 33
        subWaves.add(new SubWave(new Ghost(), 1, 100));
        subWaves.add(new SubWave(new Slime(), 8, 75));
        subWaves.add(new SubWave(new Wolf(), 2, 40));
        subWaves.add(new SubWave(new Bat(), 3, 120));
        subWaves.add(new SubWave(new Wolf(), 4, 60));
        waves.add(new Wave(subWaves));
        subWaves = new ArrayList<>();
        
        // Wave 34
        subWaves.add(new SubWave(new Ghost(), 1, 100));
        subWaves.add(new SubWave(new Slime(), 14, 75));
        subWaves.add(new SubWave(new Wolf(), 3, 75));
        subWaves.add(new SubWave(new Bat(), 3, 90));
        subWaves.add(new SubWave(new Wolf(), 4, 60));
        subWaves.add(new SubWave(new Wolf(), 1, 50));
        subWaves.add(new SubWave(new Ghost(), 1, 100));
        waves.add(new Wave(subWaves));
        subWaves = new ArrayList<>();
        
        // Wave 35
        subWaves.add(new SubWave(new Ghost(), 3, 200));
        waves.add(new Wave(subWaves));
        subWaves = new ArrayList<>();
        
        
        
        
        // Enraged waves
        // Wave 1
        subWaves.add(new SubWave(new EnragedSlime(), 1, 100));
        waves.add(new Wave(subWaves));
        subWaves = new ArrayList<>();

        // Wave 2
        subWaves.add(new SubWave(new EnragedSlime(), 3, 100));
        waves.add(new Wave(subWaves));
        subWaves = new ArrayList<>();

        // Wave 3
        subWaves.add(new SubWave(new EnragedSlime(), 5, 85));
        waves.add(new Wave(subWaves));
        subWaves = new ArrayList<>();

        // Wave 4
        subWaves.add(new SubWave(new EnragedSlime(), 5, 100));
        subWaves.add(new SubWave(new EnragedSlime(), 5, 85));
        waves.add(new Wave(subWaves));
        subWaves = new ArrayList<>();

        // Wave 5
        subWaves.add(new SubWave(new EnragedSlime(), 7, 75));
        waves.add(new Wave(subWaves));
        subWaves = new ArrayList<>();

        // Wave 6
        subWaves.add(new SubWave(new EnragedSlime(), 3, 100));
        subWaves.add(new SubWave(new EnragedSlime(), 3, 85));
        subWaves.add(new SubWave(new EnragedSlime(), 3, 75));
        waves.add(new Wave(subWaves));
        subWaves = new ArrayList<>();

        // Wave 7
        subWaves.add(new SubWave(new EnragedSlime(), 5, 50));
        waves.add(new Wave(subWaves));
        subWaves = new ArrayList<>();

        // Wave 8
        subWaves.add(new SubWave(new EnragedSlime(), 4, 60));
        subWaves.add(new SubWave(new EnragedSlime(), 7, 100));
        subWaves.add(new SubWave(new EnragedSlime(), 4, 60));
        waves.add(new Wave(subWaves));
        subWaves = new ArrayList<>();

        // Wave 9
        subWaves.add(new SubWave(new EnragedSlime(), 5, 100));
        subWaves.add(new SubWave(new EnragedSlime(), 5, 85));
        subWaves.add(new SubWave(new EnragedSlime(), 5, 75));
        subWaves.add(new SubWave(new EnragedSlime(), 5, 50));
        waves.add(new Wave(subWaves));
        subWaves = new ArrayList<>();

        // Wave 10
        subWaves.add(new SubWave(new EnragedWolf(), 1, 100));
        waves.add(new Wave(subWaves));
        subWaves = new ArrayList<>();

        // Wave 11
        subWaves.add(new SubWave(new EnragedSlime(), 10, 50));
        waves.add(new Wave(subWaves));
        subWaves = new ArrayList<>();
        
        // Wave 12
        subWaves.add(new SubWave(new EnragedWolf(), 2, 100));
        subWaves.add(new SubWave(new EnragedSlime(), 5, 75));
        waves.add(new Wave(subWaves));
        subWaves = new ArrayList<>();

        // Wave 13
        subWaves.add(new SubWave(new EnragedSlime(), 4, 85));
        subWaves.add(new SubWave(new EnragedWolf(), 1, 50));
        subWaves.add(new SubWave(new EnragedSlime(), 7, 60));
        waves.add(new Wave(subWaves));
        subWaves = new ArrayList<>();

        // Wave 14
        subWaves.add(new SubWave(new EnragedSlime(), 7, 80));
        subWaves.add(new SubWave(new EnragedWolf(), 3, 150));
        subWaves.add(new SubWave(new EnragedSlime(), 5, 75));
        subWaves.add(new SubWave(new EnragedSlime(), 3, 50));
        waves.add(new Wave(subWaves));
        subWaves = new ArrayList<>();

        // Wave 15
        subWaves.add(new SubWave(new EnragedSlime(), 4, 60));
        subWaves.add(new SubWave(new EnragedSlime(), 6, 45));
        waves.add(new Wave(subWaves));
        subWaves = new ArrayList<>();

        // Wave 16
        subWaves.add(new SubWave(new EnragedSlime(), 5, 75));
        subWaves.add(new SubWave(new EnragedWolf(), 1, 25));
        subWaves.add(new SubWave(new EnragedSlime(), 12, 45));
        subWaves.add(new SubWave(new EnragedWolf(), 2, 75));
        waves.add(new Wave(subWaves));
        subWaves = new ArrayList<>();

        // Wave 17
        subWaves.add(new SubWave(new EnragedSlime(), 5, 50));
        subWaves.add(new SubWave(new EnragedSlime(), 6, 40));
        waves.add(new Wave(subWaves));
        subWaves = new ArrayList<>();
        
        // Wave 18
        subWaves.add(new SubWave(new EnragedWolf(), 1, 100));
        subWaves.add(new SubWave(new EnragedSlime(), 8, 60));
        subWaves.add(new SubWave(new EnragedWolf(), 2, 75));
        subWaves.add(new SubWave(new EnragedSlime(), 5, 50));
        subWaves.add(new SubWave(new EnragedWolf(), 1, 25));
        waves.add(new Wave(subWaves));
        subWaves = new ArrayList<>();

        // Wave 19
        subWaves.add(new SubWave(new EnragedWolf(), 2, 80));
        subWaves.add(new SubWave(new EnragedSlime(), 10, 75));
        subWaves.add(new SubWave(new EnragedWolf(), 1, 35));
        subWaves.add(new SubWave(new EnragedSlime(), 12, 55));
        subWaves.add(new SubWave(new EnragedWolf(), 2, 70));
        waves.add(new Wave(subWaves));
        subWaves = new ArrayList<>();

        // Wave 20
        subWaves.add(new SubWave(new EnragedBat(), 1, 100));
        waves.add(new Wave(subWaves));
        subWaves = new ArrayList<>();
        
        // Wave 21
        subWaves.add(new SubWave(new EnragedSlime(), 7, 80));
        subWaves.add(new SubWave(new EnragedWolf(), 2, 150));
        subWaves.add(new SubWave(new EnragedSlime(), 5, 75));
        subWaves.add(new SubWave(new EnragedWolf(), 1, 50));
        waves.add(new Wave(subWaves));
        subWaves = new ArrayList<>();
        
        // Wave 22
        subWaves.add(new SubWave(new EnragedWolf(), 1, 100));
        subWaves.add(new SubWave(new EnragedSlime(), 10, 80));
        subWaves.add(new SubWave(new EnragedSlime(), 6, 50));
        subWaves.add(new SubWave(new EnragedWolf(), 4, 50));
        subWaves.add(new SubWave(new EnragedWolf(), 2, 100));
        waves.add(new Wave(subWaves));
        subWaves = new ArrayList<>();
        
        // Wave 23
        subWaves.add(new SubWave(new EnragedBat(), 1, 100));
        subWaves.add(new SubWave(new EnragedWolf(), 1, 100));
        subWaves.add(new SubWave(new EnragedSlime(), 6, 50));
        subWaves.add(new SubWave(new EnragedWolf(), 4, 50));
        waves.add(new Wave(subWaves));
        subWaves = new ArrayList<>();
        
        // Wave 24
        subWaves.add(new SubWave(new EnragedBat(), 1, 100));
        subWaves.add(new SubWave(new EnragedWolf(), 3, 75));
        subWaves.add(new SubWave(new EnragedSlime(), 10, 60));
        subWaves.add(new SubWave(new EnragedBat(), 1, 100));
        waves.add(new Wave(subWaves));
        subWaves = new ArrayList<>();
        
        // Wave 25
        subWaves.add(new SubWave(new EnragedBat(), 2, 150));
        subWaves.add(new SubWave(new EnragedWolf(), 3, 70));
        subWaves.add(new SubWave(new EnragedSlime(), 15, 50));
        waves.add(new Wave(subWaves));
        subWaves = new ArrayList<>();
        
        // Wave 26
        subWaves.add(new SubWave(new EnragedWolf(), 3, 70));
        subWaves.add(new SubWave(new EnragedSlime(), 15, 50));
        subWaves.add(new SubWave(new EnragedWolf(), 5, 85));
        subWaves.add(new SubWave(new EnragedSlime(), 15, 60));
        waves.add(new Wave(subWaves));
        subWaves = new ArrayList<>();
        
        // Wave 27
        subWaves.add(new SubWave(new EnragedBat(), 2, 100));
        subWaves.add(new SubWave(new EnragedWolf(), 3, 60));
        subWaves.add(new SubWave(new EnragedSlime(), 10, 60));
        subWaves.add(new SubWave(new EnragedSlime(), 6, 75));
        subWaves.add(new SubWave(new EnragedBat(), 1, 100));
        waves.add(new Wave(subWaves));
        subWaves = new ArrayList<>();
        
        // Wave 28
        subWaves.add(new SubWave(new EnragedBat(), 2, 100));
        subWaves.add(new SubWave(new EnragedSlime(), 10, 60));
        subWaves.add(new SubWave(new EnragedBat(), 2, 100));
        waves.add(new Wave(subWaves));
        subWaves = new ArrayList<>();
        
        // Wave 29
        subWaves.add(new SubWave(new EnragedSlime(), 6, 75));
        subWaves.add(new SubWave(new EnragedBat(), 2, 100));
        subWaves.add(new SubWave(new EnragedSlime(), 8, 50));
        subWaves.add(new SubWave(new EnragedWolf(), 1, 25));
        subWaves.add(new SubWave(new EnragedBat(), 2, 100));
        subWaves.add(new SubWave(new EnragedSlime(), 10, 60));
        subWaves.add(new SubWave(new EnragedWolf(), 2, 60));
        waves.add(new Wave(subWaves));
        subWaves = new ArrayList<>();
        
        // Wave 30
        subWaves.add(new SubWave(new EnragedGhost(), 1, 100));
        waves.add(new Wave(subWaves));
        subWaves = new ArrayList<>();
        
        // Wave 31
        subWaves.add(new SubWave(new EnragedWolf(), 2, 70));
        subWaves.add(new SubWave(new EnragedSlime(), 10, 50));
        subWaves.add(new SubWave(new EnragedWolf(), 6, 85));
        subWaves.add(new SubWave(new EnragedSlime(), 18, 60));
        subWaves.add(new SubWave(new EnragedSlime(), 5, 40));
        waves.add(new Wave(subWaves));
        subWaves = new ArrayList<>();

        // Wave 32
        subWaves.add(new SubWave(new EnragedBat(), 2, 100));
        subWaves.add(new SubWave(new EnragedSlime(), 15, 60));
        subWaves.add(new SubWave(new EnragedWolf(), 6, 85));
        subWaves.add(new SubWave(new EnragedWolf(), 3, 50));
        waves.add(new Wave(subWaves));
        subWaves = new ArrayList<>();
        
        // Wave 33
        subWaves.add(new SubWave(new EnragedGhost(), 1, 100));
        subWaves.add(new SubWave(new EnragedSlime(), 8, 75));
        subWaves.add(new SubWave(new EnragedWolf(), 2, 40));
        subWaves.add(new SubWave(new EnragedBat(), 3, 120));
        subWaves.add(new SubWave(new EnragedWolf(), 4, 60));
        waves.add(new Wave(subWaves));
        subWaves = new ArrayList<>();
        
        // Wave 34
        subWaves.add(new SubWave(new EnragedGhost(), 1, 100));
        subWaves.add(new SubWave(new EnragedSlime(), 14, 75));
        subWaves.add(new SubWave(new EnragedWolf(), 3, 75));
        subWaves.add(new SubWave(new EnragedBat(), 3, 90));
        subWaves.add(new SubWave(new EnragedWolf(), 4, 60));
        subWaves.add(new SubWave(new EnragedWolf(), 1, 50));
        subWaves.add(new SubWave(new EnragedGhost(), 1, 100));
        waves.add(new Wave(subWaves));
        subWaves = new ArrayList<>();
        
        // Wave 35
        subWaves.add(new SubWave(new EnragedGhost(), 3, 200));
        waves.add(new Wave(subWaves));
        subWaves = new ArrayList<>();
        
        return waves;
    }
    
    /**
     * Summons the next wave when the next wave button is clicked.
     */
    private void summonWave()
    {
        if (Greenfoot.getMouseInfo().getX() > 720 - 74 && Greenfoot.getMouseInfo().getY() > 480 - 25)
        {
            if (waveNumber == 0)
            {
                activeWave = waves.get(waveNumber);
                getWorld().addObject(activeWave, 684, 446);
                activeWave.display(waveNumber + 1, waves.size());
                waveNumber++;
            } 
            else if (activeWave.done() && waveNumber < waves.size())
            {
                getWorld().removeObject(activeWave);
                activeWave = waves.get(waveNumber);
                getWorld().addObject(activeWave, 684, 446);
                activeWave.display(waveNumber + 1, waves.size());
                waveNumber++;
            }
        }
    }
    
    /**
     * Updates the next wave button.
     */
    private void nextWaveButton()
    {
        GreenfootImage image = new GreenfootImage("Board.png");
        if (activeWave == null)
        {
            image.drawString("Next Wave", 7, 17);
            setImage(image);
            return;
        }
        
        if (activeWave.done() && waveNumber != waves.size())
        {
            image.drawString("Next Wave", 7, 17);
        }
        else
        {
            image.drawString("--------------", 8, 17);
        }
        setImage(image);
    }
    
    /**
     * Returns the list of waves.
     */
    public List<Wave> getWaves()
    {
        return waves;
    }
    
    /**
     * Returns the current wave number.
     */
    public int getWaveNumber()
    {
        return waveNumber;
    }
    
    /**
     * Returns the current active wave.
     */
    public Wave getActiveWave()
    {
        return activeWave;
    }
}
