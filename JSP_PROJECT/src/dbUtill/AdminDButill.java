package dbUtill;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import databaseConnection.dbConn;
import entities.Doctor;

public class AdminDButill {

	private Connection dbConnection = null;

	private Statement stmt = null;
	private ResultSet rs = null;
	// private static ResultSet result_get_sp = null;

	public List<Doctor> validate(String SearchString) {

		ArrayList<Doctor> doc = new ArrayList<>();

		try {

			String sql = "select * from user u , doctor d where u.uid = d.docid and u.username ='" + SearchString + "'";
			// rs = stmt.executeQuery(sql);
			dbConnection = dbConn.returnConn();
			stmt = dbConnection.createStatement();
			rs = stmt.executeQuery(sql);

			if (rs.next()) {
				int uid = Integer.parseInt(rs.getString("uid"));
				String dusername = rs.getString("username");
				String password = rs.getString("password");
				String name = rs.getString("name");
				String lname = rs.getString("lname");
				String type = "doctor";
				String address = rs.getString("address");
				String birthday = rs.getString("birthday");
				String specialization = rs.getString("specialization");

				Doctor d = new Doctor(uid, name, lname, birthday, address, type, dusername, password, specialization);
				doc.add(d);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return doc;

	}

	public boolean insertDoctor(String username, String password, String name, String lname, String specialization,
			String address, String birthday, String phoneNumber) {
		// ,String specialization

		boolean isSuccess = false;
		Connection dbConnection = dbConn.returnConn();

		ResultSet rs = null;
		try {

			String sql = "insert into user(username,password,name,lname,address,birthday,type,tpno)"
					+ " values(?,?,?,?,?,?,?,?)";
			PreparedStatement preparedStmt = dbConnection.prepareStatement(sql,
					PreparedStatement.RETURN_GENERATED_KEYS);

			preparedStmt.setString(1, username);
			preparedStmt.setString(2, password);
			preparedStmt.setString(3, name);
			preparedStmt.setString(4, lname);
			preparedStmt.setString(5, address);
			preparedStmt.setString(6, birthday);
			preparedStmt.setString(7, "doctor");
			preparedStmt.setString(8, phoneNumber);
			preparedStmt.execute();
			rs = preparedStmt.getGeneratedKeys();
			rs.first();
			int userID = rs.getInt(1);
			// int rs = stmt.executeUpdate(sql);
			System.out.println(userID);
			preparedStmt.close();
			preparedStmt = null;
			sql = "insert into doctor(docid,specialization)" + " values(?,?)";
			preparedStmt = dbConnection.prepareStatement(sql);
			preparedStmt.setInt(1, userID);
			preparedStmt.setString(2, specialization);
			preparedStmt.execute();
			dbConnection.close();

			if (userID >= 0) {
				isSuccess = true;
			} else {
				isSuccess = false;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return isSuccess;

	}

	public boolean updatedoctor(String uid, String username, String password, String name, String lname, String type,
			String address, String birthday) {

		Boolean isSuccess = false;
		try {

			Connection dbConnection = dbConn.returnConn();

			Statement stmt = (Statement) dbConnection.createStatement();

			String sql = "update user set username='" + username + "',password='" + password + "',name='" + name
					+ "',lname='" + lname + "',type='" + type + "',address='" + address + "',birthday='" + birthday
					+ "'" + "where uid='" + uid + "'";

			int rs = stmt.executeUpdate(sql);

			if (rs > 0) {
				isSuccess = true;
			} else {
				isSuccess = false;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return isSuccess;
	}

	public List<Doctor> getAllDoctors() throws Exception {

		Connection dbConnection = dbConn.returnConn();

		Statement stmt = null;
		ResultSet rs = null;

		ArrayList<Doctor> doc = new ArrayList<>();

		try {

			String sql = "select * from user u , doctor d where u.uid = d.docid and u.type = " + "'doctor'";
			stmt = dbConnection.createStatement();
			rs = stmt.executeQuery(sql);

			while (rs.next()) {
				// System.out.println("test");
				int uid = Integer.parseInt(rs.getString("uid"));
				String dusername = rs.getString("username");
				String password = rs.getString("password");
				String name = rs.getString("name");
				String lname = rs.getString("lname");
				String type = "doctor";// rs.getString(6);
				String address = rs.getString("address");
				String birthday = rs.getString("birthday");

				// getting specialization

				String specialization = rs.getString(11);
				// System.out.println("go xxxxxxxx");
				//

				// constructor
				Doctor d = new Doctor(uid, name, lname, birthday, address, type, dusername, password, specialization);
				doc.add(d);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return doc;

	}

}
