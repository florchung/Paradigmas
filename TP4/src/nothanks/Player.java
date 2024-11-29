package nothanks;

import java.util.ArrayList;
import java.util.List;

public class Player {
    private String name;
    private int tokens;
    private List<Card> cards;

    public Player(String name) {
        this.name = name;
        this.tokens = 11;
        this.cards = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void takeCard(Card card) {
        cards.add(card);
    }

    public int getTokens() {
        return tokens;
    }

    public void placeToken() {
        if (tokens <= 0) throw new IllegalStateException(name + " no tiene más fichas.");
        tokens--;
    }

    public int calculatePoints() {
        int[] result = cards.stream()
                .map(Card::getValue)
                .sorted()
                .reduce(new int[]{0, -2}, (acc, current) -> {
                    if (current != acc[1] + 1) {
                        acc[0] += current;
                    }
                    acc[1] = current;
                    return acc;
                }, (a, b) -> a);
        return result[0];
    }

    public void addTokens(int tokens) {
        this.tokens += tokens;
    }
}
