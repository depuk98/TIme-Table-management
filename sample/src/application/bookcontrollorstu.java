package application;

import java.util.ArrayList;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class bookcontrollorstu {
	//ArrayList<RoomBook> roomBooked = new ArrayList<RoomBook>();
	@FXML
	TextField name,day,date,start,end,purpose;
	@FXML
	TextField ven,etime,dat,stime,da;
	@FXML
	TextField start1,end1,venue,day1;
	admin a=null;
	public void bookroom(){
		String s1=name.getText();
		String s2=day.getText();
		String s3=date.getText();
		String s4=start.getText();
		String s5=end.getText();
		String s6=purpose.getText();
		//Admin a=null;


		student.requestRoomBooking(s3,s2,s1,s4,s5,s6,"Student");
	}

	public void avail(){
//		String s1=venue.getText();
//		String s2=end1.getText();
//		String s3=start1.getText();
//		String s4=day1.getText();
		String str=student.roomAvailability(day1.getText(), venue.getText(), start1.getText(), end1.getText());
		System.out.print(str);
	}


}
