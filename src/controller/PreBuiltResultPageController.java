package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import model.classes.PC;

public class PreBuiltResultPageController extends ControllerAbs {

	    @FXML
	    private VBox resultBox;
	    
	    @FXML
	    private Label preferenceLbl;
	    
	    @FXML
	    private Label budgetLbl;
	    
	    public static List<PC> searchResult = new ArrayList<PC>();
	    public static String preference = "";
	    public static String budget = "";
	    
	   
	    //Initialize the component result page with all information.
	    @FXML
	    public void initialize() {
	    	
	    	try {
	    		//Display preferences and budget.
	    		preferenceLbl.setText(preference);
		    	budgetLbl.setText(budget);
		    	
		    	
		    	//Display PC result. If not, display a message to the user.
		    	if (searchResult.size() == 0) {
		    		Label l = new Label();
		    		l.setText("Sorry, No Result For Your Search...");
		    		l.setFont(new Font("Arial", 28));
		    		l.setTextFill(Color.RED);
		    		
		    		resultBox.getChildren().add(l);
		    		
		    	} else {
		    		for (int i = 0; i < searchResult.size(); i ++) {
		    			int j = i + 1;
			    		FXMLLoader loader = new FXMLLoader();
			    		loader.setLocation(getClass().getResource("../view/PCResult.fxml"));
			    		AnchorPane pcBox = loader.load();
			    		PCResultController pcc = loader.getController();
			    		pcc.setData(searchResult.get(i), j);
			    		resultBox.getChildren().add(pcBox);
			    	}
		    	}
	    		
	    	} catch (IOException e) {
	    		e.printStackTrace();
	    	}
	    
	    }
	    
}
