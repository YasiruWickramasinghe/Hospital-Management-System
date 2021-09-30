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
import entities.Doctor;

/**
 * Servlet implementation class AdmDocSearchRetreveServlet
 */
@WebServlet("/AdmDocSearchRetreveServlet")
public class AdmDocSearchRetreveServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdmDocSearchRetreveServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		
		 String username = request.getParameter("username");
		    
		    try {
		    	AdminDButill adminUtil = new AdminDButill();
	        	  List<Doctor> docDetails = adminUtil.validate(username);
	        	  request.setAttribute("docDetails", docDetails);
		    }
		    catch (Exception e) {
		    	
			e.printStackTrace();
		    }
		    
		    
		    
		    RequestDispatcher dis = request.getRequestDispatcher("AdmDoctorProfiles.jsp");
		    dis.forward(request, response);    
		
	}

}
