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

    @Test
    public void testCardTokens() {
        Card card = new Card(10);
        card.addToken();
        card.addToken();
        assertEquals(2, card.getTokens(), "La carta debe tener 2 fichas acumuladas");
    }

    //Deck Test
    @Test
    public void testDeckInitialization() {
        Deck deck = new Deck();
        assertFalse(deck.isEmpty(), "El mazo no debe estar vacío tras inicialización");
    }

    @Test
    public void testDeckRandomCardRemoval() {
        Deck deck = new Deck();
        int initialSize = 33;
        assertTrue(deck.drawCard().getValue() >= 3, "Las cartas deben estar en el rango de 3 a 35");
        assertTrue(deck.drawCard().getValue() <= 35, "Las cartas deben estar en el rango de 3 a 35");
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
    public void testTakeCardWithTokens() {
        Player player = new Player("Player 1");
        Card card = new Card(10);
        card.addToken();
        card.addToken();
        player.takeCard(card);
        player.addTokens(card.getTokens());
        assertEquals(13, player.getTokens(), "El jugador debe ganar las fichas acumuladas en la carta");
        assertEquals(10, player.calculatePoints(), "El puntaje del jugador debe reflejar el valor de las cartas tomadas");
    }

    @Test
    public void testCalculatePoints() {
        Player player = new Player("Player 1");
        player.takeCard(new Card(5));
        player.takeCard(new Card(6));
        player.takeCard(new Card(10));
        assertEquals(15, player.calculatePoints(), "Las cartas consecutivas deben contar como una sola");
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

//    @Test
//    public void testGameFlow() {
//        // Create a new game instance
//        Game game = new Game();
//
//        // Add players to the game
//        game.addPlayer(new Player("Jugador 1"));
//        game.addPlayer(new Player("Jugador 2"));
//
//        // Start the game
//        game.start();
//
//        // Advance the game (draw cards)
//        game.advanceGame();
//
//        // Assert that the deck is empty after the game flow is complete
//        assertTrue(game.getDeck().isEmpty(), "El mazo debe estar vacío después de jugar");
//    }

    @Test
    public void testGameWinner() {
        Game game = new Game();
        Player player1 = new Player("Jugador 1");
        Player player2 = new Player("Jugador 2");
        game.addPlayer(player1);
        game.addPlayer(player2);

        // Simula una partida rápida
        player1.takeCard(new Card(5));
        player2.takeCard(new Card(10));
        assertTrue(player1.calculatePoints() < player2.calculatePoints(), "Jugador 1 debe ganar con menos puntos");
    }
}
