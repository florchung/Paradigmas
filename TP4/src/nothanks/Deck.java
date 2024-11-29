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
        int cardsToRemove = (int) (Math.random() * 10) + 5;
        cards = cards.stream()
                .limit(cards.size() - cardsToRemove)
                .collect(Collectors.toCollection(Stack::new));
    }

    public Stream<Card> getCardsStream() {
        return cards.stream();
    }

    public Card drawCard() {
        return cards.isEmpty() ? null : cards.pop();
    }

    public boolean isEmpty() {
        return cards.isEmpty();
    }
}
