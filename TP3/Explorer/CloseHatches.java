package explorer;

public class CloseHatches extends Comando{
    public CloseHatches(){
        super('c');
    }
    public void accion(Explorer explorer){
        explorer.cerrarEscotilla();
    }
}
