package gfx;

import java.awt.image.BufferedImage;

public class Assets {

	public static BufferedImage wall, grass, player;

	public static void init() {
		SpriteSheet sheet = new SpriteSheet(ImageLoader.loadImage("/static/tile.png"));
		wall = sheet.crop(0, 64, 32, 32);
		grass = sheet.crop(0, 32, 32, 32);
		player = sheet.crop(0, 128, 32, 32);
	}
}
