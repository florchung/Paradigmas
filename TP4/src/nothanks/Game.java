package nothanks;

import java.util.ArrayList;
import java.util.List;

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

    public void start() {
        if (players.size() < 2) {
            throw new IllegalStateException("El juego requiere al menos 2 jugadores.");
        }
        System.out.println("El juego ha comenzado.");
        playTurns();
        endGame();
    }

    private void playTurns() {
        while (!deck.isEmpty()) {
            Player currentPlayer = players.get(currentPlayerIndex);
            Card currentCard = deck.drawCard();

            System.out.println("Es el turno de " + currentPlayer.getName());
            new Turn(currentPlayer, currentCard).execute();

            currentPlayerIndex = (currentPlayerIndex + 1) % players.size();
        }
    }

    private void endGame() {
        System.out.println("El juego ha terminado. Resultados finales:");
        for (Player player : players) {
            System.out.println(player.getName() + " tiene " + player.calculatePoints() + " puntos.");
        }
    }

    public List<Player> getPlayers() {
        return players;
    }

    public Deck getDeck() {
        return deck;
    }

}
