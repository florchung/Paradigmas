package explorer;

public class Coordenadas {
    int posicionX;
    int posicionY;

    public Coordenadas(int valorX,int valorY){
        posicionX=valorX;
        posicionY=valorY;
    }
    public Coordenadas puntoActual(){
        return this;
    }
    public Coordenadas add(int valorX,int valorY){
        posicionX+=valorX;
        posicionY+=valorY;
        return this;
    }
    public boolean equals(Object anObject){
        return Coordenadas.class.isInstance(anObject)&& posicionY==Coordenadas.class.cast(anObject).posicionY&&posicionX==Coordenadas.class.cast(anObject).posicionX;
    }

}
