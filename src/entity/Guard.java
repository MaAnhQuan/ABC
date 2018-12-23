package entity;

import java.awt.Graphics;
import java.awt.Point;
import java.util.HashMap;
import java.util.Map;

import core.Game;
import gfx.Assets;

public class Guard extends Creature {
	
	public int[] direct = new int[5];
	public int moving = 0;
	public int lastMove = 0;
	public Map<Point, int[]> map = new HashMap<Point, int[]>();

	public Guard(Game game, float x, float y) {
		super(game, x, y);
		for(int i = 0; i < 5; i++) {
			direct[i] = 0;
		}
		bounds.x = 0;
		bounds.y = 0;
		bounds.width = 31;
		bounds.height = 31;
	}

	@Override
	public void update() {
		this.getInput();
		move();
	}

	public void getInput() {
		if(x % 32 == 0 && y % 32 == 0) {
			checkDirect();
			getNumOfDir();
			getMove();
			System.out.println(this.checkAvail() + " " + direct[1] + " " + direct[2] + " " + direct[3] + " " + direct[4] + " " + moving);
		}
	}
	
	private void checkDirect() {
		for(int i = 0; i < 5; i++) {
			direct[i] = 0;
		}
		if(!this.game.getWorld().getTile((int) x/32 - 1, (int) y/32).isSolid()) {
			direct[2] = 1; 
		}
		if(!this.game.getWorld().getTile((int) x/32 + 1, (int) y/32).isSolid()) {
			direct[3] = 1; 
		}
		if(!this.collisionWithTile((int) (x + 16)/32, (int) (y - 16)/32)) {
			direct[1] = 1; 
		}
		if(!this.collisionWithTile((int) (x + 16)/32, (int) (y + 48)/32)) {
			direct[4] = 1; 
		}
	}
	
	private void getNumOfDir() {
		if(this.checkAvail() == 1)
			this.oneDirect();
		else if(this.checkAvail() == 2)
			this.twoDirect();
		else if(this.checkAvail() > 2){
			this.moreDirect();
		}
	}
	
	private void getMove() {
		if(moving == 1)
			yMove = - speed;
		else if(moving == 4)
			yMove = speed;
		else if(moving == 2)
			xMove = - speed;
		else if(moving == 3)
			xMove = speed;
	}
	
	private void oneDirect() {
		if(moving == 0) {
			for(int i = 1; i < 5; i++) {
				if(direct[i] == 1) {
					moving = i;
					break;
				}
			}
		} else {
			lastMove = moving;
			moving = 5 - moving;
		}
	}
	
	private void twoDirect() {
		if(moving == 0) {
			for(int i = 1; i < 5; i++) {
				if(direct[i] == 1) {
					moving = i;
					break;
				}
			}
		} else {
			if(direct[moving] == 1) {
				return;
			} else {
				lastMove = moving;
				for(int i = 1; i < 5; i++) {
					if(direct[i] == 1 && i != lastMove) {
						moving = i;
						break;
					}
				}
			}
		}
	}
	
	private void moreDirect() {
		if(moving == 0) {
			Point curr = new Point((int) x, (int) y);
			int[] currP = new int[6];
			currP[0] = checkAvail();
			currP[5] = 0;
			for(int i = 1; i < 5; i++) {
				currP[i] = 0;
			}
			for(int i = 1; i < 5; i++) {
				if(direct[i] == 1) {
					moving = i;
					currP[i] = 1;
					break;
				}
			}
			map.put(curr, currP);
		} else {
			if(checkPoint(x, y)) {
				int[] currP = map.get(new Point((int) x, (int) y));
				if(currP[1] + currP[2] + currP[3] + currP[4] == currP[0]) {
					if(currP[5] == 0) {
						currP[5] = 5 - moving;
						for(int i = 1; i < 5; i++) {
							currP[i] = 0;
						}
						currP[5 - moving] = 1;
						for(int i = 1; i < 5; i++) {
							if(direct[i] == 1 && currP[i] != 1) {
								moving = i;
								currP[i] = 1;
								break;
							}
						}
					} else {
						moving = currP[5];
						currP[moving] = 1;
					}
					map.put(new Point((int) x, (int) y), currP);
				} else {
					for(int i = 1; i < 5; i++) {
						if(direct[i] == 1 && currP[i] != 1) {
							moving = i;
							currP[i] = 1;
							break;
						}
					}
					map.put(new Point((int) x, (int) y), currP);
				}
			} else {
				Point curr = new Point((int) x, (int) y);
				int[] currP = new int[6];
				currP[0] = checkAvail();
				currP[5] = 5 - moving;
				currP[5-moving] = 1;
				for(int i = 1; i < 5; i++) {
					if(direct[i] == 1 && currP[i] != 1) {
						moving = i;
						currP[i] = 1;
						break;
					}
				}
				map.put(curr, currP);
			}
		}
	}
	
	private boolean checkPoint(float x, float y) {
		Point check = new Point((int) x, (int) y);
		return this.map.containsKey(check);
	}
	
	private int checkAvail() {
		int sum = 0;
		for(int i = 0; i < 5; i++) {
			sum += direct[i];
		}
		return sum;
	}

	@Override
	public void render(Graphics g) {
		g.drawImage(Assets.guard, (int) (x - game.getCamera().getxOff()), (int) (y - game.getCamera().getyOff()), null);
		g.drawLine((int) (x + 16 - game.getCamera().getxOff()), (int) (y - 16 - game.getCamera().getyOff()),
				(int) (x + 16 - game.getCamera().getxOff()), (int) (y + 48 - game.getCamera().getyOff()));
		g.drawLine((int) (x - 16 - game.getCamera().getxOff()), (int) (y + 16 - game.getCamera().getyOff()),
				(int) (x + 48 - game.getCamera().getxOff()), (int) (y + 16 - game.getCamera().getyOff()));
	}

}
