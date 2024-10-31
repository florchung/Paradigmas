package explorer;

public class OpenLowerHatch extends Comando{
    public OpenLowerHatch(){
        super('o');
    }
    public void accion(Explorer explorer){
        explorer.abrirEscotillaInferior();
    }
}
