package dbUtill;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import databaseConnection.dbConn;
import entities.Prescription;

public class PriscriptionDButill {

	private void close(Connection myConn, Statement myStmt, ResultSet myRs) {//by IT19051208
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

	public void deletePrescription(int prescriptionID) {//by IT19051208

		Connection myConn = null;
		PreparedStatement preStmt = null;
		ResultSet myRs = null;

		String sql = "";

		try {

			sql = "DELETE FROM prescribe WHERE prescriptionid = ?";
			myConn = dbConn.returnConn();
			preStmt = myConn.prepareStatement(sql);

			preStmt.setInt(1, prescriptionID);

			preStmt.execute();

		} catch (Exception e) {
			e.printStackTrace();
		}

		try {
			sql = "DELETE FROM prescription WHERE prescriptionid = ?";

			myConn = dbConn.returnConn();
			preStmt = myConn.prepareStatement(sql);

			preStmt.setInt(1, prescriptionID);

			preStmt.execute();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(myConn, preStmt, myRs);
		}

		// return status;
	}

	public List<Prescription> getAllGivenPrescription(int doctorId) throws Exception {//by IT19051208
		List<Prescription> allPrescriptions = new ArrayList<>();
		Connection myConn = null;
		Statement myStmt = null;
		ResultSet myRs = null;

		try {

			String sql = "select * from prescription p , prescribe pbe where p.prescriptionid = pbe.prescriptionid and pbe.docid = "
					+ doctorId + " order by p.prescriptionid desc";

			myConn = dbConn.returnConn();
			myStmt = myConn.createStatement();
			myRs = myStmt.executeQuery(sql);

			while (myRs.next()) {

				String details = myRs.getString("details");
				int priscriptionid = Integer.parseInt(myRs.getString("prescriptionid"));
				String date = myRs.getString("date");
				String status = myRs.getString("status");

				Prescription temp_Prescription = new Prescription(details, priscriptionid, date, status);
				// System.out.println("table row called");
				allPrescriptions.add(temp_Prescription);

			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(myConn, myStmt, myRs);
		}

		return allPrescriptions;

	}

	public void updatePrescriptionDetails(int prescriptionID, String prescriptionDetails) {//by IT19051208

		Connection myConn = null;
		PreparedStatement preStmt = null;
		ResultSet myRs = null;

		try {
			String sql = "UPDATE prescription SET details = ? WHERE prescriptionid = ? ";
			myConn = dbConn.returnConn();
			preStmt = myConn.prepareStatement(sql);
			preStmt.setString(1, prescriptionDetails);
			preStmt.setInt(2, prescriptionID);

			preStmt.execute();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(myConn, preStmt, myRs);
		}

	}

	public List<Prescription> getAllPatientPrescriptionHistory(int patientId) throws Exception {//by IT19051208
		List<Prescription> allPatientPrescriptionHistory = new ArrayList<>();
		Connection myConn = null;
		Statement myStmt = null;
		ResultSet myRs = null;

		try {

			String sql = "select u.name , u.lname  , p.prescriptionid , details	, date , status from prescribe p , prescription p2, user u"
					+ "  where p.prescriptionid =p2.prescriptionid and u.uid = p.docid and p.patientid = " + patientId
					+ " order by p.prescriptionid desc";

			myConn = dbConn.returnConn();
			myStmt = myConn.createStatement();
			myRs = myStmt.executeQuery(sql);

			while (myRs.next()) {

				int prescriptionid = myRs.getInt("prescriptionid");
				String details = myRs.getString("details");
				String date = myRs.getString("date");
				String status = myRs.getString("status");
				String name = myRs.getString("name") + " " + myRs.getString("lname");

				Prescription temp_Prescription = new Prescription(details, prescriptionid, date, status, "", name);
				// System.out.println("table row called");
				allPatientPrescriptionHistory.add(temp_Prescription);

			}

		} catch (Exception e) {
			e.printStackTrace();

		} finally {
			close(myConn, myStmt, myRs);
		}

		return allPatientPrescriptionHistory;

	}

	public Boolean savePrescriptionDetails(int patient_id, int doctot_id, String details) throws Exception {//by IT19051208 

		Boolean funcStatus = true;
		// dbConn conn = new dbConn();
		Connection dbConnection = null;
		PreparedStatement preparedStmt = null;
		ResultSet rs = null;

		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date date = new Date();
		String current_date = dateFormat.format(date);

		String sql = "";

		try {

			dbConnection = dbConn.returnConn();
			sql = "insert into prescription (details,date , status) values(?,?,?)";
			preparedStmt = dbConnection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			// preparedStmt.setInt(1,patient_id);
			preparedStmt.setString(1, details);
			preparedStmt.setDate(2, java.sql.Date.valueOf(current_date));
			preparedStmt.setString(3, "pending");
			preparedStmt.execute();
			rs = preparedStmt.getGeneratedKeys();
			rs.first();

			int priscriptionID = rs.getInt(1);
			System.out.println(priscriptionID);
			// priscriptionID;

			sql = "insert into prescribe (docid,	patientid,	prescriptionid ) values(?,?,?)";
			PreparedStatement preStmt = dbConnection.prepareStatement(sql);
			preStmt.setInt(1, doctot_id);
			preStmt.setInt(2, patient_id);
			preStmt.setInt(3, priscriptionID);

			preStmt.execute();
		}

		catch (Exception e) {
			funcStatus = false;
			e.printStackTrace();
		}

		finally {
			close(dbConnection, preparedStmt, rs);
		}

		return funcStatus;

	}

}
