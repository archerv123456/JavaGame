package com.tutorial.main;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import com.tutorial.main.Game.STATE;

public class KeyInput extends KeyAdapter{
	
	private Handler handler;
	private boolean[] keyDown = new boolean[8];
	static int KeyPresses = 1;
	static int KeyPresses2 = 1;
	
	Game game;
	
	public KeyInput(Handler handler, Game game) {
		this.handler = handler;
		
		this.game = game;
		
		//Player 1
		keyDown[0]=false;
		keyDown[1]=false;
		keyDown[2]=false;
		keyDown[3]=false;
		
		//Player 2
		keyDown[4]=false;
		keyDown[5]=false;
		keyDown[6]=false;
		keyDown[7]=false;
	}
	
	
	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();
		
		
		for(int i = 0; i < handler.object.size(); i++) {
			GameObject tempObject = handler.object.get(i);
			
			if(tempObject.getId() == ID.Player) {
				
				if(key == KeyEvent.VK_W) { tempObject.setVelY(-handler.spd); keyDown[0]=true; }
				if(key == KeyEvent.VK_S) { tempObject.setVelY(handler.spd); keyDown[1]=true; }
				if(key == KeyEvent.VK_D) { tempObject.setVelX(handler.spd); keyDown[2]=true; }
				if(key == KeyEvent.VK_A) { tempObject.setVelX(-handler.spd); keyDown[3]=true; }
				
				if(key == KeyEvent.VK_ESCAPE) { Game.running = false;
				handler.clearEnemys();
				
				}
				
				
				if(Game.gameState == STATE.Game) {
					if(KeyPresses >= 1) {
						if(key == KeyEvent.VK_Q) {
							HUD.HEALTH += 100;
							KeyPresses--;
						}
				}
				}
				if(key == KeyEvent.VK_F4) {
					HUD.score += 10000;
				}
				if(key == KeyEvent.VK_F1) {
					handler.spd += 2;
				}
				if(key == KeyEvent.VK_F3) {
					HUD.HEALTH++;
				}
				if(key == KeyEvent.VK_F9) {
					HUD.level = 25;
				}
				if(key == KeyEvent.VK_P) {
					
					if(game.gameState == STATE.Game || game.gameState == STATE.PvP)
					if(Game.paused) Game.paused = false;
					else Game.paused = true;
				}
				if(key == KeyEvent.VK_SPACE) {
					if(Game.gameState == STATE.Game) Game.gameState = STATE.Shop;
					else if (Game.gameState == STATE.Shop) Game.gameState = STATE.Game;
				}
			}
				
			if(tempObject.getId() == ID.Player2) {
				if(Game.gameState == STATE.Game) {
					if(key == KeyEvent.VK_UP) { tempObject.setVelY(-handler.spd); keyDown[4]=true; }
					if(key == KeyEvent.VK_DOWN) { tempObject.setVelY(handler.spd); keyDown[5]=true; }
					if(key == KeyEvent.VK_LEFT) { tempObject.setVelX(-handler.spd); keyDown[6]=true; }
					if(key == KeyEvent.VK_RIGHT) { tempObject.setVelX(handler.spd); keyDown[7]=true; }
				}
				else if(Game.gameState == STATE.PvP) {
					if(key == KeyEvent.VK_UP) { tempObject.setVelY(-1); keyDown[4]=true; }
					if(key == KeyEvent.VK_DOWN) { tempObject.setVelY(1); keyDown[5]=true; }
					if(key == KeyEvent.VK_LEFT) { tempObject.setVelX(-5); keyDown[6]=true; }
					if(key == KeyEvent.VK_RIGHT) { tempObject.setVelX(5); keyDown[7]=true; }
				}
				
				if(Game.gameState == STATE.Game) {
					if(KeyPresses2 >= 1) {
						if(key == KeyEvent.VK_CONTROL) {
							HUD2.HEALTH += 100;
							KeyPresses2--;
						}
				}
				}
				}
				if(key == KeyEvent.VK_SLASH) {
					HUD2.HEALTH = 0;
				}
				if(key == KeyEvent.VK_ESCAPE) { Game.gameState = STATE.End;
				handler.clearEnemys();
				
				}
				if(key == KeyEvent.VK_F6) {
					HUD2.HEALTH++;
				}
			}}
			
		
