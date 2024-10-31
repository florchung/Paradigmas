package explorer;

public class East extends Cardinal{
    protected East(){
        super("Este");
    }
    protected void marchar(Explorer explorer){
        explorer.coordinates.add(1,0);
    }
    protected void recular(Explorer explorer){
        explorer.coordinates.add(-1,0);
    }
    protected void girarDerecha(Explorer explorer){
        explorer.cardinal = new South();
    }
    protected void girarIzquierda(Explorer explorer) {
        explorer.cardinal = new North();
    }
}
