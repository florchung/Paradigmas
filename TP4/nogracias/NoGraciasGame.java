// package nogracias;

// public class NoGraciasGame {

//     public static void main(String[] args) {
//         Game game = new Game();
//         game.addPlayer(new Player("Jugador 1"));
//         game.addPlayer(new Player("Jugador 2"));

//         // Game Start
//         game.startGame();
//     }
// }


package NoGracias;

import java.util.ArrayList;
import java.util.List;

public class NoGracias {
    private ArrayList<Card> deck;
    private List<Player> players;
    private int turn;
    private int tokensPot;
    private String YA_NO_HAY_MAS_CARTAS = "Ya no hay mas cartas";
    private String NO_ES_TU_TURNO = "No es tu turno";


    public NoGracias(List<Player>jugadores,ArrayList<Card>mazo){
        deck=mazo;
        players=jugadores;
        turn =0;
        tokensPot=0;
    }
    public NoGracias useToken(Player aPlayer){
        if (deck.isEmpty()){
            throw new RuntimeException(YA_NO_HAY_MAS_CARTAS);
        }
        if(playerTurn()!=aPlayer){
            throw new RuntimeException(NO_ES_TU_TURNO);
        }
        aPlayer.useCoin();
        tokensPot+=1;
        nextTurn();
        return this;
    }
    public Player playerTurn(){
       return players.get(turn%players.size());
    }
    public NoGracias draw(Player aplayer){
        if (deck.isEmpty()){
            throw new RuntimeException(YA_NO_HAY_MAS_CARTAS);
        }
        if(playerTurn()!=aplayer){
            throw new RuntimeException(NO_ES_TU_TURNO);
        }
        Card aCard = deck.remove(0);
        aplayer.drawCard(aCard);
        aplayer.addTokens(tokensPot);
        tokensPot=0;
        return this;
    }
    public void nextTurn(){
        turn+=1;
    }
    public int quantityOfPlayers(){
        return players.size();
    }
    public int quantityOfCards(){
        return deck.size();
    }

}
