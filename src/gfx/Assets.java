package gfx;

import java.awt.image.BufferedImage;

public class Assets {

	public static BufferedImage wall, grass, player, guard;

	public static void init() {
		SpriteSheet sheet = new SpriteSheet(ImageLoader.loadImage("/static/tile.png"));
		wall = sheet.crop(0, 64, 32, 32);
		grass = sheet.crop(0, 32, 32, 32);
		guard = sheet.crop(0, 256, 32, 32);
		sheet = new SpriteSheet(ImageLoader.loadImage("/static/player.png"));
		player = sheet.crop(32, 0, 32, 32);
	}
}
