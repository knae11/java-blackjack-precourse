package domain.view;

import domain.common.Answer;
import domain.common.ErrorMessage;
import domain.common.ErrorMessageException;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.Scanner;
import javafx.scene.chart.ScatterChart;

public class InputManager {
    private static final String NOT_UNDER_ONE = "1이상의 금액을 입력해주세요.";
    private static final String NO_WHITE_SPACE = "이름에 공백을 허용하지 않습니다.";
    private static final String NOT_DOUBLE = "숫자로 입력해 주세요.";
    private static final int MIN_BETTING = 1;
    private static final String PLAYER_SPLIT_DELIMITER = ",";
    private static final String NO_EMPTY_PLAYER = "플레이어 이름에는 공백을 허용하지 않습니다.";
    private static final String YES_OR_NO = "y, n 중에서 입력해 주세요.";


    private final Scanner scanner;

    public InputManager(Scanner scanner) {
        this.scanner = scanner;
    }

    public String[] getPlayersInput() {
        while (true) {
            try {
                OutputManager.printAskPlayers();
                String playersInput = scanner.nextLine().trim();
                String[] players = checkPlayersInput(playersInput);
                System.out.println(Arrays.toString(players));
                return players;
            } catch (ErrorMessageException errorMessageException) {
                ErrorMessage.print(errorMessageException);
            }
        }
    }

    private String[] checkPlayersInput(String playersInput) {
        String[] players = playersInput.split(PLAYER_SPLIT_DELIMITER, -1);
        for (String player : players) {
            player = player.trim();
            checkEmpty(player);
            checkWhiteSpace(player);

        }
        return players;
    }

    private void checkWhiteSpace(String player) {
        if (player.contains(" ")) {
            throw new ErrorMessageException(NO_WHITE_SPACE);
        }
    }

    private void checkEmpty(String player) {
        if (player.equals("")) {
            throw new ErrorMessageException(NO_EMPTY_PLAYER);
        }
    }

    public double getPlayerBetting(String player) {
        while (true) {
            OutputManager.printInputBetting(player);
            String bettingInput = scanner.nextLine().trim();
            try {
                return checkNumber(bettingInput);
            } catch (ErrorMessageException errorMessageException) {
                ErrorMessage.print(errorMessageException);
            }
        }
    }

    private double checkNumber(String bettingInput) {
        try {
            double betting = Double.parseDouble(bettingInput);
            checkOverOne(betting);
            return betting;
        } catch (NumberFormatException n) {
            throw new ErrorMessageException(NOT_DOUBLE);
        }

    }

    private void checkOverOne(double betting) {
        if (betting < MIN_BETTING) {
            throw new ErrorMessageException(NOT_UNDER_ONE);
        }
    }

    public String getAnswerOfMoreCard() {
        while (true) {
            try {
                OutputManager.printAskingMoreCard();
                String answer = scanner.nextLine().trim();
                checkAnswer(answer);
                return answer;
            } catch (ErrorMessageException errorMessageException) {
                ErrorMessage.print(errorMessageException);
            }
        }
    }

    private void checkAnswer(String answer) {
        if (!(answer.equals(Answer.YES.getAnswer()) || answer.equals(Answer.NO.getAnswer()))) {
            throw new ErrorMessageException(YES_OR_NO);
        }
    }
}
