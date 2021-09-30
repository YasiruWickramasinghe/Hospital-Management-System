package hms;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import databaseConnection.dataBaseConnection;
import entities.Room;

public class Checkroomclass implements dataBaseConnection{

	public static List<Room> roomlist(String roomtype) {
		
		ArrayList<Room> rm= new ArrayList<>();
		
		//database connection
		String url="jdbc:mysql://localhost/HMS";
		String user="root";
	    String password="";
	    
		//validate
	    try {
	    	Class.forName("com.mysql.jdbc.Driver");
	    	
	    	Connection con =DriverManager.getConnection(url, user, password);
	    	Statement stmt=con.createStatement();
	    	String sql="select roomID from room where availability=0";
	    	ResultSet rs= stmt.executeQuery(sql);
	    	
	    	if(rs.next()) {
	    		String roomid=rs.getString(1);
	    		int availability=rs.getInt(2);
	    		String typefroom=rs.getString(3);
	    		String serviceincharge=rs.getString(4);
	    		
	    		Room R=new Room(roomid, availability, typefroom, serviceincharge);
	    		rm.add(R);
	    		
	    	}
	    }
	    catch(Exception e) {
	    	e.printStackTrace();
	    }
		return rm;
		// TODO Auto-generated constructor stub
	}

}
