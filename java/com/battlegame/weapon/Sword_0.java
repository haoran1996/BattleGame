package com.battlegame.weapon;

import com.battlegame.classes.Weapon;

public class Sword_0 extends Weapon {

    public Sword_0(int level) {
        super();
        this.name = "青石巨剑";
        this.type = "巨剑";
        this.level = level;
        calculate_weapon_attack(level);
    }

    @Override
    public String getintroduction(){
        return "青石巨剑(lv "+level+"),普通巨剑,攻击力+"+attack_power;
    }

    @Override
    public int calculate_weapon_attack(int level) {
        this.attack_power = 33 + 5 * level;
        return attack_power;
    }
}
