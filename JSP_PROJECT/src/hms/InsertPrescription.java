package hms;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import dbUtill.PriscriptionDButill;

/**
 * Servlet implementation class InsertPrescription
 */
@WebServlet("/InsertPrescription")
public class InsertPrescription extends HttpServlet {
	private static final long serialVersionUID = 1L;

	PriscriptionDButill savePriscription = new PriscriptionDButill();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public InsertPrescription() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		int patient_id = Integer.parseInt(request.getParameter("patient_id"));
		int doctot_id = Integer.parseInt(request.getParameter("doctor_id"));
		String details = request.getParameter("priscription_data");
		// System.out.println(patient_id );System.out.println(doctot_id
		// );System.out.println(details );

		try {

			savePriscription.savePrescriptionDetails(patient_id, doctot_id, details);
			response.sendRedirect("Dashboardsummary");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
