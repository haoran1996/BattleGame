package com.battlegame.monster;

import com.battlegame.armor.Armor_2;
import com.battlegame.armor.Robe_2;
import com.battlegame.classes.Equipment;
import com.battlegame.classes.Monster;
import com.battlegame.weapon.Staff_2;
import com.battlegame.weapon.Sword_2;

import java.util.Random;

public class Monster_2_1 extends Monster {
    public Monster_2_1(int level){
        super();
        this.name = "石巨人";
        this.level = level;
        this.attack_power = 62 + 9 * level;
        this.max_health = 600 + 70 * level;
        temp_health = max_health;
        this.experience = 1;
    }

    @Override
    public String getintroduction(){
        return "#怪物属性# 石巨人(高级怪物，攻击力上等，血量上等) 等级:"+level+" 血量上限:"+ max_health+" 攻击力:"+attack_power+" 经验值:+"+experience;
    }

    @Override
    public Equipment dropEquipment() {
        Random random = new Random();
        //有2/3的几率爆装备
        int rnd = random.nextInt(3);
        if(rnd == 0 || rnd ==1){
            //四种装备爆率相同
            int rnd2 = random.nextInt(4);
            if(rnd2 == 0){
                return new Armor_2(level);
            }
            else if (rnd2 == 1){
                return new Robe_2(level);
            }
            else if(rnd2 == 2){
                return new Staff_2(level);
            }
            else{
                return new Sword_2(level);
            }
        }
        else return null;
    }
}
