package com.battlegame.monster;

import com.battlegame.classes.Equipment;
import com.battlegame.classes.Monster;

public class Blood_enhance extends Enhance {
    private Monster monster;

    public Blood_enhance(Monster monster){
        this.monster = monster;
    }

    @Override
    public String getintroduction(){
        monster.setMax_health(monster.getMax_health() + 100);
        return "[血量强化]"+monster.getintroduction();
    }

    @Override
    public Equipment dropEquipment() {
        return monster.dropEquipment();
    }
}
