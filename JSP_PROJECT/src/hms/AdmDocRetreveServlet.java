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
 * Servlet implementation class AdmDocRetreveServlet
 */
@WebServlet("/AdmDocRetreveServlet")
public class AdmDocRetreveServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdmDocRetreveServlet() {
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
		System.out.println(username);
		
		AdminDButill adminUtil = new AdminDButill();
	    
	    try {
        	  List<Doctor> docDetails = adminUtil.validate(username);
        	  request.setAttribute("docDetails", docDetails);
        	  RequestDispatcher dis = request.getRequestDispatcher("AdmDoctorProfiles.jsp");
      	      dis.forward(request, response);
	    }
	    catch (Exception e) {
	    	
		e.printStackTrace();
	    }
	    
	    
	    
	    
	}

}
