/**
 * Sample Skeleton for 'Alien.fxml' Controller Class
 */

package it.polito.tdp.alien;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.*;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class AlienController {

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="txtWord"
    private TextField txtWord; // Value injected by FXMLLoader

    @FXML // fx:id="btnTranslate"
    private Button btnTranslate; // Value injected by FXMLLoader

    @FXML // fx:id="txtResult"
    private TextArea txtResult; // Value injected by FXMLLoader

    @FXML // fx:id="btnReset"
    private Button btnReset; // Value injected by FXMLLoader
    
    private AlienDictionary dictionary = new AlienDictionary();

    @FXML
    void doReset(ActionEvent event) {

    }

    @FXML
    void doTranslate(ActionEvent event) {
    	
    	//txtResult.clear();
		String riga = this.txtWord.getText().toLowerCase();

		if (riga == null || riga.length() == 0) {
			txtResult.setText("Inserire una oppure due parole !");
			return;
		}
		
		StringTokenizer st = new StringTokenizer(riga, " ");
		
		String aWord = st.nextToken();
		
		if(st.hasMoreTokens()) {
			String tWord = st.nextToken();
			
			if(!(aWord.matches("[a-zA-Z]*") || tWord.matches("[a-zA-Z]*") )) {
				this.txtResult.setText("Inserire parole formate da caratteri alfabetici!!");
			return;
			}
			
			aWord.toLowerCase();
			tWord.toLowerCase();
			
			dictionary.addWord(aWord, tWord);
			
			this.txtResult.appendText("Aggiunta parola -"+aWord+"- con traduzione -"+tWord+"- \n");
		}
		else {
			if(!(aWord.matches("[a-zA-Z]*"))){
				this.txtResult.setText("Inserire parole formate da caratteri alfabetici!!");
				return;
			}
			
			aWord.toLowerCase();
			
			this.txtResult.appendText("La traduzine della parola -"+aWord+"- e' "+"-"+
			                       dictionary.translateWord(aWord)+"-\n");
		}
		

    }

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        assert txtWord != null : "fx:id=\"txtWord\" was not injected: check your FXML file 'Alien.fxml'.";
        assert btnTranslate != null : "fx:id=\"btnTranslate\" was not injected: check your FXML file 'Alien.fxml'.";
        assert txtResult != null : "fx:id=\"txtResult\" was not injected: check your FXML file 'Alien.fxml'.";
        assert btnReset != null : "fx:id=\"btnReset\" was not injected: check your FXML file 'Alien.fxml'.";

    }
}
