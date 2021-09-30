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
import dbUtill.DoctorDButill;
import entities.Doctor;
import entities.Patient;

/**
 * Servlet implementation class AdminAllDoctorList
 */
@WebServlet("/AdminAllDoctorList")
public class AdminAllDoctorList extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminAllDoctorList() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		
		AdminDButill showAllDoctorsList;
		try {
		       
			 showAllDoctorsList = new AdminDButill();

			List<Doctor> doctors;
			
			doctors = showAllDoctorsList.getAllDoctors();
			request.setAttribute("DOCTOR_LIST", doctors);
			RequestDispatcher dispatcher = request.getRequestDispatcher("/AdmDoctorDetails.jsp");
			dispatcher.forward(request, response);
		} catch (Exception e) {
			
			e.printStackTrace();
		}

		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
