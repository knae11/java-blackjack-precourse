package domain.service;

import domain.card.ShuffledCard;
import domain.common.Answer;
import domain.common.Status;
import domain.user.Character;
import domain.user.Dealer;
import domain.user.Players;
import domain.view.InputManager;
import java.util.Scanner;

public class BlackjackService {
    private static final int TWO = 2;
    private final InputManager inputManager;
    private final ShuffledCard shuffledCard;

    public BlackjackService(Scanner scanner) {
        inputManager = new InputManager(scanner);
        shuffledCard = new ShuffledCard();
    }

    public void run() {
        String[] players = inputManager.getPlayersInput();
        setPlayersAndBetting(players);
        initHandoutCards();
        playNextTurn();
        printResult();
    }

    private void playNextTurn() {
        if (turnForPlayers()) {
            return;
        }
    }


    private boolean turnForPlayers() {
        for (Character player : Players.players()) {
            if(player.getName().equals(Dealer.NAME)){
                continue;
            }
            String answer = inputManager.getAnswerOfMoreCard();
            if (answer.equals(Answer.YES.getAnswer())) {
                player.addCard(shuffledCard.getShuffledCard());
            }
            System.out.println(player.getSumOfCards());
            if (checkDie(player)) {
                return true;
            }
        }
        return false;
    }


    private boolean checkDie(Character player) {
        if (!player.isGameOver().equals("")) {
            System.out.println(player.isGameOver());
            return true;
        }
        return false;
    }

    //todo : 베팅금액 표시
    private void printResult() {
        if (Players.findIsWinner()) {
            System.out.println("winnerCase");
            isWinnerCase();
            return;
        }
        isLoserCase();

    }

    private void isLoserCase() {
        for(Character player : Players.players()){
            if(player.getName().equals(Dealer.NAME)){
                System.out.println(player.getName() + " - 카드합계 : " + player.getSumOfCards());
                continue;
            }
            System.out.println(
                player.getName() + " -  카드 합계 : " + player.getSumOfCards() + ", 결과 : " + player
                    .getLoserExistCaseReturnMoney());
        }

    }

    private void isWinnerCase() {
        for(Character player : Players.players()){
            if(player.getName().equals(Dealer.NAME)){
                System.out.println(player.getName() + " - 카드합계 : " + player.getSumOfCards());
                continue;
            }
            System.out.println(
                player.getName() + " -  카드 합계 : " + player.getSumOfCards() + ", 결과 : " + player
                    .getWinnerExistCaseReturnMoney());
        }
    }
/*
    private void isPlayerWinner() {
        System.out.println(dealer.getName() + " - 카드합계 : " + dealer.getSumOfCards());
        //for ()

    }

    private void isDealerWinner() {
        System.out.println(dealer.getName() + " - 카드합계 : " + dealer.getSumOfCards());
        for (Character player : Players.players()) {
            System.out.println(
                player.getName() + " -  카드 합계 : " + player.getSumOfCards() + ", 결과 : " + player
                    .getReturnMoneyWhenWinnerExists());
        }
    }
*/
    private void initHandoutCards() {
        for (int i = 0; i < TWO; i++) {
            setAllPlayersCard();
        }
    }

    private void setAllPlayersCard() {
        for (Character player : Players.players()) {
            player.addCard(shuffledCard.getShuffledCard());
        }
    }

    private void setPlayersAndBetting(String[] players) {
        Players.addDealer(new Dealer());
        for (String player : players) {
            double betting = inputManager.getPlayerBetting(player);
            Players.addPlayer(player, betting);
        }
    }
}
