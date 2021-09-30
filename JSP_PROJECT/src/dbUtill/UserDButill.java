package dbUtill;

import java.sql.Connection;

import java.sql.ResultSet;
import java.sql.Statement;

import databaseConnection.dbConn;
import entities.User;

public class UserDButill {

	// akalanka
	private static void close(Connection myConn, Statement myStmt, ResultSet myRs) {// by IT19051208 | close database
																					// connection and related things
		try {
			if (myRs != null) {
				myRs.close();
			}
			if (myStmt != null) {
				myStmt.close();
			}
			if (myConn != null) {
				myConn.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static User getUserInfo(int user_id) throws Exception {// by IT19051208 | get user info for profile
		User user = null;

		Connection myConn = null;
		Statement myStmt = null;
		ResultSet myRs = null;

		try {
			myConn = dbConn.returnConn();
			String sql = "select * from user WHERE uid = " + user_id;

			myStmt = myConn.createStatement();

			myRs = myStmt.executeQuery(sql);

			myRs.first();
			String username = myRs.getString("username");
			String name = myRs.getString("name");
			String lname = myRs.getString("lname");
			String type = myRs.getString("type");
			String address = myRs.getString("address");
			String birthday = myRs.getString("birthday");

			String tpno = myRs.getString("tpno");
			user = new User(name, lname, birthday, address, type, username);
			// System.out.println("table row called");

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(myConn, myStmt, myRs);

		}

		return user;

	}

	public static int changePassord(int user_id, String password) throws Exception {// by IT19051208 | change user password
		int status = 0;

		Connection myConn = null;
		Statement myStmt = null;
		ResultSet myRs = null;

		try {
			myConn = dbConn.returnConn();
			String sql = "UPDATE user SET password = '" + password + "' WHERE uid = " + user_id;

			myStmt = myConn.createStatement();

			status = myStmt.executeUpdate(sql);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(myConn, myStmt, myRs);

		}

		return status;

	}

	public static User validateLogin(String uname, String pword) throws Exception {// by IT19051208 | validate login
		User validation = null;
		Connection myConn = null;
		Statement myStmt = null;
		ResultSet myRs = null;
		int rowcount = 0;

		try {

			myConn = dbConn.returnConn();
			myStmt = myConn.createStatement();
			String sqlStatement = "SELECT * FROM user WHERE username='" + uname + "' AND password ='" + pword + "'";
			myRs = myStmt.executeQuery(sqlStatement);

			myRs.first();
			rowcount = myRs.getRow();
			if (rowcount == 1) {
				validation = new User(myRs.getInt("uid"), myRs.getString("username"), myRs.getString("type"));
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(myConn, myStmt, myRs);

		}

		return validation;
	}

}
