package Explorer;

public abstract class Hatches {

    protected Hatches(){}

    protected abstract void openUpperHatch(Explorer explorer);
    protected abstract void openLowerHatch(Explorer explorer);
    protected abstract void closeHatches(Explorer explorer);
    protected abstract void aspirate();
    protected abstract void gatherSamples();
}
