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
import model.classes.Component;

public class SearchComponentController extends ControllerAbs 
{
    @FXML
    Button searchButton;
    @FXML
    Button backButton;
    @FXML
    Label searchErrorLabel;
    
    // Checkbox
    @FXML
    CheckBox Coding;
    @FXML
    CheckBox GraphicDesign;
    @FXML
    CheckBox Student;
    @FXML
    CheckBox Gaming;
    
    // Textfield
    @FXML
    TextField cpuBudgetTextField;     
    @FXML
    TextField memoryBudgetTextField;
    @FXML
    TextField graphicsBudgetTextField;
    @FXML
    TextField coolingBudgetTextField;
    @FXML
    TextField storageBudgetTextField;
    @FXML
    TextField motherboardBudgetTextField;
    
    // Store the budgets for each component
    private double cpuBudget, memoryBudget, graphicsBudget, coolingBudget, storageBudget, motherboardBudget; 
    
    
    private ArrayList<String> isSelected = new ArrayList<String>();
    
    /**
     * This method gets the budget value and which checkbox is checked, then goes to the component result page
     * 
     * @param event
     * @throws IOException
     */
    public void searchButtonOnAction(ActionEvent event) throws IOException 
    {
        if (cpuBudgetTextField.getText().trim().isEmpty() || memoryBudgetTextField.getText().trim().isEmpty() || graphicsBudgetTextField.getText().trim().isEmpty() || coolingBudgetTextField.getText().trim().isEmpty() || storageBudgetTextField.getText().trim().isEmpty() || motherboardBudgetTextField.getText().trim().isEmpty()) 
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
        		cpuBudget = Double.parseDouble(cpuBudgetTextField.getText());
        
        	} catch(NumberFormatException e) {
        		cpuBudgetTextField.setText("");
        		searchErrorLabel.setText("Please input number only!");
        		return;
        	}
        	
        	try {
        		memoryBudget = Double.parseDouble(memoryBudgetTextField.getText());
        	} catch(NumberFormatException e) {
        		memoryBudgetTextField.setText("");
        		searchErrorLabel.setText("Please input number only!");
        		return;
        	}
        	
        	try {
        		graphicsBudget = Double.parseDouble(graphicsBudgetTextField.getText());
        	} catch(NumberFormatException e) {
        		graphicsBudgetTextField.setText("");
        		searchErrorLabel.setText("Please input number only!");
        		return;
        	}
        	
        	try {
        		coolingBudget = Double.parseDouble(coolingBudgetTextField.getText());
        	} catch(NumberFormatException e) {
        		coolingBudgetTextField.setText("");
        		searchErrorLabel.setText("Please input number only!");
        		return;
        	}
        	
        	try {
        		storageBudget = Double.parseDouble(storageBudgetTextField.getText());
        	} catch(NumberFormatException e) {
        		storageBudgetTextField.setText("");
        		searchErrorLabel.setText("Please input number only!");
        		return;
        	}
        	
        	try {
        		motherboardBudget = Double.parseDouble(motherboardBudgetTextField.getText());
        	} catch(NumberFormatException e) {
        		motherboardBudgetTextField.setText("");
        		searchErrorLabel.setText("Please input number only!");
        		return;
        	}
        	
        	searchErrorLabel.setText("Success!");
        	
        	CheckBox[] checkbox = {Gaming, GraphicDesign, Student, Coding}; 
        	
        	for (CheckBox cb: checkbox) {
        		if (cb.isSelected())
        			isSelected.add(cb.getText());
        	}
        	setResultComponent();
        	setPreferenceText();
        	setBudgetText();
        	
