package entity;

import java.awt.Graphics;

import core.Game;

public abstract class Entity {

	protected float x, y;
	protected Game game;
	
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

	public Entity(Game game, float x, float y){
		this.x = x;
		this.y = y;
		this.game = game;
	}
	
	public float getX() {
		return x;
	}

	public void setX(float x) {
		this.x = x;
	}

	public float getY() {
		return y;
	}

	public void setY(float y) {
		this.y = y;
	}

	public abstract void update();
	
	public abstract void render(Graphics g);
}
