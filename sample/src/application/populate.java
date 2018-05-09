package application;

import java.awt.event.ActionEvent;
import java.beans.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

public class populate {
	@FXML
    CheckBox stu,admin,fac;
	
	@FXML
	private TextField email;
	@FXML
	private TextField password;
	@FXML
	public void signup() {
		//stores1.setItems(options);

	    String email1 = email.getText().toString();
	    String password1 = password.getText().toString();
	    String text = null;
	    if(stu.isSelected()){
	    		 text = "Student";
	    }
	    else if(fac.isSelected()){
	    		 text = "Faculty";
	    }
	    else if(admin.isSelected()){
	    		 text = "Admin";
	    }
	    Connection conn;
	    java.sql.Statement stmt = null;

	    try{
	        Class.forName("org.sqlite.JDBC");
	        System.out.print("\nConnecting to database...");
	        conn=DriverManager.getConnection("jdbc:sqlite:project.sqlite");
	        System.out.println(" SUCCESS!\n");
	        stmt = conn.createStatement();
	        stmt.executeUpdate( "INSERT INTO login ('email','password','status') VALUES('"+email1+"','"+password1+"','"+text+"')");
	        //conn.commit();
	        System.out.println(" SUCCESS!\n");
	        conn.close();
	    } catch(Exception e){
			 e.printStackTrace();

	}
	    }
}
