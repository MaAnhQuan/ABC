package entity;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

public class EntityManager {

	private List<Entity> entityList;
	
	public EntityManager() {
		entityList = new ArrayList<Entity>();
	}
	
	public void update() {
		for(Entity e: entityList) {
			e.update();
		}
	}
	
	public void render(Graphics g) {
		for(Entity e: entityList) {
			e.render(g);
		}
	}
	
	public void addEntity(Entity e) {
		entityList.add(e);
	}
	
	public void rmvEntity(Entity e) {
		entityList.remove(e);
	}
	
	public Entity getByPosition(int x, int y) {
		for(Entity e: entityList) {
			if(e.getX() == x && e.getY() == y) {
				return e;
			}
		}
		return null;
	}
}
