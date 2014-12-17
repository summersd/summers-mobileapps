package com.example.soundsapp;

import android.app.Activity;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class MainActivity extends Activity {
	//Fields for the Image buttons and stop button
	private ImageButton buttonBell;
	private ImageButton buttonBubbles;
	private ImageButton buttonDoor;
	private ImageButton buttonPlunge;
	private ImageButton buttonPop;
	private ImageButton buttonRipple;
	
	// Stop Button
	private Button buttonStopSounds;
	
	// MediaPlayer Array
	private MediaPlayer soundPlayer [] = new MediaPlayer[6];
	
	private int soundResources [] = {R.raw.belltoll, R.raw.bubbles, R.raw.doorclose, R.raw.plunge, R.raw.pop, R.raw.ripples};
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		// Bind the ImageButton Java objects to the XML Resources
		buttonBell = (ImageButton)findViewById(R.id.buttonBell);
		buttonBubbles = (ImageButton)findViewById(R.id.buttonBubbles);
		buttonDoor = (ImageButton)findViewById(R.id.buttonDoor);
		buttonPlunge = (ImageButton)findViewById(R.id.buttonPlunge);
		buttonPop = (ImageButton)findViewById(R.id.buttonPop);
		buttonRipple = (ImageButton)findViewById(R.id.buttonRipples);
		
		// Initialize MediaPlayer with resources
		for (int i = 0; i < soundPlayer.length; i++) {
			soundPlayer[i] = MediaPlayer.create(this, soundResources[i]);}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
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
	
	// Functions to play sounds	
	public void buttonBellClick(View v) {
		soundPlayer[0].start();
	}
	public void buttonBubblesClick(View v) {
		soundPlayer[1].start();
	}
	public void buttonDoorClick(View v) {
		soundPlayer[2].start();
	}
	public void buttonPlungeClick(View v) {
		soundPlayer[3].start();
	}
	public void buttonPopClick(View v) {
		soundPlayer[4].start();
	}
	public void buttonRippleClick(View v) {
		soundPlayer[5].start();
	}
	
	// Stop All Sounds from Playing
	
	public void stopAllSounds(View v) {
		// Iterate through all the sounds
		for (int s=0; s < soundPlayer.length; s++) {
			if (soundPlayer[s].isPlaying()){
				soundPlayer[s].pause();
				soundPlayer[s].seekTo(0);
			}
		}
	}
}
