package domain.view;

import domain.common.GuideMessage;
import domain.user.BlackJackCharacter;

public class OutputManager {
    private static final String ENTER_PLAYERS = "플레이어를 입력해주세요.";
    private static final String ENTER_BETTING = "씨 베팅금액을 입력해주세요.";
    private static final String ASKING_MORE_CARD = "카드를 더 받으시겠습니까?";
    private static final String SUM_CARDS = " - 카드합계 : ";
    private static final String RETURN_MONEY = ", 결과금액 : ";

    private OutputManager() {
    }

    public static void printAskPlayers() {
        GuideMessage.print(ENTER_PLAYERS);
    }

    public static void printInputBetting(String player) {
        GuideMessage.print(player + ENTER_BETTING);
    }

    public static void printAskingMoreCard() {
        GuideMessage.print(ASKING_MORE_CARD);
    }

    public static void printDealerCase(BlackJackCharacter player) {
        System.out.println(player.getName() + SUM_CARDS + player.getSumOfCards());
    }

    public static void printLoserPlayerCase(BlackJackCharacter player) {
        System.out.println(
            player.getName() + SUM_CARDS + player.getSumOfCards() + RETURN_MONEY + player
                .getLoserExistCaseReturnMoney());
    }

    public static void printWinnerPlayerCase(BlackJackCharacter player) {
        System.out.println(
            player.getName() + SUM_CARDS + player.getSumOfCards() + RETURN_MONEY + player
                .getWinnerExistCaseReturnMoney());
    }
}
