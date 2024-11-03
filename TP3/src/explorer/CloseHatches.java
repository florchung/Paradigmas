package Explorer;

public class CloseHatches extends Command {
    protected CloseHatches(){
        super('c');
    }
    protected void accion(Explorer explorer){
        explorer.shutHatches();
    }
}
