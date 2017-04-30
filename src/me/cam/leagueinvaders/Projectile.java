package me.cam.leagueinvaders;

import java.awt.Color;
import java.awt.Graphics;

public class Projectile extends GameObject {
	public Projectile(int x, int y, int width, int height) {
		super(x, y, width, height);
		this.width = width;
		this.height = height;
	}
	private int width;
	private int height;
	private int speed = 10;
	@Override
	public void draw(Graphics g) {
		g.setColor(Color.RED);
		g.fillRect(x + width * 2, y, width, height);
		
	}
	@Override
	public void update() {
		y -= speed;
		if(y < 0)
			isAlive = false;
	}
	

}
