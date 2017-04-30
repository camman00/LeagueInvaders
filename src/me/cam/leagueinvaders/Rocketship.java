package me.cam.leagueinvaders;

import java.awt.Color;
import java.awt.Graphics;

public class Rocketship extends GameObject {
	private int width;
	private int height;
	private int speed = 5;
	public boolean up;
	public boolean down;
	public boolean left;
	public boolean right;
	public Rocketship(int x,int y,int width,int height) {
		super(x,y,width,height);
		this.setWidth(width);
		this.setHeight(height);
	}
	public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		this.height = height;
	}
	public int getWidth() {
		return width;
	}
	public void setWidth(int width) {
		this.width = width;
	}
	@Override
	public void update() {
		if(up) {
			this.y -= speed;
		}
		if(down) {
			this.y += speed;
		}
		if(right) {
			this.x += speed;
		}
		if(left) {
			this.x -= speed;
		}
		
	}
	
	
	@Override
	public void draw(Graphics g) {
		g.setColor(Color.BLUE);
		g.fillRect(x, y, width, height);
	}
}
