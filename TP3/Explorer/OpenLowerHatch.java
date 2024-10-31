package explorer;

public class OpenLowerHatch extends Command {
    protected OpenLowerHatch(){
        super('o');
    }
    protected void accion(Explorer explorer){
        explorer.openInferiorHatch();
    }
}
