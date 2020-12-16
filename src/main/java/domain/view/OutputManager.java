package domain.view;

import domain.common.GuideMessage;

public class OutputManager {
    private static final String ENTER_PLAYERS = "플레이어를 입력해주세요.";
    private static final String ENTER_BETTING = "씨 베팅금액을 입력해주세요.";

    private OutputManager(){

    }

    public static void printAskPlayers(){
        GuideMessage.print(ENTER_PLAYERS);
    }

    public static void printInputBetting(String player){
        GuideMessage.print(player + ENTER_BETTING);
    }
}
