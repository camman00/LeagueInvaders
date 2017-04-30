package me.cam.leagueinvaders;

import javax.swing.JFrame;

public class LeagueInvaders {
	private JFrame jFrame;
	public static final int width = 500;
	public static final int height = 800;
	private GamePanel gamePanel;
	public static void main(String[] args) {
		LeagueInvaders leagueInvaders = new LeagueInvaders();
	}
	public LeagueInvaders() {
		jFrame = new JFrame();
		gamePanel = new GamePanel();
		gamePanel.startGame();
		setup();
	}
	@SuppressWarnings("static-access")
	private void setup() {
		jFrame.add(gamePanel);
		jFrame.addKeyListener(gamePanel);
		jFrame.setSize(width, height);
		jFrame.setDefaultCloseOperation(jFrame.EXIT_ON_CLOSE);
		jFrame.setVisible(true);
	}

}
