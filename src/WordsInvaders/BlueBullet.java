package WordsInvaders;

public class BlueBullet extends Bullet {

    public BlueBullet(final int positionX, final int positionY) {
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

}
