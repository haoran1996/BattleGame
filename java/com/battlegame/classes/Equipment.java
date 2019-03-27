package com.battlegame.classes;

public abstract class Equipment {
    protected String name;
    protected String type;
    protected int level;
    protected int defend_power;
    protected int attack_power;

    public Equipment(){
        this.type = "装备";
    }

    public String getintroduction(){
        return "这是一个装备";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

}
