package hms;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import dbUtill.DoctorNoticeDButill;

/**
 * Servlet implementation class DoctorCreateNewNotice
 */
@WebServlet("/DoctorCreateNewNotice")
public class DoctorCreateNewNotice extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DoctorCreateNewNotice() {
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
		String noticeTitle = request.getParameter("noticeTitle");
		String noticeInfo = request.getParameter("noticeInfo");

		System.out.println(noticeTitle + "   " + noticeInfo);
		try {
			HttpSession session = request.getSession();
			DoctorNoticeDButill createNotice = new DoctorNoticeDButill();
			createNotice.createSpecialNotice(noticeTitle, noticeInfo,
					Integer.parseInt((String) session.getAttribute("userid")));
		} catch (Exception e) {
			e.printStackTrace();
			response.sendRedirect("operationFaild.jsp");
		}

		response.sendRedirect("Dashboardsummary");
	}

}
