package explorer;

public class Oeste extends Cardinal {
    protected Oeste(){
        super("Oeste");
    }
    public String direccion(){
        return sentido;
    }
    public void marchar(Explorer explorer){
        explorer.coordenadas.add(-1,0);
    }
    public void recular(Explorer explorer){
        explorer.coordenadas.add(1,0);
    }
    public void girarDerecha(Explorer explorer) {
        explorer.cardinal=new Norte();
    }
    public void girarIzquierda(Explorer explorer) {
        explorer.cardinal= new Sur();
    }
}
