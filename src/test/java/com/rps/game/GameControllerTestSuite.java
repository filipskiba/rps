package com.kodilla.rps.game;

import com.kodilla.rps.user.Player;
import com.kodilla.rps.weapon.Weapon;
import org.junit.Assert;
import org.junit.Test;

public class GameControllerTestSuite {
    @Test
    public void testRoundWinner(){
        //Given

        Weapon rock = new Weapon("Rock");
        Weapon paper = new Weapon("Paper");
        Weapon scissors = new Weapon("Scissors");

        GameController gameController = new GameController();
        Player player1 = new Player();
        player1.setName("Player 1 - Scissor");
        Player player2 = new Player();
        player2.setName("Player 2 - Paper");
        //When

        player1.setChoosedWeapon(scissors);
        player2.setChoosedWeapon(paper);
        Player winner = gameController.fight(player1,player2);
        //Then

        Assert.assertEquals("Player 1 - Scissor",winner.getName());

    }
    @Test
    public void testGameWinner(){

        Player player1 = new Player();
        Player player2 = new Player();
        GameController gameController = new GameController();

        player1.setChoosedWeapon(gameController.chooseWeapon(1));
        player2.setChoosedWeapon(gameController.chooseWeapon(3));
        gameController.fight(player1,player2);

        player1.setChoosedWeapon(gameController.chooseWeapon(3));
        player2.setChoosedWeapon(gameController.chooseWeapon(2));
        gameController.fight(player1,player2);

        player1.setChoosedWeapon(gameController.chooseWeapon(1));
        player2.setChoosedWeapon(gameController.chooseWeapon(2));
        gameController.fight(player1,player2);

        Assert.assertEquals(2,player1.getWins());
        Assert.assertEquals(1,player2.getWins());

    }
}
