package it.polito.tdp.alien;

import java.util.ArrayList;
import java.util.List;

public class WordEnhanced {

	private String alienWord;
	private List<String> traduzioni=new ArrayList<>();

	/**
	 * costruttore di Word
	 * 
	 * @param alienWord   parola aliena
	 * @param translation traduzione della parola aliena
	 */
	public WordEnhanced(String alienWord, String translation) {
		this.alienWord = alienWord;
		traduzioni.add(translation);
	}

	public void addTranslation(String trans) {
		traduzioni.add(trans);
	}

	public String getAlienWord() {
		return alienWord;
	}

	public void setAlienWord(String alienWord) {
		this.alienWord = alienWord;
	}

	public boolean equals(Object obj) {
		WordEnhanced w = (WordEnhanced) obj;
		if (w.alienWord.toLowerCase().equals(this.alienWord.toLowerCase())) {
			return true;
		} else
			return false;
	}

	public List<String> getTraduzioni() {
		return traduzioni;
	}

	public void setTraduzioni(List<String> traduzioni) {
		this.traduzioni = traduzioni;
	}

}
