package application;

import javafx.beans.value.ChangeListener;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

public class studentcontroller {
	@FXML
	Label book,add,avail,view;
	@FXML
	Button logout;
	@FXML
		public void request(){
		Stage stage = (Stage) book.getScene().getWindow();
	    // do what you have to do
	    //stage.close();
	    try {



			FXMLLoader floader=new FXMLLoader(Main.class.getResource("bookroom.fxml"));
			Parent root = FXMLLoader.load(getClass().getResource("bookroom.fxml"));
			Stage s1=new Stage();
			s1.setTitle("Request Room");

			Scene scene = new Scene(root);
			s1.setScene(scene);
			s1.show();
					} catch(Exception e) {
			e.printStackTrace();
		}
		}
	@FXML
	public void addc(){
	Stage stage = (Stage) add.getScene().getWindow();
    // do what you have to do
    //stage.close();
    try {



		FXMLLoader floader=new FXMLLoader(Main.class.getResource("addcourse.fxml"));
		Parent root = FXMLLoader.load(getClass().getResource("addcourse.fxml"));
		Stage s1=new Stage();
		s1.setTitle("Add Courses");

		Scene scene = new Scene(root);
		s1.setScene(scene);
		s1.show();
				} catch(Exception e) {
		e.printStackTrace();
	}
	}

	@FXML
	public void avail(){
	Stage stage = (Stage) avail.getScene().getWindow();
    // do what you have to do
    //stage.close();
    try {



		FXMLLoader floader=new FXMLLoader(Main.class.getResource("roomavailstu.fxml"));
		Parent root = FXMLLoader.load(getClass().getResource("roomavailstu.fxml"));
		Stage s1=new Stage();
		s1.setTitle("Room Availibility");

		Scene scene = new Scene(root);
		s1.setScene(scene);
		s1.show();
				} catch(Exception e) {
		e.printStackTrace();
	}
	}

	@FXML
	public void view(){
	Stage stage = (Stage) view.getScene().getWindow();
    // do what you have to do
    //stage.close();
    try {



		FXMLLoader floader=new FXMLLoader(Main.class.getResource("viewc.fxml"));
		Parent root = FXMLLoader.load(getClass().getResource("viewc.fxml"));
		Stage s1=new Stage();
		s1.setTitle("View Courses");

		Scene scene = new Scene(root);
		s1.setScene(scene);
		s1.show();
				} catch(Exception e) {
		e.printStackTrace();
	}
	}
	public void logout(){
		Stage stage = (Stage) logout.getScene().getWindow();
	    // do what you have to do
	    //stage.close();
	    try {



			FXMLLoader floader=new FXMLLoader(Main.class.getResource("login.fxml"));
			Parent root = FXMLLoader.load(getClass().getResource("login.fxml"));
			Stage s1=new Stage();
			s1.setTitle("Login");

			Scene scene = new Scene(root);
			s1.setScene(scene);
			s1.show();
					} catch(Exception e) {
			e.printStackTrace();
		}
	}
}
