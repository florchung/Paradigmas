package explorer;

public class Aspirate extends Command {
    protected Aspirate(){
        super('a');
    }
    protected void accion(Explorer explorer){
        explorer.inhale();
    }
}
