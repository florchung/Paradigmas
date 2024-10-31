package explorer;

public class Left extends Comando{
    public Left(){
        super('l');
    }
    public void accion(Explorer explorer){
        explorer.turnLeft();

    }
}
