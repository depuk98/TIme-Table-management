package application;

import java.sql.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class loginmodel {
	Connection con=null;
	ResultSet rs=null;
	PreparedStatement pst=null;
 public loginmodel(){
	 con=sql_connect.ConnecrDB();
	 if(con==null){
		 System.out.println("not success");
		 System.exit(1);
	 }

 }
	 public boolean isdbcon(){
		 try{
			 return !con.isClosed();
		 }catch(SQLException e){
			 e.printStackTrace();
			 return false;
		 }
	 }
	 public boolean islogin(String email ,String pass, String text) throws SQLException{
		 PreparedStatement prepared=null;
		 ResultSet rs = null;
		 String query="select * from login where email = ? and password = ?";
		 try{



			 prepared = con.prepareStatement("select email,password,status from login where email=?");
			 prepared.setString(1, email);
			 rs = prepared.executeQuery();
			 String orgUname = "", orPass = "",orStat="";
	            while (rs.next()) {
	                orgUname = rs.getString("email");
	                orPass = rs.getString("password");
	                orStat=rs.getString("status");
	            } //end while
	            if (orPass.equals(pass)&&orStat.equals(text)) {
	                //do something
	                return true;

	            } else {
	                //do something
	            	return false;
	            }

		 } catch(Exception e){
			 e.printStackTrace();
			 return false;
		 }
		 finally{
			 prepared.close();
			 rs.close();
		 }
	 }
 }

