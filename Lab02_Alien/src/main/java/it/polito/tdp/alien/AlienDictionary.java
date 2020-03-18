package it.polito.tdp.alien;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class AlienDictionary {

	private List<WordEnhanced> words = new ArrayList<>();

	public void addWord(String alienWord, String translation) {
		boolean trovato=false;
		for(WordEnhanced w:words) {
			if(w.getAlienWord().equals(alienWord)) {
				w.addTranslation(translation);
				trovato=true;
			}
		}
		if(trovato==false) {
			WordEnhanced word=new WordEnhanced(alienWord, translation);
			words.add(word);
		}
	}
	
	public List<String> translateWord(String alienWord) {
		for(WordEnhanced w:words) {
			if(w.getAlienWord().toLowerCase().equals(alienWord.toLowerCase())) {
				return w.getTraduzioni();
			}
		}
		return null;
	}

}
