package nothanks;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class NoThanksTest {

    //Card Test
    @Test
    public void testCardValue() {
        Card card = new Card(10);
        assertEquals(10, card.getValue(), "El valor de la carta debe ser 10");
    }

    //Deck Test
    @Test
    public void testDeckInitialization() {
        Deck deck = new Deck();
        assertFalse(deck.isEmpty(), "El mazo no debe estar vacío tras inicialización");
        int cardValue = deck.drawCard().getValue();
        assertTrue(cardValue >= 3 && cardValue <= 35, "El valor de la carta debe estar entre 3 y 35");
    }


    @Test
    public void testDrawCard() {
        Deck deck = new Deck();
        Card card = deck.drawCard();
        assertNotNull(card, "Debe devolver una carta al extraer");
    }

    @Test
    public void testDeckEmpty() {
        Deck deck = new Deck();
        while (!deck.isEmpty()) {
            deck.drawCard();
        }
        assertTrue(deck.isEmpty(), "El mazo debe estar vacío después de extraer todas las cartas");
    }

    //Game Test
    @Test
    public void testAddPlayer() {
        Game game = new Game();
        Player player = new Player("Jugador 1");
        game.addPlayer(player);
        assertEquals(1, game.getPlayers().size(), "El juego debe tener un jugador agregado");
        assertEquals("Jugador 1", game.getPlayers().get(0).getName(), "El nombre del jugador debe coincidir con el agregado");
    }

    @Test
    public void testStartGameWithInsufficientPlayers() {
        Game game = new Game();
        Exception exception = assertThrows(IllegalStateException.class, game::start);
        assertEquals("El juego requiere al menos 2 jugadores.", exception.getMessage());
    }

    @Test
    public void testStartGame() {
        Game game = new Game();
        game.addPlayer(new Player("Jugador 1"));
        game.addPlayer(new Player("Jugador 2"));
        assertDoesNotThrow(game::start, "El juego debe iniciarse sin errores con al menos 2 jugadores");
    }

    @Test
    public void testGameFlow() {
        Game game = new Game();
        game.addPlayer(new Player("Jugador 1"));
        game.addPlayer(new Player("Jugador 2"));

        game.start();
        assertTrue(game.getDeck().isEmpty(), "El mazo debe estar vacío después de jugar");
    }

    //Player Test
    @Test
    public void testPlayerInitialization() {
        Player player = new Player("Player 1");
        assertEquals("Player 1", player.getName());
        assertEquals(11, player.getTokens(), "El jugador debe iniciar con 11 fichas");
    }

    @Test
    public void testPlaceToken() {
        Player player = new Player("Player 1");
        player.placeToken();
        assertEquals(10, player.getTokens(), "El jugador debe tener 10 fichas después de colocar una ficha");
    }

    @Test
    public void testTakeCard() {
        Player player = new Player("Player 1");
        Card card = new Card(15);
        player.takeCard(card);
        System.out.println("Player points after taking card: " + player.calculatePoints());
        assertEquals(15, player.calculatePoints(), "El puntaje del jugador debe reflejar el valor de las cartas tomadas");
    }

    @Test
    public void testCalculatePoints() {
        Player player = new Player("Player 1");
        player.takeCard(new Card(5));  // Primer carta, valor 5
        player.takeCard(new Card(6));  // Carta consecutiva, valor 6
        player.takeCard(new Card(10)); // Carta no consecutiva, valor 10
        // Asegúrate de que solo cuentes 5 (la primera carta consecutiva, 5 y 6 deben contar como una sola)
        assertEquals(5 + 10, player.calculatePoints(), "Las cartas consecutivas deben contar como una sola");
    }

    //Turn Test
    @Test
    public void testTurnExecution() {
        Player player = new Player("Player 1");
        Card card = new Card(10);
        Turn turn = new Turn(player, card);
        turn.execute();

        assertTrue(player.getTokens() < 11 || player.calculatePoints() > 0, "El turno debe modificar el estado del jugador");
    }
}
