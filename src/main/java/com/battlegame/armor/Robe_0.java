package com.battlegame.armor;

import com.battlegame.classes.Armor;

public class Robe_0 extends Armor {
    public Robe_0(int level){
        super();
        this.name = "粗布法袍";
        this.type = "法袍";
        this.level = level;
        calculate_armor_defend(level);
    }

    @Override
    public String getintroduction(){
        return "粗布法袍(lv "+level+"),普通法袍,防御力+"+defend_power;
    }

    @Override
    public int calculate_armor_defend(int level) {
        this.defend_power = 10 + 1 *level;
        return defend_power;
    }

}
