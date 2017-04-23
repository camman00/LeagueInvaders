package me.cam.leagueinvaders;

import java.awt.Graphics;

public class GameObject {
	protected int x;
	protected int y;
	private int width = 100;
	private int height = 100;
	protected boolean isAlive;
	public GameObject(int x,int y,int width,int height) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
	}
	public void update() {

	}
	public void draw(Graphics g) {
		paintComponent(g);
	}
	public void paintComponent(Graphics g) {
		g.fillRect(x, y, width,height);
	}
	public int getX() {
		return x;
	}
	public int getY() {
		return y;
	}

}
