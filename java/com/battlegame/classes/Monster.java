/**
 * @author:RickeyJiang
 * @date:2019??3??4??
 */
package com.battlegame.classes;

import java.util.Random;

public abstract class Monster extends Role{
	protected int experience;

	
	public Monster() {
		super();
		this.type = "怪物";
	}

	@Override
	public String getintroduction(){
		return " 等级:"+level+" 血量上限:"+ max_health+" 攻击力:"+attack_power+" 经验值:+"+experience;
	}

	//爆装备
	public abstract Equipment dropEquipment();

//	//初始化属性
//	public abstract void initmonster();

	//发动攻击
	public void makeAttack(Role role) throws InterruptedException {
		Random random = new Random();
		int rnd = random.nextInt(10);
		switch (rnd){
			case 0: case 1:{
				System.out.print("["+this.name+"]"+ "向" + "["+role.getName()+"]"  + "发动攻击，触发了暴击！");
				if((int)(this.attack_power * 1.5) <= role.defend_power){
					System.out.println("由于" + "["+role.getName()+"]" + "的防御力太高，" + "["+this.name+"]" + " 无法破防，造成0点伤害！");
					role.getAttack(1);
				}
				else{
					role.getAttack((int)(this.attack_power * 1.5) - role.getDefend_power());
				}
				break;
			}
			case 2:{
				System.out.println("["+this.name+"]" + "向" + "["+role.getName()+"]" + "发动普通攻击，但"+ "["+role.getName()+"]"+"灵活地躲避开了，攻击miss！");
				break;
			}
			default:{
				System.out.print("["+this.name+"]"+ "向" + "["+role.getName()+"]" + "发动攻击，");
				if(this.attack_power <= role.defend_power){
					System.out.println("由于" + "["+role.getName()+"]" + "的防御力太高，" + "["+this.name+"]" + " 无法破防，造成0点伤害！");
				}
				else{
					role.getAttack(this.attack_power - role.getDefend_power());
				}
				break;
			}
		}
	}

	//收到攻击
	public boolean getAttack(int damage) throws InterruptedException {
		boolean isdead = false;
		if(this.temp_health <= damage){
			this.temp_health = 0;
			System.out.println("造成了" + damage + "点伤害，"+"["+this.name+"]"+"剩余血量("+temp_health+"/"+max_health+")，"+name+"死亡。");
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

	public int getExperience() {
		return experience;
	}
}
