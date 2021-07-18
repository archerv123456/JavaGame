package com.tutorial.main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class LunaiticSmartEnemy extends GameObject{
	
	private Handler handler;
	private GameObject player;
	private GameObject player2;

	public LunaiticSmartEnemy(float x, float y, ID id, Handler handler) {
		super(x, y, id);
		this.handler = handler;
		
		for(int i = 0; i < handler.object.size(); i++) {
			if(handler.object.get(i).getId() == ID.Player) player = handler.object.get(i);
			if(handler.object.get(i).getId() == ID.Player2) player2 = handler.object.get(i);
		}
		
	}
	
	public Rectangle getBounds() {
		return new Rectangle((int)x, (int)y, 25, 25);
	}

	
	public void tick() {
		x += velX;
		y += velY;
		
		if(HUD.HEALTH > 0) {
			float diffX = x - player.getX();
			float diffY = y - player.getY();
			
			float distance = (float) Math.sqrt((x - player.getX())*(x-player.getX()) + (y-player.getY())*(y-player.getY()));
			
			velX = (float) ((-4.5/distance) * diffX);
			velY = (float) ((-4.5/distance) * diffY);
		}
		
		
//		if(HUD2.HEALTH > 0) {
//			float diffX2 = x - player2.getX();
//			float diffY2 = y - player2.getY();
//			
//			float distance2 = (float) Math.sqrt((x - player2.getX())*(x-player2.getX()) + (y-player2.getY())*(y-player2.getY()));
//			
//			velX = (float) ((-4.5/distance2) * diffX2);
//			velY = (float) ((-4.5/distance2) * diffY2);
//		}
		
		
		
		
		
		if(y <= 0 || y >= Game.HEIGHT - 50) velY *= -1;
		if(x <= 0 || x >= Game.WIDTH - 32) velX *= -1;
		
		//handler.addObject(new Trail(x, y, ID.Trail, Color.magenta, 25, 25, 0.1f, handler));
	}

	
	public void render(Graphics g) {
		g.setColor(Color.yellow);
		g.fillRect((int)x, (int)y, 25, 25);
	}

}
