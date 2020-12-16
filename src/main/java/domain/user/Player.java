package domain.user;

import domain.card.Card;

import domain.common.Status;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

/**
 * 게임 참여자를 의미하는 객체
 */
public class Player extends Character {
    private final String name;
    private final double bettingMoney;
    private static final double WINNER_RATE = 1.5;
    private final List<Card> cards = new ArrayList<>();

    public Player(String name, double bettingMoney) {
        this.name = name;
        this.bettingMoney = bettingMoney;
    }

    @Override
    public void addCard(Card card) {
        cards.add(card);
        sumOfCards += card.getScoreOfCard();
        checkDie();
        checkBlackJack();
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public double getWinnerExistCaseReturnMoney() {
        if(isGameOver().equals(Status.WINNER.getStatus())){
            return bettingMoney * WINNER_RATE;
        }
        return 0;
    }

    @Override
    public double getLoserExistCaseReturnMoney() {
        if(isGameOver().equals(Status.LOSER.getStatus())){
            return 0;
        }
        return bettingMoney;
    }

}
