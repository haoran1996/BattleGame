package com.battlegame;


import com.battlegame.classes.Player;
import com.battlegame.factory.PlayerFactory;

import static com.battlegame.Game.GameInit;
import static com.battlegame.Game.startGame;

public class Main {
    public static void main(String args[]) throws InterruptedException {
        //重定向
//        reDirect rd=new reDirect();
//        PlayerFactory playerFactory = new PlayerFactory();
//        Player newplayer = playerFactory.createPlayer("铠甲勇士","战士");
        Player newplayer = GameInit();
        startGame(newplayer);
    }


}
