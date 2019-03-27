package com.battlegame.weapon;

import com.battlegame.classes.Weapon;

public class Sword_1 extends Weapon {
    public Sword_1(int level) {
        super();
        this.name = "帝国斩铁巨剑";
        this.type = "巨剑";
        this.level = level;
        calculate_weapon_attack(level);
    }

    @Override
    public String getintroduction(){
        return "帝国斩铁巨剑(lv "+level+"),稀有巨剑,攻击力+"+attack_power;
    }

    @Override
    public int calculate_weapon_attack(int level) {
        this.attack_power = 41 + 7 * level;
        return attack_power;
    }
}
