package hms;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import dbUtill.DoctorNoticeDButill;

/**
 * Servlet implementation class DoctorUpdateNotice
 */
@WebServlet("/DoctorUpdateNotice")
public class DoctorUpdateNotice extends HttpServlet {
	private static final long serialVersionUID = 1L;
	int sequenceNum = 0;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DoctorUpdateNotice() {
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
		
		doGet(request, response);

		String noticeContent = request.getParameter("noticeContent" + sequenceNum);
		String noticeTitle = request.getParameter("noticeTitle" + sequenceNum);
		int noticeId = Integer.parseInt((String) request.getParameter("noticeId" + sequenceNum));

		try {

			DoctorNoticeDButill updateNotice = new DoctorNoticeDButill();
			updateNotice.updateNoticeDetails(noticeId, noticeContent, noticeTitle);
			response.sendRedirect("DoctorManageNotices");
		} catch (Exception e) {

			e.printStackTrace();
			response.sendRedirect("operationFaild.jsp");
		}

	}

}
