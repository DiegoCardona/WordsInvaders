package WordsInvaders;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class BlueBullet extends Bullet {

    public BlueBullet(final int positionX, final int positionY, GraphicsContext gc) {
        super(gc);
        this.positionX = positionX;
        this.positionY = positionY;
        this.size = 20;
    }

    /**
     * Expected to hit the goal enemy.
     * @param enemy
     * @param goal
     * @return
     */
    @Override
    public boolean expectedImpact(Enemy enemy, Goal goal) {
        return goal.equals(enemy);
    }

    @Override
    public void fire() {
        this.graphicsContext.setFill(Color.BLUE);
        this.graphicsContext.fillOval(this.positionX, this.positionY, this.size, this.size);
    }
}
