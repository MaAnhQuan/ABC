package entity;

import java.awt.Graphics;

import gfx.Assets;

public class Wall extends Static {

	public Wall(int x, int y) {
		super(x, y);
	}

	public void update() {
		
	}

	@Override
	public void render(Graphics g) {
		g.drawImage(Assets.wall, x, y, null);
	}
}
