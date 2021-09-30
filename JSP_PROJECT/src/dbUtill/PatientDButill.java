package dbUtill;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import databaseConnection.dbConn;
import entities.Patient;

public class PatientDButill {

	private void close(Connection myConn, Statement myStmt, ResultSet myRs) {//by IT19051208 | close database connection and related things 
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

	public List<Patient> getPatientSearchResults(String name_or_id) throws Exception {//by IT19051208 | search patient to give new prescription 
		List<Patient> patients = new ArrayList<>();
		Connection myConn = null;
		Statement myStmt = null;
		ResultSet myRs = null;

		try {

			String sql = "select * from patient WHERE name LIKE '%" + name_or_id + "%' or patientid like '%"
					+ name_or_id + "%' or lname LIKE '%" + name_or_id + "%'";

			myConn = dbConn.returnConn();
			myStmt = myConn.createStatement();
			myRs = myStmt.executeQuery(sql);

			while (myRs.next()) {

				int patient_id = myRs.getInt("patientid");
				String blood_group = myRs.getString("bloodgroup");
				String f_name = myRs.getString("name");
				String l_name = myRs.getString("lname");
				String address = myRs.getString("address");
				String note = myRs.getString("specialnote");
				String tpNumber = myRs.getString("tpno");

				java.sql.Date dob = myRs.getDate("birthday");

				Calendar cal = Calendar.getInstance();
				cal.setTime(dob);

				int birthyear = cal.get(Calendar.YEAR);

				int currentyear = Calendar.getInstance().get(Calendar.YEAR);

				int p_age = currentyear - birthyear;
				Patient temp_patient = new Patient(patient_id, f_name, l_name, p_age, address, note, tpNumber,
						blood_group);

				patients.add(temp_patient);
				// logger.log(null, "Exceptions happen!");

			}

		} catch (Exception e) {
			e.printStackTrace();
			// logger.log(null, "Exceptions happen!", e);
		} finally {
			close(myConn, myStmt, myRs);
		}

		return patients;

	}

	public Patient getPatientInfo(int patient_id) throws Exception {//by IT19051208 | get patient details
		Patient patient = null;

		Connection myConn = null;
		Statement myStmt = null;
		ResultSet myRs = null;

		try {
			myConn = dbConn.returnConn();
			String sql = "select * from patient WHERE patientid = " + patient_id;

			myStmt = myConn.createStatement();

			myRs = myStmt.executeQuery(sql);

			// int currentyear = Calendar.getInstance().get(Calendar.YEAR);
			myRs.first();
			String blood_group = myRs.getString("bloodgroup");
			String f_name = myRs.getString("name");
			String l_name = myRs.getString("lname");
			String address = myRs.getString("address");
			String note = myRs.getString("specialnote");
			String tpNumber = myRs.getString("tpno");

			java.sql.Date dob = myRs.getDate("birthday");

			Calendar cal = Calendar.getInstance();
			cal.setTime(dob);

			int birthyear = cal.get(Calendar.YEAR);

			int currentyear = Calendar.getInstance().get(Calendar.YEAR);

			int p_age = currentyear - birthyear;
			patient = new Patient(patient_id, f_name, l_name, p_age, address, note, tpNumber, blood_group);
			// System.out.println("table row called");

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(myConn, myStmt, myRs);

		}

		return patient;

	}

}
