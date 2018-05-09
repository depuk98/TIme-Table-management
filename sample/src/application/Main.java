package application;

import java.io.FileInputStream;


import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Text;


public class Main extends Application {
	static Stage s1,s2,s3;
	
	
	@Override
	public void start(Stage primaryStage) {
		
		s1=new Stage();
		this.s1=primaryStage;
		//s1.show();
		login();

	}
	
	public void login() {
		try {



			FXMLLoader floader=new FXMLLoader(Main.class.getResource("login.fxml"));
			Parent root = FXMLLoader.load(getClass().getResource("login.fxml"));
			//s1=new Stage();
			s1.setTitle("Log In");
			//closeButton.setDisable(false);
			Scene scene = new Scene(root);
			
			s1.setScene(scene);
			s1.show();
					} catch(Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		launch(args);
	}
}
