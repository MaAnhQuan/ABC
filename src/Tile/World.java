package Tile;

import java.awt.Graphics;
import java.util.List;

public class World {

	public List<Tile> world;
	
	public World() {
		
	}
	
	public void update() {
		
	}
	
	
	public void render(Graphics g) {
		for(Tile e: world) {
			e.render(g);
		}
	}
}
