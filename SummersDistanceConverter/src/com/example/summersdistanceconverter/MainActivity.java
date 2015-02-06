package com.example.summersdistanceconverter;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
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
	
	public void handleClick(View v) {
		//Boolean object - which button was checked
		boolean checked = ((RadioButton) v).isChecked();
		
		EditText text1 = (EditText)findViewById(R.id.editDistance);
		double distance = Double.parseDouble(String.valueOf(text1.getText()));
		
		//Which button was clicked
		switch(v.getId()) {
		case R.id.radioMiles:
			if (checked) {
				String miles = kmToMiles(distance);
				text1.setText(miles);
			}
			break;
			
		case R.id.radioKilometers:
			if (checked) {
				String kilos = milesToKm(distance);
				text1.setText(kilos);
			}
			break;
			
		}
	}

	private String milesToKm(double distance) {
		double kilos = distance*1.609;
		return String.valueOf(kilos);
	}

	private String kmToMiles(double distance) {
		double miles = distance/1.609;
		return String.valueOf(miles);
	}
}
