package domain.user;

import domain.card.Card;
import domain.common.Status;

public abstract class BlackJackCharacter {
    private static final int BLACKJACK = 21;
    private String gameOver = "";
    public int sumOfCards = 0;

    public abstract void addCard(Card card);

    public abstract String getName();

    public abstract double getWinnerExistCaseReturnMoney();

    public abstract double getLoserExistCaseReturnMoney();

    public void setAsWinner() {
        gameOver = Status.WINNER.getStatus();
    }

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

