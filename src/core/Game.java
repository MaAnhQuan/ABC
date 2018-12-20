package core;

import java.awt.Graphics;
import java.awt.image.BufferStrategy;

import Tile.World;
import entity.EntityManager;
import entity.Player;
import gfx.Assets;
import gfx.Camera;
import gfx.Window;
import input.KeyManager;

public class Game implements Runnable {
	
	private Window window;
	
	private int width, height;
	private String title;
	
	private Thread thread;
	private boolean running = false; 
	
	private BufferStrategy bs;
	private Graphics g;
	
	private Camera camera;
	
	private Player player;
	private EntityManager entityManager;
	private World world;
	
	private KeyManager keyManager;
	
	public Game(String title, int width, int height) {
		this.width = width;
		this.height = height;
		this.title = title;
		entityManager = new EntityManager();
		player = new Player(this, 32, 32);
		world = new World(this);
		keyManager = new KeyManager();
	}
	
	public World getWorld() {
		return world;
	}

	public void setWorld(World world) {
		this.world = world;
	}

	private void init() {
		window = new Window(title, width, height);
		window.getFrame().addKeyListener(keyManager);
		Assets.init();
		
		camera = new Camera(0, 0, this);
	}
	
	public KeyManager getKeyManager() {
		return keyManager;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public Camera getCamera() {
		return camera;
	}

	public void setCamera(Camera camera) {
		this.camera = camera;
	}

	private void update() {
		keyManager.update();
		player.update();
		entityManager.update();
	}
	
	private void render() {
		bs = window.getCanvas().getBufferStrategy();
		if(bs == null) {
			window.getCanvas().createBufferStrategy(3);
			return;
		}
		g = bs.getDrawGraphics();
		//clear screen
		g.clearRect(0, 0, width, height);
		
		world.render(g);
		player.render(g);
		entityManager.render(g);
		
		bs.show();
		g.dispose();
	}

	public void run() {
		
		init();
		
		int fps = 60;
		double timePerUp = 1000000000 / fps;
		double delta = 0;
		long now;
		long lastTime = System.nanoTime();
		
		long timer = 0;
		int ticks = 0;
		
		while(running) {
			now = System.nanoTime();
			delta += (now - lastTime) / timePerUp;
			timer += now - lastTime;
			lastTime = now;
			
			if(delta >= 1) {
				update();
				render();
				ticks++;
				delta--;
			}
			
			if(timer >= 1000000000) {
				System.out.println(ticks);
				ticks = 0;
				timer = 0;
			}
		}
		
		stop();
	}
	
	public synchronized void start() {
		if(running) 
			return;
		running = true;
		thread = new Thread(this);
		thread.start();
	}
	
	public synchronized void stop() {
		if(!running) 
			return;
		running = false;
		try {
			thread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
