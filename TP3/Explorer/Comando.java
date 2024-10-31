package explorer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public abstract class Comando {
    public static char operacion;
    private static List<Comando> listaDeComandos = Arrays.asList(
            new Forward(), new Backward(), new Left(), new Right(), new OpenUpperHatch(),
            new OpenLowerHatch(), new CloseHatches(), new Aspirate(), new GatherSamples());

    public Comando(char operacion) {
        this.operacion = operacion;
    }

    public boolean apply(char ordens) {
        return ordens == operacion;
    }
    public abstract void accion(Explorer explorer);

    public static Comando tomarOrden(char orden) {
        return listaDeComandos.stream().filter(comando -> comando.apply(orden)).toList().getFirst();
    }
}



