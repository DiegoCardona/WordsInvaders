package Tests;

import WordsInvaders.Player;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import junit.framework.TestCase;

public class PlayerTest extends TestCase {

    private Canvas testCanvas = new Canvas(10, 10);

    public void testPassLevel() {
        Player player = new Player(0, 0, 0, testCanvas);
        player.beaten();
        player.passLevel();

        assertEquals(Player.DEFAULT_LIVES, player.getLives());
    }

    public void testBeaten() {
        Player player = new Player(0, 0, 0, testCanvas);
        player.beaten();

        assertEquals(Player.DEFAULT_LIVES-1, player.getLives());
    }
}
