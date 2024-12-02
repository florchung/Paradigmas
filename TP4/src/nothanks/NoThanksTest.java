package nothanks;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


public class NoThanksTest {
    private static final String EL_JUGADOR_NO_TIENE_MAS_FICHAS = "El jugador ya no tiene mas fichas";
    private static final String EL_JUEGO_AUN_NO_TERMINO = "El juego aun no termino";
    private NoThanks game;
    private ArrayList<Card> deck;
    private String NO_ES_TU_TURNO="No es tu turno";
    private String EL_JUEGO_YA_TERMINO="El juego ya termino";

    @BeforeEach public void setup(){
        deck = new ArrayList<>(Arrays.asList(new Card(4),new Card(5),new Card(2),new Card(21),new Card(20),new Card(3),new Card(8)));
        game = new NoThanks(Arrays.asList("jugador1","jugador2"),deck,3);
    }

    @Test public void QuantityOfCards(){
        assertEquals(7,game.quantityOfCards());
    }

    @Test public void DrawACard(){
        game.draw("jugador1");
        StateOfGame(6, -1, "jugador1", 3, "jugador2");
    }

    @Test public void TryToDrawACardButItIsNotTheirTurn(){
        NoEsElTurnoDeJugador2(() -> game.draw("jugador2"));
    }

    @Test public void UseToken(){
        game.useToken("jugador1");
        StateOfGame(7, 2, "jugador1", 3, "jugador2");
    }

    @Test public void TryToUseTokenButItIsNotTheirTurn(){
        NoEsElTurnoDeJugador2(() -> game.useToken("jugador2"));
    }

    @Test public void DrawACardWhichWasSkipped(){
        game.useToken("jugador1").useToken("jugador2").draw("jugador1");
        StateOfGame(6, 0, "jugador1", 2, "jugador2");
    }

    @Test public void DrawACardInAnEmptyDeck(){
        ElJugador1SeRoboTodasLasCartas(EL_JUEGO_YA_TERMINO, () -> game.draw("jugador1"));
    }

    @Test public void TryToUseTokenInAnEmptyDeck(){
        ElJugador1SeRoboTodasLasCartas(EL_JUEGO_YA_TERMINO, () -> game.useToken("jugador1"));
    }

    @Test public void TryToUseTokenButDontHaveAnyMore(){
        game.useToken("jugador1").useToken("jugador2").useToken("jugador1").useToken("jugador2").useToken("jugador1").useToken("jugador2");
        StateOfGame(7, 0, "jugador1", 0, "jugador2");
        assertThrowsLike(EL_JUGADOR_NO_TIENE_MAS_FICHAS, ()->game.useToken("jugador1"));
    }

    @Test public void Winner(){
        ElJugador1SeRoboTodasLasCartas(EL_JUEGO_YA_TERMINO, () -> game.useToken("jugador1"));
        assertEquals("jugador2",game.winner());
    }

    @Test public void AskingForAWinnerWhenTheGameDidNotEnd(){
        ElJugador1Agarro3CartasSeguidas();
        assertThrowsLike(EL_JUEGO_AUN_NO_TERMINO,()->game.winner());
    }

    @Test public void Loser(){
        ElJugador1SeRoboTodasLasCartas(EL_JUEGO_YA_TERMINO, () -> game.useToken("jugador1"));
        assertEquals("jugador1",game.loser());
    }

    @Test public void AskingForALoserWhenTheGameDidNotEnd(){
        ElJugador1Agarro3CartasSeguidas();
        assertThrowsLike(EL_JUEGO_AUN_NO_TERMINO,()->game.loser());
    }

    private void ElJugador1Agarro3CartasSeguidas() {
        game.draw("jugador1").draw("jugador1").draw("jugador1");
        StateOfGame(4, -8, "jugador1", 3, "jugador2");
    }

    private static void assertThrowsLike(String msg, Executable executable) {
        assertEquals(msg, assertThrows(RuntimeException.class, executable).getMessage());
    }

    private void StateOfGame(int quantityOfCards, int player1Points, String player1Name, int player2Points, String player2Name) {
        assertEquals(quantityOfCards,game.quantityOfCards());
        assertEquals(player1Points,game.getPoints(player1Name));
        assertEquals(player2Points,game.getPoints(player2Name));
    }

    private void NoEsElTurnoDeJugador2(Executable executable) {
        assertThrowsLike(NO_ES_TU_TURNO, executable);
        StateOfGame(7, 3, "jugador1", 3, "jugador2");
    }
    
    private void ElJugador1SeRoboTodasLasCartas(String msg, Executable executable) {
        game.draw("jugador1").draw("jugador1").draw("jugador1").draw("jugador1").draw("jugador1").draw("jugador1").draw("jugador1");
        assertThrowsLike(msg, executable);
        StateOfGame(0, -60, "jugador1", 3, "jugador2");
    }
}
