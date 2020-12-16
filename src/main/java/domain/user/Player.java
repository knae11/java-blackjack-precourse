package domain.user;

import domain.card.Card;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

/**
 * 게임 참여자를 의미하는 객체
 */
public class Player {
    private static final int BLACKJACK = 21;
    public static final double WINNER_RATE = 1.5;
    public String gameOver = "";
    public int sumOfCards = 0;
    private static final String WINNER = "WINNER";
    private static final String LOSER = "LOSER";
    private final String name;
    private final double bettingMoney;
    private double returnMoney = 0;
    private final List<Card> cards = new ArrayList<>();

    public Player(String name, double bettingMoney) {
        this.name = name;
        this.bettingMoney = bettingMoney;
    }

    public void addCard(Card card) {
        cards.add(card);
        sumOfCards += card.getScoreOfCard();
        checkDie();
        checkBlackJack();
    }

    public String getName() {
        return name;
    }

    // TODO 추가 기능 구현

    public void checkBlackJack() {
        if (sumOfCards == BLACKJACK) {
            returnMoney = bettingMoney* WINNER_RATE;
            gameOver = WINNER;
        }
    }

    public void checkDie() {
        if (sumOfCards > BLACKJACK) {
            gameOver = LOSER;
        }
    }

    public String isGameOver() {
        return gameOver;
    }

    public int getSumOfCards() {
        return sumOfCards;
    }

    public double getReturnMoney(){
        return returnMoney;
    }
}
