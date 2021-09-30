package hms;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import dbUtill.PriscriptionDButill;

/**
 * Servlet implementation class DoctorDeletePrescription
 */
@WebServlet("/DoctorDeletePrescription")
public class DoctorDeletePrescription extends HttpServlet {
	private static final long serialVersionUID = 1L;
	int sequenceNum = 0;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DoctorDeletePrescription() {
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
		sequenceNum = Integer.parseInt((String) request.getParameter("sequenceNum"));
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);

		String tempIDNumber = request.getParameter("prescriptionID" + sequenceNum);
		int prescriptionID = Integer.parseInt(tempIDNumber.replaceAll("\\s+", ""));

		try {

			PriscriptionDButill updatePrescription = new PriscriptionDButill();
			updatePrescription.deletePrescription(prescriptionID);
			response.sendRedirect("Dashboardsummary");
		} catch (Exception e) {
			e.printStackTrace();
			response.sendRedirect("operationFaild.jsp");
		}

	}

}
