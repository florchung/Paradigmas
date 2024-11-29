package nothanks;

public class Turn {
    private Player player;
    private Card card;

    public Turn(Player player, Card card) {
        this.player = player;
        this.card = card;
    }

    public void execute() {
        if (shouldPlaceToken()) {
            player.placeToken();
            card.addToken();
            System.out.println(player.getName() + " colocó una ficha en la carta " + card.getValue());
        } else {
            player.takeCard(card);
            player.addTokens(card.getTokens());
            System.out.println(player.getName() + " tomó la carta " + card.getValue() + " con " + card.getTokens() + " fichas.");
        }
    }

    private boolean shouldPlaceToken() {
        if (player.getTokens() == 0) {
            return false;
        }
        return card.getValue() + card.getTokens() < 10 || Math.random() < 0.3;
    }
}
