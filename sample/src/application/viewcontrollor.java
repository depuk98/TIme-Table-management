package application;

import com.jfoenix.controls.JFXTreeTableColumn;
import com.jfoenix.controls.datamodels.treetable.RecursiveTreeObject;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.FlowPane;
import com.jfoenix.controls.JFXTreeTableView;
import com.jfoenix.controls.RecursiveTreeItem;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeTableColumn;
import javafx.util.Callback;

public class viewcontrollor  {
	ArrayList<course> roomBooked = new ArrayList<course>();
	@FXML
	TextField text,serch;
	@FXML
	private Label leb,ok;
	@FXML

    public void view(){
    String s=text.getText();
    String str=student.search(s, roomBooked);
    leb.setText(str);
    }
    public void added(){
    String s=serch.getText();
    student.addCourse(s,roomBooked);
    ok.setText("Added");
    }
}
