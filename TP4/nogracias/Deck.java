package nogracias;

import java.util.Collections;
import java.util.Stack;

public class Deck {
    private Stack<Card> cards;

    public Deck() {
        this.cards = new Stack<>();
        // Se generan las cartas del mazo
        for (int i = 3; i <= 35; i++) {
            cards.push(new Card(i));
        }
        Collections.shuffle(cards);
    }

    public Card drawCard() {
        return cards.isEmpty() ? null : cards.pop();
    }

    public int getRemainingCards() {
        return cards.size();
    }
}
