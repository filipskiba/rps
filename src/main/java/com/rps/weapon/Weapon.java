package com.rps.weapon;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Weapon {

    private String weaponName;
    private final ArrayList<Weapon> weakness = new ArrayList<Weapon>();
    private HashMap<Weapon, String> loseMessages = new HashMap<>();


    public ArrayList getWeakness() {
        return weakness;
    }

    public void addWeakness(Weapon weapon) {
        weakness.add(weapon);
    }

    public void addLoseInfo(Weapon weapon, String message) {
        loseMessages.put(weapon, message);
    }

    public String getLoseMessage(Weapon weapon) {
        String message = "";
        for (Map.Entry<Weapon, String> entry : loseMessages.entrySet()) {
            if (entry.getKey() == weapon)
                message = entry.getValue();
        }
        return message;
    }

    public String getWeaponName() {
        return weaponName;
    }

    public void setWeaponName(String weaponName) {
        this.weaponName = weaponName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Weapon that = (Weapon) o;
        return Objects.equals(weaponName, that.weaponName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(weaponName);
    }

    public Weapon(String weaponName) {
        this.weaponName = weaponName;
    }

    @Override
    public String toString() {
        return weaponName;
    }
}
