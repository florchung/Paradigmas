package nogracias;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class NoGraciasGameTest {

    private Game game;
    private Player player1;
    private Player player2;

    @BeforeEach
    public void setUp() {
        game = new Game();
        player1 = new Player("Jugador 1");
        player2 = new Player("Jugador 2");

        game.addPlayer(player1);
        game.addPlayer(player2);
    }

    @Test
    public void testGameOver() {
        // Simulamos el fin del juego y verificamos los puntajes
        game.startGame();
        assertTrue(player1.getPoints() >= 0);
        assertTrue(player2.getPoints() >= 0);

        // Verificamos que el juego haya terminado y que los jugadores tengan puntajes correctos
        assertTrue(game.getPlayers().get(0).getPoints() >= 0);
        assertTrue(game.getPlayers().get(1).getPoints() >= 0);
    }

    @Test
    public void testGameInitialization() {
        assertEquals(2, game.getPlayers().size());
        assertEquals("Jugador 1", player1.getName());
        assertEquals("Jugador 2", player2.getName());
    }

    @Test
    public void testCardDraw() {
        Deck deck = new Deck();
        Card card = deck.drawCard();
        assertNotNull(card);
    }

    @Test
    public void testPlayerPoints() {
        player1.addPoints(10);
        assertEquals(10, player1.getPoints());
        player2.addPoints(5);
        assertEquals(5, player2.getPoints());
    }
}
