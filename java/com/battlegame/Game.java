package com.battlegame;

import com.battlegame.classes.Monster;
import com.battlegame.classes.Player;
import com.battlegame.factory.MonsterFactory;
import com.battlegame.factory.PlayerFactory;

import java.util.Random;
import java.util.Scanner;

public class Game {
    static boolean gameend = false;
    //创建玩家
    public static Player GameInit() throws InterruptedException {
        Scanner sc = new Scanner(System.in);
        System.out.println("[游戏名称：天空之城与勇士 制作者：巫浩然]");
        Thread.sleep(500);
        System.out.println("欢迎来到[天空之城与勇士]，在该游戏中，你将扮演一个勇士，体验打怪升级爆装备的快感！");
        Thread.sleep(500);
        System.out.println("本游戏的初始等级为1级，满级是30级，获胜条件是前往天空之城杀死最终BOSS天之驱逐者。");
        Thread.sleep(500);
        System.out.println("请注意，战斗失败等级会掉1，等级为0时再掉级角色死亡，所以在进行战斗前请慎重选择。");
        Thread.sleep(500);
        System.out.print("请选择你的职业（战士/法师）：");
        String player_type = sc.nextLine();
        while(!player_type.equals("战士")&&!player_type.equals("法师")){
            System.out.print("请输入正确职业（战士/法师）：");
            player_type = sc.nextLine();
        }
        Thread.sleep(500);
        System.out.print("请为你的人物取一个名字：");
        String player_name = sc.nextLine();
        while(player_name.length() > 8){
            System.out.print("名字长度太长了，请取一个短于8个字符的名字：");
            player_name = sc.nextLine();
        }
        //创建人物
        PlayerFactory playerFactory = new PlayerFactory();
        Player newplayer = playerFactory.createPlayer(player_name,player_type);
        Thread.sleep(500);
        System.out.print("人物创建成功，游戏开始。勇士，祝你好运！");
//        newplayer.getAttributes();
        return newplayer;
    }
    //开始游戏
    public static void startGame(Player player) throws InterruptedException {
        while (player.getLevel() >= 0 && player.getLevel() <= 30) {
            battlewithmonster(player);
        }
        if(player.getLevel() == -1){
            System.out.println("生的伟大，死的光荣！");
        }else if(player.getLevel() == 33){
            System.out.println("阿拉德的旅程还未结束，更多的挑战在等着你，敬请期待！");
        }

    }
    //遭遇怪物
    public static void battlewithmonster(Player player) throws InterruptedException {
        Monster monster = meetMonster(player);
        System.out.print("是否要与之战斗? 请输入(是/否):");
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        while(!str.equals("是")&&!str.equals("否")){
            System.out.print("请输入（是/否）：");
            str = sc.nextLine();
        }
        if(str.equals("是")){
            Battle battle = new Battle(player,monster);
            battle.beginBattle();
        }else if (str.equals("否")){
            battlewithmonster(player);
        }
    }

    //随机刷新怪物
    public static Monster meetMonster(Player player) throws InterruptedException {
        Thread.sleep(500);
        player.getAttributes();
        Thread.sleep(500);
        MonsterFactory monsterFactory = new MonsterFactory();
        Monster monster = monsterFactory.createMonster(player.getLevel());
        System.out.println(player.getName()+"一路披荆斩棘。忽然，他发现前方有怪物的身影，仔细一看，是"+monster.getName());
        Thread.sleep(500);
        System.out.println(monster.getintroduction());
        Thread.sleep(500);
        return monster;
    }

//    //游戏结束
//    public static void endGame(Player player){
//        System.out.println(player.getName()+"壮烈牺牲，游戏结束！");
//    }
}
