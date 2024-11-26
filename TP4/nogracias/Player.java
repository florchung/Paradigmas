// package nogracias;

// public class Player {
//     private String name;
//     private int points;

//     public Player(String name) {
//         this.name = name;
//         this.points = 0;
//     }

//     public String getName() {
//         return name;
//     }

//     public int getPoints() {
//         return points;
//     }

//     public void addPoints(int points) {
//         this.points += points;
//     }

//     public void resetPoints() {
//         this.points = 0;
//     }
// }
package NoGracias;

import java.util.ArrayList;
import java.util.Objects;

public class Player {
    private String name;
    private ArrayList<Card> drawnCards = new ArrayList<>();
    private int tokens;
    private String EL_JUGADOR_YA_NO_TIENE_MAS_FICHAS="El jugador ya no tiene mas fichas";

    public Player(String name, int tokens) {
        this.name = name;
        this.tokens = tokens;
    }
    public void useCoin(){
        if(tokens==0){
            throw new RuntimeException(EL_JUGADOR_YA_NO_TIENE_MAS_FICHAS);
        }
        tokens-=1;
    }
    public String name(){
        return name;
    }
    public int points(){
        return -drawnCards.stream().reduce(0,(total,card)->total+card.value(), Integer ::sum)+ tokens;
    }
    public boolean equals(Objects anObject){
        return Player.class.isInstance(anObject)&& name==Player.class.cast(anObject).name&&tokens==Player.class.cast(anObject).tokens;
    }
    public void drawCard(Card aCard) {
        drawnCards.add(aCard);
    }
    public void addTokens(int tokensPot) {
        tokens+=tokensPot;
    }
}

