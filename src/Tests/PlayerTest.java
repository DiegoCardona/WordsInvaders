package Tests;

import WordsInvaders.Player;
import junit.framework.TestCase;

public class PlayerTest extends TestCase {

    public void testPassLevel() {
        Player player = new Player();
        player.beaten();
        player.passLevel();

        assertEquals(Player.DEFAULT_LIVES, player.getLives());
    }

    public void testBeaten() {
        Player player = new Player();
        player.beaten();

        assertEquals(Player.DEFAULT_LIVES-1, player.getLives());
    }
}
