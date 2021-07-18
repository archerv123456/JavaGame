package com.tutorial.main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;

import com.sun.glass.events.KeyEvent;
import com.tutorial.main.Game.STATE;

public class Player2 extends GameObject{
	
	Handler handler;

	public Player2(int x, int y, ID id, Handler handler) {
		super(x, y, id);
		this.handler = handler;
	}
	
	public Rectangle getBounds() {
		return new Rectangle((int)x, (int)y, 32, 32);
	}

	
	public void tick() {
		x += velX;
		y += velY; 
		
		x = Game.clamp(x, 0, Game.WIDTH - 48);
		y = Game.clamp(y, 0, Game.HEIGHT - 71);
		
		handler.addObject(new Trail(x, y, ID.Trail, Color.blue, 32, 32, 0.1f, handler));

		
		collision();
		
		if(HUD2.HEALTH <= 0) {
			handler.removeObject(this);
		}
	}
	
	private void collision() {
		for(int i = 0; i < handler.object.size(); i++) {
			
			GameObject tempObject = handler.object.get(i);
			
			if(tempObject.getId() == ID.BasicEnemy) {
				if(getBounds().intersects(tempObject.getBounds())) {
					HUD2.HEALTH -= 5;
				}}
				
				if(tempObject.getId() == ID.Friend) {
					if(getBounds().intersects(tempObject.getBounds())) {
						HUD2.HEALTH -= 50;
					}	}
				if(tempObject.getId() == ID.FastEnemy) {
					if(getBounds().intersects(tempObject.getBounds())) {
						HUD2.HEALTH -= 10;
					} }
				if(tempObject.getId() == ID.SmartEnemy) {
					if(getBounds().intersects(tempObject.getBounds())) {
						HUD2.HEALTH -= 4;
				}	}
				
				if(Game.gameState == STATE.Game) {
					if(tempObject.getId() == ID.EnemyBoss) {
						if(getBounds().intersects(tempObject.getBounds())) {
							HUD2.HEALTH -= 0;
					}	}
				}
				
				if(tempObject.getId() == ID.HardEnemy) {
					if(getBounds().intersects(tempObject.getBounds())) {
						HUD.HEALTH -= 8;
					}}
				if(tempObject.getId() == ID.LunaiticEnemy) {
					if(getBounds().intersects(tempObject.getBounds())) {
						HUD.HEALTH -= 15;
					}}
				
				
					
				
			
			
			
		}
	}

	
	public void render(Graphics g) {
		
		Graphics2D g2d = (Graphics2D) g;
		
		g.setColor(Color.blue);
		g.fillRect((int)x, (int)y, 32, 32);
		
		
	}
	

}
