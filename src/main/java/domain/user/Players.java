package domain.user;

import domain.common.ErrorMessageException;
import domain.common.Status;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class Players {
    private static List<Character> players = new ArrayList<>();
    private static final String NOT_EXIST_PLAYER = "해당 플레이어가 존재하지 않습니다.";

    private Players(){
    }
    public static void addDealer(Character dealer){
        players.add(dealer);
    }
    public static void addPlayer(String player, double betting) {
        players.add(new Player(player, betting));
    }

    public static List<Character> players() {
        return Collections.unmodifiableList(players);
    }

    public static boolean findIsWinner() {
        return players.stream().anyMatch(player -> Objects.equals(player.getName(), Status.WINNER.getStatus()));
    }


}
