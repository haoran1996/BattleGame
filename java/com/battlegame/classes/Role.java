/**
 * @author:RickeyJiang
 * @date:2019年3月4日
 */
package com.battlegame.classes;

public abstract class Role {
	protected String name;
	protected String type;
	protected int level;
	protected int attack_power;
	protected int defend_power;
	protected int max_health;
	protected int temp_health;



	public Role() {
		this.type = "角色";
	}

	public String getintroduction(){
		return "角色介绍";
	}

	//发动攻击
	public abstract void makeAttack(Role role) throws InterruptedException;

	//受到攻击
	public abstract boolean getAttack(int damage) throws InterruptedException;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public int getAttack_power() {
		return attack_power;
	}

	public void setAttack_power(int attack_power) {
		this.attack_power = attack_power;
	}


	public int getMax_health() {
		return max_health;
	}

	public void setMax_health(int max_health) {
		this.max_health = max_health;
	}

	public int getTemp_health() {
		return temp_health;
	}

	public void setTemp_health(int temp_health) {
		this.temp_health = temp_health;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getDefend_power() {
		return defend_power;
	}

	public void setDefend_power(int defend_power) {
		this.defend_power = defend_power;
	}
}
