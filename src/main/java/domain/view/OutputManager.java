package domain.view;

import domain.common.GuideMessage;

public class OutputManager {
    private static final String ENTER_PLAYERS = "플레이어를 입력해주세요.";
    private OutputManager(){

    }

    public static void printAskPlayers(){
        GuideMessage.print(ENTER_PLAYERS);
    }
}
