package com.battlegame.classes;

public abstract class Armor extends Equipment{
    private Equipment equipment;

    public Armor(){

    }

    public Armor(Equipment equipment) {
        this.equipment = equipment;
    }

    @Override
    public String getintroduction(){
        return "这是一个防具";
    }

    public abstract int calculate_armor_defend(int level);

    public int getDefend_power() {
        return defend_power;
    }

    public void setDefend_power(int defend_power) {
        this.defend_power = defend_power;
    }
}
