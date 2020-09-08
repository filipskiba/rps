package com.rps.game;

import com.rps.user.Player;
import com.rps.weapon.*;

public class GameController {

    Weapon rock = new Weapon("Rock");
    Weapon paper = new Weapon("Paper");
    Weapon scissors = new Weapon("Scissors");
    Weapon lizard = new Weapon("Lizard");
    Weapon spock = new Weapon("Spock");

    private Weapon chosenWeapon;

    public void setRules() {
        rock.addWeakness(paper);
        paper.addWeakness(scissors);
        scissors.addWeakness(rock);
        lizard.addWeakness(rock);
        lizard.addWeakness(scissors);
        spock.addWeakness(lizard);
        spock.addWeakness(paper);

        rock.addLoseInfo(paper, "The paper covers the rock");
        rock.addLoseInfo(spock, "Spock smashes the rock");

        paper.addLoseInfo(scissors, "The scissors cuts the paper");
        paper.addLoseInfo(lizard, "The lizard eats paper");

        scissors.addLoseInfo(rock, "The rock crushes scissors");
        scissors.addLoseInfo(spock, "Spock breaks scissors");

        lizard.addLoseInfo(rock, "The rock crushes the lizard");
        lizard.addLoseInfo(scissors, "The scissors hurt the lizard");

        spock.addLoseInfo(lizard, "The lizard is poisoning spock");
        spock.addLoseInfo(paper, "Paper proves the spock mistake");
    }

    public GameController() {
        setRules();
    }

    public Weapon chooseWeapon(int option) {

        switch (option) {
            case 1:
                chosenWeapon = rock;
                break;
            case 2:
                chosenWeapon = paper;
                break;
            case 3:
                chosenWeapon = scissors;
                break;
            case 4:
                chosenWeapon = spock;
                break;
            case 5:
                chosenWeapon = lizard;
                break;
        }
        return chosenWeapon;

    }

    public Player fight(Player player1, Player player2) {

        if (player1.getChosenWeapon().equals(player2.getChosenWeapon())) {
            System.out.println("Draw");
            return null;
        } else {
            if (player1.getChosenWeapon().getWeakness().contains(player2.getChosenWeapon())) {
                player2.addPoint();
                System.out.println(player1.getChosenWeapon().getLoseMessage(player2.getChosenWeapon()));
                return player2;
            } else {
                player1.addPoint();
                System.out.println(player2.getChosenWeapon().getLoseMessage(player1.getChosenWeapon()));
                return player1;
            }
        }
    }

    public String getWinner(Player player1, Player player2) {
        if (player1.getWins() > player2.getWins())
            return player1.getName();
        else if (player1.getWins() == player2.getWins())
            return "Draw";
        else
            return player2.getName();
    }


}
