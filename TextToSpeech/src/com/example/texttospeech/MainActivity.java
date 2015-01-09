package com.example.texttospeech;

import java.util.Locale;
import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.TextView;
import android.speech.tts.TextToSpeech;
import android.text.Editable;

public class MainActivity extends Activity implements TextToSpeech.OnInitListener {
	
	// XML Objects
	private Button speak;
	private Button english;
	private Button french;
	private Button german;
	private Button italian;
	private EditText enterText;
	private SeekBar seekBar;
	private TextView textView;
	
	
	//Variable to store text for speaking
	private String phrase;
	
	//Text to Speech Object
	private TextToSpeech speaker;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		//Bind XML Objects
		speak = (Button)findViewById(R.id.speechButton);
		english = (Button)findViewById(R.id.buttonEnglish);
		french = (Button)findViewById(R.id.buttonFrench);
		german = (Button)findViewById(R.id.buttonGerman);
		italian = (Button)findViewById(R.id.buttonItalian);
		enterText = (EditText)findViewById(R.id.enterText);
		seekBar = (SeekBar)findViewById(R.id.seekBar);
		textView = (TextView)findViewById(R.id.textView);
		
		//Initialize the Text to speech object
		speaker = new TextToSpeech(this, this);
		
		// Register seekBar with a listener
		seekBar.setMax(2);
		seekBar.setProgress(1);
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

	@Override
	public void onInit(int status) {
		// TODO Auto-generated method stub
		
	}
	
	//speak function called by the button
	public void speak(View v) {
				
		//Get Input Text
		Editable input = enterText.getText();
				
		//convert input text into a String
		phrase = input.toString();
		
		//Speaking the phrase aloud
		speaker.speak(phrase, 1, null);
	}

	//set language function called by the buttons
	public void handleClick(View v) {
		switch (v.getId()) {
		case R.id.buttonEnglish:
			speaker.setLanguage(Locale.ENGLISH);
			v.setBackgroundColor(Color.BLUE);
			french.setBackgroundColor(Color.GRAY);
			german.setBackgroundColor(Color.GRAY);
			italian.setBackgroundColor(Color.GRAY);
			break;
		case R.id.buttonFrench:
			speaker.setLanguage(Locale.FRENCH);
			v.setBackgroundColor(Color.BLUE);
			english.setBackgroundColor(Color.GRAY);
			german.setBackgroundColor(Color.GRAY);
			italian.setBackgroundColor(Color.GRAY);
			break;
		case R.id.buttonGerman:
			speaker.setLanguage(Locale.GERMAN);
			v.setBackgroundColor(Color.BLUE);
			french.setBackgroundColor(Color.GRAY);
			english.setBackgroundColor(Color.GRAY);
			italian.setBackgroundColor(Color.GRAY);
			break;
		case R.id.buttonItalian:
			speaker.setLanguage(Locale.ITALIAN);
			v.setBackgroundColor(Color.BLUE);
			french.setBackgroundColor(Color.GRAY);
			german.setBackgroundColor(Color.GRAY);
			english.setBackgroundColor(Color.GRAY);
			break;
		}
	}
	
	private OnSeekBarChangeListener seekBarListener = new OnSeekBarChangeListener() {
		
		@Override
		public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
			// TODO Auto-generated method sub
			
			// Get value from Seekbar, display, and call getTax function
			int pitch = seekBar.getProgress();
			String pitchString = String.valueOf(pitch);
			textView.setText("Set Pitch to: " + pitchString);
			speaker.setPitch(Float.valueOf(pitchString));
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
}
