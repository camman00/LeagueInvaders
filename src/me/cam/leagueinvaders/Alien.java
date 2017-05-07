package me.cam.leagueinvaders;

import java.awt.Color;
import java.awt.Graphics;

public class Alien extends GameObject {
	private int width;
	private int height;
	public Alien(int x, int y, int width, int height) {
		super(x, y, width, height);
		this.width = width;
		this.height = height;
	}
	float ctr = 0;
	@Override
	public void update() {
		super.update();
		y += 5;
		x += Math.cos(ctr);
		ctr += 0.1;
	}
	@Override
	public void draw(Graphics g) {
		g.setColor(Color.YELLOW);
		g.fillRect(x, y, width, height);
	}
	

}
