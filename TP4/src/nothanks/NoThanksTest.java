package NoGracias;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


public class NoGraciasTest {

    private static NoGracias game;
    private static Player player1;
    private static Player player2;
    private ArrayList<Card> deck;
    private List<Player> players;

    @BeforeEach public void setup(){
        player1 = new Player("Jugador1",3);
        player2= new Player("Jugador2",3);
        players = List.of(player1,player2);
        deck = new ArrayList<>(Arrays.asList(new Card(4),new Card(5),new Card(2),new Card(21),new Card(20),new Card(3),new Card(8)));
        game = new NoGracias(players,deck);
    }

    @Test public void GameWithNoCardsNorPlayers(){
        NoGracias game = new NoGracias(new ArrayList<>(),new ArrayList<>());
        assertEquals(0, game.quantityOfCards());
        assertEquals(0, game.quantityOfPlayers());
    }
    @Test public void QuantityOfPlayersAndCards(){
        assertGame(2, 7, 3, 3);
    }
    @Test public void DrawACard(){
        game.draw(player1);
        assertGame(2, 6, -1, 3);
    }
    @Test public void TryToDrawACardButItIsNotTheirTurn(){
        assertThrowsLike("No es tu turno", () -> game.draw(player2));
        assertGame(2,7,3,3);
    }
    @Test public void UseToken(){
        game.useToken(player1);
        assertGame(2,7,2,3);
    }
    @Test public void TryToUseTokenButItIsNotTheirTurn(){
        assertThrowsLike("No es tu turno", () -> game.useToken(player2));
        assertGame(2,7,3,3);
    }
    @Test public void DrawACardWhichWasSkipped(){
        game.useToken(player1).useToken(player2).draw(player1);
        assertGame(2,6,0,2);
    }
    @Test public void DrawACardInAnEmptyDeck(){
        game.draw(player1).draw(player1).draw(player1).draw(player1).draw(player1).draw(player1).draw(player1);
        assertThrowsLike("Ya no hay mas cartas",()->game.draw(player1));
    }
    @Test public void TryToUseTokenInAnEmptyDeck(){
        game.draw(player1).draw(player1).draw(player1).draw(player1).draw(player1).draw(player1).draw(player1);
        assertThrowsLike("Ya no hay mas cartas",()->game.useToken(player1));
    }
    @Test public void TryToUseTokenButDontHaveAnyMore(){
        game.useToken(player1).useToken(player2).useToken(player1).useToken(player2).useToken(player1).useToken(player2);
        assertThrowsLike("El jugador ya no tiene mas fichas", ()->game.useToken(player1));
    }

    private static void assertThrowsLike(String msg, Executable executable) {
        assertEquals(msg, assertThrows(RuntimeException.class, executable).getMessage());
    }
    private static void assertGame(int quantityOfPlayers, int quantityOfCards, int player1Points, int Player2Points) {
        assertEquals(quantityOfPlayers,game.quantityOfPlayers());
        assertEquals(quantityOfCards,game.quantityOfCards());
        assertEquals(player1Points,player1.points());
        assertEquals(Player2Points,player2.points());
    }

}
