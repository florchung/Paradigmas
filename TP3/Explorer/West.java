package explorer;

public class West extends Cardinal {
    protected West(){
        super("Oeste");
    }
    protected void marchar(Explorer explorer){
        explorer.coordinates.add(-1,0);
    }
    protected void recular(Explorer explorer){
        explorer.coordinates.add(1,0);
    }
    protected void girarDerecha(Explorer explorer) {
        explorer.cardinal=new North();
    }
    protected void girarIzquierda(Explorer explorer) {
        explorer.cardinal= new South();
    }
}
