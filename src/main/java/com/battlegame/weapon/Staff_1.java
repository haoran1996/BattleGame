package com.battlegame.weapon;

import com.battlegame.classes.Weapon;

public class Staff_1 extends Weapon {
    public Staff_1(int level) {
        super();
        this.name = "离火之杖";
        this.type = "法杖";
        this.level = level;
        calculate_weapon_attack(level);
    }

    @Override
    public String getintroduction(){
        return "离火之杖(lv "+level+"),稀有法杖,攻击力+"+attack_power;
    }

    @Override
    public int calculate_weapon_attack(int level) {
        this.attack_power = 37 + 6 * level;
        return attack_power;
    }

}
