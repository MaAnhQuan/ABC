package gfx;

import core.Game;
import entity.Entity;

public class Camera {

	private float xOff, yOff;
	private Game game;

	public Camera(float xOff, float yOff, Game game) {
		this.xOff = xOff;
		this.yOff = yOff;
		this.game = game;	
	}
	
	public void move(float xAmt, float yAmt) {
		xOff += xAmt;
		yOff += yAmt;
	}
	
	public void focus(Entity e) {
		xOff = e.getX() - game.getWidth()/2;
		yOff = e.getY() - game.getHeight()/2;
		this.checkBlank();
	}
	
	public void checkBlank() {
		if(xOff < 0) {
			xOff = 0;
		} else if(xOff > game.getWorld().width * 32 - game.getWidth()) {
			xOff = game.getWorld().width * 32 - game.getWidth();
		}
		
		if(yOff < 0) {
			yOff = 0;
		} else if(yOff > game.getWorld().height * 32 - game.getHeight()) {
			yOff = game.getWorld().height * 32 - game.getHeight();
		}
	}
	
	public float getxOff() {
		return xOff;
	}

	public void setxOff(float xOff) {
		this.xOff = xOff;
	}

	public float getyOff() {
		return yOff;
	}

	public void setyOff(float yOff) {
		this.yOff = yOff;
	}
	
	
}
