package hms;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import dbUtill.UserDButill;

/**
 * Servlet implementation class ChangePassword
 */
@WebServlet("/ChangePassword")
public class ChangePassword extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ChangePassword() {
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
		int userId = 0;
		String pass1 = "";
		String pass2 = "";
		//getting values from form
		pass1 = request.getParameter("InputPassword");
		pass2 = request.getParameter("ReInputPassword");
		//	
		if (pass1.equals(pass2)) {//check entered passwords are matching
			try {
				HttpSession session = request.getSession();
				userId = Integer.parseInt((String) session.getAttribute("userid"));

				if (UserDButill.changePassord(userId, pass1) == 1) {
					response.sendRedirect("UserProfile");
				} else {
					response.sendRedirect("operationFaild.jsp");
				}
			} catch (Exception e) {
				e.printStackTrace();
				response.sendRedirect("operationFaild.jsp");
			}

		} else {
			response.sendRedirect("operationFaild.jsp");
		}

	}

}
