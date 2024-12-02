package NoGracias;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


public class NoGraciasTest {
    private NoGracias game;
    private ArrayList<Card> deck;

    @BeforeEach public void setup(){
        deck = new ArrayList<>(Arrays.asList(new Card(4),new Card(5),new Card(2),new Card(21),new Card(20),new Card(3),new Card(8)));
        game = new NoGracias(Arrays.asList("jugador1","jugador2"),deck,3);
    }
    @Test public void QuantityOfCards(){
        assertEquals(7,game.quantityOfCards());
    }
    @Test public void DrawACard(){
        game.draw("jugador1");
        assertEquals(6,game.quantityOfCards());
        assertEquals(-1,game.getPoints("jugador1"));
        assertEquals(3,game.getPoints("jugador2"));
    }
    @Test public void TryToDrawACardButItIsNotTheirTurn(){
        assertThrowsLike("No es tu turno", () -> game.draw("jugador2"));
        assertEquals(7,game.quantityOfCards());
        assertEquals(3,game.getPoints("jugador1"));
        assertEquals(3,game.getPoints("jugador2"));
    }
    @Test public void UseToken(){
        game.useToken("jugador1");
        assertEquals(7,game.quantityOfCards());
        assertEquals(2,game.getPoints("jugador1"));
        assertEquals(3,game.getPoints("jugador2"));
    }
    @Test public void TryToUseTokenButItIsNotTheirTurn(){
        assertThrowsLike("No es tu turno", () -> game.useToken("jugador2"));
        assertEquals(7,game.quantityOfCards());
        assertEquals(3,game.getPoints("jugador1"));
        assertEquals(3,game.getPoints("jugador2"));
    }
    @Test public void DrawACardWhichWasSkipped(){
        game.useToken("jugador1").useToken("jugador2").draw("jugador1");
        assertEquals(6,game.quantityOfCards());
        assertEquals(0,game.getPoints("jugador1"));
        assertEquals(2,game.getPoints("jugador2"));;
    }
    @Test public void DrawACardInAnEmptyDeck(){
        game.draw("jugador1").draw("jugador1").draw("jugador1").draw("jugador1").draw("jugador1").draw("jugador1").draw("jugador1");
        assertThrowsLike("El juego ya termino",()->game.draw("jugador1"));
        assertEquals(-60,game.getPoints("jugador1"));
        assertEquals(3,game.getPoints("jugador2"));
    }
    @Test public void TryToUseTokenInAnEmptyDeck(){
        game.draw("jugador1").draw("jugador1").draw("jugador1").draw("jugador1").draw("jugador1").draw("jugador1").draw("jugador1");
        assertThrowsLike("El juego ya termino",()->game.useToken("jugador1"));
        assertEquals(-60,game.getPoints("jugador1"));
        assertEquals(3,game.getPoints("jugador2"));
    }
    @Test public void TryToUseTokenButDontHaveAnyMore(){
        game.useToken("jugador1").useToken("jugador2").useToken("jugador1").useToken("jugador2").useToken("jugador1").useToken("jugador2");
        assertThrowsLike("El jugador ya no tiene mas fichas", ()->game.useToken("jugador1"));
        assertEquals(0,game.getPoints("jugador1"));
        assertEquals(0,game.getPoints("jugador2"));
    }
    @Test public void Winner(){
        game.draw("jugador1").draw("jugador1").draw("jugador1").draw("jugador1").draw("jugador1").draw("jugador1").draw("jugador1");
        assertThrowsLike("El juego ya termino",()->game.useToken("jugador1"));
        assertEquals(-60,game.getPoints("jugador1"));
        assertEquals(3,game.getPoints("jugador2"));
        assertEquals("jugador2",game.winner());
    }
    @Test public void AskingForAWinnerWhenTheGameDidNotEnd(){
        game.draw("jugador1").draw("jugador1").draw("jugador1");
        assertEquals(-8,game.getPoints("jugador1"));
        assertEquals(3,game.getPoints("jugador2"));
        assertThrowsLike("El juego aun no termino",()->game.winner());

    }
    @Test public void Looser(){
        game.draw("jugador1").draw("jugador1").draw("jugador1").draw("jugador1").draw("jugador1").draw("jugador1").draw("jugador1");
        assertThrowsLike("El juego ya termino",()->game.useToken("jugador1"));
        assertEquals(-60,game.getPoints("jugador1"));
        assertEquals(3,game.getPoints("jugador2"));
        assertEquals("jugador1",game.looser());
    }
    @Test public void AskingForALooserrWhenTheGameDidNotEnd(){
        game.draw("jugador1").draw("jugador1").draw("jugador1");
        assertEquals(-8,game.getPoints("jugador1"));
        assertEquals(3,game.getPoints("jugador2"));
        assertThrowsLike("El juego aun no termino",()->game.looser());
    }

    private static void assertThrowsLike(String msg, Executable executable) {
        assertEquals(msg, assertThrows(RuntimeException.class, executable).getMessage());
    }
}
