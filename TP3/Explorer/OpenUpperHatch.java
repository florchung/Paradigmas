package Explorer;

public class OpenUpperHatch extends Command {
    protected OpenUpperHatch(){
        super('O');
    }
    protected void accion(Explorer explorer){
        explorer.openSuperiorHatch();
    }
}
