package domain.user;

import domain.card.Card;

import java.util.ArrayList;
import java.util.List;

/**
 * 게임 딜러를 의미하는 객체
 */
public class Dealer  {
    private static final int BLACKJACK = 21;
    public String gameOver = "";
    public int sumOfCards = 0;
    private static final String WINNER = "WINNER";
    private static final String LOSER = "LOSER";
    private static final int MIN_NOT_MORE_CARD = 17;
    private final String name = "DEALER";
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
    public void checkBlackJack() {
        if(sumOfCards == BLACKJACK){
            gameOver = WINNER;
        }
    }
    public void checkDie() {
        if (sumOfCards > BLACKJACK) {
            gameOver = LOSER;
        }
    }
    public String isGameOver(){
        return gameOver;
    }
    public int getSumOfCards(){
        return sumOfCards;
    }

    public String getName() {
        return name;
    }


    // TODO 추가 기능 구현

}
