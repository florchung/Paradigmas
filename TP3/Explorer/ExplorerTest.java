package explorer;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import static org.junit.jupiter.api.Assertions.*;

public class ExplorerTest {
    private  String COMANDO_NO_DETECTADO = "Comando no detectado";
    private String NO_PUEDEN_HABER_DOS_ESCOTILLAS_ABIERTAS_AL_MISMO_TIEMPO="No pueden haber dos escotillas abiertas al mismo tiempo";
    private String LA_ESCOTILLA_YA_ESTA_ABIERTA="La escotilla ya esta abierta";
    private String PRIMERO_TIENE_QUE_ABRIR_LA_ESCOTILLA_SUPERIOR="Primero tiene que abrir la escotilla superior";
    private String PRIMERO_TIENE_QUE_ABRIR_LA_ESCOTILLA_INFERIOR="Primero tiene que abrir la escotilla inferior";
    private String NO_HAY_NINGUNA_ESCOTILLA_ABIERTA="No hay ninguna escotilla abierta";

    @Test public void crearExplorer(){
        assertExplorerLike(new Coordinates(0, 0), new North(),
                crearExplorer(new Coordinates(0,0), new North()));
    }
    @Test public void AvanzarMirandoNorte() {
        assertExplorerLike(new Coordinates(0, 1), new North(),
                explorerCreadoHaceUnaAccion(new Coordinates(0, 0), new North(), 'f'));
    }
    @Test public void AvanzarMirandoEste(){
        assertExplorerLike(new Coordinates(1, 0), new East(),
                explorerCreadoHaceUnaAccion(new Coordinates(0, 0), new East(), 'f'));
    }
    @Test public void AvanzarMirandoSur(){
        assertExplorerLike(new Coordinates(0, -1), new South(),
                explorerCreadoHaceUnaAccion(new Coordinates(0, 0), new South(), 'f'));
    }
    @Test public void AvanzarMirandoOeste(){
        assertExplorerLike(new Coordinates(-1, 0), new West(),
                explorerCreadoHaceUnaAccion(new Coordinates(0, 0), new West(), 'f'));
    }
    @Test public void RetrocederMirandoNorte(){
        assertExplorerLike(new Coordinates(0, -1), new North(),
                explorerCreadoHaceUnaAccion(new Coordinates(0, 0), new North(), 'b'));
    }
    @Test public void RetrocederMirandoEste(){
        assertExplorerLike(new Coordinates(-1, 0), new East(),
                explorerCreadoHaceUnaAccion(new Coordinates(0, 0), new East(), 'b'));
    }
    @Test public void RetrocederMirandoSur(){
        assertExplorerLike(new Coordinates(0, 1), new South(),
                explorerCreadoHaceUnaAccion(new Coordinates(0, 0), new South(), 'b'));
    }
    @Test public void RetrocederMirandoOeste(){
        assertExplorerLike(new Coordinates(1, 0), new West(),
                explorerCreadoHaceUnaAccion(new Coordinates(0, 0), new West(), 'b'));
    }
    @Test public void ComandoNoDetectado(){
        assertExplorerThrowsLike(COMANDO_NO_DETECTADO, () -> crearExplorer(new Coordinates(0,0),
                new North()).order('z'), new Coordinates(0, 0), new North(),
                crearExplorer(new Coordinates(0,0), new North()));
    }
    @Test public void RotarDerechaMirandoNorte(){
        assertExplorerLike(new Coordinates(0, 0), new East(),
                explorerCreadoHaceUnaAccion(new Coordinates(0, 0), new North(), 'r'));
    }
    @Test public void RotarDerechaMirandoEste(){
        assertExplorerLike(new Coordinates(0, 0), new South(),
                explorerCreadoHaceUnaAccion(new Coordinates(0, 0), new East(), 'r'));
    }
    @Test public void RotarDerechaMirandoSur(){
        assertExplorerLike(new Coordinates(0, 0), new West(),
                explorerCreadoHaceUnaAccion(new Coordinates(0, 0), new South(), 'r'));
    }
    @Test public void RotarDerechaMirandoOeste(){
        assertExplorerLike(new Coordinates(0, 0), new North(),
                explorerCreadoHaceUnaAccion(new Coordinates(0, 0), new West(), 'r'));
    }
    @Test public void RotarIzquierdaMirandoNorte(){
        assertExplorerLike(new Coordinates(0, 0), new West(),
                explorerCreadoHaceUnaAccion(new Coordinates(0, 0), new North(), 'l'));
    }
    @Test public void RotarIzquierdaMirandoEste(){
        assertExplorerLike(new Coordinates(0, 0), new North(),
                explorerCreadoHaceUnaAccion(new Coordinates(0, 0), new East(), 'l'));
    }
    @Test public void RotarIzquierdaMirandoSur(){
        assertExplorerLike(new Coordinates(0, 0), new East(),
                explorerCreadoHaceUnaAccion(new Coordinates(0, 0), new South(), 'l'));
    }
    @Test public void RotarIzquierdaMirandoOeste(){
        assertExplorerLike(new Coordinates(0, 0), new South(),
                explorerCreadoHaceUnaAccion(new Coordinates(0, 0), new West(), 'l'));
    }
    @Test public void AbrirEscotillaSuperior(){
        assertExplorerLike(new Coordinates(0, 0), new North(),
                explorerCreadoHaceUnaAccion(new Coordinates(0, 0), new North(), 'O'));
    }
    @Test public void AbrirEscotillaInferior(){
        assertExplorerLike(new Coordinates(0, 0), new North(),
                explorerCreadoHaceUnaAccion(new Coordinates(0, 0), new North(), 'o'));
    }
    @Test public void AbrirEscorillaAbierta(){
        assertExplorerThrowsLikeSequenceOfOrders(LA_ESCOTILLA_YA_ESTA_ABIERTA, () -> crearExplorer(new Coordinates(0, 0), new North()).SequenceOfOrders("oo"), new Coordinates(0, 0), new North(), crearExplorer(new Coordinates(0, 0), new North()));

    }
    @Test public void Abrir2EscotillasAlMismoTiempo(){
        assertExplorerThrowsLikeSequenceOfOrders(NO_PUEDEN_HABER_DOS_ESCOTILLAS_ABIERTAS_AL_MISMO_TIEMPO, () -> crearExplorer(new Coordinates(0,0),new North()).SequenceOfOrders("oO"), new Coordinates(0, 0), new North(), crearExplorer(new Coordinates(0,0),new North()));
    }
    @Test public void CerrarEscotillas(){
        assertExplorerLikeSequenceOfOrders(crearExplorer(new Coordinates(0,0), new North()), "oc", new Coordinates(0, 2), new North());
    }

