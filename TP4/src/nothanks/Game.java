package nothanks;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class Game {
    private List<Player> players;
    private Deck deck;
    private int currentPlayerIndex;

    public Game() {
        players = new ArrayList<>();
        deck = new Deck();
        currentPlayerIndex = 0;
    }

    public void addPlayer(Player player) {
        players.add(player);
    }

    public List<Player> getPlayers() {
        return players;
    }

    public Deck getDeck() {
        return deck;
    }

    public void start() {
        if (players.size() < 2) {
            throw new IllegalStateException("El juego requiere al menos 2 jugadores.");
        }
        System.out.println("El juego ha comenzado.");
        advanceGame();
        endGame();
    }

    private boolean isGameOver() {
        return deck.isEmpty();
    }

    private void endGame() {
        System.out.println("\nEl juego ha terminado. Resultados finales:");
        players.forEach(player ->
                System.out.println(player.getName() + " tiene " + player.calculatePoints() + " puntos.")
        );
    }

    public void advanceGame() {
        Stream.iterate(deck.drawCard(), card -> !isGameOver(), card -> deck.drawCard())
                .forEach(this::advanceTurn);
    }

    private void advanceTurn(Card card) {
        Player currentPlayer = players.get(currentPlayerIndex);

        System.out.println("\nEs el turno de " + currentPlayer.getName());
        System.out.println("Carta actual: " + card.getValue() + " con " + card.getTokens() + " fichas.");

        new Turn(currentPlayer, card).execute();

        displayPlayersStatus();
        currentPlayerIndex = (currentPlayerIndex + 1) % players.size();
    }

    private void displayPlayersStatus() {
        players.forEach(player ->
                System.out.println(player.getName() + " tiene " + player.getTokens() + " fichas y " + player.calculatePoints() + " puntos.")
        );
    }
}
