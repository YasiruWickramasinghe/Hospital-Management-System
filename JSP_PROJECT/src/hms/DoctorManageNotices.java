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
import dbUtill.DoctorNoticeDButill;
import entities.DoctorNotice;

/**
 * Servlet implementation class DoctorManageNotices
 */
@WebServlet("/DoctorManageNotices")
public class DoctorManageNotices extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DoctorManageNotices() {
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

		HttpSession session = request.getSession();
		int doctorIdNumber = 0;
		doctorIdNumber = Integer.parseInt((String) session.getAttribute("userid"));

		try {
			DoctorNoticeDButill allDoctorNotices = new DoctorNoticeDButill();
			List<DoctorNotice> doctorNoticeList;

			doctorNoticeList = allDoctorNotices.getAllDoctorNotices(doctorIdNumber);
			request.setAttribute("DOCTORNOTICE_LIST", doctorNoticeList);
			RequestDispatcher dispatcher = request.getRequestDispatcher("/manageDoctorNotice.jsp");
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
