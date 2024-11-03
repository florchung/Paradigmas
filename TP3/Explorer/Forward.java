package Explorer;

public class Forward extends Command {
    protected Forward(){
        super('f');
    }
    protected void accion(Explorer explorer){
        explorer.goForward();

    }


}
