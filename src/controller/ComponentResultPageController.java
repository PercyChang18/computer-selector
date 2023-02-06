package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import model.classes.Component;

public class ComponentResultPageController extends ControllerAbs{

	@FXML
    private HBox cpuResultBox;

    @FXML
    private HBox graphicsResultBox;

    @FXML
    private HBox memoryResultBox;

    @FXML
    private HBox coolingResultBox;

    @FXML
    private HBox storageResultBox;

    @FXML
    private HBox motherboardResultBox;
    
    @FXML 
    private Label preferenceLbl;
    
    @FXML
    private Label cpuBudgetLbl;
    
    @FXML
    private Label graphicBudgetLbl;
    
    @FXML
    private Label memoryBudgetLbl;
    
    @FXML
    private Label coolingBudgetLbl;
    
    @FXML
    private Label storageBudgetLbl;
    
    @FXML
    private Label motherboardBudgetLbl;
    
    public static List<Component> cpuResult = new ArrayList<Component>();
    public static List<Component> graphicsResult = new ArrayList<Component>();
    public static List<Component> memoryResult = new ArrayList<Component>();
    public static List<Component> coolingResult = new ArrayList<Component>();
    public static List<Component> storageResult = new ArrayList<Component>();
    public static List<Component> motherboardResult = new ArrayList<Component>();
    public static String preferences = "";
    public static String cpuBudget = "";
    public static String graphicBudget = "";
    public static String memoryBudget = "";
    public static String coolingBudget = "";
    public static String storageBudget = "";
    public static String motherboardBudget = "";
    
    
    //Initialize the component result page with all information.
    @FXML
    public void initialize() {
    	
    	try {
    		
    		//Display preferences and budgets.
    		preferenceLbl.setText(preferences);
    		cpuBudgetLbl.setText(cpuBudget);
    		graphicBudgetLbl.setText(graphicBudget);
    		memoryBudgetLbl.setText(memoryBudget);
    		coolingBudgetLbl.setText(coolingBudget);
    		storageBudgetLbl.setText(storageBudget);
    		motherboardBudgetLbl.setText(motherboardBudget);
			
    		
    		//Display CPU result. If not, display a message to the user.
    		if (cpuResult.size() == 0) {
	    		Label l = new Label();
	    		l.setText("Sorry, No Result For Your Search...");
	    		l.setFont(new Font("Arial", 28));
	    		l.setTextFill(Color.RED);
	    		
	    		cpuResultBox.getChildren().add(l);
	    		
	    	} else {
	    		for (int i = 0; i < cpuResult.size(); i ++) {
		    		FXMLLoader loader = new FXMLLoader();
		    		loader.setLocation(getClass().getResource("../view/ComponentResult.fxml"));
		    		
		    		AnchorPane cpuBox = loader.load();
		    		ComponentResultController crc = loader.getController();
		    		crc.setData(cpuResult.get(i));
		    		cpuResultBox.getChildren().add(cpuBox);
		    		
		    	}
	    	}
	    	
    		
    		//Display graphics result. If not, display a message to the user.
    		if (graphicsResult.size() == 0) {
	    		Label l = new Label();
	    		l.setText("Sorry, No Result For Your Search...");
	    		l.setFont(new Font("Arial", 28));
	    		l.setTextFill(Color.RED);
	    		
	    		graphicsResultBox.getChildren().add(l);
	    		
	    	} else {
		    	for (int i = 0; i < graphicsResult.size(); i ++) {
		    		FXMLLoader loader = new FXMLLoader();
		    		loader.setLocation(getClass().getResource("../view/ComponentResult.fxml"));
		    		
		    		AnchorPane graphicsBox = loader.load();
		    		ComponentResultController crc = loader.getController();
		    		crc.setData(graphicsResult.get(i));
		    		graphicsResultBox.getChildren().add(graphicsBox);
		    		
		    	}
	    	}
    		
    		
    		//Display memory result. If not, display a message to the user.
    		if (memoryResult.size() == 0) {
	    		Label l = new Label();
	    		l.setText("Sorry, No Result For Your Search...");
	    		l.setFont(new Font("Arial", 28));
	    		l.setTextFill(Color.RED);
	    		
	    		memoryResultBox.getChildren().add(l);
	    		
	    	} else {
		    	for (int i = 0; i < memoryResult.size(); i ++) {
		    		FXMLLoader loader = new FXMLLoader();
		    		loader.setLocation(getClass().getResource("../view/ComponentResult.fxml"));
		    		
		    		AnchorPane memoryBox = loader.load();
		    		ComponentResultController crc = loader.getController();
		    		crc.setData(memoryResult.get(i));
		    		memoryResultBox.getChildren().add(memoryBox);
		    		
		    	}
	    	}
	    	
    		
    		//Display cooling result. If not, display a message to the user.
    		if (coolingResult.size() == 0) {
	    		Label l = new Label();
	    		l.setText("Sorry, No Result For Your Search...");
	    		l.setFont(new Font("Arial", 28));
	    		l.setTextFill(Color.RED);
	    		
	    		coolingResultBox.getChildren().add(l);
	    		
	    	} else {
		    	for (int i = 0; i < coolingResult.size(); i ++) {
		    		FXMLLoader loader = new FXMLLoader();
		    		loader.setLocation(getClass().getResource("../view/ComponentResult.fxml"));
		    		
		    		AnchorPane coolingBox = loader.load();
		    		ComponentResultController crc = loader.getController();
		    		crc.setData(coolingResult.get(i));
		    		coolingResultBox.getChildren().add(coolingBox);
		    		
		    	}
	    	}
    		
    		
    		//Display storage result. If not, display a message to the user.
    		if (storageResult.size() == 0) {
	    		Label l = new Label();
	    		l.setText("Sorry, No Result For Your Search...");
	    		l.setFont(new Font("Arial", 28));
	    		l.setTextFill(Color.RED);
	    		
	    		storageResultBox.getChildren().add(l);
	    		
	    	} else {
		    	for (int i = 0; i < storageResult.size(); i ++) {
		    		FXMLLoader loader = new FXMLLoader();
		    		loader.setLocation(getClass().getResource("../view/ComponentResult.fxml"));
		    		
		    		AnchorPane storageBox = loader.load();
		    		ComponentResultController crc = loader.getController();
		    		crc.setData(storageResult.get(i));
		    		storageResultBox.getChildren().add(storageBox);
		    		
		    	}
	    	}
	    	
    		
    		//Display motherboard result. If not, display a message to the user.
    		if (motherboardResult.size() == 0) {
	    		Label l = new Label();
	    		l.setText("Sorry, No Result For Your Search...");
	    		l.setFont(new Font("Arial", 28));
	    		l.setTextFill(Color.RED);
	    		
	    		motherboardResultBox.getChildren().add(l);
	    		
	    	} else {
		    	for (int i = 0; i < motherboardResult.size(); i ++) {
		    		FXMLLoader loader = new FXMLLoader();
		    		loader.setLocation(getClass().getResource("../view/ComponentResult.fxml"));
		    		
		    		AnchorPane motherboardBox = loader.load();
		    		ComponentResultController crc = loader.getController();
		    		crc.setData(motherboardResult.get(i));
		    		motherboardResultBox.getChildren().add(motherboardBox);
		    		
		    	}
	    	}
	    	
    	} catch (IOException e) {
			
			e.printStackTrace();
		}
    }
}
