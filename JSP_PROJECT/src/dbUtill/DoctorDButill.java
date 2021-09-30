package dbUtill;

import java.sql.Connection;

import java.sql.ResultSet;
import java.sql.Statement;

import java.lang.String;

import databaseConnection.dbConn;

public class DoctorDButill {

	private void close(Connection myConn, Statement myStmt, ResultSet myRs) {//by IT19051208 close database connection and related things 
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

	public int[] dashboardSummary(int docid) throws Exception {//by IT19051208 returns summary about doctor 
		Connection myConn = null;
		Statement myStmt = null;
		ResultSet myRs = null;
		int[] summaryvalues = new int[2];

		try {

			String sql = "select count(*) as count from prescribe where docid = " + docid;
			myConn = dbConn.returnConn();
			myStmt = myConn.createStatement();
			myRs = myStmt.executeQuery(sql);

			if (myRs.first()) {
				summaryvalues[0] = myRs.getInt("count");

			}

		} catch (Exception e) {
			e.printStackTrace();

		} finally {
			close(myConn, myStmt, myRs);
		}

		try {

			String sql = "select count(*) as count from doctornotice where docid = " + docid;
			myConn = dbConn.returnConn();
			myStmt = myConn.createStatement();
			myRs = myStmt.executeQuery(sql);

			if (myRs.first()) {
				summaryvalues[1] = myRs.getInt("count");

			}

		} catch (Exception e) {
			e.printStackTrace();

		} finally {
			close(myConn, myStmt, myRs);
		}

		return summaryvalues;

	}

}
