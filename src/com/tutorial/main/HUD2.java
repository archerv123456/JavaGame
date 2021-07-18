package com.tutorial.main;

import java.awt.Color;
import java.awt.Graphics;

public class HUD2 {
	
	
	public static float HEALTH = 100;
	public int bounds2 = 0;
	
	private float greenValue = 255f;
	private int score2 = 0;
	private float level2 = 1;
	
	public void tick() {
		
		
		HEALTH = (int) Game.clamp(HEALTH, 0, 100+(bounds2/2));
		greenValue = (int) Game.clamp(greenValue, 0, 255);
		
		greenValue = HEALTH*2; 
		score2++;
	}
	
	public void render(Graphics g) {
		g.setColor(Color.gray);
		g.fillRect(415, 15, 200 + bounds2, 32);
		g.setColor(new Color(75, (int)greenValue, 0));
		g.fillRect(415, 15, (int)HEALTH * 2, 32);
		g.setColor(Color.white);
		g.drawRect(415, 15, 200 + bounds2, 32);
		
		g.drawString("Score: " + score2, 555, 64);
		g.drawString("Press / to kill", 550, 80);
		g.drawString("Player2", 575, 13);
		
		if(HEALTH <= 0) {
			g.setColor(Color.WHITE);
			g.drawString("Player2 Died.", 545, 100);
			score2 = 0;
		}
	}
	
	public void setScore(int score2) {
		this.score2 = score2;
	}
	
	public int getScore() {
		return score2;
	}
	

	
}
