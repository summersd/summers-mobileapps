package com.example.translator;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.speech.tts.TextToSpeech;

public class MainActivity extends Activity  implements TextToSpeech.OnInitListener{
	
	//Define the dictionary field for Translations
	private EnglishToSpanish spanishDictionary;
	private EnglishToItalian italianDictionary;
	
	//Fields for UI
	private EditText editEnglish;
	private EditText editTranslate;
	private Button buttonSpanish;
	private Button buttonItalian;
	private Button buttonAddWord;
	private Button buttonTranslate;
	private Button buttonSpeak;
	private Button buttonClear;
	
	private TextToSpeech speaker;
	
	private boolean isSpanish;
	private boolean isLangClicked = false;
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		// Initialize the dictionary
		spanishDictionary = new EnglishToSpanish();
		italianDictionary = new EnglishToItalian();
		
		//bind to XML objects
		editEnglish = (EditText)findViewById(R.id.editEnglish);
		editTranslate = (EditText)findViewById(R.id.editTranslate);
		buttonSpanish = (Button)findViewById(R.id.buttonSpanish);
		buttonItalian = (Button)findViewById(R.id.buttonItalian);
		buttonTranslate = (Button)findViewById(R.id.buttonTranslate);
		buttonSpeak = (Button)findViewById(R.id.buttonSpeak);
		buttonClear = (Button)findViewById(R.id.buttonClear);
		speaker = new TextToSpeech(this,this);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	
	//returns a list of words parsed from a string
	public List<String> getParsed(String s){
		//establish a blank List to return
		List <String> words = new ArrayList<String>(0);
		//transfer content of s to phrase
		String phrase = s;
		//convert phrase to lower case
		phrase.toLowerCase();
		//define current word
		String currentWord = "";
		//create an array of char objects from string
		char [] charList = phrase.toCharArray();
		
		//for loop to search characters and pull out words
		for (int i = 0; i < charList.length; i++) {
			//is the char not a space
			if (!String.valueOf(charList[i]).equals(" ")) {
				currentWord += String.valueOf(charList[i]);
			}
			else {
				words.add(currentWord);
				currentWord = "";
			}
		}
		
		if (currentWord.length() > 0) {
			words.add(currentWord);
		}
		
		return words;
	}
	
	//Translate a string of words and return a string with translation
	public String translate(String s) {
		String result = "";
		
		//Define a blank list
		List<String> words = getParsed(s);
		//Define a List of available translations
		List<String []> spanishBank = spanishDictionary.getDictionary();
		List<String []> italianBank = italianDictionary.getDictionary();
		
		if (isLangClicked == true) {
			if (isSpanish == true){
				for (int i = 0; i < words.size(); i++){
					// Search for the match in the bank List
					for (int w = 0; w < spanishBank.size(); w++){ 
						if (words.get(i).equals(spanishBank.get(w)[0])){ //match
							result += spanishBank.get(w)[1]; //add translated word to result
							result += " "; //add a space
						}
					}
				}
			}
			
			if (isSpanish == false) {
				for (int i = 0; i < words.size(); i++){
					// Search for the match in the bank List
					for (int w = 0; w < italianBank.size(); w++){ 
						if (words.get(i).equals(italianBank.get(w)[0])){ //match
							result += italianBank.get(w)[1]; //add translated word to result
							result += " "; //add a space
						}
					}
				}
			}
		}
		else {
			AlertDialog.Builder translateError = new AlertDialog.Builder(this);
			translateError.setMessage("Select a Language.");
			translateError.setCancelable(true);
			translateError.setNeutralButton("Ok", new DialogInterface.OnClickListener() {
				 public void onClick(DialogInterface dialog, int id) {
	                    dialog.cancel();
	                }
			});
			AlertDialog error = translateError.create();
            error.show();
		}
		
		return result;
	}
	
	//Functions for Button Clicks
	
	public void buttonLanguage(View v) {
		switch (v.getId()) {
		case R.id.buttonSpanish:
			isSpanish = true;
			isLangClicked = true;
			buttonSpanish.setTextColor(Color.RED);
			buttonItalian.setTextColor(Color.BLACK);
			break;
		case R.id.buttonItalian:
			isSpanish = false;
			isLangClicked = true;
			buttonItalian.setTextColor(Color.RED);
			buttonSpanish.setTextColor(Color.BLACK);
			break;
		}
	}
	
	//Translate single word (or phrase)
	public void buttonTranslate(View v) {
		String english = editEnglish.getText().toString();
		String spanish = translate(english);
		editTranslate.setText(spanish);
	}
	
	// Add english/spanish to dictionary
	public void buttonAddSpanishWordClicked(View v) {
		String english = editEnglish.getText().toString();
		String spanish = editTranslate.getText().toString();
		spanishDictionary.addEntry(english, spanish);
		editEnglish.setText("");
		editTranslate.setText("");
		editEnglish.requestFocus();
	}
	
	public void buttonAddItalianWordClicked(View v) {
		String english = editEnglish.getText().toString();
		String italian = editTranslate.getText().toString();
		italianDictionary.addEntry(english, italian);
		editEnglish.setText("");
		editTranslate.setText("");
		editEnglish.requestFocus();
	}
	
	public void buttonClearClicked(View v) {
		editEnglish.setText("");
		editTranslate.setText("");
		isLangClicked = false;		
		buttonSpanish.setTextColor(Color.BLACK);
		buttonItalian.setTextColor(Color.BLACK);
	}

	public void buttonSpeakClicked(View v) {
		String english = editEnglish.getText().toString();
		String translated = translate(english);
		editTranslate.setText(translated);
		speaker.speak(translated, 1, null);
		speaker.setLanguage(Locale.ITALIAN);
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
}
