package com.battlegame.armor;

import com.battlegame.classes.Armor;

public class Armor_2 extends Armor {
    public Armor_2(int level){
        super();
        this.name = "耀之荣光铠甲";
        this.type = "铠甲";
        this.level = level;
        calculate_armor_defend(level);
    }

    @Override
    public String getintroduction(){
        return "耀之荣光铠甲(lv "+level+"),神器铠甲,防御力+ "+defend_power;
    }

    @Override
    public int calculate_armor_defend(int level) {
        this.defend_power = 20 + 4 *level;
        return defend_power;
    }
}
