package it.polito.tdp.alien;

import java.util.*;

public class AlienDictionary {
	
	
	private List<Word> dictionary ;
	
	

	
	public AlienDictionary() {
		dictionary = new LinkedList<Word>();
	}




	public void addWord(String aw, String tw) {
		
		Word w = new Word(aw,tw);
		
		//for(Word wtemp : dictionary) {
			//if(wtemp.getAlienWord().compareTo(aw) == 0) PERCHE' NON FUNZIONA ?
		
		if(dictionary.contains(w)) {
				dictionary.get(dictionary.indexOf(w)).setTranslation(tw);
			return;
		}
		
		dictionary.add(w);
		
	}
	
	public String translateWord(String aw) {
		
		Word w = new Word(aw);
		
		
			if(dictionary.contains(w)) {
				// return wtemp.getTranslation();
				//provato a farlo con compareTo delle parole non va !
				return dictionary.get(dictionary.indexOf(w)).getTranslation();
		}
		return null;
	}
}
