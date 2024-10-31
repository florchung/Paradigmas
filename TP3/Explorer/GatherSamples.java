package explorer;

public class GatherSamples extends Comando{
    public GatherSamples(){
        super('i');
    }
    public void accion(Explorer explorer){
        explorer.recolectarMuestras();

    }
}
