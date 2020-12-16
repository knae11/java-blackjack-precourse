package domain.user;

import domain.card.Card;

import java.util.ArrayList;
import java.util.List;

/**
 * 게임 딜러를 의미하는 객체
 */
public class Dealer {
    private static final int BLACKJACK = 21;
    private static final String WINNER = "WINNER";
    private static final String LOSER = "LOSER";
    private String gameOver = "";
    private final List<Card> cards = new ArrayList<>();
    private int sumOfCards = 0;

    public Dealer() {}

    public void addCard(Card card) {
        cards.add(card);
        sumOfCards += card.getScoreOfCard();
        checkDie();
        checkBlackJack();
    }

    // TODO 추가 기능 구현
    private void checkBlackJack() {
        if(sumOfCards == BLACKJACK){
            gameOver = WINNER;
        }
    }

    private void checkDie() {
        if (sumOfCards > BLACKJACK) {
            gameOver = LOSER;
        }
    }
    private String isGameOver(){
        return gameOver;
    }
    public int getSumOfCards(){
        return sumOfCards;
    }
}
