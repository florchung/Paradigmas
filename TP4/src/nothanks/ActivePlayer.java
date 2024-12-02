package nothanks;

public class ActivePlayer extends Player{
    private String EL_JUGADOR_YA_NO_TIENE_MAS_FICHAS="El jugador ya no tiene mas fichas";

    public ActivePlayer(String name, int tokens) {
        super(name,tokens);
    }

    public void useCoin(){
        if(tokens==0){
            throw new RuntimeException(EL_JUGADOR_YA_NO_TIENE_MAS_FICHAS);
        }
        tokens-=1;
    }

    public void drawCard(NoThanks game) {
        if (game.deck().size() == 1) {
            drawCard(game.deck().remove(0));
            game.getPlayerInTurn(new NobodyPlays(name, points()));
        } else {
            drawnCards.add(game.deck().remove(0));
        }
    }

    public int points() {
        return -drawnCards.stream().reduce(0,(total,card)->total+card.value(), Integer ::sum)+ tokens;
    }

    public void drawCard(Card aCard) {
        drawnCards.add(aCard);
    }
}
