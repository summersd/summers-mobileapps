package com.example.bouncing;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;

public class Actor {
	//Fields for Actor
	private Point p; //for Location
	private int c; //for color
	private int s; //for size
	private int w; //for width
	private int h; //for height
	private int dx; //for change in x speed
	private int dy; //for change in y speed
	private Paint paint; //Paint object to hold painter
	
	//Context so Actor can get at graphic resources
	private Context aContext;
	private int costume;
	private BitmapDrawable graphic;
	
	//Constructor
	public Actor(Context context, int x, int y, int col, int size) {
		//Initialize Values
		p = new Point(x, y); //set the x and y position
		c = col; //set the color
		s = size; //set the size
		//w = size;
		//h = size;
		paint = new Paint(); //creates Paint object
		paint.setColor(c);
		dx = 0; //sets x speed to 0
		dy = 0; //sets y speed to 0
		aContext = context;
	}
	
	//Functions
	public void bounce(Canvas c) {		
		if (p.x + h > c.getWidth() || p.x < 0) {
			dx = dx * -1;
		}
		if(p.y + w > c.getHeight() || p.y < 0) {
			dy = dy * -1;
		}
	}
	
	public void bounceActor(Actor a) {
		
	}
	
	public void drawCircle(Canvas c) {
		c.drawCircle(p.x, p.y, s, paint);
	}
	
	public void drawSquare(Canvas c) {
		c.drawRect(p.x, p.y, p.x+s, p.y+s, paint);
	}
	
	//Accessors (getters)
	public int getX() {
		return p.x;
	}
	
	public int getY() {
		return p.y;
	}
	
	public Paint getPaint() {
		return paint;
	}
	
	public int getSize() {
		return s;
	}
	
	public int getWidth() {
		return w;
	}
	
	public int getHeight() {
		return h;
	}
	
	//Modifiers
	public void setColor(int col) {
		c = col;
		paint.setColor(c);
	}
	
	public void goTo(int x, int y) {
		p.x = x;
		p.y = y;
	}
	
	public void setDX(int speed) {
		dx = speed;
	}
	
	public void setDY(int speed) {
		dy = speed;
	}
	
	public void changeDX(float a) {
		dx += a;
	}
	
	public void changeDY(float a) {
		dy += a;
	}
	
	public void move() {
		p.x += dx;
		p.y += dy;
	}

	public void setCostume(int cost){
		costume = cost;
		graphic = (BitmapDrawable)aContext.getResources().getDrawable(costume);
		w = getBitmap().getWidth();
		h = getBitmap().getHeight();
		
	}
	
	public Bitmap getBitmap() {
		return graphic.getBitmap();
	}
	
	public void draw(Canvas c) {
		c.drawBitmap(getBitmap(), p.x, p.y, paint);
	}
	
}
