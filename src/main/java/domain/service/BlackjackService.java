package domain.service;

import domain.card.Card;
import domain.card.CardFactory;
import domain.card.ShuffledCard;
import domain.common.Answer;
import domain.user.Dealer;
import domain.user.Player;
import domain.user.Players;
import domain.view.InputManager;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class BlackjackService {
    private static final int TWO = 2;
    private final InputManager inputManager;
    private final ShuffledCard shuffledCard;
    private final Dealer dealer;

    public BlackjackService(Scanner scanner) {
        inputManager = new InputManager(scanner);
        shuffledCard = new ShuffledCard();
        dealer = new Dealer();
    }

    public void run() {
        String[] players = inputManager.getPlayersInput();
        setPlayersAndBetting(players);
        initHandoutCards();
        playNextTurn();
        printResult();


    }

    private void playNextTurn() {
        if(turnForPlayers()){
            return;
        }
        if(turnForDealer()){
            return;
        }
    }

    private boolean turnForDealer() {
        dealer.addCard(shuffledCard.getShuffledCard());
        if(checkDieForDealer()) {
            return true;
        }
        return false;
    }

    private boolean turnForPlayers() {
        for (Player player : Players.players()) {
            String answer = inputManager.getAnswerOfMoreCard();
            if(answer.equals(Answer.YES.getAnswer())){
                player.addCard(shuffledCard.getShuffledCard());
            }
            System.out.println(player.getSumOfCards());
            if(checkDie(player)){
                return true;
            };
        }
        return false;
    }

    private boolean checkDieForDealer() {
        if(!dealer.isGameOver().equals("")){
            System.out.println(dealer.isGameOver());
            return true;
        }
        return false;
    }

    private boolean checkDie(Player player) {
        if(!player.isGameOver().equals("")){
            System.out.println(player.isGameOver());
            return true;
        }
        return false;
    }
    //todo : 베팅금액 표시
    private void printResult() {
        System.out.println(dealer.getName() + " - 카드합계 : " + dealer.getSumOfCards());
        for (Player player : Players.players()) {
            System.out.println(player.getName() + " -  카드 합계 : " + player.getSumOfCards() + ", 결과 : " + player.getReturnMoney());
        }
    }

    private void initHandoutCards() {
        for (int i = 0; i < TWO; i++) {
            dealer.addCard(shuffledCard.getShuffledCard());
            setAllPlayersCard();
        }
    }

    private void setAllPlayersCard() {
        for (Player player : Players.players()) {
            player.addCard(shuffledCard.getShuffledCard());
        }
    }

    private void setPlayersAndBetting(String[] players) {
        for (String player : players) {
            double betting = inputManager.getPlayerBetting(player);
            Players.addPlayer(player, betting);
        }
    }
}
