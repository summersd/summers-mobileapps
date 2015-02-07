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
		EditText text2 = (EditText)findViewById(R.id.editArea);
		double area = Double.parseDouble(String.valueOf(text2.getText()));
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
			
		case R.id.radioAcres:
			if (checked) {
				String acres = acresToSm(area);
				text2.setText(acres);
			}
			break;
			
		case R.id.radioSquareMiles:
			if (checked) {
				String sm = smToAcres(area);
				text2.setText(sm);
			}
			break;	
		}
	}
	
	public void resetClicked(View v) {
		EditText text1 = (EditText)findViewById(R.id.editDistance);
		EditText text2 = (EditText)findViewById(R.id.editArea);
		text1.setText("0");
		text2.setText("0");
	}

	private String smToAcres(double area) {
		double acres = area*640;
		return String.valueOf(acres);
	}

	private String acresToSm(double area) {
		double sm = area/640;
		return String.valueOf(sm);
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
