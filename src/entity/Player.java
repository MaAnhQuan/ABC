package entity;

import java.awt.Graphics;

import core.Game;
import gfx.Assets;

public class Player extends Creature {

	public Player(Game game, float x, float y) {
		super(game, x, y);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void update() {
		if(game.getKeyManager().up) {
			y -= 1;
		} else if (game.getKeyManager().down) {
			y += 1;
		} else if (game.getKeyManager().left) {
			x -= 1;
		} else if (game.getKeyManager().right) {
			x += 1;
		}
		game.getCamera().focus(this);
	}

	@Override
	public void render(Graphics g) {
		g.drawImage(Assets.player, (int) (x - game.getCamera().getxOff()), (int) (y - game.getCamera().getyOff()),
				null);
	}

}
