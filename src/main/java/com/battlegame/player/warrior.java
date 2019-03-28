package com.battlegame.player;

import com.battlegame.armor.Robe_0;
import com.battlegame.classes.*;
import com.battlegame.armor.Armor_0;
import com.battlegame.weapon.Staff_0;
import com.battlegame.weapon.Sword_0;

import java.util.Random;

public class warrior extends Player {

    /**
     * 使用静态变量来保存实例
     */
    private static warrior newplayer;
    /**
     * 私有化构造方法 作用：无法使用new关键字来创建SingletonPattern的实例。
     */
    private warrior(String name){
        super(name);
        this.type = "战士";
        this.armor = new Armor_0(0);
        this.weapon = new Sword_0(0);
        this.calculate_attack_power();
        this.calculate_defend_power();
    }
    /**
     * 以自己实例为返回值的静态的公有方法，静态工厂方法
     */
    public static warrior createwarrior(String name) {
        // 被动创建，在真正需要使用时才去创建
        if (newplayer == null) {
            newplayer = new warrior(name);
        }
        return newplayer;
    }


    @Override
    public void receiveEquipment(Equipment equipment) {
        String type = equipment.getType();
        if(type.equals("巨剑")){
            this.weapon = (Weapon)equipment;
            calculate_attack_power();
        }
        else if(type.equals("铠甲")){
            this.armor = (Armor) equipment;
            calculate_defend_power();
        }else if(type.equals("法杖")){
            System.out.println("可惜，战士无法装备法杖，你只能丢下装备，继续前进");
        }else if(type.equals("法袍")){
            System.out.println("可惜，战士无法装备法袍，你只能丢下装备，继续前进");
        }

    }
    public int calculate_attack_power(){
        this.basic_attack_power = 35 + 3 * level;
        this.attack_power = basic_attack_power + this.weapon.getAttack_power();
        return attack_power;
    }
    //计算血量上限
    public int calculate_max_health(){
        this.max_health = 50 * this.level + 300;
        return max_health;
    }
    @Override
    //战士攻击时有50%几率普通攻击，20%的几率释放暴击技能，造成150%伤害，
    // 有10的几率释放技能二，造成200%伤害，有10%几率放出技能三，造成250%伤害，有10%的几率miss。
    public void makeAttack(Role role) throws InterruptedException {
//        System.out.print(this.name + "向" + role.getName() + "发动攻击，");
//        Thread.sleep(500);
        calculate_attack_power();
        Random random = new Random();
        int rnd = random.nextInt(10);
        switch (rnd){
            case 0: case 1: case 2: case 3:{
                System.out.print("["+this.name+"]" + "对" + "["+role.getName()+"]" + "使出普通攻击，");
                role.getAttack(attack_power);
                break;
            }
            case 4: case 5: case 6:{
                System.out.print("["+this.name+"]"+ "一跃而起，对" + "["+role.getName()+"]" + "使出崩山击，");
                role.getAttack((int) (attack_power * 1.5));
                break;
            }
            case 7: {
                System.out.print("["+this.name+"]"+ "巨剑一轮，对" + "["+role.getName()+"]" + "使出横扫千军，");
                role.getAttack((int) (attack_power * 2));
                break;
            }
            case 8: {
                System.out.print("["+this.name+"]" + "手中武器爆发出强烈的光芒，使出了剑荡八荒！");
                role.getAttack((int) (attack_power * 2.5));
                break;
            }
            case 9:{
                System.out.println("["+this.name+"]" + "冲锋时被石头绊了一跤，攻击miss了，受到了"+"["+role.getName()+"]"+"的嘲笑");
//                role.getAttack(0);
                break;
            }
            default:{
                System.out.println("你和怪物坐下来聊天");
                break;
            }
        }
    }
}
