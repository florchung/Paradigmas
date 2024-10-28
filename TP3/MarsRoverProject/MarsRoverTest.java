package MarsRoverProject;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class MarsRoverTest {

    private MarsRover marsRover;

    @BeforeEach
    public void setUp() {
        marsRover = new MarsRover(new Point(0, 0), new East());
    }

    @Test
    public void test00MarsRoverCanBeCreatedAnyWhereFacingAnything() {
        marsRover = new MarsRover(new Point(25, 13), new South());
        assertCoords(25, 13);
        assertEquals(new South(), marsRover.getDirection());
    }

    @Test
    public void test01MarsRoverStartsAtCenterByDefault() {
        assertCoords(0, 0);
    }

    @Test
    public void test02MarsRoverStartsFacingEast() {
        assertEquals(new East(), marsRover.getDirection());
    }

    // Movement tests
    @Test
    public void test03MarsRoverMovesForwardInXCoordinate() {
        marsRover.receiveMessage("f");
        assertCoords(1, 0); // Moves 1 unit east
    }

    @Test
    public void test04MarsRoverMovesBackwardInXCoordinate() {
        marsRover.receiveMessage("b");
        assertCoords(-1, 0); // Moves 1 unit west
    }

    @Test
    public void test05MarsRoverTurnsRightToFaceSouth() {
        marsRover.receiveMessage("r");
        assertEquals(new South(), marsRover.getDirection());
    }

    @Test
    public void test06MarsRoverTurnsLeftToFaceNorth() {
        marsRover.receiveMessage("l");
        assertEquals(new North(), marsRover.getDirection());
    }

    @Test
    public void test07MarsRoverMovesInYCoordinateAfterTurnLeft() {
        marsRover.receiveMessage("lf");
        assertCoords(0, 1); // Moves 1 unit north after turning left (to face north)
    }

    @Test
    public void test08MarsRoverMovesBackInYCoordinateAfterTurnRight() {
        marsRover.receiveMessage("rf");
        assertCoords(0, -1); // Moves 1 unit south after turning right (to face south)
    }

    // Hatch tests
    @Test
    public void test09OpenUpperHatch() {
        marsRover.receiveMessage("O");
        assertThrows(RuntimeException.class, () -> marsRover.openLowerHatch()); // Cannot open lower hatch while upper hatch is open
    }

    @Test
    public void test10OpenLowerHatch() {
        marsRover.receiveMessage("o");
        assertThrows(RuntimeException.class, () -> marsRover.openUpperHatch()); // Cannot open upper hatch while lower hatch is open
    }

    @Test
    public void test11CloseHatches() {
        marsRover.receiveMessage("O"); // Open upper hatch
        marsRover.receiveMessage("c"); // Close hatches
        // Trying to close hatches when they are already closed should throw an exception
        assertThrows(RuntimeException.class, () -> marsRover.closeHatches());
    }

    // Air aspirating tests
    @Test
    public void test12AspirateAirFailsWhenUpperHatchClosed() {
        assertThrows(RuntimeException.class, () -> marsRover.aspirateAir()); // Upper hatch is closed
    }

    @Test
    public void test13AspirateAirSucceedsWhenUpperHatchOpen() {
        marsRover.receiveMessage("O"); // Open upper hatch
        marsRover.aspirateAir(); // This should work without exceptions
    }

    // Collecting samples tests
    @Test
    public void test14CollectSampleFailsWhenLowerHatchClosed() {
        assertThrows(RuntimeException.class, () -> marsRover.collectSample()); // Lower hatch is closed
    }

    @Test
    public void test15CollectSampleSucceedsWhenLowerHatchOpen() {
        marsRover.receiveMessage("o"); // Open lower hatch
        marsRover.collectSample(); // This should work without exceptions
    }

    // Utility methods to verify coordinates
    private void assertCoords(int x, int y) {
        assertEquals(x, marsRover.getCoordinates().getXcoord());
        assertEquals(y, marsRover.getCoordinates().getYcoord());
    }

    // Dirección adicional: Movimientos y giros desde el Oeste
    @Test
    public void test16MarsRoverMovesWest() {
        marsRover = new MarsRover(new Point(0, 0), new West());
        marsRover.receiveMessage("f");
        assertCoords(-1, 0);
    }

    @Test
    public void test17MarsRoverTurnsRightFromWestToNorth() {
        marsRover = new MarsRover(new Point(0, 0), new West());
        marsRover.receiveMessage("r");
        assertEquals(new North(), marsRover.getDirection());
    }

//    // Secuencia compleja de movimientos
//    @Test
//    public void test18ComplexMovementSequence() {
//        marsRover.receiveMessage("ffrfflffbbr");
//        getCoordinate(3, 2);
//    }

    // Estado de escotillas: Apertura y cierre múltiples
    @Test
    public void test19ToggleUpperAndLowerHatches() {
        marsRover.receiveMessage("O");
        marsRover.receiveMessage("c");
        marsRover.receiveMessage("o");
        marsRover.receiveMessage("c");
        assertThrows(RuntimeException.class, () -> marsRover.closeHatches()); // No se podria cerrar devuelta
    }

//    // Validación de secuencia incorrecta: Aspirar aire mientras se mueve
//    @Test
//    public void test20AspirateAirWhileMoving() {
//        marsRover.receiveMessage("O");
//        assertThrows(RuntimeException.class, () -> {
//            marsRover.receiveMessage("ff");
//            marsRover.aspirateAir();
//        });
//    }

}
