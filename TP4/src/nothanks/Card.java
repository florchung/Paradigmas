package nothanks;

public class Card {
    private int value;
    private int tokens;

    public Card(int value) {
        this.value = value;
        this.tokens = 0;
    }

    public int getValue() {
        return value;
    }

    public int getTokens() {
        return tokens;
    }

    public void addToken() {
        tokens++;
    }
}
