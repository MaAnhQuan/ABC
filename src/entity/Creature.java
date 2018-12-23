package entity;

import core.Game;

public abstract class Creature extends Entity {

	protected float speed;
	protected float xMove, yMove;
	
	public Creature(Game game, float x, float y) {
		super(game, x, y);
		speed = 2.0f;
		xMove = 0;
		yMove = 0;
	}
	
	public void moveX() {
		if(xMove > 0) {
			int tx = (int) (x + xMove + bounds.x + bounds.width) / 32;
			if(!collisionWithTile(tx, (int) (y + bounds.y)/32) && !collisionWithTile(tx, (int) (y + bounds.y + bounds.height)/32)) {
				x += xMove;
			} else {
				x = tx * 32 - bounds.x - bounds.width - 1;
			}
		} else if(xMove < 0) {
			int tx = (int) (x + xMove + bounds.x) / 32;
			if(!collisionWithTile(tx, (int) (y + bounds.y)/32) && !collisionWithTile(tx, (int) (y + bounds.y + bounds.height)/32)) {
				x += xMove;
			} else {
				x = tx * 32 + 32 - bounds.x;
			}
		}
	}
	
	public void moveY() {
		if(yMove > 0) {
			int ty = (int) (y + yMove + bounds.y + bounds.height) / 32;
			if(!collisionWithTile((int) (x + bounds.x)/32, ty) && !collisionWithTile((int) (x + bounds.x + bounds.width)/32, ty)) {
				y += yMove;
			} else {
				y = ty * 32 - bounds.y - bounds.height - 1;
			}
		} else if(yMove < 0) {
			int ty = (int) (y + yMove + bounds.y) / 32;
			if(!collisionWithTile((int) (x + bounds.x)/32, ty) && !collisionWithTile((int) (x + bounds.x + bounds.width)/32, ty)) {
				y += yMove;
			} else {
				y = ty * 32 + 32 - bounds.y;
			}
		}
	}

	public void move() {
		moveX();
		moveY();
	}
	
	protected boolean collisionWithTile(int x, int y) {
		return game.getWorld().getTile(x, y).isSolid();
	}
	
	public float getSpeed() {
		return speed;
	}

	public void setSpeed(float speed) {
		this.speed = speed;
	}

	
}
