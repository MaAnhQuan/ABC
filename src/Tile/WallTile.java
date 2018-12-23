package Tile;

import gfx.Assets;

public class WallTile extends Tile{

	public WallTile() {
		super(Assets.wall, 2);
	}
	
	public boolean isSolid() {
		return true; 
	}
}
