package explorer;

public abstract class Cardinal {
    public String sentido;
    public Cardinal(String sentido) {
        this.sentido=sentido;
    }
    public abstract String direccion();
    public abstract void marchar(Explorer explorer);
    public abstract void recular(Explorer explorer);
    public abstract void girarDerecha(Explorer explorer);
    public abstract void girarIzquierda(Explorer explorer);
}


