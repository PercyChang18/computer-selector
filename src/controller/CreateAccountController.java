package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class CreateAccountController {

    @FXML
    private Button backButton;
    @FXML
    private ImageView brandingImageView;
    @FXML
    private Label errorMessageLabel;
    @FXML
    private TextField usernameTextField;
    @FXML
    private PasswordField enterPasswordField;
    @FXML
    private PasswordField confirmPasswordField;
    @FXML 
    private Button createButton;
    
    private String username = "";
	private String password = "";
	private String confirmPassword = "";

	
	//This method get the username.
    public void getUsername() {
    	username = usernameTextField.getText();
    }
    
    
    //This method get the password.
    public void getPassword() {
    	password = enterPasswordField.getText();
    }
    
    
    //This method get the confirm password.
    public void getConfirmPassword() {
    	confirmPassword = confirmPasswordField.getText();
    }
    
    
    //Check is username and password are greater than 0 character.
    //Also check if password and confirm password is the same.
    public boolean isLegal() {
    	
    	getUsername();
    	getPassword();
    	getConfirmPassword();
    	
        if(username.length() < 1 || password.length() < 1 || confirmPassword.length() < 1)
        {
            errorMessageLabel.setText("Input cannot be blank!");
            return false;
        } 
        else if (!password.equals(confirmPassword)){
            errorMessageLabel.setText("Password does not match!");
            return false;
        } 
	    
        return true;
        
    }

    
    //This method will call the method from the model package to create a new account.
    public void createButtonOnAction(ActionEvent event) {
        if(isLegal()){
        	
            errorMessageLabel.setText("Congrats!");
            model.classes.DatabaseWriter.writeUserData(usernameTextField.getText(), enterPasswordField.getText(), "src/model/data/userdata.json");
            
            //Close pop-up window.
            Stage stage = (Stage) createButton.getScene().getWindow();
            stage.close();
        }
    }

    //Close pop-up window.
    public void backButtonOnAction(ActionEvent event){
        Stage stage = (Stage) backButton.getScene().getWindow();
        stage.close();
    }

}
