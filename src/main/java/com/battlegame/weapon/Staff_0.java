package com.battlegame.weapon;

import com.battlegame.classes.Weapon;

public class Staff_0 extends Weapon {
    public Staff_0(int level) {
        super();
        this.name = "枯木法杖";
        this.type = "法杖";
        this.level = level;
        calculate_weapon_attack(level);
    }

    @Override
    public String getintroduction(){
        return "枯木法杖(lv "+level+"),普通法杖,攻击力+"+attack_power;
    }

    @Override
    public int calculate_weapon_attack(int level) {
        this.attack_power = 25 + 5 * level;
        return attack_power;
    }

}
