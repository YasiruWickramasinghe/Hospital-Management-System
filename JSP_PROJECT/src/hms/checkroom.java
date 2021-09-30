package hms;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entities.Room;


/**
 * Servlet implementation class checkroom
 */
@WebServlet("/checkroom")
public class checkroom extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String typefroom=request.getParameter("typeofroom");
		try {
		List<Room> roomDetails= Checkroomclass.roomlist(typefroom);
		
		//set that got details to another page
		request.setAttribute("roomDetails", roomDetails);
		}catch(Exception e){
			e.printStackTrace();
		}
		//redirecttopage
		RequestDispatcher dis =request.getRequestDispatcher("roomdetails.jsp");
		dis.forward(request, response);
		
	}

}

