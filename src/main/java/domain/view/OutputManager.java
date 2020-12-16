package domain.view;

import domain.common.GuideMessage;

public class OutputManager {
    private static final String ENTER_PLAYERS = "플레이어를 입력해주세요.";
    private static final String ENTER_BETTING = "씨 베팅금액을 입력해주세요.";
    private static final String ASKING_MORE_CARD = "카드를 더 받으시겠습니까?";

    private OutputManager(){

    }

    public static void printAskPlayers(){
        GuideMessage.print(ENTER_PLAYERS);
    }

    public static void printInputBetting(String player){
        GuideMessage.print(player + ENTER_BETTING);
    }
    public static void printAskingMoreCard(){
        GuideMessage.print(ASKING_MORE_CARD);
    }




}
