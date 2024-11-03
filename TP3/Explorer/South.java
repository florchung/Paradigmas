package Explorer;

public class South extends Cardinal{
    protected South(){
        super("Sur");
    }
    protected String direccion(){
        return sentido;
    }
    protected void marchar(Explorer explorer){
        explorer.coordinates.add(0,-1);
    }
    protected void recular(Explorer explorer){
        explorer.coordinates.add(0,1);
    }
    protected void girarDerecha(Explorer explorer) {
        explorer.cardinal=new West();
    }
    protected void girarIzquierda(Explorer explorer) {
        explorer.cardinal=new East();
    }
}
