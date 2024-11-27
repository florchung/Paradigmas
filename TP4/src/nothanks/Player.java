package nothanks;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Player {
    private String name;
    private int tokens;
    private List<Card> cards;
    private int points;

    public Player(String name) {
        this.name = name;
        this.tokens = 11;
        this.cards = new ArrayList<>();
        this.points = 0;
    }

    public String getName() {
        return name;
    }

    public int getTokens() {
        return tokens;
    }

    public void placeToken() {
        if (tokens <= 0) throw new IllegalStateException(name + " no tiene más fichas.");
        tokens--;
    }

    public void takeCard(Card card) {
        cards.add(card);
    }

    public int calculatePoints() {
        if (cards.isEmpty()) {
            return 0;
        }

        int totalPoints = 0;
        int lastCardValue = cards.get(0).getValue(); // El valor de la primera carta
        totalPoints += lastCardValue; // Contamos la primera carta

        for (int i = 1; i < cards.size(); i++) {
            int currentCardValue = cards.get(i).getValue();

            // Si la carta actual no es consecutiva con la anterior
            if (currentCardValue != lastCardValue + 1) {
                totalPoints += currentCardValue; // Sumamos el valor de la carta
            }

            // Si la carta es consecutiva, no la sumamos, solo actualizamos el valor de lastCardValue
            lastCardValue = currentCardValue;
        }

        return totalPoints;
    }
}
