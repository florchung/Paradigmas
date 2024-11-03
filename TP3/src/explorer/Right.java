package Explorer;

public class Right extends Command {
    protected Right(){
        super('r');
    }
    protected void accion(Explorer explorer){
        explorer.turnright();
    }
}
