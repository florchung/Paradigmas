package explorer;

public class GatherSamples extends Command {
    protected GatherSamples(){
        super('i');
    }
    protected void accion(Explorer explorer){
        explorer.recollect();

    }
}
