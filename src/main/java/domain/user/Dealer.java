package domain.user;

import domain.card.Card;

import domain.common.Status;
import java.util.ArrayList;
import java.util.List;

/**
 * 게임 딜러를 의미하는 객체
 */
public class Dealer extends Character {
    private static final int MIN_NOT_MORE_CARD = 17;
    public static final String NAME = "DEALER";
    private final List<Card> cards = new ArrayList<>();

    public Dealer() {}

    public void addCard(Card card) {
        if(sumOfCards < MIN_NOT_MORE_CARD){
            cards.add(card);
            sumOfCards += card.getScoreOfCard();
            checkDie();
            checkBlackJack();
        }
    }

    public String getName() {
        return NAME;
    }

    @Override
    public double getWinnerExistCaseReturnMoney() {
        return 0;
    }

    @Override
    public double getLoserExistCaseReturnMoney(){
        return 0;
    }

}
