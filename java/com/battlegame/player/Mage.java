package com.battlegame.player;

import com.battlegame.armor.Robe_0;
import com.battlegame.classes.*;
import com.battlegame.weapon.Staff_0;


import java.util.Random;

public class Mage extends Player {
    /**
     * 使用静态变量来保存实例
     */
    private static Mage newplayer;
    /**
     * 私有化构造方法 作用：无法使用new关键字来创建SingletonPattern的实例。
     */
    private Mage(String name){
        super(name);
        this.type = "法师";
        this.armor = new Robe_0(0);
        this.weapon = new Staff_0(0);
        this.calculate_attack_power();
        this.calculate_defend_power();
    }
    /**
     * 以自己实例为返回值的静态的公有方法，静态工厂方法
     */
    public static Mage createmage(String name) {
        // 被动创建，在真正需要使用时才去创建
        if (newplayer == null) {
            newplayer = new Mage(name);
        }
        return newplayer;
    }


    @Override
    public void receiveEquipment(Equipment equipment) {
        String type = equipment.getType();
        if(type.equals("法杖")){
            this.weapon = (Weapon)equipment;
            calculate_attack_power();
        }
        else if(type.equals("法袍")){
            this.armor = (Armor) equipment;
            calculate_defend_power();
        }else if(type.equals("巨剑")){
            System.out.println("可惜，法师无法装备刀剑，你只能丢下装备，继续前进");
        }else if(type.equals("铠甲")){
            System.out.println("可惜，法师无法装备铠甲，你只能丢下装备，继续前进");
        }
    }

    public int calculate_attack_power(){
        this.basic_attack_power = 25 + 3 * level;
        this.attack_power = basic_attack_power + this.weapon.getAttack_power();
        return attack_power;
    }
    //计算血量上限
    public int calculate_max_health(){
        this.max_health = 40 * this.level + 200;
        return max_health;
    }
    @Override
    //法师攻击时有40%的几率释放技能一，造成150%伤害，有20%的几率释放技能二，造成200%的伤害，
    //有10%的几率释放技能三，造成250%的伤害，有10%的几率miss。
    public void makeAttack(Role role) throws InterruptedException {
//        System.out.print(this.name + "向" + role.getName() + "发动攻击，");
//        Thread.sleep(500);
        calculate_attack_power();
        Random random = new Random();
        int rnd = random.nextInt(10);
        switch (rnd){
            case 0: case 1:{
                System.out.print("["+this.name+"]"+ "用法杖敲打" + "["+role.getName()+"]" + "，");
                role.getAttack(attack_power);
                break;
            }
            case 2: case 3: case 4: case 5:{
                System.out.print("["+this.name+"]" + "对" + "["+role.getName()+"]" + "使出小火球，");
                role.getAttack((int) (attack_power * 1.5));
                break;
            }
            case 6: case 7: {
                System.out.print("["+this.name+"]"+ "法杖一热，对" + "["+role.getName()+"]" + "使出火龙术，");
                role.getAttack(attack_power * 2);
                break;
            }
            case 8: {
                System.out.print("["+this.name+"]" + "吟唱咒语，爆发出最强技能——火神之怒！");
                role.getAttack((int) (attack_power * 2.5));
                break;
            }
            case 9:{
                System.out.println("["+this.name+"]"+ "挥舞法杖，然而什么也没有发生，攻击miss了，受到了"+"["+role.getName()+"]"+"的嘲笑");
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
