package Tile;

import java.awt.Graphics;

import core.Game;
import entity.EntityManager;
import entity.Guard;
import entity.Player;
import utils.Util;

public class World {

	public int[][] tiles;
	public int width, height;
	public EntityManager entityManager;
	public Game game;

	public World(Game game, EntityManager entityManager) {
		this.game = game;
		this.entityManager = entityManager;
		loadWorld("textures/world/w1.txt");
	}

	public void update() {

	}

	public void render(Graphics g) {
		int xStart = (int) Math.max(0, game.getCamera().getxOff()/32);
		int yStart = (int) Math.max(0, game.getCamera().getyOff()/32);
		int xEnd = (int) Math.min(width, (game.getCamera().getxOff() + game.getWidth())/32 + 1);
		int yEnd = (int) Math.min(height, (game.getCamera().getyOff() + game.getHeight())/32 + 1);
		
		for (int y = yStart; y < yEnd; y++) {
			for (int x = xStart; x < xEnd; x++) {
				getTile(x, y).render(g, (int) (x * 32 - game.getCamera().getxOff()),
						(int) (y * 32 - game.getCamera().getyOff()));
			}
		}
	}

	public Tile getTile(int x, int y) {
		Tile t = Tile.tileList[tiles[x][y]];
		if (t == null)
			return Tile.grassTile;
		return t;
	}

	private void loadWorld(String path) {
		String file = Util.loadFileAsString(path);
		String[] tokens = file.split("\\s+");
		width = Util.parseInt(tokens[0]);
		height = Util.parseInt(tokens[1]);

		tiles = new int[width][height];
		for (int y = 0; y < height; y++) {
			for (int x = 0; x < width; x++) {
				tiles[x][y] = Util.parseInt(tokens[(x + y * width) + 2]);
			}
		}
		int pXSpawn = Util.parseInt(tokens[width * height + 2]);
		int pYSpawn = Util.parseInt(tokens[width * height + 3]);
		Player player = new Player(this.game, pXSpawn, pYSpawn);
		this.entityManager.addEntity(player);
		
		int eCount = Util.parseInt(tokens[width * height + 4]);
		for(int i = 0; i < eCount; i++) {
			int xS = Util.parseInt(tokens[width * height + 5 + i*2]);
			int yS = Util.parseInt(tokens[width * height + 6 + i*2]);
			Guard guard = new Guard(this.game, xS, yS);
			this.entityManager.addEntity(guard);
		}
	}
}
