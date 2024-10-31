package explorer;

public class Este extends Cardinal{
    protected Este(){
        super("Este");
    }
    public String direccion(){
        return sentido;
    }
    public void marchar(Explorer explorer){
        explorer.coordenadas.add(1,0);
    }
    public void recular(Explorer explorer){
        explorer.coordenadas.add(-1,0);
    }
    public void girarDerecha(Explorer explorer){
        explorer.cardinal = new Sur();
    }
    public void girarIzquierda(Explorer explorer) {
        explorer.cardinal = new Norte();
    }
}
