package explorer;

public class BothHatchesClosed extends Hatches {
    private String NO_HAY_NINGUNA_ESCOTILLA_ABIERTA="No hay ninguna escotilla abierta";
    private String PRIMERO_TIENE_QUE_ABRIR_LA_ESCOTILLA_SUPERIOR="Primero tiene que abrir la escotilla superior";
    private String PRIMERO_TIENE_QUE_ABRIR_LA_ESCOTILLA_INFERIOR="Primero tiene que abrir la escotilla inferior";

    protected BothHatchesClosed(){}
    protected void openUpperHatch(Explorer explorer) {
        explorer.escotillas = new UpperHatchOpened();
    }
    protected void openLowerHatch(Explorer explorer) {
        explorer.escotillas = new LowerHatchOpened();
    }
    protected void closeHatches(Explorer explorer) {
        throw new RuntimeException(NO_HAY_NINGUNA_ESCOTILLA_ABIERTA);
    }
    protected void aspirate() {
        throw new RuntimeException(PRIMERO_TIENE_QUE_ABRIR_LA_ESCOTILLA_SUPERIOR);
    }
    protected void gatherSamples() {
        throw new RuntimeException(PRIMERO_TIENE_QUE_ABRIR_LA_ESCOTILLA_INFERIOR);

    }


}
