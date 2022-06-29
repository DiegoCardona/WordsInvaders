package WordsInvaders;

import javafx.scene.canvas.Canvas;
import javafx.scene.image.Image;
import javafx.scene.input.MouseButton;

import java.util.ArrayList;
import java.util.List;

public class Player extends LiveObject {
    public static final int DEFAULT_LIVES = 3;
    private int lives = DEFAULT_LIVES;
    private int currentLevel = 1;
    private int wrongEnemiesBeaten = 0;
    private String name;
    private final Image IMAGE = new Image("file:assets/player-ship.png");
    private Canvas canvas;
    public List<Bullet> bulletList;

    public Player(int posX, int posY, int playerSize, Canvas canvas) {
        super(canvas.getGraphicsContext2D());
        this.positionX = posX;
        this.positionY = posY;
        this.size = playerSize;
        this.canvas = canvas;
        this.bulletList = new ArrayList<>();

        this.canvas.setOnMouseClicked(e -> {
            if (e.getButton().equals(MouseButton.SECONDARY)) {
                fireRedBullet();
            } else {
                fireBlueBullet();
                System.out.print(this.bulletList.size());
            }
        });
    }

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
        final Bullet redBullet = new RedBullet(this.positionX, this.positionY, this.graphicsContext);
        redBullet.fire();
        this.bulletList.add(redBullet);
    }

    /**
     * This method is used to fire a blue bullet
     * the blue bullet is intended to hit enemies that are the goal word
     * TO DO: attach to a mouse event, input events will be added in the next
     * deliverable for the class(Scenario 7)
     */
    public void fireBlueBullet() {
        final Bullet blueBullet = new BlueBullet(this.positionX, this.positionY, this.graphicsContext);
        blueBullet.fire();
        this.bulletList.add(blueBullet);
    }

    /**
     * This method will be used to handle the common logic required to enable
     * movement.
     */
    public void update() {
        if (!this.bulletList.isEmpty()) {
            this.bulletList.stream().peek(Bullet::update).forEach(Bullet::fire);

            if (this.bulletList.size() > 30) {
                this.bulletList.remove(this.bulletList.size()-1);
            }
        }
    }

    public void draw() {
        this.graphicsContext.drawImage(IMAGE, this.positionX, this.positionY, size, size);
    }

    /**
     * This method is call every time the player got beaten by the enemies,
     * one live is removed from the counter every time it happen, if the live
     * counter goes down to zero the player will lose
     */
    public void beaten() {
        this.lives = 0;
    }

    public Boolean collide(Enemy enemy) {
        int distance = distance(
                this.positionX + this.size / 2,
                this.positionY + this.size / 2,
                enemy.positionX + enemy.size / 2,
                enemy.positionY + enemy.size / 2
        );
        return  distance  < enemy.size / 2 + this.size / 2;
    }

    public void wrongEnemy() {
        this.wrongEnemiesBeaten += 1;
    }
}
