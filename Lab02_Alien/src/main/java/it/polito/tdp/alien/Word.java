package it.polito.tdp.alien;

public class Word {

	private String alienWord;
	private String translation;
	
	
	/**
	 * costruttore di Word
	 * @param alienWord parola aliena
	 * @param translation traduzione della parola aliena
	 */
	public Word(String alienWord, String translation) {
		super();
		this.alienWord = alienWord;
		this.translation = translation;
	}
	
	public String getAlienWord() {
		return alienWord;
	}



	public void setAlienWord(String alienWord) {
		this.alienWord = alienWord;
	}



	public String getTranslation() {
		return translation;
	}



	public void setTranslation(String translation) {
		this.translation = translation;
	}



	public boolean equals(Object obj) {
		Word w=(Word) obj;
		if(w.alienWord.toLowerCase().equals(this.alienWord.toLowerCase())) {
			return true;
		}else
			return false;
	}
	
}
