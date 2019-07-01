package com.rps.user;

import com.rps.weapon.Weapon;

public class Player {
    private String name;
    private int wins = 0;
    private Weapon choosedWeapon;

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

    public Weapon getChoosedWeapon() {
        return choosedWeapon;
    }

    public void setChoosedWeapon(Weapon choosedWeapon) {
        this.choosedWeapon = choosedWeapon;
    }

}
