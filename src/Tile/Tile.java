package Tile;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import entity.Entity;
import entity.EntityManager;

public abstract class Tile {
	
	public static Tile[] tileList = new Tile[200];
	public static Tile grassTile = new GrassTile(0, 0);

	protected BufferedImage texture;
	protected int x, y, id;
	protected boolean accessible;

	public Tile(BufferedImage texture, int x, int y, int id) {
		this.texture = texture;
		this.id = id;
		this.x = x;
		this.y = y;
		
		tileList[id] = this;
	}
	
	public Entity contain(EntityManager e) {
		return e.getByPosition(this.x, this.y);
	}
	
	public void render(Graphics g) {
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

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public boolean isAccessible() {
		return accessible;
	}

	public void setAccessible(boolean accessible) {
		this.accessible = accessible;
	}
	
}
