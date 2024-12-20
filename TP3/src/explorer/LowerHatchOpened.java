package Explorer;

public class LowerHatchOpened extends Hatches{
    private String LA_ESCOTILLA_YA_ESTA_ABIERTA="La escotilla ya esta abierta";
    private String NO_PUEDEN_HABER_DOS_ESCOTILLAS_ABIERTAS_AL_MISMO_TIEMPO="No pueden haber dos escotillas abiertas al mismo tiempo";
    private String PRIMERO_TIENE_QUE_ABRIR_LA_ESCOTILLA_SUPERIOR="Primero tiene que abrir la escotilla superior";

    protected LowerHatchOpened(){}
    protected void openUpperHatch(Explorer explorer) {
        throw new RuntimeException(NO_PUEDEN_HABER_DOS_ESCOTILLAS_ABIERTAS_AL_MISMO_TIEMPO);
    }
    protected void openLowerHatch(Explorer explorer) {
        throw new RuntimeException(LA_ESCOTILLA_YA_ESTA_ABIERTA);
    }
    protected void closeHatches(Explorer explorer) {
        explorer.escotillas = new BothHatchesClosed();
    }
    protected void aspirate(){
        throw new RuntimeException(PRIMERO_TIENE_QUE_ABRIR_LA_ESCOTILLA_SUPERIOR);
    }
    protected void gatherSamples(){}


}
