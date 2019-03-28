package com.battlegame.factory;

import com.battlegame.classes.Monster;
import com.battlegame.monster.*;
import java.util.Random;

public class MonsterFactory implements AbsMonsterFactory {

    @Override
    public Monster createMonster(int level) {
        Monster monster = null;
        if(level>=0 && level<10){
            //三分之二几率遇到普通怪，三分之一几率遇到精英怪
            Random random = new Random();
            int rnd = random.nextInt(3);
            if(rnd == 0 || rnd == 1){
                monster = new Monster_0_1(level);
            }else{
                monster = new Monster_0_2(level);
            }
        }else if(level>=10 && level<20){
            //三分之二几率遇到普通怪，三分之一几率遇到精英怪
            Random random = new Random();
            int rnd = random.nextInt(3);
            if(rnd == 0 || rnd == 1){
                monster = new Monster_1_1(level);
            }else{
                monster = new Monster_1_2(level);
            }
        }else if(level>=20 && level<30){
            //三分之二几率遇到普通怪，三分之一几率遇到精英怪
            Random random = new Random();
            int rnd = random.nextInt(3);
            if(rnd == 0 || rnd == 1){
                monster = new Monster_2_1(level);
            }else{
                monster = new Monster_2_2(level);
            }
        }else if(level == 30){
            //三分之二几率遇到普通怪，三分之一几率遇到精英怪
            Random random = new Random();
            int rnd = random.nextInt(3);
            if(rnd == 0 ){
                monster = new Monster_2_1(level);
            }else if(rnd == 1){
                monster = new Monster_2_2(level);
            }else{
                monster = new Monster_3(35);
            }
        }

        return monster;
    }
}
