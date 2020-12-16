package domain.view;

import domain.common.ErrorMessage;
import domain.common.ErrorMessageException;
import java.util.Arrays;
import java.util.Scanner;

public class InputManager {
    private static final String NO_WHITE_SPACE = "이름에 공백을 허용하지 않습니다.";
    private final Scanner scanner;
    private static final String PLAYER_SPLIT_DELIMITER = ",";
    private static final String NO_EMPTY_PLAYER = "플레이어 이름에는 공백을 허용하지 않습니다.";


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
        String[] players = playersInput.split(PLAYER_SPLIT_DELIMITER,-1);
        for (String player : players) {
            player = player.trim();
            checkEmpty(player);
            checkWhiteSpace(player);

        }
        return players;
    }

    private void checkWhiteSpace(String player) {
        if(player.contains(" ")){
            throw new ErrorMessageException(NO_WHITE_SPACE);
        }
    }

    private void checkEmpty(String player) {
        if (player.equals("")) {
            throw new ErrorMessageException(NO_EMPTY_PLAYER);
        }
    }
}
