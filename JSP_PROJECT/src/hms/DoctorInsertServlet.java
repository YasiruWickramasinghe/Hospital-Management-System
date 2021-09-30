package hms;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dbUtill.AdminDButill;

@WebServlet("/DoctorInsertServlet")
public class DoctorInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String name = request.getParameter("name");
		String lname = request.getParameter("lname");
		String type = request.getParameter("type");
		String address = request.getParameter("address");
		String birthday = request.getParameter("birthday");
		String specialization = request.getParameter("specialization");

		boolean isTrue;

		AdminDButill doctordbUtill = new AdminDButill();

		isTrue = doctordbUtill.insertDoctor(username, password, name, lname, type, address, birthday, specialization);

		if (isTrue == true) {
			RequestDispatcher dis1 = request.getRequestDispatcher("AdmDoctorDetails.jsp");
			dis1.forward(request, response);
		} else {
			RequestDispatcher dis2 = request.getRequestDispatcher("dashboardAdmin.jsp");
			dis2.forward(request, response);
		}

	}

}
