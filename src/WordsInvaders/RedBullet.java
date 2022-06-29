package WordsInvaders;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class RedBullet extends Bullet {

    public RedBullet(final int positionX, final int positionY, GraphicsContext gc) {
        super(gc);
        this.positionX = positionX;
        this.positionY = positionY;
        this.size = 20;
    }

    /**
     * Expected to hit a enemies different from the goal
     * @param enemy
     * @param goal
     * @return
     */
    @Override
    public boolean expectedImpact(Enemy enemy, Goal goal) {
        return !goal.equals(enemy);
    }

    @Override
    public void fire() {
        this.graphicsContext.setFill(Color.RED);
        this.graphicsContext.fillOval(this.positionX, this.positionY, this.size, this.size);
    }
}
