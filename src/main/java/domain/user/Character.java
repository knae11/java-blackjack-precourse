package domain.user;

import domain.card.Card;
import domain.common.Status;
import java.util.ArrayList;
import java.util.List;

public abstract class Character {

    private static final int BLACKJACK = 21;
    private String gameOver = "";
    public int sumOfCards = 0;

    public abstract void addCard(Card card);

    public abstract String getName();

    public abstract double getWinnerExistCaseReturnMoney();

    public abstract double getLoserExistCaseReturnMoney();

    // TODO 추가 기능 구현

    public void checkBlackJack() {
        if (sumOfCards == BLACKJACK) {
            gameOver = Status.WINNER.getStatus();
        }
    }

    public void checkDie() {
        if (sumOfCards > BLACKJACK) {
            gameOver = Status.LOSER.getStatus();
        }
    }

    public String isGameOver() {
        return gameOver;
    }

    public int getSumOfCards() {
        return sumOfCards;
    }


}

