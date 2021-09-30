package hms;

import java.io.IOException;

import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import dbUtill.PatientDButill;
import entities.Patient;

@WebServlet("/DoctorSearchPatient")
public class DoctorSearchPatient extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public DoctorSearchPatient() {
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

		String p_id_name = request.getParameter("p_name_id");

		try {

			PatientDButill findpatient = new PatientDButill();

			List<Patient> patients;

			patients = findpatient.getPatientSearchResults(p_id_name);
			request.setAttribute("PATIENT_LIST", patients);
			RequestDispatcher dispatcher = request.getRequestDispatcher("/patientSearchResults.jsp");
			dispatcher.forward(request, response);
		} catch (Exception e) {

			e.printStackTrace();
		}

	}

}
