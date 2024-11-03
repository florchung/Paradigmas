package Explorer;

public class Explorer {
    protected Coordinates coordinates;
    protected Cardinal cardinal;
    protected Hatches escotillas;

    protected Explorer(Coordinates coordinates, Cardinal cardinal) {
        this.coordinates = coordinates;
        this.cardinal = cardinal;
        escotillas = new BothHatchesClosed();
    }
    protected Cardinal getDirection() {
        return cardinal;
    }
    protected Coordinates getPosition(){
        return coordinates.puntoActual();
    }
    protected void order(char operacion) {
        (Command.tomarOrden(operacion)).accion(this);
    }
    protected void turnright() {
        cardinal.girarDerecha(this);
    }
    protected void backUp() {
        cardinal.recular(this);
    }
    protected void turnLeft() {
        cardinal.girarIzquierda(this);
    }
    protected void goForward() {
        cardinal.marchar(this);
    }
    protected void openSuperiorHatch(){
        escotillas.openUpperHatch(this);
    }
    protected void openInferiorHatch(){
        escotillas.openLowerHatch(this);
    }
    protected void shutHatches(){
        escotillas.closeHatches(this);
    }
    protected void inhale(){
        escotillas.aspirate();
    }
    protected void recollect(){
        escotillas.gatherSamples();
    }
    protected Explorer sequenceOfOrders(String ordenes){
        ordenes.chars().forEach(charascii-> order((char) charascii));
        return this;
    }
}
