package Explorer;

public class North extends Cardinal {
    protected North(){
        super("Norte");
    }
    protected void marchar(Explorer explorer){
        explorer.coordinates.add(0,1);
    }
    protected void recular(Explorer explorer){
        explorer.coordinates.add(0,-1);
    }
    protected void girarDerecha(Explorer explorer) {
        explorer.cardinal=new East();
    }
    protected void girarIzquierda(Explorer explorer) {
        explorer.cardinal=new West();
    }
}


