package Explorer;

import java.util.concurrent.Callable;

public class Aspirate extends Command {
    protected Aspirate(){
        super('a');
    }
    protected void accion(Explorer explorer){
        explorer.inhale();
    }
}
