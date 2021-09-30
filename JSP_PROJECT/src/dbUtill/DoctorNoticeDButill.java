package dbUtill;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import databaseConnection.dbConn;
import entities.DoctorNotice;

public class DoctorNoticeDButill {
	// method to close
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

	public void createSpecialNotice(String title, String discription, int doctorID) {//by IT19051208 | create new notice by doctor
		String sql = "";
		try {

			Connection dbConnection = dbConn.returnConn();

			sql = "insert into doctornotice (title,content,docid) values(?,?,?)";
			PreparedStatement preparedStmt = dbConnection.prepareStatement(sql);
			preparedStmt.setString(1, title);
			preparedStmt.setString(2, discription);
			preparedStmt.setInt(3, doctorID);

			preparedStmt.execute();
			dbConnection.close();
		} catch (Exception e) {
			System.out.println(e);
		}

	}

	public void deleteDoctorNotice(int docNoticeID) {//by IT19051208 | deletes doctor's notice 

		Connection myConn = null;
		PreparedStatement preStmt = null;
		ResultSet myRs = null;

		try {
			String sql = "DELETE FROM doctornotice WHERE noteid = ?";
			myConn = dbConn.returnConn();
			preStmt = myConn.prepareStatement(sql);

			preStmt.setInt(1, docNoticeID);

			preStmt.execute();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(myConn, preStmt, myRs);
		}

	}

	public List<DoctorNotice> getAllDoctorNotices(int doctorId) throws Exception {//by IT19051208 | get all notices by doctor
		List<DoctorNotice> allDoctorNotices = new ArrayList<>();
		Connection myConn = null;
		Statement myStmt = null;
		ResultSet myRs = null;

		try {

			String sql = "select * from doctornotice where docid = " + doctorId;

			myConn = dbConn.returnConn();
			myStmt = myConn.createStatement();
			myRs = myStmt.executeQuery(sql);

			while (myRs.next()) {

				int noticeId = Integer.parseInt(myRs.getString("noteid"));
				String noticeTitle = myRs.getString("title");
				String noticeContent = myRs.getString("content");

				DoctorNotice temp_DoctorNotice = new DoctorNotice(noticeId, noticeTitle, noticeContent);
				// System.out.println("table row called");
				allDoctorNotices.add(temp_DoctorNotice);

			}

		} catch (Exception e) {
			e.printStackTrace();

		} finally {
			close(myConn, myStmt, myRs);
		}

		return allDoctorNotices;

	}

	public void updateNoticeDetails(int docNoticeID, String docNoticenDetails, String docNoticenTitle) {//by IT19051208 | update notices details by doctor

		Connection myConn = null;
		PreparedStatement preStmt = null;
		ResultSet myRs = null;

		try {
			String sql = "UPDATE doctornotice SET content = ? , title = ? WHERE noteid = ? ";
			myConn = dbConn.returnConn();
			preStmt = myConn.prepareStatement(sql);

			preStmt.setString(1, docNoticenDetails);
			preStmt.setString(2, docNoticenTitle);
			preStmt.setInt(3, docNoticeID);

			preStmt.execute();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(myConn, preStmt, myRs);
		}

	}

}
