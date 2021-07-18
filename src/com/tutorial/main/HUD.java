package com.tutorial.main;

import java.awt.Color;
import java.awt.Graphics;

public class HUD {
	
	public static int bounds = 0;
	public static float HEALTH = 100;
	
	private float greenValue = 255f;
	static int score = 0;
	static float level = 0;
	
	public void tick() {
		
		
		HEALTH = Game.clamp(HEALTH, 0, 100+(bounds/2));		
		greenValue = HEALTH*2;
		score++;
	}
	
	public void render(Graphics g) {
		g.setColor(Color.gray);
		g.fillRect(15, 15, 200 + bounds, 32);
		g.setColor(new Color(75, 255, 0));
		g.fillRect(15, 15, (int)HEALTH * 2, 32);
		g.setColor(Color.white);
		g.drawRect(15, 15, 200 + bounds, 32);
		
		g.drawString("Score: " + score, 15, 64);
		g.drawString("Level: " + level, 15, 80);
		g.drawString("Space for Shop", 15, 94);
		g.drawString("Player1", 15, 13);
		
		if(getLevel() == 25.5) {
			g.drawString("ENDLESS WAVE!", 15, 132);
		}
		
		if(HEALTH <= 0) {
			g.setColor(Color.WHITE);
			g.drawString("Player1 Died.", 15, 100);
			score = 0;
		}
	}
	
	public void setScore(int score) {
		this.score = score;
	}
	
	public int getScore() {
		return score;
	}
	
	public static float getLevel() {
		return level;
	}
	
	public void setLevel(float level) {
		this.level = level;
	}
	
}
