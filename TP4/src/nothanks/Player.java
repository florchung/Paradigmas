package NoGracias;

import java.util.ArrayList;


public abstract class Player {
    protected Player nextPlayerInTurn;
    protected String name;
    protected ArrayList<Card> drawnCards = new ArrayList<>();
    protected int tokens;

    public Player(String name, int tokens) {
        this.name = name;
        this.tokens = tokens;
    }
    public abstract void useCoin();
    public String name(){
        return name;
    }


    public abstract void drawCard(NoGracias game);


    public Player turnPass(NoGracias noGracias) {
        return nextPlayerInTurn;
    }

    public abstract int points();
    public void nextPlayer(Player aPlayer){
        nextPlayerInTurn=aPlayer;
    }

    public void addTokens(int tokensPot){
        tokens+=tokensPot;
    }
}

