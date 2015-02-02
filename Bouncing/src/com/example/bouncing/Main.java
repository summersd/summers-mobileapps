package com.example.bouncing;

import android.app.Activity;
import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public class Main extends Activity {
	
	//Field for Animation View
	private AnimationView animationView;
	
	//Sensor Manager for Accelerometer
	private SensorManager sensorManager;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		//Initialize the Animation View
		animationView = (AnimationView)findViewById(R.id.animationView);
		
		//Enable the listener
		enableAcclerometerListening();
	}

	private void enableAcclerometerListening() {
		//Initialize the Sensor Manager
		sensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
		sensorManager.registerListener(sensorEventListener, sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER), sensorManager.SENSOR_DELAY_NORMAL);
	}
	
	//Define the sensorEventListener
	private SensorEventListener sensorEventListener = new SensorEventListener() {
		@Override
		public void onAccuracyChanged(Sensor arg0, int arg1) {
			// TODO Auto-generated method stub
			//Not Used
		}
		
		@Override
		public void onSensorChanged(SensorEvent event) {
			// Gather the x, y, and z values from the accelerometer
			float x = event.values[0];
			float y = event.values[1];
			float z = event.values[2];
			
			//pass the values to the AnimationView object
			animationView.setAX((float) (x * .6));
			animationView.setAY((float) (y * .6));
			animationView.setAZ((float) (z * .6));
			
		}
	};

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
}
