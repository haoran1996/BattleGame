package com.battlegame.armor;

import com.battlegame.classes.Armor;

public class Robe_1 extends Armor {
    public Robe_1(int level){
        super();
        this.name = "琉璃丝绸长袍";
        this.type = "法袍";
        this.level = level;
        calculate_armor_defend(level);
    }

    @Override
    public String getintroduction(){
        return "琉璃丝绸长袍(lv "+level+"),稀有法袍,防御力+"+defend_power;
    }

    @Override
    public int calculate_armor_defend(int level) {
        this.defend_power = 10 + 2 *level;
        return defend_power;
    }
}
