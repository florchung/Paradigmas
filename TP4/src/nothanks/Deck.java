package nothanks;

import java.util.Collections;
import java.util.Stack;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Deck {
    private Stack<Card> cards;

    public Deck() {
        cards = new Stack<>();
        cards.addAll(
                java.util.stream.IntStream.rangeClosed(3, 35)
                        .mapToObj(Card::new)
                        .collect(Collectors.toList())
        );
        Collections.shuffle(cards);
        removeRandomCards();
    }

    private void removeRandomCards() {
        int cardsToRemove = Math.min(cards.size() / 3, (int) (Math.random() * 10) + 5);
        cards = cards.stream()
                .skip(cardsToRemove)
                .collect(Collectors.toCollection(Stack::new));
    }

    public Stream<Card> getCardsStream() {
        Stack<Card> copy = new Stack<>();
        copy.addAll(cards);
        return copy.stream();
    }

    public Card drawCard() {
        return cards.isEmpty() ? null : cards.pop();
    }

    public boolean isEmpty() {
        return cards.isEmpty();
    }
}
