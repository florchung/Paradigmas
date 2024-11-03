package Explorer;

public class Left extends Command {
    protected Left(){
        super('l');
    }
    protected void accion(Explorer explorer){
        explorer.turnLeft();

    }
}
