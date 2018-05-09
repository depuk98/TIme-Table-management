package application;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

import javafx.beans.value.ChangeListener;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class loginController implements Initializable {
	@FXML private javafx.scene.control.Button closeButton;

	@FXML
    CheckBox stu,admin,fac;
	ObservableList<String> options =
			FXCollections.observableArrayList(
			    "Student",
			    "Admin",
			    "Faculty"
			);
	@FXML ComboBox<String> stores;
	@FXML ComboBox<String> stores1;
	@FXML
	public void sign(){
		try {


			FXMLLoader floader=new FXMLLoader(Main.class.getResource("signup.fxml"));
			Parent root = FXMLLoader.load(getClass().getResource("signup.fxml"));
			Stage s1=new Stage();
			s1.setTitle("Sign Up");

			Scene scene = new Scene(root);
			s1.setScene(scene);
			s1.show();
					} catch(Exception e) {
			e.printStackTrace();
		}
	}
	public void closeButtonAction(){
		String	 text = (String) stores.getSelectionModel().getSelectedItem();
		Stage stage = (Stage) closeButton.getScene().getWindow();
		try{
	    // get a handle to the stage

	    // do what you have to do
	    //stage.close();
	    String emai=email.getText();
	    System.out.println(emai);
	    String pass=password.getText();
	    System.out.println(pass);

	    if (login.islogin(emai,pass,text)) {
	    	status.setText("correct");
	    	System.out.println("correct");
	    	if(text.equals("Student")){student();stage.close();}
		    if(text.equals("Admin")){admin();stage.close();}
		    if(text.equals("Faculty")){faculty();stage.close();}
	       }
	else{
		status.setText("incorrect");
		System.out.println("incorrect");
	}
		} catch(SQLException e){
			status.setText("incorrect");
			System.out.println("incorrect");
			e.printStackTrace();
		}

//
	}

	private void faculty() {
		// TODO Auto-generated method stub
try {



			FXMLLoader floader=new FXMLLoader(Main.class.getResource("faculty.fxml"));
			Parent root = FXMLLoader.load(getClass().getResource("faculty.fxml"));
			Stage s1=new Stage();
			s1.setTitle("Faculty");

			Scene scene = new Scene(root);
			s1.setScene(scene);
			s1.show();
					} catch(Exception e) {
			e.printStackTrace();
		}
	}

	private void admin() {
		// TODO Auto-generated method stub
try {



			FXMLLoader floader=new FXMLLoader(Main.class.getResource("admin.fxml"));
			Parent root = FXMLLoader.load(getClass().getResource("admin.fxml"));
			Stage s1=new Stage();
			s1.setTitle("admin");

			Scene scene = new Scene(root);
			s1.setScene(scene);
			s1.show();
					} catch(Exception e) {
			e.printStackTrace();
		}
	}

	private void student() {
		// TODO Auto-generated method stub
try {



			FXMLLoader floader=new FXMLLoader(Main.class.getResource("student.fxml"));
			Parent root = FXMLLoader.load(getClass().getResource("student.fxml"));
			Stage s1=new Stage();
			s1.setTitle("Student");

			Scene scene = new Scene(root);
			s1.setScene(scene);
			s1.show();
					} catch(Exception e) {
			e.printStackTrace();
		}
	}
	public loginmodel login=new loginmodel();
	@FXML
	private Label status;
	@FXML
	private TextField email;
	@FXML
	private TextField password;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		stores.setItems(options);
		if(login.isdbcon()){
			//status.setText("Connected");
		}
		else{
			//status.setText("not Connected");
		}
	}

}

