package com.tutorial.main;

import java.awt.Color;
import java.awt.Graphics;

public class HUD2 {
	
	
	public static float HEALTH = 100;
	public static int bounds2 = 0;
	
	private static float greenValue = 255f;
	private int score2 = 0;
	
	public static float reviveTimer = 0;
	public static boolean canRevive = false;
	
	public static void tick() {
		
		
		HEALTH = (int) Game.clamp(HEALTH, 0, 100+(bounds2/2));
		greenValue = (int) Game.clamp(greenValue, 0, 255);
		
		greenValue = HEALTH*2; 
		
		if (HUD.HEALTH <= 0) {
			if (reviveTimer >= 100) {
				canRevive = true;
			} else if (reviveTimer < 100) {
				reviveTimer++;
			}
		}
	}
	
	public static void render(Graphics g) {
		g.setColor(Color.gray);
		g.fillRect(715, 15, 200 + bounds2, 32);
		g.setColor(new Color(75, (int)greenValue, 0));
		g.fillRect(715, 15, (int)HEALTH * 2, 32);
		g.setColor(Color.white);
		g.drawRect(715, 15, 200 + bounds2, 32);
		
		g.drawString("Player2", 870, 13);
		
		if(HEALTH <= 0) {
			g.setColor(Color.WHITE);
			g.drawString("Player2 Died.", 745, 100);
		}
	}
	
	public void setScore(int score2) {
		this.score2 = score2;
	}
	
	public int getScore() {
		return score2;
	}
	

	
}
