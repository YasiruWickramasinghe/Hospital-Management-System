package logInOut;

import java.sql.*;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import dbUtill.UserDButill;
import entities.User;
import hmsLogger.hmsLog;

/**
 * Servlet implementation class LoginValidator
 */
@WebServlet("/LoginValidator")
public class LoginValidator extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * Default constructor.
	 */
	public LoginValidator() {
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
		try {
			String uname = request.getParameter("username");
			String pword = request.getParameter("password");

			HttpSession session = request.getSession();
			session.setAttribute("name", uname);
			hmsLog.writeLogger((String) session.getAttribute("name") + " attempted to log in");
			User tempUser = null;

			tempUser = UserDButill.validateLogin(uname, pword);

			if (tempUser != null) {
				session.setAttribute("userName", uname);
				session.setAttribute("userid",Integer.toString(tempUser.getUserIDnumber()) );
				session.setAttribute("userType",tempUser.getUserType());

				hmsLog.writeLogger((String) session.getAttribute("userName")+" logged in");
				response.sendRedirect("home.jsp");
			} else {
				response.sendRedirect("login.jsp");
			}

		} catch (Exception e) {
			System.out.println(e);
		} finally {

		}

	}

}
