package com.rps.user;

import com.rps.weapon.Weapon;

public class Player {
    private String name;
    private int wins = 0;
    private Weapon chosenWeapon;

    public void addPoint() {
        this.wins++;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getWins() {
        return wins;
    }

    public void setWins(int wins) {
        this.wins = wins;
    }

    public Weapon getChosenWeapon() {
        return chosenWeapon;
    }

    public void setChosenWeapon(Weapon chosenWeapon) {
        this.chosenWeapon = chosenWeapon;
    }

}
