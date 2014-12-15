package Tester;

import java.util.ArrayList;
import java.util.List;

public class EnglishToSpanish {
	//Field for List to String Arrays
	private List<String []> dictionary;
	
	public EnglishToSpanish() {
		dictionary = new ArrayList<String []>(0);
		
		//Add words to the dictionary
		addEntry("this", "esta");
		addEntry("dog", "pero");
		addEntry("is", "es");
		addEntry("a", "un");
		addEntry("father", "padre");
	}
	
	//Adds words to the dictionary list
	public void addEntry(String e, String s) {
		String entry [] = {e, s};
		dictionary.add(entry);
	}
	
	//Translate function
	public String translate(String s) {
		String result = ""; //Blank Word
		
		//Search for translation
		for (int w = 0; w < dictionary.size(); w++) {
			if (s.equals(dictionary.get(w)[0])) {
				result = dictionary.get(w)[1]; // get match
			}
		}
		
		if (result.equals("")) {
			result = s; // set to incoming word
		}
		
		return result;
	}
}
