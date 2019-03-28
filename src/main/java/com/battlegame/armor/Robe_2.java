package com.battlegame.armor;

import com.battlegame.classes.Armor;

public class Robe_2 extends Armor {
    public Robe_2(int level){
        super();
        this.name = "紫炎隐月长袍";
        this.type = "法袍";
        this.level = level;
        calculate_armor_defend(level);
    }

    @Override
    public String getintroduction(){
        return "紫炎隐月长袍(lv "+level+"),神器法袍,防御力+"+defend_power;
    }

    @Override
    public int calculate_armor_defend(int level) {
        this.defend_power = 20 + 3 *level;
        return defend_power;
    }
}
