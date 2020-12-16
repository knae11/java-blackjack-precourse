package domain.card;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ShuffledCard {

    private List<Card> randomCards = new ArrayList<>(CardFactory.create());
    private int cardNumber = -1;
    public ShuffledCard(){
        Collections.shuffle(randomCards);
    }
    public Card getShuffledCard(){
        cardNumber += 1;
        return randomCards.get(cardNumber);
    }
}
