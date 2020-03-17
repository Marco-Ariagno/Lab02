package it.polito.tdp.alien;

import java.util.ArrayList;
import java.util.List;

public class AlienDictionary {

	private List<Word> words = new ArrayList<>();

	public void addWord(String alienWord, String translation) {
		Word w = new Word(alienWord, translation);
		boolean trovata = false;
		for (Word wo : words) {
			if (wo.equals(w)) {
				wo.setTranslation(translation);
				trovata = true;
			}
		}
		if (trovata == false) {
			words.add(w);
		}
	}
	
	public String translateWord(String alienWord) {
		for(Word w:words) {
			if(w.getAlienWord().toLowerCase().equals(alienWord.toLowerCase())) {
				return w.getTranslation();
			}
		}
		return null;
	}

}
