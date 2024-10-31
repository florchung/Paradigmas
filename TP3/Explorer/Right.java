package explorer;

public class Right extends Comando{
    public Right(){
        super('r');
    }
    public void accion(Explorer explorer){
        explorer.turnright();
    }
}
