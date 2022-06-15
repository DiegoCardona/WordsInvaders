package WordsInvaders;

public class Player extends LiveObject {
    public static final int DEFAULT_LIVES = 3;
    private int lives = DEFAULT_LIVES;
    private int currentLevel = 1;
    private int wrongEnemiesBeaten = 0;
    private String name;
    private String imagePath = "to/be/defined";

    public int getWrongEnemiesBeaten() {
        return wrongEnemiesBeaten;
    }

    public int getLives() {
        return this.lives;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCurrentLevel() {
        return this.currentLevel;
    }

    /**
     * Once the level accomplish to clear or pass the level the lives counter
     * get back to the default value also the counter for enemies beaten with
     * the wrong bullet get back to zwro and the level is increased
     */
    public void passLevel() {
        this.lives = DEFAULT_LIVES;
        this.wrongEnemiesBeaten = 0;
        this.currentLevel += 1;
    }

    /**
     * This method is used to fire a red bullet
     * the red bullet is intended to hit enemies that aren't the goal word
     * TO DO: attach to a mouse event, input events will be added in the next
     * deliverable for the class(Scenario 7)
     */
    public void fireRedBullet() {
        final Bullet redBullet = new RedBullet(this.positionX, this.positionY);
        redBullet.fire();
    }

    /**
     * This method is used to fire a blue bullet
     * the blue bullet is intended to hit enemies that are the goal word
     * TO DO: attach to a mouse event, input events will be added in the next
     * deliverable for the class(Scenario 7)
     */
    public void fireBlueBullet() {
        final Bullet redBullet = new BlueBullet(this.positionX, this.positionY);
        redBullet.fire();
    }

    /**
     * This method will be used to handle the common logic required to enable
     * movement.
     * TO DO: attach to a mouse event, input events will be added in the next
     * deliverable for the class(Scenario 7)
     */
    public void move() {
        // To be defined when listener implemented for the third deliverable of the class
    }

    /**
     * This method is call every time the player got beaten by the enemies,
     * one live is removed from the counter every time it happen, if the live
     * counter goes down to zero the player will lose
     */
    public void beaten() {
        this.lives--;
        if (0 == lives) {
            // to add logic for game over, it will be defined once the Java FX logic to handle
            // the scene got implement, for the next deliverable
        }
    }

}
