package com.battlegame.monster;

import com.battlegame.classes.Equipment;
import com.battlegame.classes.Monster;

public class Attack_enhance extends Enhance{
    private Monster monster;

    public Attack_enhance(Monster monster){
        this.monster = monster;
    }

    @Override
    public String getintroduction(){
        monster.setAttack_power(monster.getAttack_power() + 10);
        return "[攻击强化]"+monster.getintroduction();
    }

    @Override
    public Equipment dropEquipment() {
        return monster.dropEquipment();
    }
}
