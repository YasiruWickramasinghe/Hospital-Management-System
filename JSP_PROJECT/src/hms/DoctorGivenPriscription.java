package hms;

import java.io.IOException;

import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import dbUtill.PriscriptionDButill;

import entities.Prescription;

/**
 * Servlet implementation class DoctorGivenPriscription
 */
@WebServlet("/DoctorGivenPriscription")
public class DoctorGivenPriscription extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DoctorGivenPriscription() {
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

		doGet(request, response);
		HttpSession session = request.getSession();
		int doctorIdNumber = Integer.parseInt((String) session.getAttribute("userid"));// getting logged in user id
																						// number

		try {
			PriscriptionDButill allGivenPricscriptions = new PriscriptionDButill();
			List<Prescription> prescriptions;

			prescriptions = allGivenPricscriptions.getAllGivenPrescription(doctorIdNumber);
			request.setAttribute("PRISCRIPTION_LIST", prescriptions);
			RequestDispatcher dispatcher = request.getRequestDispatcher("/doctorPrescriptionHistory.jsp");
			dispatcher.forward(request, response);
		} catch (Exception e) {

			e.printStackTrace();
			response.sendRedirect("operationFaild.jsp");
		}

	}

}
