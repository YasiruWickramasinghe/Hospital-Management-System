package hms;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import dbUtill.PatientDButill;
import entities.Patient;

/**
 * Servlet implementation class GetPatientDetailsServlet
 */
@WebServlet("/GetPatientDetailsServlet")
public class GetPatientDetailsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	int patientId = 0;

	private PatientDButill patientDetails = new PatientDButill();

	public GetPatientDetailsServlet() {
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

		patientId = Integer.parseInt(request.getParameter("patientNumber"));
		try {
			Patient patient;

			patient = patientDetails.getPatientInfo(patientId);
			request.setAttribute("PATIENT_DATA", patient);
			RequestDispatcher dispatcher = request.getRequestDispatcher("/newPrescription.jsp?patientId=" + patientId);
			dispatcher.forward(request, response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);

	}

}
