package domain.user;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Players {
    private static List<Player> players = new ArrayList<>();

    public static void addPlayer(String player, double betting){
        players.add(new Player(player, betting));
    }
    public static List<Player> players() {
        return Collections.unmodifiableList(players);
    }
}
