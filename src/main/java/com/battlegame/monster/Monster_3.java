package com.battlegame.monster;

import com.battlegame.classes.Equipment;
import com.battlegame.classes.Monster;

public class Monster_3 extends Monster {
    public Monster_3(int level){
        super();
        this.name = "天之驱逐者";
        this.level = level;
        this.attack_power = 4000 * level;
        this.max_health = 450 * level;
        temp_health = max_health;
        this.experience = 3;
    }

    @Override
    public String getintroduction(){
        return "#怪物属性# 天之驱逐者(最终Boss，天空之城的守卫者) 等级:"+level+" 血量上限:"+ max_health+" 攻击力:"+attack_power+" 经验值:+"+experience;
    }

    @Override
    public Equipment dropEquipment() {
        return null;
    }
}
