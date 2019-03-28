package com.battlegame;

import com.battlegame.classes.Monster;
import com.battlegame.classes.Player;

import java.util.Random;

public class Battle {
    Player player;
    Monster monster;

    public Battle(Player player, Monster monster) {
        this.player = player;
        this.monster = monster;
    }

    public void beginBattle() throws InterruptedException {
        player.refreashAttributes();
        System.out.println();
        System.out.println("##################战斗开始##################");
        Thread.sleep(500);
        while(player.getTemp_health()>0 && monster.getTemp_health()>0){
            player.makeAttack(monster);
            if(monster.getTemp_health()>0){
                monster.makeAttack(player);
            }
        }
       if(player.getTemp_health()==0){
            player.battle_lose();
       }else{
            player.battle_win(monster);
       }
    }



}
