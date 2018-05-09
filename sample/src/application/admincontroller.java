
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
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class admincontroller {
	@FXML
	Label avail,cancel,book,process;
	@FXML
	Button logout;
	@FXML
		public void avail(){
		Stage stage = (Stage) avail.getScene().getWindow();
	    // do what you have to do
	    //stage.close();
	    try {



			FXMLLoader floader=new FXMLLoader(Main.class.getResource("roomavail.fxml"));
			AnchorPane root = (AnchorPane) FXMLLoader.load(Main.class.getResource("/application/roomavail.fxml"));
			Stage s1=new Stage();
			s1.setTitle("Room Availibilty");

			Scene scene = new Scene(root);
			s1.setScene(scene);
			s1.show();
					} catch(Exception e) {
			e.printStackTrace();
		}
		}

	@FXML
	public void cancel(){
	Stage stage = (Stage) cancel.getScene().getWindow();
    // do what you have to do
    //stage.close();
    try {



		FXMLLoader floader=new FXMLLoader(Main.class.getResource("cancelf.fxml"));
		Parent root = FXMLLoader.load(getClass().getResource("cancelf.fxml"));
		Stage s1=new Stage();
		s1.setTitle("Cancel Room");

		Scene scene = new Scene(root);
		s1.setScene(scene);
		s1.show();
				} catch(Exception e) {
		e.printStackTrace();
	}
	}
	@FXML
	public void book(){
	Stage stage = (Stage) book.getScene().getWindow();
    // do what you have to do
    //stage.close();
    try {



		FXMLLoader floader=new FXMLLoader(Main.class.getResource("roomreq.fxml"));
		Parent root = FXMLLoader.load(getClass().getResource("roomreq.fxml"));
		Stage s1=new Stage();
		s1.setTitle("Book Room");

		Scene scene = new Scene(root);
		s1.setScene(scene);
		s1.show();
				} catch(Exception e) {
		e.printStackTrace();
	}
	}

	@FXML
	public void process(){
	Stage stage = (Stage) process.getScene().getWindow();
    // do what you have to do
    //stage.close();
    try {



		FXMLLoader floader=new FXMLLoader(Main.class.getResource("processreq.fxml"));
		Parent root = FXMLLoader.load(getClass().getResource("processreq.fxml"));
		Stage s1=new Stage();
		s1.setTitle("Process Request");

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
