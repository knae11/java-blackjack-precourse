package domain.user;

import domain.common.ErrorMessageException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class Players {
    private static List<Player> players = new ArrayList<>();
    private static final String NOT_EXIST_PLAYER = "해당 플레이어가 존재하지 않습니다.";

    public static void addPlayer(String player, double betting) {
        players.add(new Player(player, betting));
    }

    public static List<Player> players() {
        return Collections.unmodifiableList(players);
    }

    public static Player findPlayer(String targetPlayer) {
        return players.stream().filter(player -> Objects.equals(player.getName(), targetPlayer))
            .findFirst().orElseThrow(() -> new ErrorMessageException(NOT_EXIST_PLAYER));
    }

}
