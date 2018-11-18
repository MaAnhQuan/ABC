package Tile;

import gfx.Assets;

public class GrassTile extends Tile {

	public GrassTile(int x, int y) {
		super(Assets.grass, x, y, 1);
		this.setAccessible(true);
	}
}
