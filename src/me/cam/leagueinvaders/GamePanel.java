package me.cam.leagueinvaders;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;
import javax.swing.Timer;

@SuppressWarnings("serial")
public class GamePanel extends JPanel implements KeyListener,ActionListener {
	final int MENU_STATE = 0;
	final int GAME_STATE = 1;
	final int END_STATE = 2;
	private Font font;
	private int currentState = MENU_STATE;
	private Timer timer;
	//private GameObject gameObject;
	public GamePanel() {
		timer = new Timer(1000 / 60,this);
		font = new Font("Arial",Font.PLAIN,48);
		
		//gameObject = new GameObject(10,10,100,100);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		repaint();
		//gameObject.update();
		if(currentState == MENU_STATE){
			updateMenuState();
		}
		else if(currentState == GAME_STATE){
			updateGameState();
		}
		else if(currentState == END_STATE){
			updateEndState();
		}
		
	}
	public void startGame() {
		timer.start();
	}
	public void paintComponent(Graphics g) {
		//gameObject.draw(g);
		if(currentState == MENU_STATE){
			drawMenuState(g);
		}
		else if(currentState == GAME_STATE){
			drawGameState(g);
		}
		else if(currentState == END_STATE){
			drawEndState(g);
		}
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
	}

	@Override
	public void keyPressed(KeyEvent e) {
		
		if(e.getKeyCode() == KeyEvent.VK_SPACE) {
			currentState++;
		}
		if(currentState > END_STATE){
			currentState = MENU_STATE;
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
	}
	public void updateMenuState() {
		
	}
	public void updateGameState() {
		
	}
	public void updateEndState() {
		
	}
	public void drawMenuState(Graphics g) {
		g.setColor(Color.BLUE);
		g.fillRect(0, 0, LeagueInvaders.width, LeagueInvaders.height);
		g.setColor(Color.BLACK);
		g.setFont(font);
		g.drawString("texr", 50, 50);
	}
	public void drawGameState(Graphics g) {
		
	}
	public void drawEndState(Graphics g) {
		
	}
}
