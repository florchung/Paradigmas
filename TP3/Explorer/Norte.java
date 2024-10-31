package explorer;

public class Norte extends Cardinal {
    protected Norte(){
        super("Norte");
    }
    public String direccion(){
        return sentido;
    }
    public void marchar(Explorer explorer){
        explorer.coordenadas.add(0,1);
    }
    public void recular(Explorer explorer){
        explorer.coordenadas.add(0,-1);
    }
    public void girarDerecha(Explorer explorer) {
        explorer.cardinal=new Este();
    }
    public void girarIzquierda(Explorer explorer) {
        explorer.cardinal=new Oeste();
    }
}


