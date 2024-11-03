package Explorer;

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
        assertExplorerLike(zeroZero(), norte(), explorerMirandoNorteEnElZeroZero());
    }
    @Test public void AvanzarMirandoNorte() {
        assertExplorerLike(new Coordinates(0, 1), norte(), explorerMirandoNorteEnElZeroZeroRecibiendoOrdenes("f"));
    }
    @Test public void AvanzarMirandoEste(){
        assertExplorerLike(new Coordinates(1, 0), este(), explorerMirandoEsteEnElZeroZeroRecibiendoOrdenes("f"));
    }
    @Test public void AvanzarMirandoSur(){
        assertExplorerLike(new Coordinates(0, -1), sur(), explorerMirandoSurEnElZeroZeroRecibiendoOrdenes("f"));
    }
    @Test public void AvanzarMirandoOeste(){
        assertExplorerLike(new Coordinates(-1, 0), oeste(), explorerMirandoOesteEnElZeroZeroRecibiendoOrdenes("f"));
    }
    @Test public void RetrocederMirandoNorte(){
        assertExplorerLike(new Coordinates(0, -1), norte(), explorerMirandoNorteEnElZeroZeroRecibiendoOrdenes("b"));
    }
    @Test public void RetrocederMirandoEste(){
        assertExplorerLike(new Coordinates(-1, 0), este(), explorerMirandoEsteEnElZeroZeroRecibiendoOrdenes("b"));
    }
    @Test public void RetrocederMirandoSur(){
        assertExplorerLike(new Coordinates(0, 1), sur(), explorerMirandoSurEnElZeroZeroRecibiendoOrdenes("b"));
    }
    @Test public void RetrocederMirandoOeste(){
        assertExplorerLike(new Coordinates(1, 0), oeste(), explorerMirandoOesteEnElZeroZeroRecibiendoOrdenes("b"));
    }
    @Test public void ComandoNoDetectado(){
        extracted(COMANDO_NO_DETECTADO, explorerMirandoNorteEnElZeroZero(), "z");
    }
    @Test public void RotarDerechaMirandoNorte(){
        assertExplorerLike(zeroZero(), este(), explorerMirandoNorteEnElZeroZeroRecibiendoOrdenes("r"));
    }
    @Test public void RotarDerechaMirandoEste(){
        assertExplorerLike(zeroZero(), sur(), explorerMirandoEsteEnElZeroZeroRecibiendoOrdenes("r"));
    }
    @Test public void RotarDerechaMirandoSur(){
        assertExplorerLike(zeroZero(), oeste(), explorerMirandoSurEnElZeroZeroRecibiendoOrdenes("r"));
    }
    @Test public void RotarDerechaMirandoOeste(){
        assertExplorerLike(zeroZero(), norte(), explorerMirandoOesteEnElZeroZeroRecibiendoOrdenes("r"));
    }
    @Test public void RotarIzquierdaMirandoNorte(){
        assertExplorerLike(zeroZero(), oeste(), explorerMirandoNorteEnElZeroZeroRecibiendoOrdenes("l"));
    }
    @Test public void RotarIzquierdaMirandoEste(){
        assertExplorerLike(zeroZero(), norte(), explorerMirandoEsteEnElZeroZeroRecibiendoOrdenes("l"));
    }
    @Test public void RotarIzquierdaMirandoSur(){
        assertExplorerLike(zeroZero(), este(), explorerMirandoSurEnElZeroZeroRecibiendoOrdenes("l"));
    }
    @Test public void RotarIzquierdaMirandoOeste(){
        assertExplorerLike(zeroZero(), sur(), explorerMirandoOesteEnElZeroZeroRecibiendoOrdenes("l"));
    }
    @Test public void AbrirEscotillaSuperior(){
        assertExplorerLike(zeroZero(), norte(), explorerMirandoNorteEnElZeroZeroRecibiendoOrdenes("O"));
    }
    @Test public void AbrirEscotillaInferior(){
        assertExplorerLike(zeroZero(), norte(), explorerMirandoNorteEnElZeroZeroRecibiendoOrdenes("o"));
    }
    @Test public void AbrirEscorillaAbierta(){
        Explorer explorer =explorerMirandoNorteEnElZeroZero();
        extracted(LA_ESCOTILLA_YA_ESTA_ABIERTA, explorer, "oo");
    }
    @Test public void Abrir2EscotillasAlMismoTiempo(){
        Explorer explorer = explorerMirandoNorteEnElZeroZero();
        extracted(NO_PUEDEN_HABER_DOS_ESCOTILLAS_ABIERTAS_AL_MISMO_TIEMPO, explorer, "oO");
    }
    @Test public void CerrarEscotillas(){
        assertExplorerLike(zeroZero(), norte(), explorerMirandoNorteEnElZeroZeroRecibiendoOrdenes("oc"));
    }
    @Test public void CerrarEscotillasCerradas(){
        Explorer explorer = explorerMirandoNorteEnElZeroZero();
        extracted(NO_HAY_NINGUNA_ESCOTILLA_ABIERTA, explorer, "c");
    }
    @Test public void Aspirar(){
        assertExplorerLike(zeroZero(), norte(), explorerMirandoNorteEnElZeroZeroRecibiendoOrdenes("Oa"));
    }
    @Test public void AspirarConEscotillaCerrada(){
        Explorer explorer= explorerMirandoNorteEnElZeroZero();
        extracted(PRIMERO_TIENE_QUE_ABRIR_LA_ESCOTILLA_SUPERIOR, explorer, "a");
    }
    @Test public void RecogerMuestra(){
        assertExplorerLike(zeroZero(), norte(), explorerMirandoNorteEnElZeroZeroRecibiendoOrdenes("oi"));
    }
    @Test public void RecogerMuestraConEscotillaCerrada(){
        Explorer explorer= explorerMirandoNorteEnElZeroZero();
        extracted(PRIMERO_TIENE_QUE_ABRIR_LA_ESCOTILLA_INFERIOR, explorer, "i");
    }
    @Test public void RecibirComandoEmpaquetado(){
        assertExplorerLike(new Coordinates(0, 2), norte(), explorerMirandoNorteEnElZeroZeroRecibiendoOrdenes("ff"));
    }

    @Test public void HacerUn360(){
        assertExplorerLike(zeroZero(), norte(), explorerMirandoNorteEnElZeroZeroRecibiendoOrdenes("rrrr"));
    }

    @Test public void ComandoInterrumpido(){
        Explorer explorer = explorerMirandoNorteEnElZeroZero();
        assertThrowsLike(COMANDO_NO_DETECTADO, () -> explorer.sequenceOfOrders("frffj"));
        assertExplorerLike(new Coordinates(2, 1), este(), explorer);
    }
    private static Explorer explorerMirandoNorteEnElZeroZero() {
        return new Explorer(zeroZero(), norte());
    }
    private static void assertExplorerLike(Coordinates posicionFinal, Cardinal direccionFinal,Explorer explorer) {
        assertEquals(posicionFinal, explorer.getPosition());
        assertEquals(direccionFinal, explorer.getDirection());
    }
    private static Explorer explorerMirandoNorteEnElZeroZeroRecibiendoOrdenes(String ordenes) {
        return explorerMirandoNorteEnElZeroZero().sequenceOfOrders(ordenes);
    }
    private static Explorer explorerMirandoEsteEnElZeroZeroRecibiendoOrdenes(String ordenes) {
        return new Explorer(zeroZero(), este()).sequenceOfOrders(ordenes);
    }
    private static Explorer explorerMirandoSurEnElZeroZeroRecibiendoOrdenes(String ordenes) {
        return new Explorer(zeroZero(), sur()).sequenceOfOrders(ordenes);
    }
    private static Explorer explorerMirandoOesteEnElZeroZeroRecibiendoOrdenes(String ordenes) {
        return new Explorer(zeroZero(), oeste()).sequenceOfOrders(ordenes);
    }

    private static void assertThrowsLike(String mensaje, Executable executable) {
        assertEquals(mensaje,assertThrows(Exception.class, executable).getMessage());
    }

    private static North norte() {
        return new North();
    }
    private static East este() {
        return new East();
    }

    private static West oeste() {
        return new West();
    }

    private static South sur() {
        return new South();
    }

    private static Coordinates zeroZero() {
        return new Coordinates(0, 0);
    }
    private void extracted(String mensaje, Explorer explorer, String ordenes) {
        assertThrowsLike(mensaje, () -> explorer.sequenceOfOrders(ordenes));
        assertExplorerLike(zeroZero(), norte(), explorer);
    }
}
