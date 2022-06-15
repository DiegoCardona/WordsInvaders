package WordsInvaders;

public class RedBullet extends Bullet {

    public RedBullet(final int positionX, final int positionY) {
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
}
