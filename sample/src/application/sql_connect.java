package application;

import java.sql.Connection;
import java.sql.DriverManager;

public class sql_connect {
Connection cin=null;
public static Connection ConnecrDB(){
	try{
		Class.forName("org.sqlite.JDBC");
		Connection con=DriverManager.getConnection("jdbc:sqlite:project.sqlite");
		System.out.println("connected");
		return con;

	}catch(Exception e){
		System.out.println(e);
		return null;
	}


}
}
