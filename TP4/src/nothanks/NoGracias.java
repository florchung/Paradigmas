package NoGracias;

import java.util.ArrayList;
import java.util.List;

public class NoGracias {
    private ArrayList<Card> deck;
    private Player playerInTurn;
    private int tokensPot;
    private String NO_ES_TU_TURNO = "No es tu turno";
    private List<ActivePlayer> players;


    public NoGracias(List<String> jugadores,ArrayList<Card>mazo, int tokens){
        deck=mazo;
        players= jugadores.stream().map(player->new ActivePlayer(player,tokens)).toList();
        players.stream().forEach(player->player.nextPlayer(players.get((players.indexOf(player)+1)%players.size())));
        playerInTurn=players.get(0);
        tokensPot=0;
    }
    public void verifyPlayer(String aName){
        if(aName!= playerInTurn.name()){
            throw new RuntimeException(NO_ES_TU_TURNO);
        }
    }
    public NoGracias useToken(String aName){
        verifyPlayer(aName);
        playerInTurn.useCoin();
        tokensPot+=1;
        nextTurn();
        return this;
    }
    public void getPlayerInTurn(Player aPlayer){
        playerInTurn = aPlayer;
    }
    private void nextTurn() {
        playerInTurn = playerInTurn.turnPass(this);
    }
    public NoGracias draw(String aName){
        verifyPlayer(aName);
        playerInTurn.drawCard(this);
        playerInTurn.addTokens(tokensPot);
        tokensPot=0;
        return this;
    }
    public int getPoints(String aName){
        return players.stream().filter(player->player.name()==aName).findFirst().get().points();
    }
    public int quantityOfCards(){
        return deck.size();
    }
    public List<Card> deck() {
        return deck;
    }
}
