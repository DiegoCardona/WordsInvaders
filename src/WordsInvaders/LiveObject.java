package WordsInvaders;

import javafx.scene.canvas.GraphicsContext;

public class LiveObject {
    public int positionX;
    public int positionY;
    public GraphicsContext graphicsContext;
    public int size;

    public LiveObject(GraphicsContext gc) {
        this.graphicsContext = gc;
    }


    /**
     * This method is use to calculate the distance from one object to other
     * this method is pretty helpful to calculate colision
     * @param x1 position in x for the first object
     * @param y1 position in y for the first object
     * @param x2 position in x for the second object
     * @param y2 position in y for the second object
     * @return an int with the distance between the two objects
     */
    public static int distance(int x1, int y1, int x2, int y2) {
        return (int) Math.sqrt(Math.pow((x1 - x2), 2) + Math.pow((y1 - y2), 2));
    }
}
