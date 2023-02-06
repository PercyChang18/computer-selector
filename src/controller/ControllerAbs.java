package controller;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public abstract class ControllerAbs {

	public Stage primaryStage = application.Main.window;
	
	
	//This method changes the scene to the login page
	public void getLoginPage() throws IOException {
		
		BorderPane loginPane = (BorderPane)FXMLLoader.load(getClass().getResource("../view/LoginPage.fxml"));
		Scene loginScene = new Scene(loginPane, 1080, 630);
		
		primaryStage.setScene(loginScene);
		primaryStage.show();
		
	}
	
	
	//This method changes the scene to the home page
	public void getHomePage() throws IOException {
		
		BorderPane homePane = (BorderPane)FXMLLoader.load(getClass().getResource("../view/HomePage.fxml"));
		Scene homeScene = new Scene(homePane, 1080, 630);
		
		primaryStage.setScene(homeScene);
		primaryStage.show();
	}
	
	
	//This method changes the scene to the search component page
	public void getSearchComponentPage() throws IOException {
		
		BorderPane searchComponentPage = (BorderPane)FXMLLoader.load(getClass().getResource("../view/SearchComponentPage.fxml"));
		Scene searchComponentScene = new Scene(searchComponentPage, 1080, 630);
		
		primaryStage.setScene(searchComponentScene);
		primaryStage.show();
	}
	
	//This method changes the scene to the search full page
	public void getSearchFullPage() throws IOException {
		
		BorderPane searchFullPage = (BorderPane)FXMLLoader.load(getClass().getResource("../view/SearchFullPage.fxml"));
		Scene searchFullScene = new Scene(searchFullPage, 1080, 630);
		
		primaryStage.setScene(searchFullScene);
		primaryStage.show();
	}
	
	//This method changes the scene to the PreBuilt result page
	public void getPreBuiltResultPage() throws IOException {
		
		BorderPane preBuiltResultPage = (BorderPane)FXMLLoader.load(getClass().getResource("../view/PreBuiltResultPage.fxml"));
		Scene preBuiltResultScene = new Scene(preBuiltResultPage, 1080, 630);
		
		primaryStage.setScene(preBuiltResultScene);
		primaryStage.show();
	}
	
	//This method changes the scene to the component result page
	public void getComponentResultPage() throws IOException {
		
		BorderPane componentResultPage = (BorderPane)FXMLLoader.load(getClass().getResource("../view/ComponentResultPage.fxml"));
		Scene componentResultScene = new Scene(componentResultPage, 1080, 630);
		
		primaryStage.setScene(componentResultScene);
		primaryStage.show();
	}
}
