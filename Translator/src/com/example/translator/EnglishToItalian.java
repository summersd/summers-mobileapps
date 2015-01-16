package com.example.translator;

import java.util.ArrayList;
import java.util.List;

public class EnglishToItalian {
		private List<String []> italianDictionary;
		
		public EnglishToItalian() {
			italianDictionary = new ArrayList<String []>(0);
			
			//Add words to the dictionary
			addEntry("this", "questo");
			addEntry("dog", "cane");
			addEntry("is", "e");
			addEntry("a", "un");
			addEntry("father", "padre");
			addEntry("mother", "madre");
			addEntry("kitchen", "cucina");
			addEntry("in", "in");
			addEntry("the", "il");
			addEntry("with", "con");
		}
			
		//Adds words to the dictionary List
		public void addEntry(String e, String i) {
			String entry[] = {e, i};
			italianDictionary.add(entry);
		}
		
		//Return the dictionary object
		public List <String []> getDictionary(){
			return italianDictionary;
		}
}