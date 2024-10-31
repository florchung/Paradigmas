package explorer;

public class Backward extends Comando{
    public Backward(){
        super('b');
    }
    public void accion(Explorer explorer){
        explorer.retroceder();

    }
}
