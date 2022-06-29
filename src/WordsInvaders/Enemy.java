package WordsInvaders;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

import java.util.Random;

public class Enemy extends Word {

    private int speed = 5;
    private int width;
    private int side = -1;

    public Enemy(GraphicsContext gc, int width) {
        super(gc);
        this.width = width;
        this.positionX = new Random().nextInt(width);
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public void kill() {
        System.out.print("I'm dying");
    }

    public void draw(int size) {
        this.size = size;
        this.graphicsContext.setFill(Color.WHITESMOKE);
        this.graphicsContext.fillRect(this.positionX, this.positionY, size, size);
        this.graphicsContext.setFill(Color.BLACK);
        this.graphicsContext.setStroke(Color.BLUE);
        this.graphicsContext.fillText(this.textEnglish, this.positionX+size/2, this.positionY+size/2);

    }

    public void update() {
        this.positionY += speed;
        if (side == -1) {
            side = new Random().nextInt(2);
        }
        int newPosition;
        if (side == 1) {
             newPosition = this.positionX - speed * 2;
        } else {
            newPosition = this.positionX + speed * 2;
        }

        if (newPosition > width) {
            this.side = 1;
            update();
        } else if (newPosition < 0) {
            this.side = 2;
            update();
        } else {
            this.positionX = newPosition;
        }
    }
}
