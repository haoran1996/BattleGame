/**
 * @author:RickeyJiang
 * @date:2019年3月4日
 */
package com.battlegame.classes;

public abstract class Weapon extends Equipment{


	public Weapon() {
		super();
		this.type = "武器";
	}

	@Override
	public String getintroduction(){
		return "武器介绍";
	}

	public int getAttack_power() {
		return attack_power;
	}

	public abstract int calculate_weapon_attack(int level);

	public void setAttack_power(int attack_power) {
		this.attack_power = attack_power;
	}



}