        	initializeResultPage();
        	getComponentResultPage();
        }
    }
    
    
    /**
     * This method initializes the result page
     */
    public void initializeResultPage() throws IOException
    {    
    	FXMLLoader loader = new FXMLLoader(getClass().getResource("../view/ComponentResultPage.fxml"));
    	loader.load();
    	ComponentResultPageController crc = loader.getController();
    	
    	crc.initialize();
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
    	ComponentResultPageController.preferences = preferences;
    }
    
    
    //This method set the budgets of the result page.
    private void setBudgetText() {
    	DecimalFormat df = new DecimalFormat("#.##");
    	ComponentResultPageController.cpuBudget = "Budget: $" + df.format(cpuBudget);
    	ComponentResultPageController.graphicBudget = "Budget: $" + df.format(graphicsBudget);
    	ComponentResultPageController.memoryBudget = "Budget: $" + df.format(memoryBudget);
    	ComponentResultPageController.coolingBudget = "Budget: $" + df.format(coolingBudget);
    	ComponentResultPageController.storageBudget = "Budget: $" + df.format(storageBudget);
    	ComponentResultPageController.motherboardBudget = "Budget: $" + df.format(motherboardBudget);
    }
    
    
    //This method set the result components of the result page.
    private void setResultComponent() {
    	ComponentResultPageController.cpuResult = cpuList();
    	ComponentResultPageController.graphicsResult = graphicsList();
    	ComponentResultPageController.memoryResult = memoryList();
    	ComponentResultPageController.coolingResult = coolingList();
    	ComponentResultPageController.storageResult = storageList();
    	ComponentResultPageController.motherboardResult = motherboardList();
    }
    
    
    //This method get the CPU base on user preferences and budget, return a list of CPUs.
    private List<Component> cpuList() {
    	List<Component> ls = new ArrayList<>();
    	
    	for (int i = 0; i < isSelected.size(); i ++) {
    		JSONArray ja = model.classes.DatabaseReader.readArray("src/model/data/ComponentData.json");
			
			@SuppressWarnings("unchecked")
			Iterator<JSONObject> iter = ja.iterator();
			
			while (iter.hasNext()) {
				JSONObject temp = (JSONObject) iter.next().get(isSelected.get(i));
				if (temp != null) {
					String category = (String) temp.get("Category");
					if (category.equals("CPU"))
					{
						String price = (String) temp.get("Price");
						double priceDouble = Double.parseDouble(price.substring(1));
						if (priceDouble <= cpuBudget) {
							String name = (String) temp.get("Name");
							String spec1 = (String) temp.get("Spec1");
							String spec2 = (String) temp.get("Spec2");
							String spec3 = (String) temp.get("Spec3");
							String imgSrc = (String) temp.get("Image");
							String link = (String) temp.get("Link");
							
							Component c = new Component();
							c.setCategory(category);
							c.setName(name);
							c.setPrice(price);
							c.setSpec1(spec1);
							c.setSpec2(spec2);
							c.setSpec3(spec3);
							c.setImgSrc(imgSrc);
							c.setLink(link);
							ls.add(c);
						}
					}
				}
			}
    	}
    	
    	return ls;
    }
    
    //This method get the memory base on user preferences and budget, return a list of memories.
    private List<Component> memoryList() {
    	List<Component> ls = new ArrayList<>();
    	
    	for (int i = 0; i < isSelected.size(); i ++) {
    		JSONArray ja = model.classes.DatabaseReader.readArray("src/model/data/ComponentData.json");
			
			@SuppressWarnings("unchecked")
			Iterator<JSONObject> iter = ja.iterator();
			
			while (iter.hasNext()) {
				JSONObject temp = (JSONObject) iter.next().get(isSelected.get(i));
				if (temp != null) {
					String category = (String) temp.get("Category");
					if (category.equals("Memory"))
					{
						String price = (String) temp.get("Price");
						double priceDouble = Double.parseDouble(price.substring(1));
						if (priceDouble <= memoryBudget) {
							String name = (String) temp.get("Name");
							String spec1 = (String) temp.get("Spec1");
							String spec2 = (String) temp.get("Spec2");
							String spec3 = (String) temp.get("Spec3");
							String imgSrc = (String) temp.get("Image");
							String link = (String) temp.get("Link");
							
							Component c = new Component();
							c.setCategory(category);
							c.setName(name);
							c.setPrice(price);
							c.setSpec1(spec1);
							c.setSpec2(spec2);
							c.setSpec3(spec3);
							c.setImgSrc(imgSrc);
							c.setLink(link);
							ls.add(c);
						}
					}
				}
			}
    	}
    	
    	return ls;
    }
    
    
    //This method get the graphics base on user preferences and budget, return a list of graphics.
    private List<Component> graphicsList() {
    	List<Component> ls = new ArrayList<>();
    	
    	for (int i = 0; i < isSelected.size(); i ++) {
    		JSONArray ja = model.classes.DatabaseReader.readArray("src/model/data/ComponentData.json");
			
			@SuppressWarnings("unchecked")
			Iterator<JSONObject> iter = ja.iterator();
			
			while (iter.hasNext()) {
				JSONObject temp = (JSONObject) iter.next().get(isSelected.get(i));
				if (temp != null) {
					String category = (String) temp.get("Category");
					if (category.equals("Graphic Card"))
					{
						String price = (String) temp.get("Price");
						double priceDouble = Double.parseDouble(price.substring(1));
						if (priceDouble <= graphicsBudget) {
							String name = (String) temp.get("Name");
							String spec1 = (String) temp.get("Spec1");
							String spec2 = (String) temp.get("Spec2");
							String spec3 = (String) temp.get("Spec3");
							String imgSrc = (String) temp.get("Image");
							String link = (String) temp.get("Link");
							
							Component c = new Component();
							c.setCategory(category);
							c.setName(name);
							c.setPrice(price);
							c.setSpec1(spec1);
							c.setSpec2(spec2);
							c.setSpec3(spec3);
							c.setImgSrc(imgSrc);
							c.setLink(link);
							ls.add(c);
						}
					}
				}
			}
    	}
    	
    	return ls;
    }
    
    //This method get the cooling base on user preferences and budget, return a list of coolings.
    private List<Component> coolingList() {
    	List<Component> ls = new ArrayList<>();
    	
    	for (int i = 0; i < isSelected.size(); i ++) {
    		JSONArray ja = model.classes.DatabaseReader.readArray("src/model/data/ComponentData.json");
			
			@SuppressWarnings("unchecked")
			Iterator<JSONObject> iter = ja.iterator();
			
			while (iter.hasNext()) {
				JSONObject temp = (JSONObject) iter.next().get(isSelected.get(i));
				if (temp != null) {
					String category = (String) temp.get("Category");
					if (category.equals("Cooling System"))
					{
						String price = (String) temp.get("Price");
						double priceDouble = Double.parseDouble(price.substring(1));
						if (priceDouble <= coolingBudget) {
							String name = (String) temp.get("Name");
							String spec1 = (String) temp.get("Spec1");
							String spec2 = (String) temp.get("Spec2");
							String spec3 = (String) temp.get("Spec3");
							String imgSrc = (String) temp.get("Image");
							String link = (String) temp.get("Link");
							
							Component c = new Component();
							c.setCategory(category);
							c.setName(name);
							c.setPrice(price);
							c.setSpec1(spec1);
							c.setSpec2(spec2);
							c.setSpec3(spec3);
							c.setImgSrc(imgSrc);
							c.setLink(link);
							ls.add(c);
						}
					}
				}
			}
    	}
    	
    	return ls;
    }
    
    
    //This method get the storage base on user preferences and budget, return a list of storages.
    private List<Component> storageList() {
    	List<Component> ls = new ArrayList<>();
    	
    	for (int i = 0; i < isSelected.size(); i ++) {
    		JSONArray ja = model.classes.DatabaseReader.readArray("src/model/data/ComponentData.json");
			
			@SuppressWarnings("unchecked")
			Iterator<JSONObject> iter = ja.iterator();
			
			while (iter.hasNext()) {
				JSONObject temp = (JSONObject) iter.next().get(isSelected.get(i));
				if (temp != null) {
					String category = (String) temp.get("Category");
					if (category.equals("Storage"))
					{
						String price = (String) temp.get("Price");
						double priceDouble = Double.parseDouble(price.substring(1));
						if (priceDouble <= storageBudget) {
							String name = (String) temp.get("Name");
							String spec1 = (String) temp.get("Spec1");
							String spec2 = (String) temp.get("Spec2");
							String spec3 = (String) temp.get("Spec3");
							String imgSrc = (String) temp.get("Image");
							String link = (String) temp.get("Link");
							
							Component c = new Component();
							c.setCategory(category);
							c.setName(name);
							c.setPrice(price);
							c.setSpec1(spec1);
							c.setSpec2(spec2);
							c.setSpec3(spec3);
							c.setImgSrc(imgSrc);
							c.setLink(link);
							ls.add(c);
						}
					}
				}
			}
    	}
    	
    	return ls;
    }
    
    //This method get the motherboard base on user preferences and budget, return a list of motherboards.
    private List<Component> motherboardList() {
    	List<Component> ls = new ArrayList<>();
    	
    	for (int i = 0; i < isSelected.size(); i ++) {
    		JSONArray ja = model.classes.DatabaseReader.readArray("src/model/data/ComponentData.json");
			
			@SuppressWarnings("unchecked")
			Iterator<JSONObject> iter = ja.iterator();
			
			while (iter.hasNext()) {
				JSONObject temp = (JSONObject) iter.next().get(isSelected.get(i));
				if (temp != null) {
					String category = (String) temp.get("Category");
					if (category.equals("Motherboard"))
					{
						String price = (String) temp.get("Price");
						double priceDouble = Double.parseDouble(price.substring(1));
						if (priceDouble <= motherboardBudget) {
							String name = (String) temp.get("Name");
							String spec1 = (String) temp.get("Spec1");
							String spec2 = (String) temp.get("Spec2");
							String spec3 = (String) temp.get("Spec3");
							String imgSrc = (String) temp.get("Image");
							String link = (String) temp.get("Link");
							
							Component c = new Component();
							c.setCategory(category);
							c.setName(name);
							c.setPrice(price);
							c.setSpec1(spec1);
							c.setSpec2(spec2);
							c.setSpec3(spec3);
							c.setImgSrc(imgSrc);
							c.setLink(link);
							ls.add(c);
						}
					}
				}
			}
    	}
    	
    	return ls;
    }
    
}
