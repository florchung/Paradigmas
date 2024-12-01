package NoGracias;

public class NobodyPlays extends Player{
    private String EL_JUEGO_YA_TERMINO= "El juego ya termino";
    public NobodyPlays(String name,int points) {
        super(name,points);
    }
    public void useCoin() {
        throw new RuntimeException(EL_JUEGO_YA_TERMINO);
    }
    public void drawCard(NoGracias game) {
        throw new RuntimeException(EL_JUEGO_YA_TERMINO);
    }
    public int points(){
        return tokens;
    }
}
