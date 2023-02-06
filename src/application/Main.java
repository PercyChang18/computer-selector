package application;
	
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;


public class Main extends Application {
	public static Stage window;

	@Override
	public void start(Stage primaryStage) {
		try {
			
			window = primaryStage;
			BorderPane root = (BorderPane)FXMLLoader.load(getClass().getResource("/view/HomePage.fxml"));
			Scene scene = new Scene(root,1080,630);
			primaryStage.setScene(scene);
			primaryStage.show();
			
			
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
