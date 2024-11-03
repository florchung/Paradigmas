package Explorer;

public class Coordinates {
    private int posicionX;
    private int posicionY;

    protected Coordinates(int valorX, int valorY){
        posicionX=valorX;
        posicionY=valorY;
    }
    protected Coordinates puntoActual(){
        return this;
    }
    protected Coordinates add(int valorX, int valorY){
        posicionX+=valorX;
        posicionY+=valorY;
        return this;
    }
    public boolean equals(Object anObject){
        return Coordinates.class.isInstance(anObject)&& posicionY== Coordinates.class.cast(anObject).posicionY&&posicionX== Coordinates.class.cast(anObject).posicionX;
    }

}
