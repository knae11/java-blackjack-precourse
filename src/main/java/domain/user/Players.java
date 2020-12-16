package domain.user;

import domain.common.ErrorMessageException;
import domain.common.Status;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class Players {
    private static List<Character> players = new ArrayList<>();
    private static int maxScore = 0;

    private Players(){
    }
    public static void addDealer(Character dealer){
        players.add(dealer);
        setMaxScore(dealer.getSumOfCards());
    }

    public static void setMaxScore(int score) {
        if(maxScore < score){
            maxScore = score;
        }
    }

    public static void setResultWhenTie(){
        players.stream().filter(player -> player.getSumOfCards() == maxScore).forEach(player -> player.setAsWinner());
    }

    public static void addPlayer(String playerInput, double betting) {
        Character player = new Player(playerInput, betting);
        players.add(player);
        setMaxScore(player.getSumOfCards());
    }

    public static List<Character> players() {
        return Collections.unmodifiableList(players);
    }

    public static boolean findIsWinner() {
        return players.stream().anyMatch(player -> Objects.equals(player.isGameOver(), Status.WINNER.getStatus()));
    }


}
