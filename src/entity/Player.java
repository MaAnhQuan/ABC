package entity;

import java.awt.Graphics;

import core.Game;
import gfx.Assets;

public class Player extends Creature {

	public Player(Game game, float x, float y) {
		super(game, x, y);
	}

	@Override
	public void update() {
		this.getInput();
		move();
		game.getCamera().focus(this);
	}
	
	public void getInput() {
		xMove = 0;
		yMove = 0;
		if(game.getKeyManager().up) {
			yMove = -speed;
		} else if (game.getKeyManager().down) {
			yMove = speed;
		} else if (game.getKeyManager().left) {
			xMove = -speed;
		} else if (game.getKeyManager().right) {
			xMove = speed;
		}
	}

	@Override
	public void render(Graphics g) {
		g.drawImage(Assets.player, (int) (x - game.getCamera().getxOff()), (int) (y - game.getCamera().getyOff()),
				null);
	}

}
