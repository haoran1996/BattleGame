package com.battlegame.weapon;

import com.battlegame.classes.Weapon;

public class Sword_2  extends Weapon {
    public Sword_2(int level) {
        super();
        this.name = "魔剑阿波菲斯";
        this.type = "巨剑";
        this.level = level;
        calculate_weapon_attack(level);
    }

    @Override
    public String getintroduction(){
        return "魔剑阿波菲斯(lv "+level+"),神器巨剑,攻击力+"+attack_power;
    }

    @Override
    public int calculate_weapon_attack(int level) {
        this.attack_power = 49 + 9 * level;
        return attack_power;
    }
}
