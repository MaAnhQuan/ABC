package entity;

import java.awt.Graphics;
import java.awt.Rectangle;

import core.Game;

public abstract class Entity {

	protected float x, y;
	protected Game game;
	protected Rectangle bounds;
	
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
		
		bounds = new Rectangle(5, 5, 22, 22);
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
