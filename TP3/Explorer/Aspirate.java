package explorer;

public class Aspirate extends Comando{
    public Aspirate(){
        super('a');
    }
    public void accion(Explorer explorer){
        explorer.aspirar();
    }
}
