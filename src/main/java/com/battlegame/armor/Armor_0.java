package com.battlegame.armor;

import com.battlegame.classes.Armor;

public class Armor_0 extends Armor {

    public Armor_0(int level){
        super();
        this.name = "锁子甲";
        this.type = "铠甲";
        this.level = level;
        calculate_armor_defend(level);
    }

    @Override
    public String getintroduction(){
        return "锁子甲(lv "+level+"),普通铠甲,防御力+"+defend_power;
    }

    @Override
    public int calculate_armor_defend(int level) {
        this.defend_power = 15 + 2 *level;
        return defend_power;
    }

}
