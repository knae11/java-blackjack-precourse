package domain.service;

import domain.view.InputManager;
import java.util.Scanner;

public class BlackjackService {
    private final InputManager inputManager;
    public BlackjackService(Scanner scanner){
        inputManager = new InputManager(scanner);


    }

    public void run(){
       String[] players = inputManager.getPlayersInput();

    }
}
