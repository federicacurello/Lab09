/**
 * Skeleton for 'Borders.fxml' Controller Class
 */

package it.polito.tdp.borders;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;

import it.polito.tdp.borders.model.Country;
import it.polito.tdp.borders.model.Model;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class BordersController {

	Model model;
	List<Country> paesi= new ArrayList<Country>();

	@FXML // ResourceBundle that was given to the FXMLLoader
	private ResourceBundle resources;

	@FXML // URL location of the FXML file that was given to the FXMLLoader
	private URL location;

	@FXML // fx:id="txtAnno"
	private TextField txtAnno; // Value injected by FXMLLoader
	
	 @FXML // fx:id="comboBox"
	    private ComboBox<Country> comboBox; // Value injected by FXMLLoader
	 
	 @FXML // fx:id="btnVicini"
	    private Button btnVicini; // Value injected by FXMLLoader

	@FXML // fx:id="txtResult"
	private TextArea txtResult; // Value injected by FXMLLoader

	@FXML
	void doCalcolaConfini(ActionEvent event) {
		int anno= Integer.parseUnsignedInt(txtAnno.getText());
		model.creaGrafo(anno);
		txtResult.setText("Vertici:"+ model.getGrafo().vertexSet().size()+" archi:"+model.getGrafo().edgeSet().size()+"\n");
		Map<Country, Integer> stats = model.getCountryCounts();
		for (Country country : stats.keySet())
			txtResult.appendText( country.toString()+" "+ stats.get(country)+"\n");
		txtResult.appendText("Numero componenti connesse: " +model.getNumberOfConnectedComponents());
		
	}

	@FXML
    void doScegli() {
		paesi= model.loadAllCountries();
		comboBox.getItems().addAll(paesi);

    }
	 @FXML
	    void doTrovaVicini(ActionEvent event) {
		 txtResult.clear();
		 int anno= Integer.parseUnsignedInt(txtAnno.getText());
		 model.creaGrafo(anno);
		 Country input= comboBox.getValue();
		 txtResult.setText("Paesi confinanti: "+ model.trovaVicini(model.getGrafo(), input));
	    }
	@FXML // This method is called by the FXMLLoader when initialization is complete
	void initialize() {
		assert txtAnno != null : "fx:id=\"txtAnno\" was not injected: check your FXML file 'Borders.fxml'.";
		assert txtResult != null : "fx:id=\"txtResult\" was not injected: check your FXML file 'Borders.fxml'.";
		assert comboBox != null : "fx:id=\"comboBox\" was not injected: check your FXML file 'Borders.fxml'.";
		assert btnVicini != null : "fx:id=\"btnVicini\" was not injected: check your FXML file 'Borders.fxml'.";
	}

	public void setModel(Model model) {
		this.model = model;
		this.doScegli();
	}
	
	
}
