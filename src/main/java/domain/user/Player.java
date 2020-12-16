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
    private static final String WINNER = "WINNER";
    private static final String LOSER = "LOSER";
    private String gameOver = "";
    private final String name;
    private final double bettingMoney;
    private final List<Card> cards = new ArrayList<>();
    private int sumOfCards = 0;

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

    public String getName() {
        return name;
    }

    public int getSumOfCards(){
        return sumOfCards;
    }

    // TODO 추가 기능 구현

}
