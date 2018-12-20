package Tile;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

public abstract class Tile {
	
	public static Tile[] tileList = new Tile[200];
	public static Tile grassTile = new GrassTile();
	public static Tile wallTile = new WallTile();

	protected BufferedImage texture;
	protected int id;

	public Tile(BufferedImage texture, int id) {
		this.texture = texture;
		this.id = id;
		
		tileList[id] = this;
	}
	
	public void render(Graphics g, int x, int y) {
		g.drawImage(texture, x, y, null);
	}

	public BufferedImage getTexture() {
		return texture;
	}

	public void setTexture(BufferedImage texture) {
		this.texture = texture;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

}
