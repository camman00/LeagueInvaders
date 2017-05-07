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
	private Rocketship rocketship;
	private ObjectManager objectManager;
	private boolean spacePressed = false;
	//private GameObject gameObject;
	public GamePanel() {
		timer = new Timer(1000 / 60,this);
		font = new Font("Arial",Font.PLAIN,48);
		rocketship = new Rocketship(250,700,50,50);
		objectManager = new ObjectManager();
		objectManager.addObject(rocketship);
		
		//gameObject = new GameObject(10,10,100,100);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		repaint();
		//objectManager.update();
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
		//objectManager.draw(g);
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
		if(e.getKeyCode() == KeyEvent.VK_W) {
			currentState++;
		}
		if(currentState > END_STATE){
			currentState = MENU_STATE;
		}
		if(e.getKeyCode() == KeyEvent.VK_RIGHT) {
			rocketship.right = true;
		}
		if(e.getKeyCode() == KeyEvent.VK_LEFT) {
			rocketship.left = true;
		}
		if(e.getKeyCode() == KeyEvent.VK_UP) {
			rocketship.up = true;
		}
		if(e.getKeyCode() == KeyEvent.VK_DOWN) {
			rocketship.down = true;
		}
		if(e.getKeyCode() == KeyEvent.VK_SPACE) {
			spacePressed = true;
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		if(e.getKeyCode() == KeyEvent.VK_RIGHT) {
			rocketship.right = false;
		}
		if(e.getKeyCode() == KeyEvent.VK_LEFT) {
			rocketship.left = false;
		}
		if(e.getKeyCode() == KeyEvent.VK_UP) {
			rocketship.up = false;
		}
		if(e.getKeyCode() == KeyEvent.VK_DOWN) {
			rocketship.down = false;
		}
		if(e.getKeyCode() == KeyEvent.VK_SPACE) {
			spacePressed = false;
		}
	}
	public void updateMenuState() {
		
	}
	public void updateGameState() {
		if(spacePressed == true)
			objectManager.addObject(new Projectile(rocketship.x,rocketship.y,10,10));
		objectManager.update();
		objectManager.manageEnemies();
		objectManager.checkCollision();
		System.out.println(rocketship.isAlive);
		if(rocketship.isAlive == false) {
			currentState = END_STATE;
		}
	}
	public void updateEndState() {
		
	}
	public void drawMenuState(Graphics g) {
		g.setColor(Color.BLUE);
		g.fillRect(0, 0, LeagueInvaders.width, LeagueInvaders.height);
		g.setColor(Color.BLACK);
		g.setFont(font);
		g.drawString("League Invaders", 50, 50);
		//TODO: Add all the fonts;
	}
	public void drawGameState(Graphics g) {
		objectManager.draw(g);
	}
	public void drawEndState(Graphics g) {
		//objectManager.draw(g);
	}
}
