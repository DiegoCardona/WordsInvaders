package WordsInvaders;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public abstract class Bullet extends LiveObject{

    private static final int SPEED = 150;

    public Bullet(GraphicsContext gc) {
        super(gc);
    }

    /**
     * Create the bullet image and set the initial position of it.
     */
    public abstract void fire();

    /**
     * This method will be used by java FX to update the position of the bullet
     * TO DO: Java FX scene update will be added in the next
     * deliverable for the class(Scenario 7)
     */
    public void update() {
        this.positionY -= SPEED;
    }

    /**
     * Abstract method to be implemented by every type of bullet
     * the intention is to include the logic when a bullet impact happen and return
     * true if the bullet hit the expected type of enemy
     */
    public abstract boolean expectedImpact(Enemy enemy, Goal goal);

    /**
     * Function to calculate if a collision happen
     * @param enemy
     * @return
     */
    public boolean collide(Enemy enemy) {
        int distance = distance(
                this.positionX + this.size / 2,
                this.positionY + this.size / 2,
                enemy.positionX + enemy.size / 2,
                enemy.positionY + enemy.size / 2
        );
        return  distance  < enemy.size / 2 + this.size / 2;
    }

}
