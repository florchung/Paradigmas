package nothanks;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class NoThanks {
    private ArrayList<Card> deck;
    private Player playerInTurn;
    private int tokensPot;
    private String NO_ES_TU_TURNO = "No es tu turno";
    private List<ActivePlayer> players;


    public NoThanks(List<String> jugadores, ArrayList<Card> mazo, int tokens) {
        deck = mazo;
        players = jugadores.stream().map(player -> new ActivePlayer(player, tokens)).toList();
        players.stream().forEach(player -> player.nextPlayer(players.get((players.indexOf(player) + 1) % players.size())));
        playerInTurn = players.get(0);
        tokensPot = 0;
    }

    public void verifyPlayer(String aName) {
        if (aName != playerInTurn.name()) {
            throw new RuntimeException(NO_ES_TU_TURNO);
        }
    }

    public NoThanks useToken(String aName) {
        verifyPlayer(aName);
        playerInTurn.useCoin();
        tokensPot += 1;
        nextTurn();
        return this;
    }

    public void getPlayerInTurn(Player aPlayer) {
        playerInTurn = aPlayer;
    }

    private void nextTurn() {
        playerInTurn = playerInTurn.turnPass(this);
    }

    public NoThanks draw(String aName) {
        verifyPlayer(aName);
        playerInTurn.drawCard(this);
        playerInTurn.addTokens(tokensPot);
        tokensPot = 0;
        return this;
    }

    public int getPoints(String aName) {
        return players.stream().filter(player -> player.name() == aName).findFirst().get().points();
    }

    public int quantityOfCards() {
        return deck.size();
    }

    public List<Card> deck() {
        return deck;
    }

    public String winner() {
        if (playerInTurn.getClass() != NobodyPlays.class) {
            throw new RuntimeException("El juego aun no termino");
        }
        return players.stream().max(Comparator.comparingInt(Player::points)).get().name();
    }

    public String loser() {
        if (playerInTurn.getClass() != NobodyPlays.class) {
            throw new RuntimeException("El juego aun no termino");
        }
        return players.stream().min(Comparator.comparingInt(Player::points)).get().name();
    }
}
