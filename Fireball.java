import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;
import java.util.ArrayList;

/**
 * The fireball is a projectile that hits an enemy and explodes hitting more enemies.
 * 
 * @author SJonas
 * @version 2023-11-06
 */
public class Fireball extends Projectile
{
    // Constants for gameplay
    private static final int DAMAGE = 6;
    private static final Enemy[] IMMUNE_ENEMIES = {};
    
    // Constants/variables for the fireball animation
    private static final String[] IMAGES = {"Fireball-0.png", "Fireball-1.png", "Fireball-2.png"};
    private static final int ANIMATION_DELAY = 10;
    private int image = 0;
    private int animationTimer = 0;

    // Constants/variables for the fireball explosion
    private static final int EXPLOSION_IMAGE_COUNT = 30;
    private GreenfootImage[] explosionImages;
    private int explosionImage = 0;
    private List<Enemy> enemiesHit = new ArrayList<>();
    private boolean exploding = false;

    /**
     * Constructs the fireball object.
     */
    public Fireball(Mage mage, Vector velocity, int startingX, int startingY)
    {
        super(mage, velocity, startingX, startingY);
        initializeExplosionImages();
    }

    /**
     * Constantly checks if the fireball hit an enemy, animates the fireball, and moves the fireball.
     */
    public void act()
    {
        checkEnemyHit();
        if (!exploding)
        {
            animate();
            move();
        }
        else
        {
            animateExplosion();
        }
    }

    /**
     * Checks if the fireball hit any enemies.
     */
    @Override
    public void checkEnemyHit()
    {
        List<Enemy> enemies = (List<Enemy>) getIntersectingObjects(Enemy.class);
        for (Enemy enemy : enemies) {
            if (enemy != null && canHit(enemy) && !enemiesHit.contains(enemy))
            {
                if (!exploding)
                {
                    setLocation(enemy.getX(), enemy.getY());
                }
                enemy.hit(DAMAGE + (tower.getAttackBoost() * tower.getUpgradeLevels()[0]));
                enemiesHit.add(enemy);
                exploding = true;
            }
        }
    }

    /**
     * Animates the fireball.
     */
    private void animate()
    {
        if (animationTimer == ANIMATION_DELAY)
        {
            if (image >= IMAGES.length)
            {
                image = 0;
                setImage(IMAGES[image]);
            }
            else
            {
                setImage(IMAGES[image]);
                image++;
            }
            animationTimer = 0;
        }
        else
        {
            animationTimer++;
        }
    }

    /**
     * Initializes the explosion images of the fireball.
     */
    private void initializeExplosionImages()
    {
        GreenfootImage baseImage = new GreenfootImage("Fireball-1.png");
        explosionImages = new GreenfootImage[EXPLOSION_IMAGE_COUNT];

        for (int i = 1; i < EXPLOSION_IMAGE_COUNT; i++)
        {
            int size = baseImage.getWidth() * i / (8 - (tower.getAoeBoost() * tower.getUpgradeLevels()[2]));
            explosionImages[i] = new GreenfootImage(baseImage);
            explosionImages[i].scale(size, size);
        }
    }

    /**
     * Animates the explosion of the fireball.
     */
    private void animateExplosion()
    {
        if (explosionImage >= explosionImages.length)
        {
            exploding = false;
            getWorld().removeObject(this);
        }
        else
        {
            setImage(explosionImages[explosionImage]);
            explosionImage++;
        }
    }
    
    /**
     * Returns the damage of the fireball.
     */
    @Override
    public int getDamage() { return DAMAGE; }
    
    /**
     * Returns the immune enemies of the fireball.
     */
    @Override
    public Enemy[] getImmuneEnemies() { return IMMUNE_ENEMIES; }
}