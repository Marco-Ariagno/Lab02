package it.polito.tdp.alien;

import java.net.URL;
import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import it.polito.tdp.alien.model.Model;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class FXMLController {

	private Model model;
	private AlienDictionary al = new AlienDictionary();

	@FXML
	private ResourceBundle resources;

	@FXML
	private URL location;

	@FXML
	private TextField txtParola;

	@FXML
	private Button btnTranslate;

	@FXML
	private TextArea txtRisultati;

	@FXML
	private Button btnReset;

	@FXML
	void doReset(ActionEvent event) {

		txtParola.clear();
		txtRisultati.clear();

	}

	@FXML
	void doTranslate(ActionEvent event) {

		String parola = txtParola.getText();
		for(char c:parola.toCharArray()) {
			if(!(Character.isAlphabetic(c) || c==' ')) {
				txtRisultati.appendText("\nSolo lettere ammesse");
				throw new InvalidParameterException("Puoi inserire solo lettere");
			}
		}
		if (parola.contains(" ")) {
			int indice = parola.indexOf(" ");
			String alienWord = parola.substring(0, indice);
			String translation = parola.substring(indice + 1);
			al.addWord(alienWord, translation);
		} else {
			List<String> tradotta =al.translateWord(parola);
			if (tradotta==null) {
				txtRisultati.appendText("\nparola non inserita nel dizionario!");
			} else {
				String traduz="";
				for(String s: tradotta) {
					traduz=traduz+"\n"+s;
				}
				txtRisultati.appendText("\n" + traduz);
			}
		}

	}
	/*  @FXML
    void doTranslate(ActionEvent event) {
    	
		txtResult.clear();
		String riga = lblTesto.getText().toLowerCase();

		// Controllo sull'input
		if (riga == null || riga.length() == 0) {
			txtResult.setText("Inserire una o due parole.");
			return;
		}

		StringTokenizer st = new StringTokenizer(riga, " ");

		// Controllo su String Tokenizer (superfluo)
		if (!st.hasMoreElements()) {
			txtResult.setText("Inserire una o due parole.");
			return;
		}

		// Estraggo la prima parola
		String alienWord = st.nextToken();

		if (st.hasMoreTokens()) {
			// Devo inserire parola e traduzione nel dizionario

			// Estraggo la seconda parola
			String translation = st.nextToken();

			if (!alienWord.matches("[a-zA-Z]*") || !translation.matches("[a-zA-Z]*")) {
				txtResult.setText("Inserire solo caratteri alfabetici.");
				return;
			}

			// Aggiungo la parola aliena e traduzione nel dizionario
			alienDictionary.addWord(alienWord, translation);

			txtResult.setText("La parola: \"" + alienWord + "\", con traduzione: \"" + translation + "\", è stata inserita nel dizionario.");

		} else {

			// Controllo che non ci siano caratteri non ammessi
			if (!alienWord.matches("[a-zA-Z]*")) {
				txtResult.setText("Inserire solo caratteri alfabetici.");
				return;
			}

			String translation = alienDictionary.translateWord(alienWord);

			if (translation != null) {
				txtResult.setText(translation);
			} else {
				txtResult.setText("La parola cercata non esiste nel dizionario.");
			}
		}
    	
    	

    }*/

	@FXML
	void initialize() {
		assert txtParola != null : "fx:id=\"txtParola\" was not injected: check your FXML file 'Scene.fxml'.";
		assert btnTranslate != null : "fx:id=\"btnTranslate\" was not injected: check your FXML file 'Scene.fxml'.";
		assert txtRisultati != null : "fx:id=\"txtRisultati\" was not injected: check your FXML file 'Scene.fxml'.";
		assert btnReset != null : "fx:id=\"btnReset\" was not injected: check your FXML file 'Scene.fxml'.";

	}

	public void setModel(Model model) {
		this.model = model;
	}
}
