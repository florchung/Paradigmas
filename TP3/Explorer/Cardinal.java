package Explorer;

public abstract class Cardinal {
    protected String sentido;
    protected Cardinal(String sentido) {
        this.sentido=sentido;
    }
    protected abstract void marchar(Explorer explorer);
    protected abstract void recular(Explorer explorer);
    protected abstract void girarDerecha(Explorer explorer);
    protected abstract void girarIzquierda(Explorer explorer);
    public boolean equals(Object anObject){
        return Cardinal.class.isInstance(anObject)&& sentido==Cardinal.class.cast(anObject).sentido;
    }
}


