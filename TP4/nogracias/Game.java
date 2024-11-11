package nogracias;

import java.util.ArrayList;
import java.util.List;

public class Game {
    private List<Player> players;
    private Deck deck;
    private int currentPlayerIndex;

    public Game() {
        this.players = new ArrayList<>();
        this.deck = new Deck();
        this.currentPlayerIndex = 0;
    }

    public void addPlayer(Player player) {
        players.add(player);
    }

    public void startGame() {
        while (deckHasCards()) {
            Player currentPlayer = players.get(currentPlayerIndex);
            Card card = deck.drawCard();
            if (card == null) {
                break;  // Si no hay más cartas, termina el juego
            }

            // El jugador puede "tomar" la carta o "pagar" con un chip (simulado)
            if (takeCard(currentPlayer, card)) {
                System.out.println(currentPlayer.getName() + " toma la carta: " + card.getValue());
            } else {
                currentPlayer.addPoints(card.getValue());
                System.out.println(currentPlayer.getName() + " paga " + card.getValue() + " puntos");
            }

            // Cambiar al siguiente jugador
            currentPlayerIndex = (currentPlayerIndex + 1) % players.size();
        }

        // Al final del juego, mostramos los puntos finales
        showFinalScores();
    }

    private boolean takeCard(Player player, Card card) {
        // Simulamos que el jugador toma la carta si el valor es menor que 20
        return card.getValue() < 20;
    }

    private boolean deckHasCards() {
        // Ahora verificamos correctamente si el mazo tiene cartas
        return deck != null && deck.getRemainingCards() > 0;
    }

    private void showFinalScores() {
        for (Player player : players) {
            System.out.println(player.getName() + " tiene " + player.getPoints() + " puntos.");
        }
    }

    // Para agregar players
    public List<Player> getPlayers() {
        return players;
    }
}
