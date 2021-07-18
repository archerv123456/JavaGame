package com.tutorial.main;

import java.awt.Graphics;
import java.util.LinkedList;

import com.tutorial.main.Game.STATE;

public class Handler {
	
	LinkedList<GameObject> object = new LinkedList<GameObject>();
	
	public int spd = 5;
	
	public void tick() {
		for(int i = 0; i < object.size(); i++) {
			GameObject tempObject = object.get(i);
			
			tempObject.tick();
			
		}
		
		
	}
	
	public void render(Graphics g) {
		for(int i = 0; i < object.size(); i++) {
			GameObject tempObject = object.get(i);
			
			tempObject.render(g);
		}
	}
	
	public void clearEnemys() {
		for(int i = 0; i < object.size(); i++) {
			GameObject tempObject = object.get(i);
			
			if(Game.gameState == STATE.Game) {
				if(tempObject.getId() == ID.Player || tempObject.getId() == ID.Player2) {
					object.clear();
					if(Game.gameState != Game.STATE.End)
					addObject(new Player((int)tempObject.getX(), (int)tempObject.getY(), ID.Player, this));
					//addObject(new Player2((int)tempObject.getX(), (int)tempObject.getY(), ID.Player2, this));}
				}
			if(Game.gameState == STATE.PvP) {
				if(tempObject.getId() == ID.Player || tempObject.getId() == ID.Player2) {
					object.clear();
					if(Game.gameState != Game.STATE.End)
					addObject(new Player((int)tempObject.getX(), (int)tempObject.getY(), ID.Player, this));
					addObject(new PlayerBoss(Game.WIDTH/3-140, Game.HEIGHT/3-140, ID.Player2, this));}
				}
				
			}}
	} 
	
		
		
	
				
			
			
			
			
		
	
	
	public void addObject(GameObject object) {
		this.object.add(object);
	}
	
	public void removeObject(GameObject object) {
		this.object.remove(object);
	}
	
}
