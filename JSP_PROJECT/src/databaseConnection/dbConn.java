package databaseConnection;

import java.sql.*;

public class dbConn implements dataBaseConnection {//returns connection object
	public static Connection returnConn() {
		Connection retConn = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection(connUrl, uname, password);
			retConn = conn;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return retConn;

	}

}
