package domain.service;

import domain.user.Player;
import domain.user.Players;
import domain.view.InputManager;
import java.util.Scanner;

public class BlackjackService {
    private final InputManager inputManager;
    public BlackjackService(Scanner scanner){
        inputManager = new InputManager(scanner);


    }

    public void run(){
       String[] players = inputManager.getPlayersInput();
       setPlayersAndBetting(players);


    }

    private void setPlayersAndBetting(String[] players) {
        for(String player : players){
            double betting = inputManager.getPlayerBetting(player);
            Players.addPlayer(player, betting);
        }
    }
}
