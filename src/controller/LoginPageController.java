package controller;

import java.io.IOException;

//import application.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;


public class LoginPageController extends ControllerAbs{
	
	@FXML private Button loginButton;
	@FXML private Button exitButton;
	@FXML private Label loginMessageLabel;
	@FXML private TextField username;
	@FXML private PasswordField password;
	private Stage createNewAccStage = null;
	
	//If the login request is valid, this method will login the user and open the home page.
	public void userLogin(ActionEvent event) throws IOException {
		
		boolean validLogin = checkLogin();
		if (!validLogin) {
			return;
		} 
		
		getHomePage();
	}
	
	
	//This method gets the username and password input by the user and sends it to the model layer.
	//The methods in the model layer will check whether the username and password are valid and match
	//with the account in the database. If the result is valid, the user has logged in successfully 
	//and can go to the home page.
	private boolean checkLogin() {
		
		boolean valid = (model.classes.DatabaseReader.findEntry(
				model.classes.DatabaseWriter.wrapUserInfo(username.getText(), password.getText()),
				model.classes.DatabaseReader.readArray("src/model/data/userdata.json"))
				!= null);
		
		if (!valid) {
			loginMessageLabel.setText("Wrong");
		} else {
			loginMessageLabel.setText("Valid!");
		}
		
		return valid;
		
	}
	
	
	//This method let the user close the window and exit the application.
	public void exit(ActionEvent event) throws IOException {
		
		Stage stage = (Stage) exitButton.getScene().getWindow();
        stage.close();
		
	}
	
	
	//This method open a new window for user to create a new account.
	public void createNewAccount(ActionEvent event) throws IOException
	{
		BorderPane createNewAccPane = (BorderPane)FXMLLoader.load(getClass().getResource("/view/CreateAccountPage.fxml"));
		Scene createNewAccScene = new Scene(createNewAccPane,600,400);
		
		if(createNewAccStage == null || !createNewAccStage.isShowing())
		{
			createNewAccStage = new Stage();
			createNewAccStage.setScene(createNewAccScene);
			createNewAccStage.show();
		}
		else
			createNewAccStage.toFront();
	}
	
}
