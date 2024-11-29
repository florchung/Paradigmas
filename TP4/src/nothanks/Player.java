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
        return cards.stream()
                .map(Card::getValue)
                .sorted()
                .reduce(0, (sum, current) -> {
                    if (sum == 0 || current > (sum & 0xFFFF) + 1) {
                        return sum + current;
                    }
                    return sum;
                });
    }

    public void addTokens(int tokens) {
        this.tokens += tokens;
    }
}
