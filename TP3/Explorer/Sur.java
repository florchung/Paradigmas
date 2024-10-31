package explorer;

public class Sur extends Cardinal{
    protected Sur(){
        super("Sur");
    }
    public String direccion(){
        return sentido;
    }
    public void marchar(Explorer explorer){
        explorer.coordenadas.add(0,-1);
    }
    public void recular(Explorer explorer){
        explorer.coordenadas.add(0,1);
    }
    public void girarDerecha(Explorer explorer) {
        explorer.cardinal=new Oeste();
    }
    public void girarIzquierda(Explorer explorer) {
        explorer.cardinal=new Este();
    }
}
