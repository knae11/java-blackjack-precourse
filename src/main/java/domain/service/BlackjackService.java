package domain.service;

import domain.card.ShuffledCard;
import domain.common.Answer;
import domain.user.BlackJackCharacter;
import domain.user.Dealer;
import domain.user.Players;
import domain.view.InputManager;
import domain.view.OutputManager;
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
        if (turnAgain()) {
            return;
        }
        setCaseOfNoWinnerAndLoser();
    }

    private void setCaseOfNoWinnerAndLoser() {
        Players.setResultWhenTie();
    }


    private boolean turnAgain() {
        for (BlackJackCharacter player : Players.players()) {
            if (player.getName().equals(Dealer.NAME)) {
                return turnForDealer(player);
            }
            if (turnForPlayers(player)) {
                return true;
            }
        }
        return false;
    }

    private boolean turnForDealer(BlackJackCharacter player) {
        player.addCard(shuffledCard.getShuffledCard());
        return checkDie(player);

    }

    private boolean turnForPlayers(BlackJackCharacter player) {
        String answer = inputManager.getAnswerOfMoreCard();
        if (answer.equals(Answer.YES.getAnswer())) {
            player.addCard(shuffledCard.getShuffledCard());
            return checkDie(player);
        }
        return false;
    }


    private boolean checkDie(BlackJackCharacter player) {
        return !player.isGameOver().equals("");
    }

    private void printResult() {
        if (Players.findIsWinner()) {
            isWinnerCase();
            return;
        }
        isLoserCase();
    }

    private void isLoserCase() {
        for (BlackJackCharacter player : Players.players()) {
            if (player.getName().equals(Dealer.NAME)) {
                OutputManager.printDealerCase(player);
                continue;
            }
            OutputManager.printLoserPlayerCase(player);
        }
    }

    private void isWinnerCase() {
        for (BlackJackCharacter player : Players.players()) {
            if (player.getName().equals(Dealer.NAME)) {
                OutputManager.printDealerCase(player);
                continue;
            }
            OutputManager.printWinnerPlayerCase(player);
        }
    }

    private void initHandoutCards() {
        for (int i = 0; i < TWO; i++) {
            setAllPlayersCard();
        }
    }

    private void setAllPlayersCard() {
        for (BlackJackCharacter player : Players.players()) {
            player.addCard(shuffledCard.getShuffledCard());
        }
    }

    private void setPlayersAndBetting(String[] players) {
        for (String player : players) {
            double betting = inputManager.getPlayerBetting(player);
            Players.addPlayer(player, betting);
        }
        Players.addDealer(new Dealer());
    }
}
