package entity;

import java.awt.Graphics;

public abstract class Entity {

	protected int x, y, hp;
	
	protected boolean attackable;
	protected boolean moveable;
	
	public boolean isAttackable() {
		return attackable;
	}

	public void setAttackable(boolean attackable) {
		this.attackable = attackable;
	}

	public boolean isMoveable() {
		return moveable;
	}

	public void setMoveable(boolean moveable) {
		this.moveable = moveable;
	}

	Entity(int x, int y, int hp){
		this.x = x;
		this.y = y;
		this.hp = hp;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getHp() {
		return hp;
	}

	public void setHp(int hp) {
		this.hp = hp;
	}
	
	public abstract void update();
	
	public abstract void render(Graphics g);
}
