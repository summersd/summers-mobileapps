package com.example.countdown;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Countdown extends Activity {

	//Fields
	private TextView textTimer; //Displays the text
	private Button resetButton; //Used to reset the counter
	private Button buttonPausePlay;
	
	private int elapsedTime; //Used to hold the elapsed Time
	private boolean isCounting; 
	
	private Handler h; //The handler
	
	private int RATE = 1000; //in milliseconds - how fast to count
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_countdown);
		
		//Bind to XML
		textTimer = (TextView)findViewById(R.id.textTimer);
		buttonPausePlay = (Button)findViewById(R.id.buttonPausePlay);
		resetButton = (Button)findViewById(R.id.resetButton);
		
		elapsedTime = 61;
		isCounting = true;
		
		//Initialize the Handler
		h = new Handler();
		
		if (elapsedTime > 0){
		count(); //Starts the count
		}
		else {}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.countdown, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
	
	public void reset (View v) {
		elapsedTime = 61;
	}

	public void pauseplay(View v) {
		if (isCounting == true) {
			buttonPausePlay.setText("Play");
			isCounting = false;

		}
		else {
			buttonPausePlay.setText("Pause");
			isCounting = true;
			count();
		}
	}
	
	public void count() {
		elapsedTime--; //decrease the counter by 1
		textTimer.setText(String.valueOf(elapsedTime)); // set the view
		h.postDelayed(r, RATE); //Call the Runnable
	}
	
	//Runnable - calls the count() function to continue the sequence
	private Runnable r = new Runnable() {
		public void run() {
			if (elapsedTime > 0) {
				if (isCounting == true) {
				count(); //calls the count function
				}
				else{}
			}
			else {
				elapsedTime = 61; 
				count();
			}
		}
	}; 
}
