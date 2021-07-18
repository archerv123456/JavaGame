package com.tutorial.main;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.util.Random;

public class Game extends Canvas implements Runnable{
	
	private static final long serialVersionUID = 7580815534084638412L;
	
	public static final int WIDTH = 640, HEIGHT = WIDTH / 12 * 9;
	private Thread thread;
	static boolean running = false;
	static boolean paused = false;
	private Handler handler;
	private Random r;
	private HUD hud;
	private HUD2 hud2;
	private Spawn spawner;
	public int diff = 0;
	private Shop shop;
	
	private Menu menu;
	public enum STATE {
		Menu,
		Select,
		Help,
		Shop,
		Game,
		PvP,
		End
	}
	
	public static STATE gameState = STATE.Select;
	
	public Game() {
		handler = new Handler();
		hud = new HUD();
		shop = new Shop(handler, hud);
		menu = new Menu(this, handler, hud);
		this.addKeyListener(new KeyInput(handler, this));
		this.addMouseListener(menu);
		this.addMouseListener(shop);
		
		AudioPlayer.load();
		
		AudioPlayer.getMusic("music").loop();
		
		new Window(WIDTH, HEIGHT, "Game!", this);
		
		
		hud2 = new HUD2();
		spawner = new Spawn(handler, hud, this);
		menu = new Menu(this, handler, hud);
			
		if(gameState == STATE.Game) {
			handler.addObject(new Player(WIDTH/2-32, HEIGHT/2-32, ID.Player, handler));
			//handler.addObject(new BasicEnemy(WIDTH/3-164, HEIGHT/2-128, ID.BasicEnemy, handler));
			//handler.addObject(new Player2(WIDTH/2-125, HEIGHT/2-114, ID.Player2, handler));
			//handler.addObject(new BasicEnemy(WIDTH/3-164, HEIGHT/2-128, ID.BasicEnemy, handler));
		}
		else if(gameState == STATE.PvP) {
			handler.addObject(new Player(WIDTH/2-32, HEIGHT/2-32, ID.Player, handler));
			handler.addObject(new EnemyBoss(WIDTH/3-140, HEIGHT/3-140, ID.Player2, handler));
			
		}
		
		else{
			for(int i = 0; i < 1; i++) {
				handler.addObject(new MenuParticle(WIDTH/3-164, HEIGHT/2-128, ID.MenuParticle, handler));
				handler.addObject(new MenuParticle(WIDTH/2-100, HEIGHT/2-165, ID.MenuParticle, handler));
				handler.addObject(new MenuParticle(WIDTH/1-232, HEIGHT/4-128, ID.MenuParticle, handler));
				handler.addObject(new MenuParticle(WIDTH/2-100, HEIGHT/4-167, ID.MenuParticle, handler));
				handler.addObject(new MenuParticle(WIDTH/2-255, HEIGHT/3-245, ID.MenuParticle, handler));
				handler.addObject(new MenuParticle(WIDTH/2-168, HEIGHT/1-245, ID.MenuParticle, handler));
				handler.addObject(new MenuParticle(WIDTH/1-125, HEIGHT/2-89, ID.MenuParticle, handler));
				handler.addObject(new MenuParticle(WIDTH/2-94, HEIGHT/3-10, ID.MenuParticle, handler));

			}
		}
		
	}
	
	public synchronized void start() {
		thread = new Thread(this);
		thread.start();
		running = true;
	}
	
	public synchronized void stop() {
		try{
			thread.join();
			running = false;
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void run() {
		long lastTime = System.nanoTime();
		double amountOfTicks = 60.0;
		double ns = 1000000000 / amountOfTicks;
		double delta = 0;
		long timer = System.currentTimeMillis();
		int frames = 0;
		while(running) {
			long now = System.nanoTime();
			delta += (now - lastTime) / ns;
			lastTime = now;
			while(delta >= 1) {
				tick();
				delta--;
			
			}
			if(running)
				render();
			frames++;
			
			if(System.currentTimeMillis() - timer > 1000) {
				timer += 1000;
				System.out.println("FPS: " + frames);
				frames = 0;
			}
		}
		stop();
	}

	private void render() {
		BufferStrategy bs = this.getBufferStrategy();
		if(bs == null) {
			this.createBufferStrategy(3);
			return;
		}
		
		Graphics g = bs.getDrawGraphics();
		
		g.setColor(Color.black);
		g.fillRect(0, 0, WIDTH, HEIGHT);	
		
		
		
		if(gameState == STATE.Game || gameState == STATE.PvP) {
			hud.render(g);
			//hud2.render(g);
			handler.render(g);
		}else if(gameState == STATE.Menu || gameState == STATE.End || gameState == STATE.Select) {
			menu.render(g);
			handler.render(g);
		}else if(gameState == STATE.Shop)
			shop.render(g);
		if(paused) {
			g.setColor(Color.WHITE);
			g.drawString("PAUSED", 100, 100);
		}
		
		g.dispose();
		bs.show();
	}

	private void tick() {
		
		
		
		if(!paused && gameState == STATE.Game || gameState == STATE.PvP) {
			handler.tick();
			hud.tick();
			spawner.tick();
			//hud2.tick();
			if(HUD.HEALTH <= 0) {
				HUD.HEALTH = 0;
				//HUD2.HEALTH = 0;
				hud.setLevel(0.0f);
				hud.setScore(0);
				//hud2.setScore(0);
				gameState = STATE.End;
				handler.clearEnemys();
			}
		}else if(gameState == STATE.Menu || gameState == STATE.End || gameState == STATE.Select) {
			menu.tick();
			handler.tick();
		}else if(gameState == STATE.PvP) {
			hud.tick();
			spawner.tick();
			//hud2.tick();
			if(HUD.HEALTH <= 0 || HUD2.HEALTH <= 0) {
				HUD.HEALTH = 0;
				//HUD2.HEALTH = 0;
				hud.setLevel(0.0f);
				hud.setScore(0);
				//hud2.setScore(0);
				gameState = STATE.End;
				handler.clearEnemys();
			}}else if(gameState == STATE.Shop) {
				shop.tick();
			}
		

	}
	
	public static float clamp(float var, float min, float max) {
		if(var >= max)
			return var = max;
		else if(var <= min)
			return var = min;
		else
			return var;
	}

	public static void main(String agrs[]) {
		new Game();
	}
	
}
