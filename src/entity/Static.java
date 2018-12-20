package entity;

import core.Game;

public abstract class Static extends Entity{
	
	public Static(Game game, float x, float y) {
		super(game, x, y);
		super.setAttackable(false);
	}
}
