package Explorer;

public class Backward extends Command {
    protected Backward(){
        super('b');
    }
    protected void accion(Explorer explorer){
        explorer.backUp();

    }
}
