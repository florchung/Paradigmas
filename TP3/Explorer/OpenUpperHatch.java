package explorer;

public class OpenUpperHatch extends Comando{
    public OpenUpperHatch(){
        super('O');
    }
    public void accion(Explorer explorer){
        explorer.abrirEscotillaSuperior();
    }
}
