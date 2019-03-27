package com.battlegame.monster;


import com.battlegame.armor.Armor_1;
import com.battlegame.armor.Robe_1;
import com.battlegame.classes.Equipment;
import com.battlegame.classes.Monster;
import com.battlegame.weapon.Staff_1;
import com.battlegame.weapon.Sword_1;

import java.util.Random;

public class Monster_1_1 extends Monster {
    public Monster_1_1(int level){
        super();
        this.name = "牛头怪";
        this.level = level;
        this.attack_power = 60 + 7 * level;
        this.max_health = 550 + 70 * level;
        temp_health = max_health;
        this.experience = 1;
    }

    @Override
    public String getintroduction(){
        return "#怪物属性# 牛头怪(中级怪物，攻击力中等，血量上等) 等级:"+level+" 血量上限:"+ max_health+" 攻击力:"+attack_power+" 经验值:+"+experience;
    }

    @Override
    public Equipment dropEquipment() {
        Random random = new Random();
        //有2/3的几率爆装备
        int rnd = random.nextInt(3);
        if(rnd == 0|| rnd ==1){
            //四种装备爆率相同
            int rnd2 = random.nextInt(4);
            if(rnd2 == 0){
                return new Armor_1(level);
            }
            else if (rnd2 == 1){
                return new Robe_1(level);
            }
            else if(rnd2 == 2){
                return new Staff_1(level);
            }
            else{
                return new Sword_1(level);
            }
        }
        else return null;
    }

}
