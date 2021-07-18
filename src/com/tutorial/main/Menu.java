package com.tutorial.main;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;

import com.tutorial.main.Game.STATE;


public class Menu extends MouseAdapter{
	
	private Game game;
	private Handler handler;
	private Random r = new Random();
	private HUD hud;
	private HUD2 hud2;
	
	public Menu(Game game, Handler handler, HUD hud) {
		this.game = game;
		this.handler = handler;
		this.hud = hud;
	}
	
	public void mousePressed(MouseEvent e) {
		int mx = e.getX();
		int my = e.getY();
		
		
		
//		if(mouseOver(mx, my, 210, 150, 200, 64)) {
//			if(Game.gameState == STATE.Menu) {
//				Game.gameState = STATE.Game;
//				handler.addObject(new Player(Game.WIDTH/2-32, Game.HEIGHT/2-32, ID.Player, handler));
//				handler.addObject(new Player2(Game.WIDTH/2-140, Game.HEIGHT/2-140, ID.Player2, handler));
//				handler.clearEnemys();
//				//handler.addObject(new BasicEnemy(Game.WIDTH/3-164, Game.HEIGHT/2-128, ID.BasicEnemy, handler));
//				//handler.addObject(new BasicEnemy(Game.WIDTH/3-164, Game.HEIGHT/2-128, ID.BasicEnemy, handler));
//			}}
		
		if(mouseOver(mx, my, 210, 150, 200, 64)) {
			if(Game.gameState == STATE.Menu) {
				
				Game.gameState = STATE.Select;
			}
			
		}
			
			if(mouseOver(mx, my, 210, 250, 200, 64)) {
				if(Game.gameState == STATE.Menu) {
					Game.gameState = STATE.PvP;
					
					handler.addObject(new Player(Game.WIDTH/2-32, Game.HEIGHT/2-32, ID.Player, handler));
					handler.clearEnemys();
					handler.addObject(new PlayerBoss(Game.WIDTH/3-140, Game.HEIGHT/3-140, ID.Player2, handler));
					
				}
			
		}
		
		if(mouseOver(mx, my, 210, 350, 200, 64)) {
			if(Game.gameState == STATE.Menu) {
				System.exit(1);
			}else if(Game.gameState == STATE.End) {
				
				HUD.HEALTH = 100;
				HUD2.HEALTH = 100;
				handler.clearEnemys();
				Game.gameState = STATE.Select;
				
				hud.setLevel(0.0f);
				hud.setScore(0);
				Shop.B1 = 2000;
				Shop.B2 = 1500;
				Shop.B3 = 1000;
				HUD.bounds = 0;
				
				//hud2.setScore(0);
				
			}
			
		}
		
		
		
		if(mouseOver(mx, my, 210, 150, 200, 64)) {
			if(Game.gameState == STATE.Select) {
				
				Game.gameState = STATE.Game;
				handler.addObject(new Player(Game.WIDTH/2-32, Game.HEIGHT/2-32, ID.Player, handler));
				handler.addObject(new Player2(Game.WIDTH/2-140, Game.HEIGHT/2-140, ID.Player2, handler));
				handler.clearEnemys();
				handler.addObject(new BasicEnemy(Game.WIDTH/3-164, Game.HEIGHT/2-128, ID.BasicEnemy, handler));
				handler.clearEnemys();
				game.diff = 0;
			}
		
	}
		if(mouseOver(mx, my, 210, 250, 200, 64)) {
			if(Game.gameState == STATE.Select) {
				
				Game.gameState = STATE.Game;
				handler.addObject(new Player(Game.WIDTH/2-32, Game.HEIGHT/2-32, ID.Player, handler));
				handler.addObject(new Player2(Game.WIDTH/2-140, Game.HEIGHT/2-140, ID.Player2, handler));
				handler.clearEnemys();
				handler.addObject(new HardEnemy(Game.WIDTH/3-164, Game.HEIGHT/2-128, ID.HardEnemy, handler));
				
				
				game.diff = 1;
			}
		
	}
		
		if(mouseOver(mx, my, 210, 350, 200, 64)) {
			if(Game.gameState == STATE.Select) {
				
				Game.gameState = STATE.Game;
				handler.addObject(new Player(Game.WIDTH/2-32, Game.HEIGHT/2-32, ID.Player, handler));
				handler.clearEnemys();
				handler.addObject(new LunaiticEnemy(Game.WIDTH/3-164, Game.HEIGHT/2-128, ID.LunaiticEnemy, handler));
				
				
				game.diff = 2;
			}
		
	}
	}
	
	public void mouseReleased(MouseEvent e) {
		
	}
	
	private boolean mouseOver(int mx, int my, int x, int y, int width, int height) {
		if(mx > x && mx < x + width) {
			if(my > y && my < y + height) {
				return true;
			}else return false;
		}else return false;
	}
	
	public void tick() {
		
	}

	public void render(Graphics g) {
		if(Game.gameState == STATE.Menu) {
			Font fnt = new Font("arial", 1, 50);
			Font fnt2 = new Font("arial", 1, 30);
			
			g.setFont(fnt);
			g.setColor(Color.white);
			g.drawString("Game!", 240, 70);
			
			g.setFont(fnt2);
			g.drawRect(210, 150, 200, 64);
			g.drawString("Play", 270, 190);
			
			g.drawRect(210, 250, 200, 64);
			g.drawString("PvP", 270, 290);
		
			
			
			g.drawRect(210, 350, 200, 64);
			g.drawString("Quit", 270, 390);
		}else if(Game.gameState == STATE.End) {
			Font fnt = new Font("arial", 1, 50);
			Font fnt2 = new Font("arial", 1, 30);
			
			g.setFont(fnt);
			g.setColor(Color.white);
			g.drawString("Game Over", 180, 70);
			
			g.setFont(fnt2);
						
			
		
			
			
			g.drawRect(210, 350, 200, 64);
			g.drawString("Try Again?", 245, 390);
		}else if(Game.gameState == STATE.Select) {
			Font fnt = new Font("arial", 1, 50);
			Font fnt2 = new Font("arial", 1, 30);
			
			g.setFont(fnt);
			g.setColor(Color.white);
			g.drawString("SELECT DIFFICULTY", 240, 70);
			
			g.setFont(fnt2);
						
			g.drawRect(210, 350, 200, 64);
			g.drawString("Normal", 270, 190);
					
			g.drawRect(210, 150, 200, 64);
			g.drawString("Hard", 270, 290);
			
			g.drawRect(210, 250, 200, 64);
			g.drawString("Lunaitic", 270, 390);
		}
	}
}

