package it.polito.tdp.alien;

import java.net.URL;
import java.security.InvalidParameterException;
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

	}

	@FXML
	void doTranslate(ActionEvent event) {

		String parola = txtParola.getText();
		for(char c:parola.toCharArray()) {
			if(!(Character.isAlphabetic(c) || c==' ')) {
				throw new InvalidParameterException("Puoi inserire solo lettere");
			}
		}
		if (parola.contains(" ")) {
			int indice = parola.indexOf(" ");
			String alienWord = parola.substring(0, indice);
			String translation = parola.substring(indice + 1);
			al.addWord(alienWord, translation);
		} else {
			String tradotta = al.translateWord(parola);
			if (tradotta==null) {
				txtRisultati.appendText("\nparola non inserita nel dizionario!");
			} else {
				txtRisultati.appendText("\n" + tradotta);
			}
		}

	}

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
