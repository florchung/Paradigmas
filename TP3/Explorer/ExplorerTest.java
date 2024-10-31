package explorer;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import static org.junit.jupiter.api.Assertions.*;

public class ExplorerTest {
    private String N = "Norte";
    private String S = "Sur";
    private String O = "Oeste";
    private String E = "Este";
    public String NO_PUEDEN_HABER_DOS_ESCOTILLAS_ABIERTAS_AL_MISMO_TIEMPO="No pueden haber dos escotillas abiertas al mismo tiempo";
    public String LA_ESCOTILLA_YA_ESTA_ABIERTA="La escotilla ya esta abierta";
    public String PRIMERO_TIENE_QUE_ABRIR_LA_ESCOTILLA_SUPERIOR="Primero tiene que abrir la escotilla superior";
    public String PRIMERO_TIENE_QUE_ABRIR_LA_ESCOTILLA_INFERIOR="Primero tiene que abrir la escotilla inferior";
    public String NO_HAY_NINGUNA_ESCOTILLA_ABIERTA="No hay ninguna escotilla abierta";

    @Test public void CrearExplorer(){
        Cardinal norte = new Norte();
        Coordenadas zeroZero = new Coordenadas(0,0);
        Explorer explorer = new Explorer(zeroZero,norte);
        assertEquals(N,explorer.getDireccion());
        assertEquals(new Coordenadas(0,0),explorer.getPosition());
    }
    @Test public void AvanzarMirandoNorte() {
        Cardinal norte = new Norte();
        Coordenadas zeroZero = new Coordenadas(0,0);
        Explorer explorer = new Explorer(zeroZero,norte);
        explorer.comandar('f');
        assertEquals(N,explorer.getDireccion());
        assertEquals(new Coordenadas(0,1),explorer.getPosition());
    }
    @Test public void AvanzarMirandoEste(){
        Cardinal este = new Este();
        Coordenadas zeroZero = new Coordenadas(0,0);
        Explorer explorer = new Explorer(zeroZero,este);
        explorer.comandar('f');
        assertEquals(E,explorer.getDireccion());
        assertEquals(new Coordenadas(1,0),explorer.getPosition());

    }
    @Test public void AvanzarMirandoSur(){
        Cardinal sur = new Sur();
        Coordenadas zeroZero = new Coordenadas(0,0);
        Explorer explorer = new Explorer(zeroZero,sur);
        explorer.comandar('f');
        assertEquals(S,explorer.getDireccion());
        assertEquals(new Coordenadas(0,-1),explorer.getPosition());
    }
    @Test public void AvanzarMirandoOeste(){
        Cardinal oeste = new Oeste();
        Coordenadas zeroZero = new Coordenadas(0,0);
        Explorer explorer = new Explorer(zeroZero,oeste);
        explorer.comandar('f');
        assertEquals(O,explorer.getDireccion());
        assertEquals(new Coordenadas(-1,0),explorer.getPosition());
    }
    @Test public void RetrocederMirandoNorte(){
        Cardinal norte = new Norte();
        Coordenadas zeroZero = new Coordenadas(0,0);
        Explorer explorer = new Explorer(zeroZero,norte);
        explorer.comandar('b');
        assertEquals(N,explorer.getDireccion());
        assertEquals(new Coordenadas(0,-1),explorer.getPosition());
    }
    @Test public void RetrocederMirandoEste(){
        Cardinal este = new Este();
        Coordenadas zeroZero = new Coordenadas(0,0);
        Explorer explorer = new Explorer(zeroZero,este);
        explorer.comandar('b');
        assertEquals(E,explorer.getDireccion());
        assertEquals(new Coordenadas(-1,0),explorer.getPosition());
    }
    @Test public void RetrocederMirandoSur(){
        Cardinal sur = new Sur();
        Coordenadas zeroZero = new Coordenadas(0,0);
        Explorer explorer = new Explorer(zeroZero,sur);
        explorer.comandar('b');
        assertEquals(S,explorer.getDireccion());
        assertEquals(new Coordenadas(0,1),explorer.getPosition());
    }
    @Test public void RetrocederMirandoOeste(){
        Cardinal oeste = new Oeste();
        Coordenadas zeroZero = new Coordenadas(0,0);
        Explorer explorer = new Explorer(zeroZero,oeste);
        explorer.comandar('b');
        assertEquals(O,explorer.getDireccion());
        assertEquals(new Coordenadas(1,0),explorer.getPosition());
    }
    @Test public void ComandoNoDetectado(){
        Cardinal norte = new Norte();
        Coordenadas zeroZero = new Coordenadas(0,0);
        Explorer explorer = new Explorer(zeroZero,norte);
        explorer.comandar('z');
        assertEquals(N,explorer.getDireccion());
        assertEquals(new Coordenadas(0,0),explorer.getPosition());
        //agregar una excepcion de que no se entendio el comando
    }
    @Test public void RotarDerechaMirandoNorte(){
        Cardinal norte = new Norte();
        Coordenadas zeroZero = new Coordenadas(0,0);
        Explorer explorer = new Explorer(zeroZero,norte);
        explorer.comandar('r');
        assertEquals(E,explorer.getDireccion());
        assertEquals(new Coordenadas(0,0),explorer.getPosition());
    }
    @Test public void RotarDerechaMirandoEste(){
        Cardinal este = new Este();
        Coordenadas zeroZero = new Coordenadas(0,0);
        Explorer explorer = new Explorer(zeroZero,este);
        explorer.comandar('r');
        assertEquals(S,explorer.getDireccion());
        assertEquals(new Coordenadas(0,0),explorer.getPosition());
    }
    @Test public void RotarDerechaMirandoSur(){
        Cardinal sur = new Sur();
        Coordenadas zeroZero = new Coordenadas(0,0);
        Explorer explorer = new Explorer(zeroZero,sur);
        explorer.comandar('r');
        assertEquals(O,explorer.getDireccion());
        assertEquals(new Coordenadas(0,0),explorer.getPosition());
    }
    @Test public void RotarDerechaMirandoOeste(){
        Cardinal oeste = new Oeste();
        Coordenadas zeroZero = new Coordenadas(0,0);
        Explorer explorer = new Explorer(zeroZero,oeste);
        explorer.comandar('r');
        assertEquals(N,explorer.getDireccion());
        assertEquals(new Coordenadas(0,0),explorer.getPosition());
    }
    @Test public void RotarIzquierdaMirandoNorte(){
        Cardinal norte = new Norte();
        Coordenadas zeroZero = new Coordenadas(0,0);
        Explorer explorer = new Explorer(zeroZero,norte);
        explorer.comandar('l');
        assertEquals(O,explorer.getDireccion());
        assertEquals(new Coordenadas(0,0),explorer.getPosition());
    }
    @Test public void RotarIzquierdaMirandoEste(){
        Cardinal este = new Este();
        Coordenadas zeroZero = new Coordenadas(0,0);
        Explorer explorer = new Explorer(zeroZero,este);
        explorer.comandar('l');
        assertEquals(N,explorer.getDireccion());
        assertEquals(new Coordenadas(0,0),explorer.getPosition());
    }
    @Test public void RotarIzquierdaMirandoSur(){
        Cardinal sur = new Sur();
        Coordenadas zeroZero = new Coordenadas(0,0);
        Explorer explorer = new Explorer(zeroZero,sur);
        explorer.comandar('l');
        assertEquals(E,explorer.getDireccion());
        assertEquals(new Coordenadas(0,0),explorer.getPosition());
    }
    @Test public void RotarIzquierdaMirandoOeste(){
        Cardinal oeste = new Oeste();
        Coordenadas zeroZero = new Coordenadas(0,0);
        Explorer explorer = new Explorer(zeroZero,oeste);
        explorer.comandar('l');
        assertEquals(S,explorer.getDireccion());
        assertEquals(new Coordenadas(0,0),explorer.getPosition());
    }
    @Test public void AbrirEscotillaSuperior(){
        Cardinal norte = new Norte();
        Coordenadas zeroZero = new Coordenadas(0,0);
        Explorer explorer = new Explorer(zeroZero,norte);
        explorer.comandar('O');
        assertEquals(N,explorer.getDireccion());
        assertEquals(new Coordenadas(0,0),explorer.getPosition());
    }
    @Test public void AbrirEscotillaInferior(){
        Cardinal norte = new Norte();
        Coordenadas zeroZero = new Coordenadas(0,0);
        Explorer explorer = new Explorer(zeroZero,norte);
        explorer.comandar('o');
        assertEquals(N,explorer.getDireccion());
        assertEquals(new Coordenadas(0,0),explorer.getPosition());
    }
    @Test public void Abrir2EscotillasAlMismoTiempo(){
        Cardinal norte = new Norte();
        Coordenadas zeroZero = new Coordenadas(0,0);
        Explorer explorer = new Explorer(zeroZero,norte);
        explorer.comandar('o');
        assertEquals(N,explorer.getDireccion());
        assertEquals(new Coordenadas(0,0),explorer.getPosition());
        assertThrowsLike(NO_PUEDEN_HABER_DOS_ESCOTILLAS_ABIERTAS_AL_MISMO_TIEMPO, () -> explorer.comandar('O'));
    }
    @Test public void CerrarEscotillas(){
        Cardinal norte = new Norte();
        Coordenadas zeroZero = new Coordenadas(0,0);
        Explorer explorer = new Explorer(zeroZero,norte);
        explorer.comandar('o');
        explorer.comandar('c');
        assertEquals(N,explorer.getDireccion());
        assertEquals(new Coordenadas(0,0),explorer.getPosition());
    }
    @Test public void CerrarEscotillasCerradas(){
        Cardinal norte = new Norte();
        Coordenadas zeroZero = new Coordenadas(0,0);
        Explorer explorer = new Explorer(zeroZero,norte);
        assertEquals(N,explorer.getDireccion());
        assertEquals(new Coordenadas(0,0),explorer.getPosition());
        assertThrowsLike(NO_HAY_NINGUNA_ESCOTILLA_ABIERTA,()->explorer.comandar('c'));
    }
    @Test public void Aspirar(){
        Cardinal norte = new Norte();
        Coordenadas zeroZero = new Coordenadas(0,0);
        Explorer explorer = new Explorer(zeroZero,norte);
        explorer.comandar('O');
        explorer.comandar('a');
        assertEquals(N,explorer.getDireccion());
        assertEquals(new Coordenadas(0,0),explorer.getPosition());
    }
    @Test public void AspirarConEscotillaCerrada(){
        Cardinal norte = new Norte();
        Coordenadas zeroZero = new Coordenadas(0,0);
        Explorer explorer = new Explorer(zeroZero,norte);
        assertEquals(N,explorer.getDireccion());
        assertEquals(new Coordenadas(0,0),explorer.getPosition());
        assertThrowsLike(PRIMERO_TIENE_QUE_ABRIR_LA_ESCOTILLA_SUPERIOR,()->explorer.comandar('a'));
    }
    @Test public void RecogerMuestra(){
        Cardinal norte = new Norte();
        Coordenadas zeroZero = new Coordenadas(0,0);
        Explorer explorer = new Explorer(zeroZero,norte);
        explorer.comandar('o');
        explorer.comandar('i');
        assertEquals(N,explorer.getDireccion());
        assertEquals(new Coordenadas(0,0),explorer.getPosition());
    }
    @Test public void RecogerMuestraConEscotillaCerrada(){
        Cardinal norte = new Norte();
        Coordenadas zeroZero = new Coordenadas(0,0);
        Explorer explorer = new Explorer(zeroZero,norte);
        assertEquals(N,explorer.getDireccion());
        assertEquals(new Coordenadas(0,0),explorer.getPosition());
        assertThrowsLike(PRIMERO_TIENE_QUE_ABRIR_LA_ESCOTILLA_INFERIOR,()->explorer.comandar('i'));
    }
    //@Test public void RecibirComandoEmpaquetado(){}
    private static void assertThrowsLike(String excepcion, Executable executable) {
        assertEquals(excepcion,assertThrows(Exception.class, executable).getMessage());
    }
}
