package hms;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dbUtill.DoctorNoticeDButill;

/**
 * Servlet implementation class DoctorDeleteNotice
 */
@WebServlet("/DoctorDeleteNotice")
public class DoctorDeleteNotice extends HttpServlet {
	private static final long serialVersionUID = 1L;
	String sequenceNum = "";

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DoctorDeleteNotice() {
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
		sequenceNum = ((String) request.getParameter("sequenceNum"));
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		int noticeId = Integer.parseInt((String) request.getParameter("noticeId" + sequenceNum));

		try {

			DoctorNoticeDButill deleteNotice = new DoctorNoticeDButill();
			deleteNotice.deleteDoctorNotice(noticeId);
			response.sendRedirect("DoctorManageNotices");
		} catch (Exception e) {

			e.printStackTrace();
			response.sendRedirect("operationFaild.jsp");
		}

	}

}
