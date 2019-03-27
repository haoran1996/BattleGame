package com.battlegame.classes;

public abstract class Player extends Role{
    protected int basic_attack_power;
    protected int defend_power;
    protected Weapon weapon;
    protected Armor armor;
//    protected int experience;

    public Player(String name) {
        super();
        this.name = name;
        this.type = "玩家";
        this.max_health = 300;
        this.level = 1;
//        this.experience = 10;
    }

    //刷新人物属性
    public void refreashAttributes(){
        this.calculate_attack_power();
        this.calculate_defend_power();
        this.calculate_max_health();
        this.temp_health = this.max_health;
    }
    //获取人物属性
    public void getAttributes(){
        refreashAttributes();
        System.out.println();
        System.out.println("******************人物属性******************");
        System.out.println("姓名:"+name+"  职业:"+type+"  等级:"+level+"  血量上限:"+max_health+"  攻击力:"
                +attack_power+"("+basic_attack_power+"+"+weapon.getAttack_power()+")"+"  防御力:"+defend_power);
        System.out.println("武器:"+weapon.getintroduction()+"  防具:"+armor.getintroduction());
//        System.out.println("********************************************");
        System.out.println();
    }
//    //计算等级
//    public void calculateLevel(){
//        //0到10级每级需要10点经验，10到15级每级需要15点经验，15到20级20点，20到25级25点，25到30级30点
//        if(experience<)
//    }
    //计算总攻击力
    public abstract int calculate_attack_power();
    //计算防御力
    public int calculate_defend_power(){
        this.defend_power = armor.defend_power;
        return defend_power;
    }
    //计算血量上限
    public abstract int calculate_max_health();

    //发动攻击，各职业重新写
    @Override
    public void makeAttack(Role role) throws InterruptedException {
        System.out.print("["+this.name+"]"+ "向" + "["+role.getName()+"]" + "发动攻击，");
//        Thread.sleep(500);
        calculate_attack_power();
        role.getAttack(this.attack_power);
    }

    //收到攻击
    public boolean getAttack(int damage) throws InterruptedException {
        boolean isdead = false;
        if(this.temp_health <= damage){
            this.temp_health = 0;
            System.out.println("造成了" + damage + "点伤害，"+"["+this.name+"]"+"剩余血量("+temp_health+"/"+max_health+")，你输了。");
            Thread.sleep(500);
            isdead = true;
        }
        else{
            this.temp_health = this.temp_health - damage;
            System.out.println("造成了" + damage + "点伤害，"+"["+this.name+"]"+"剩余血量("+temp_health+"/"+max_health+")");
            Thread.sleep(500);
        }
        return isdead;
    }
    //战斗获胜
    public void battle_win(Monster monster) throws InterruptedException {
        int templevel = level + monster.getExperience();
        {
            if(templevel < 30){
                setLevel(level+monster.getExperience());
                System.out.println("你杀死了" + monster.getName()+"，随着一道金光，你的等级提升了"+monster.getExperience()+"级，你开始搜刮战利品");
            }else if(templevel == 30 || templevel == 31 || templevel == 32){
                setLevel(30);
                System.out.println("你杀死了" + monster.getName()+"，随着一道金光，你升到了满级30级，你开始搜刮战利品");
            }else if(templevel == 33){
                System.out.println("恭喜你，成功击杀了Boss天之驱逐者，通关了本游戏！");
            }
        }

        Thread.sleep(500);
        Equipment equipment = monster.dropEquipment();
        if(equipment == null){
            System.out.println("可惜,并没有任何收获，你只能继续前进");
            Thread.sleep(500);
        }
        else{
            System.out.println("恭喜，您获得了"+equipment.getintroduction());
            receiveEquipment(equipment);
            Thread.sleep(500);
        }
    }
    //战斗失败
    public void battle_lose() throws InterruptedException {
        Thread.sleep(500);
        if(level == 0){
            level = -1;
            System.out.println("你的等级小于0，你倒下时还期待着会有人能够再救你一次，但是这次没有那么幸运，安息吧。");
        }
        else{
            this.level = this.level - 1;
            System.out.println("["+this.name+"]"+"不甘的倒下，眼看着就将命丧于此，一名路过的勇士突然出现，把你救了下来，但你的等级减1。");
        }
    }
    //获得装备
    public abstract void receiveEquipment(Equipment equipment);

    public int getBasic_attack_power() {
        return basic_attack_power;
    }

    public void setBasic_attack_power(int basic_attack_power) {
        this.basic_attack_power = basic_attack_power;
    }

    public int getDefend_power() {
        return defend_power;
    }

    public void setDefend_power(int defend_power) {
        this.defend_power = defend_power;
    }

    public Weapon getWeapon() {
        return weapon;
    }

    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }

    public Armor getArmor() {
        return armor;
    }

    public void setArmor(Armor armor) {
        this.armor = armor;
    }
}
