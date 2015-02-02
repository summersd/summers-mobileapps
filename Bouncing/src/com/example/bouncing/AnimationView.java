package com.example.bouncing;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

public class AnimationView extends View{
	
	//Create Actors 
	private Actor hammer;
	private Actor devin;
	private Actor will;
	private Actor ironman;
	private Actor minion;
	
	//values to hold Accel Data
	private float ax = 0;
	private float ay = 0;
	private float az = 0;
	
	//Create the handler for animation
	private Handler h;
	private int RATE = 30;

	public AnimationView(Context context, AttributeSet attrs) {
		super(context, attrs);
		// TODO Auto-generated constructor stub
		
		//Initialize
		hammer = new Actor(context, 100, 100, Color.RED, 10);
		devin = new Actor(context, 200, 200, Color.BLUE, 20);
		will = new Actor(context, 300, 300, Color.GREEN, 30);
		
		ironman = new Actor(context, 300, 300, Color.BLUE, 40);
		ironman.setCostume(R.drawable.ironman);
		
		minion = new Actor(context, 300, 300, Color.BLACK, 50);
		minion.setCostume(R.drawable.minion);
		
		hammer.setDX(5);
		hammer.setDY(5);
		
		devin.setDX(-10);
		devin.setDY(-10);
		
		will.setDX(25);
		will.setDY(25);
		
		//ironman.setDX(50);
		//ironman.setDY(-10);
		
		minion.setDX(5);
		minion.setDY(5);
		
		h = new Handler();
	}
	
	//Modifier fields for acceleration data on x, y, and z
	public void setAX(float x) {
		ax = x;
	}
	
	public void setAY(float y) {
		ay = y;
	}
	
	public void setAZ(float z) {
		az = z;
	}
	
	public void onDraw(Canvas c) {
		//Actors Move
		//hammer.move();
		devin.move();
		will.move();
		minion.move();
		
		//hammer.bounce(c);
		devin.bounce(c);
		will.bounce(c);
		minion.bounce(c);
		
		//read accel data and move the picture
		ironman.changeDX(ax * -1);
		ironman.changeDY(ay);
		ironman.move();
		ironman.bounce(c);
		
		hammer.drawCircle(c);
		devin.drawSquare(c);
		will.drawCircle(c);
		ironman.draw(c);
		minion.draw(c);
		
		h.postDelayed(r, RATE);
	}
	
	private Runnable r = new Runnable() {
		
		@Override
		public void run() {
			//TODO Auto-generated method stub
			//Call the Invalidate Method to reDraw
			invalidate();
		}
		
	};
	
	//Function to Grab touch event data
	public boolean onTouchEvent(MotionEvent event) {
		//Fetch data from touch event
		int action = event.getActionMasked(); //get type of action
		int actionIndex = event.getActionIndex(); //get index of action
		
		//set position of sandy to touch data
		hammer.goTo((int) event.getX(), (int)event.getY());
		
		return true;
	}
}
