package explorer;

public class Forward extends Comando{
    public Forward(){
        super('f');
    }
    public void accion(Explorer explorer){
        explorer.avanzar();

    }


}
