package com.battlegame.armor;

import com.battlegame.classes.Armor;

public class Armor_1 extends Armor {
    public Armor_1(int level){
        super();
        this.name = "帝国黑金铠甲";
        this.type = "铠甲";
        this.level = level;
        calculate_armor_defend(level);
    }

    @Override
    public String getintroduction(){
        return "帝国黑金铠甲(lv "+level+"),稀有铠甲,防御力+ "+defend_power;
    }

    @Override
    public int calculate_armor_defend(int level) {
        this.defend_power = 17 + 3 *level;
        return defend_power;
    }

}
