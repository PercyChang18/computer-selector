package controller;

import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import model.classes.PC;

public class SearchFullController extends ControllerAbs{
    @FXML
    private Button backButton;
    @FXML 
    private Button searchButton;
    @FXML
    private Label searchErrorLabel;
    @FXML
    private CheckBox Gaming;
    @FXML
    private CheckBox Student;
    @FXML
    private CheckBox Coding;
    @FXML
    private CheckBox GraphicDesign;
    @FXML
    private TextField budgetTextField;

    private double budget;
    
    private ArrayList<String> isSelected = new ArrayList<String>();


    //This method get budget and checkbox value, then changes scene to the PreBuilt result page
    public void searchButtonOnAction(ActionEvent event) throws IOException {
        if (budgetTextField.getText().trim().isEmpty())
        {
        	searchErrorLabel.setText("Budget cannot be empty!");
        }
        else if (!Gaming.isSelected() && !Student.isSelected() && !GraphicDesign.isSelected() && !Coding.isSelected())
        {
        	searchErrorLabel.setText("Please check one type of components!");
        }
        else
        {
        	try {
                budget = Double.parseDouble(budgetTextField.getText());
                CheckBox[] checkBox = {Gaming, Student, GraphicDesign, Coding};
                
                for (CheckBox cb: checkBox) {
                  if (cb.isSelected())
                    		isSelected.add(cb.getText());
                }   
                    
            	List<PC> ls = resultPC();
            	setResultPC(ls);
            	setPreferenceText();
            	setBudgetText();
                
            	initializeResultPage();
                getPreBuiltResultPage();
                
            } catch (NumberFormatException e) {
                budgetTextField.setText("");
                searchErrorLabel.setText("Please input number only!");
            }
        }

    }
    
    //This method initialize the result page
    public void initializeResultPage() throws IOException {
	    FXMLLoader loader = new FXMLLoader(getClass().getResource("../view/PreBuiltResultPage.fxml"));
		loader.load();
		PreBuiltResultPageController prc = loader.getController();
		
		prc.initialize();
    }
    
    
    //This method set the user preferences text of the result page.
    private void setPreferenceText() {
    	String preferences = "";
    	for (int i = 0; i < isSelected.size(); i ++) {
    		if (i != isSelected.size() - 1) {
    			preferences += isSelected.get(i).toString() + ", ";
    		} else {
    			preferences += isSelected.get(i).toString();
    		}
    		
    	}
    	
		PreBuiltResultPageController.preference = preferences;
    }
    
    
    //This method set the budget of the result page.	
    private void setBudgetText() {
    	DecimalFormat df = new DecimalFormat("#.##");
		PreBuiltResultPageController.budget = "$" + df.format(budget);
    }
    
    
    //This method set the result PCs of the result page.
    private void setResultPC(List<PC> list) {
    	PreBuiltResultPageController.searchResult = list;
    }
    
    
    //This method gets the PCs base on user preferences and budget, then return the PCs.
    private List<PC> resultPC(){
    	List<PC> ls = new ArrayList<>();
		
		for (int j = 0; j < isSelected.size(); j ++) {
			JSONArray ja = model.classes.DatabaseReader.readArray("src/model/data/Prebuilt.json");
			
			@SuppressWarnings("unchecked")
			Iterator<JSONObject> iter = ja.iterator();
			
			while(iter.hasNext()) {
				JSONObject temp = (JSONObject) iter.next().get(isSelected.get(j));
		        	if (temp != null) {
			        	String price = (String) temp.get("Price");
			        	double priceDouble = Double.parseDouble(price.substring(1).replace(",", ""));
			        	if (checkPriceRange(priceDouble)) {
			        		PC pc = new PC();  
			        		String name = (String) temp.get("PCName");
			    	        String cpu = (String) temp.get("CPU");
			    	        String ram = (String) temp.get("RAM");
			    	        String graphics = (String) temp.get("Graphics");
			    	        String storage = (String) temp.get("Storage");
			    	        String imgSrc = (String) temp.get("Image");
			    	        String link = (String) temp.get("Link");
			    	    
			    	        pc.setName(name);
			    	    	pc.setCpu(cpu);
			    	    	pc.setGraphics(graphics);
			    	    	pc.setRam(ram);
			    	    	pc.setStorage(storage);
			    	    	pc.setPrice(price);
			    	    	pc.setImgSrc(imgSrc);
			    	    	pc.setLink(link);
			    	    	ls.add(pc);
			    	        
			        	}
		 	        	
		        }
			}
    
		}
		
		return ls;
    }
    
    
    //This method checks if the price is lower than the budget.
    private boolean checkPriceRange(double price) {
    	boolean rangeMatch = false;
    	if (price <= budget) {
    		rangeMatch = true;
    	}
    	return rangeMatch;
    }

}
