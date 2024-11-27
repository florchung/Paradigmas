package nothanks;

public class Main {
    public static void main(String[] args) {
        Game game = new Game();
        game.addPlayer(new Player("Jugador 1"));
        game.addPlayer(new Player("Jugador 2"));
        game.start();
    }
}
