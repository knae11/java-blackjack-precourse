package domain;

import domain.service.BlackjackService;
import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        BlackjackService blackjackService = new BlackjackService(scanner);
        blackjackService.run();
        scanner.close();
    }
}
