package Explorer;

import java.util.Arrays;
import java.util.List;

public abstract class Command {
    protected char operacion;
    protected static List<Command> listaDeComandos = Arrays.asList(
            new Forward(), new Backward(), new Left(), new Right(), new OpenUpperHatch(),
            new OpenLowerHatch(), new CloseHatches(), new Aspirate(), new GatherSamples());

    protected Command(char operacion) {
        this.operacion = operacion;
    }

    protected boolean apply(char orden) {
        return orden == operacion;
    }
    protected abstract void accion(Explorer explorer);

    protected static Command tomarOrden(char orden) {
        return listaDeComandos.stream().filter(comando -> comando.apply(orden)).findFirst().orElseThrow(()->new RuntimeException("Comando no detectado"));
    }
}



