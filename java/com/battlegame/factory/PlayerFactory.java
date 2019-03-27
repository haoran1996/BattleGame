package com.battlegame.factory;

import com.battlegame.classes.Player;
import com.battlegame.player.Mage;
import com.battlegame.player.warrior;

public class PlayerFactory {

    public Player createPlayer(String name, String type) {
        Player player = null;
        if(type.equals("战士")){
            player = warrior.createwarrior(name);
        }else if(type.equals("法师")){
            player = Mage.createmage(name);
        }
        return player;
    }

}
