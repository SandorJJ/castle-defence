import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;
import java.util.ArrayList;

/**
 * The slash is a projectile that hits multiple enemies.
 * 
 * @author SJonas
 * @version 2023-11-06
 */
public class Slash extends Projectile
{
    // Constants for gameplay
    private static final int DAMAGE = 4;
    private static final Enemy[] IMMUNE_ENEMIES = {
        new Bat(),
        new EnragedBat(),
        new Ghost(),
        new EnragedGhost()
    };

    private GreenfootImage[] images;
    private static final int IMAGE_COUNT = 30;
    private int imageCount = 0;

    private List<Enemy> enemiesHit = new ArrayList<>();

    /**
     * Constructs the slash object and initializes the images.
     */
    public Slash(Knight knight, Vector velocity, int startingX, int startingY)
    {
        super(knight, velocity, startingX, startingY);
        initializeImages();
    }

    /**
     * Constantly checks if the slash hit an enemy, animates the slash, and moves the slash.
     */
    public void act()
    {
        checkEnemyHit();
        animate();
        move();
    }

    /**
     * Initializes the images of the slash.
     */
    private void initializeImages()
    {
        GreenfootImage baseImage = new GreenfootImage("Slash.png");
        images = new GreenfootImage[IMAGE_COUNT];

        for (int i = 1; i < IMAGE_COUNT; i++)
        {
            int scaleX = baseImage.getWidth() * i / (6 - (tower.getAoeBoost() * tower.getUpgradeLevels()[2]));
            int scaleY = baseImage.getHeight() * i / (7 - (tower.getAoeBoost() * tower.getUpgradeLevels()[2]));
            images[i] = new GreenfootImage(baseImage);
            images[i].scale(scaleX , scaleY);
        }
    }

    /**
     * Animates the slash.
     */
    private void animate()
    {
        if (imageCount >= IMAGE_COUNT) 
        {
            getWorld().removeObject(this);
        }
        else 
        {
            setImage(images[imageCount]);
            imageCount++;
        }
    }

    /**
     * Checks if the slash hit any enemies.
     */
    @Override
    public void checkEnemyHit()
    {
        List<Enemy> enemies = (List<Enemy>) getIntersectingObjects(Enemy.class);
        for (Enemy enemy : enemies) {
            if (enemy != null && canHit(enemy) && !enemiesHit.contains(enemy))
            {
                enemy.hit(DAMAGE + (tower.getAttackBoost() * tower.getUpgradeLevels()[0]));
                enemiesHit.add(enemy);
            }
        }
    }
    
    /**
     * Returns the damage of the slash.
     */
    @Override
    public int getDamage() { return DAMAGE; }
    
    /**
     * Returns the immune enemies of the slash.
     */
    @Override
    public Enemy[] getImmuneEnemies() { return IMMUNE_ENEMIES; }
}