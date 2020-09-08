package com.rps.game;

import com.rps.user.Player;

import java.util.Random;
import java.util.Scanner;

public class Menu {

    int roundCounter = 0;
    int rounds = 0;

    Player player1 = new Player();
    Player player2 = new Player();
    GameController gameController = new GameController();

    Scanner scanner = new Scanner(System.in);

    public void mainMenu() {
        System.out.println("Menu:");
        System.out.println("1 - Play");
        System.out.println("2 - Exit");

        while (!scanner.hasNextInt()) scanner.next();
        int option = scanner.nextInt();

        switch (option) {
            case 1:
                round();
                break;
            case 2:
                System.out.println("Game over");
                scanner.close();
                break;
        }
    }

    public void repeatGame() {
        System.out.println("Game over. Do you want to repeat? Y/N?");
        String repeat = scanner.next();
        if (repeat.toLowerCase().equals("y")) {
            player1.setWins(0);
            player2.setWins(0);
            round();
        } else if (repeat.toLowerCase().equals("n")) {
            mainMenu();
        } else {
            System.out.println("Choose one option  Y or N");
            repeatGame();
        }
    }

    public void round() {
        System.out.println("Enter your name: ");
        player1.setName(scanner.next());
        player2.setName("Cpu");
        System.out.print("Welcome " + player1.getName() + "\n");

        System.out.println("Select the number of rounds: ");
        while (!scanner.hasNextInt()) scanner.next();
        rounds = scanner.nextInt();

        do {
            System.out.println("****************************************************");
            System.out.println("Round: " + (roundCounter + 1));
            System.out.println(player1.getName() + " choose your weapon: ");
            System.out.println("1 - rock, 2- paper, 3 - scissors, 4 - spock, 5 - lizard");
            battle();
        }
        while (roundCounter < rounds);
        System.out.println("The winner is: " + gameController.getWinner(player1, player2));
        roundCounter = 0;
        rounds = 0;
        repeatGame();
        scanner.close();
    }

    public void battle() {
        Random cpuChoose = new Random();
        while (!scanner.hasNextInt()) scanner.next();
        int choice = scanner.nextInt();
        if (choice > 0 && choice < 6) {
            player1.setChosenWeapon(gameController.chooseWeapon(choice));
            player2.setChosenWeapon(gameController.chooseWeapon(cpuChoose.nextInt(4) + 1));
            System.out.println(player1.getName() + " : " + player1.getChosenWeapon().toString() + " , "
                    + player2.getName() + " : " + player2.getChosenWeapon().toString());
            gameController.fight(player1, player2);
            System.out.println("******************Results****************************");
            System.out.println(player1.getName() + ": " + player1.getWins());
            System.out.println(player2.getName() + ": " + player2.getWins());
            System.out.println("****************************************************");
            roundCounter++;
        } else {
            System.out.println("Choose option between 1 - 5");
            battle();
        }
    }
}
