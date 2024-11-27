package nothanks;

public class Turn {
    private Player player;
    private Card card;

    public Turn(Player player, Card card) {
        this.player = player;
        this.card = card;
    }

    public void execute() {
        if (player.getTokens() > 0 && Math.random() < 0.5) {
            player.placeToken();
            System.out.println(player.getName() + " colocó una ficha.");
        } else {
            player.takeCard(card);
            System.out.println(player.getName() + " tomó la carta " + card.getValue());
        }
    }
}
