package com.example.summerssalestax;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.TextView;

public class MainActivity extends Activity {
	// Fields for UI objects
	private EditText editSale;
	private TextView textTax;
	private SeekBar seekBar;
	private TextView textPercent;
	private TextView textTotal;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		// Bind fields to XML tags
		editSale = (EditText)findViewById(R.id.editSale);
		textTax = (TextView)findViewById(R.id.textTax);
		seekBar = (SeekBar)findViewById(R.id.seekBar);
		textPercent = (TextView)findViewById(R.id.textPercent);
		textTotal = (TextView)findViewById(R.id.textTotal);
				
		
		// Register seekBar with a listener
		seekBar.setMax(100);
		seekBar.setProgress(6);
		seekBar.setOnSeekBarChangeListener(seekBarListener);
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
	
	private OnSeekBarChangeListener seekBarListener = new OnSeekBarChangeListener() {
		
		@Override
		public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
			// TODO Auto-generated method sub
			
			// Get value from Seekbar, display, and call getTax function
			int percent = seekBar.getProgress();
			String percentString = String.valueOf(percent);
			textPercent.setText(percentString);
			textTax.setText(getTax(percent));
		}
		
		@Override
		public void onStartTrackingTouch(SeekBar arg0) {
			//TODO Auto-generated method stub
		
		}
		
		@Override
		public void onStopTrackingTouch(SeekBar arg0) {
			// TODO Auto-generated method stub
			
		}
	};
	
	// Calculate Sales Tax
	private String getTax(int percent) {
		// Get value from editSale
		double bill = Double.valueOf(editSale.getText().toString());
		double tax = bill * (Double.valueOf(percent)/100);
		String taxString = String.valueOf(tax);
		
		textTotal.setText(String.valueOf(bill + tax));
		
		return taxString;
		
		
	}
}
