package hms;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dbUtill.AdminDButill;


@WebServlet("/AdmDoctorInsertServlet")
public class AdmDoctorInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	AdminDButill addNewDoctor = new  AdminDButill();

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String name = request.getParameter("name");
		String lname = request.getParameter("lname");
		String specialization = request.getParameter("specialization");
		String address = request.getParameter("address");
		String birthday = request.getParameter("birthday");
		String tpno = request.getParameter("tpno");
		
		

		boolean isTrue;
		
		isTrue = addNewDoctor.insertDoctor(username,password,name,lname,specialization,address,birthday,tpno); //,specialization
		
		if(isTrue == true) {
			response.sendRedirect("AdmDoctorProfiles.jsp");
			//List<AdmDoctor> docDetails = AdmDoctorDBUtil.validate(username);
			//request.setAttribute("docDetails", docDetails);
			
			//RequestDispatcher dis1 = request.getRequestDispatcher("AdmDoctorProfiles.jsp");
			//dis1.forward(request, response);
		}
		else {
			response.sendRedirect("operationFaild.jsp");
			//List<AdmDoctor> docDetails = AdmDoctorDBUtil.validate(username);
			//request.setAttribute("docDetails", docDetails);
			
			//RequestDispatcher dis2 = request.getRequestDispatcher("AdmDoctorProfiles.jsp");
			//dis2.forward(request, response);
		}
		
	}

}