//		if(tempObject.getId() == ID.Player3) {
//			if(key == KeyEvent.VK_UP) { tempObject.setVelY(-5); keyDown[4]=true; }
//			if(key == KeyEvent.VK_DOWN) { tempObject.setVelY(5); keyDown[5]=true; }
//			if(key == KeyEvent.VK_LEFT) { tempObject.setVelX(-5); keyDown[6]=true; }
//			if(key == KeyEvent.VK_RIGHT) { tempObject.setVelX(5); keyDown[7]=true; }
//			
//			if(Game.gameState == STATE.Game) {
//				if(KeyPresses2 >= 1) {
//					if(key == KeyEvent.VK_CONTROL) {
//						HUD2.HEALTH += 100;
//						KeyPresses2--;
//					}
//			}
//			}
//			}
//			if(key == KeyEvent.VK_SLASH) {
//				HUD2.HEALTH = 0;
//			}
//			if(key == KeyEvent.VK_ESCAPE) { Game.gameState = STATE.End;
//			handler.clearEnemys();
//			
//			}
//			
//		
	
	
//	if(tempObject.getId() == ID.Player4) {
//	if(key == KeyEvent.VK_UP) { tempObject.setVelY(-5); keyDown[4]=true; }
//	if(key == KeyEvent.VK_DOWN) { tempObject.setVelY(5); keyDown[5]=true; }
//	if(key == KeyEvent.VK_LEFT) { tempObject.setVelX(-5); keyDown[6]=true; }
//	if(key == KeyEvent.VK_RIGHT) { tempObject.setVelX(5); keyDown[7]=true; }
//	
//	if(Game.gameState == STATE.Game) {
//		if(KeyPresses2 >= 1) {
//			if(key == KeyEvent.VK_CONTROL) {
//				HUD2.HEALTH += 100;
//				KeyPresses2--;
//			}
//	}
//	}
//	}
//	if(key == KeyEvent.VK_SLASH) {
//		HUD2.HEALTH = 0;
//	}
//	if(key == KeyEvent.VK_ESCAPE) { Game.gameState = STATE.End;
//	handler.clearEnemys();
//	
//	}
//	
//
		
	
	
			
		
	
	
	public void keyReleased(KeyEvent e) {
		int key = e.getKeyCode();
		
		for(int i = 0; i < handler.object.size(); i++) {
			GameObject tempObject = handler.object.get(i);
			
			if(tempObject.getId() == ID.Player) {
				
				if(key == KeyEvent.VK_W) keyDown[0]=false;	//tempObject.setVelY(0);
				if(key == KeyEvent.VK_S) keyDown[1]=false;	//tempObject.setVelY(0);
				if(key == KeyEvent.VK_D) keyDown[2]=false;	//tempObject.setVelX(0);
				if(key == KeyEvent.VK_A) keyDown[3]=false;	//tempObject.setVelX(0);
				
				if(!keyDown[0] && !keyDown[1]) tempObject.setVelY(0);
				if(!keyDown[2] && !keyDown[3]) tempObject.setVelX(0);
							
				
			}
			
			if(tempObject.getId() == ID.Player2) {
				if(key == KeyEvent.VK_UP) keyDown[4]=false;
				if(key == KeyEvent.VK_DOWN) keyDown[5]=false;
				if(key == KeyEvent.VK_LEFT) keyDown[6]=false;
				if(key == KeyEvent.VK_RIGHT) keyDown[7]=false;
				
				if(!keyDown[4] && !keyDown[5]) tempObject.setVelY(0);
				if(!keyDown[6] && !keyDown[7]) tempObject.setVelX(0);
			}
		}
		
	}
	
	
}