    private static void assertExplorerLikeSequenceOfOrders(Explorer explorer, String ordenes, Coordinates posicion, Cardinal direccionDelExplorer) {
        explorer.SequenceOfOrders(ordenes);
        assertExplorerLike(posicion, direccionDelExplorer, explorer);
    }

    @Test public void CerrarEscotillasCerradas(){
        assertExplorerThrowsLike(NO_HAY_NINGUNA_ESCOTILLA_ABIERTA, () -> crearExplorer(new Coordinates(0,0),
                new North()).order('c'), new Coordinates(0, 0), new North(),
                crearExplorer(new Coordinates(0,0), new North()));
    }
    @Test public void Aspirar(){
        assertExplorerLikeSequenceOfOrders(crearExplorer(new Coordinates(0,0), new North()), "Oa", new Coordinates(0, 2), new North());
    }
    @Test public void AspirarConEscotillaCerrada(){
        assertExplorerThrowsLike(PRIMERO_TIENE_QUE_ABRIR_LA_ESCOTILLA_SUPERIOR,
                () -> crearExplorer(new Coordinates(0,0), new North()).order('a'),
                new Coordinates(0, 0), new North(), crearExplorer(new Coordinates(0,0), new North()));
    }
    @Test public void RecogerMuestra(){
        assertExplorerLikeSequenceOfOrders(crearExplorer(new Coordinates(0,0), new North()), "oi", new Coordinates(0, 2), new North());
    }
    @Test public void RecogerMuestraConEscotillaCerrada(){
        assertExplorerThrowsLike(PRIMERO_TIENE_QUE_ABRIR_LA_ESCOTILLA_INFERIOR, () -> crearExplorer(new Coordinates(0,0), new North()).order('i'), new Coordinates(0, 0), new North(), crearExplorer(new Coordinates(0,0), new North()));
    }
    @Test public void RecibirComandoEmpaquetado(){
        assertExplorerLikeSequenceOfOrders(crearExplorer(new Coordinates(0,0), new North()), "ff", new Coordinates(0, 2), new North());
    }
    @Test public void HacerUn360(){
        assertExplorerLikeSequenceOfOrders(crearExplorer(new Coordinates(0,0), new North()), "rrrr", new Coordinates(0, 0), new North());
    }
    @Test public void ComandoInterrumpido(){
        assertExplorerThrowsLikeSequenceOfOrders(COMANDO_NO_DETECTADO, () -> crearExplorer(new Coordinates(0,0), new North()).SequenceOfOrders("frffj"), new Coordinates(2, 1), new East(), crearExplorer(new Coordinates(0,0), new North()));
    }
    private static Explorer crearExplorer(Coordinates posicion, Cardinal direccionDelExplorer) {
        Explorer explorer = new Explorer(posicion, direccionDelExplorer);
        return explorer;
    }
    private static void assertThrowsLike(String mensaje, Executable executable) {
        assertEquals(mensaje,assertThrows(Exception.class, executable).getMessage());
    }
    private static void assertExplorerLike(Coordinates posicion, Cardinal direccionDelExplorer, Explorer explorer) {
        assertEquals(direccionDelExplorer, explorer.getDirection());
        assertEquals(posicion, explorer.getPosition());
    }
    private static Explorer explorerCreadoHaceUnaAccion(Coordinates posicion, Cardinal direccionDelExplorer, char accion) {
        Explorer explorer = crearExplorer(posicion, direccionDelExplorer);
        explorer.order(accion);
        return explorer;
    }
    private static void assertExplorerThrowsLike(String mensaje, Executable executable, Coordinates posicion, Cardinal direccionDelExplorer, Explorer explorer) {
        assertThrowsLike(mensaje, executable);
        assertExplorerLike(posicion, direccionDelExplorer, explorer);
    }
    private static void assertExplorerThrowsLikeSequenceOfOrders(String mensaje, Executable executable, Coordinates posicion, Cardinal direccionDelExplorer, Explorer explorer) {
        assertThrowsLike(mensaje, executable);
        assertExplorerLike(posicion, direccionDelExplorer, explorer);
    }
}
