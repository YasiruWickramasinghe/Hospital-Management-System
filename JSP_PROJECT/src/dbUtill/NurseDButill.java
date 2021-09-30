package dbUtill;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import databaseConnection.dbConn;
import entities.Prescription;

public class NurseDButill {

	public static List<Prescription> validate() throws Exception {

		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;

		ArrayList<Prescription> pres = new ArrayList<>();

		try {
			conn = dbConn.returnConn();
			stmt = conn.createStatement();

			String sql = "select  p.prescriptionid , p.details , pat.name , p.date , p.status from prescription p , prescribe pr, patient pat where p.prescriptionid = pr.prescriptionid and pat.patientid = pr.patientid and p.status = 'pending'";
			rs = stmt.executeQuery(sql);

			// Process result set
			while (rs.next()) {

				// retrive data from result set row
				int preId = rs.getInt("prescriptionid");
				String patientName = rs.getString("name");
				String detail = rs.getString("details");
				String preDate = rs.getString("date");
				String status = rs.getString("status");

				// Create new prescription
				Prescription p = new Prescription(detail, preId, preDate, status, patientName);

				// Add it to the list
				pres.add(p);
			}

		}

		catch (Exception e) {
			e.printStackTrace();
		}

		return pres;
	}

}
