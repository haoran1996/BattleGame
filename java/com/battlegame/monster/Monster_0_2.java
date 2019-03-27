package com.battlegame.monster;

import com.battlegame.classes.Equipment;
import com.battlegame.classes.Monster;
import com.battlegame.armor.Armor_0;
import com.battlegame.armor.Robe_0;
import com.battlegame.weapon.Staff_0;
import com.battlegame.weapon.Sword_0;

import java.util.Random;

public class Monster_0_2 extends Monster {
    public Monster_0_2(int level){
        super();
        this.name = "哥布林首领";
        this.level = level;
        this.attack_power = 57 + 7 * level;
        this.max_health = 450 + 60 * level;
        temp_health = max_health;
        this.experience = 2;
    }


    @Override
    public String getintroduction(){
        return "#怪物属性# 哥布林首领(精英怪物，实力强大，100%爆出装备) 等级:"+level+" 血量上限:"+ max_health+" 攻击力:"+attack_power+" 经验值:+"+experience;
    }

    @Override
    public Equipment dropEquipment() {
        Random random = new Random();
        //有100%的几率爆装备
        if(true){
            //四种装备爆率相同
            int rnd2 = random.nextInt(4);
            if(rnd2 == 0){
                return new Armor_0(level);
            }
            else if (rnd2 == 1){
                return new Robe_0(level);
            }
            else if(rnd2 == 2){
                return new Staff_0(level);
            }
            else{
                return new Sword_0(level);
            }
        }
        else return null;
    }
}
