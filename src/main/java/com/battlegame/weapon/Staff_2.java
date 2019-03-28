package com.battlegame.weapon;

import com.battlegame.classes.Weapon;

public class Staff_2 extends Weapon {
    public Staff_2(int level) {
        super();
        this.name = "苍凉之月权杖";
        this.type = "法杖";
        this.level = level;
        calculate_weapon_attack(level);
    }

    @Override
    public String getintroduction(){
        return "苍凉之月权杖(lv "+level+"),神器法杖,攻击力+"+attack_power;
    }

    @Override
    public int calculate_weapon_attack(int level) {
        this.attack_power = 41 + 9 * level;
        return attack_power;
    }
}
