package hms;

import java.io.IOException;

import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import dbUtill.PriscriptionDButill;
import entities.Prescription;

/**
 * Servlet implementation class DoctorViewPatientPrescriptionHistory
 */
@WebServlet("/DoctorViewPatientPrescriptionHistory")
public class DoctorViewPatientPrescriptionHistory extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DoctorViewPatientPrescriptionHistory() {
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

		int patientId = 0;
		// HttpSession session = request.getSession();
		// int doctorIdNumber = Integer.parseInt((String)
		// session.getAttribute("userid"));
		patientId = Integer.parseInt(request.getParameter("patientId"));

		try {
			PriscriptionDButill allPatientPricscriptions = new PriscriptionDButill();
			List<Prescription> prescriptions;

			prescriptions = allPatientPricscriptions.getAllPatientPrescriptionHistory(patientId);
			request.setAttribute("PRISCRIPTION_LIST", prescriptions);
			RequestDispatcher dispatcher = request.getRequestDispatcher("/viewPrescriptionHistory.jsp");
			dispatcher.forward(request, response);
		} catch (Exception e) {

			e.printStackTrace();
			response.sendRedirect("operationFaild.jsp");
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
