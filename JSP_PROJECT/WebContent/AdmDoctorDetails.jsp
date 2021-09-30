<jsp:include page="header.jsp" />
  		<%
 			if(session.getAttribute("userName") == null || session == null)
 				{
 				response.sendRedirect("login.jsp");
  				return;
  				}
  		
  		%>
  		
  		
  		
<div class="d-flex justify-content-center">
        <div > 
        <h1 class="text-success">Doctor Details</h1>
        </div>
  </div>
      

 
  		<div class="d-flex justify-content-around">
  				  <div >  
			        <a href="dashboardAdmin.jsp" class="btn btn-primary" >Back</a>
			        </div> 
			        <div>
			         <a href="AdmAddDoctorForm.jsp" class="btn btn-primary" >Add New Doctor</a>
			        </div>
			        
  				<div>
  				<form action="log" method="post">
                <input type="text" name="username" >
                 <input class="btn btn-primary"  type="submit" name="submit" value="Search">
             	 </form>
  				</div>
  		 		
  		</div>
 			<br>
 			
 			<%@ page import="java.util.ArrayList" %>
		<%@ page import="entities.Doctor" %>
 
        <%
        ArrayList<Doctor> print_Doctor_list = new ArrayList<Doctor>();
        print_Doctor_list = null;
        try{
        	print_Doctor_list =  (ArrayList<Doctor>)request.getAttribute("DOCTOR_LIST");
        }
        catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
        int i = 1; 
       
        %> 
        
			
     <div class="container " style="margin-bottom:5em;"> 
			<table class="table">
			  <thead>
			    <tr>
			      <th scope="col">#</th>
			      <th scope="col"></th>
			      <th scope="col">Name</th>
			      <th scope="col">Action</th>
			    </tr>
			  </thead>
			  <tbody>
			  <% for (Doctor tempDoctor : print_Doctor_list) { 
				 
				%>
			    <tr>
			      <th scope="row"><%=i%></th>
			      <td><img src="images/Admin/img_avatar1.png" alt="profile" class="rounded-circle" width="50" height="50"></td>
			      <td><%= tempDoctor.getfName()+" "+tempDoctor.getlName() %></td>
			      <td>
			      <form action="get">
			      <input type="submit" class="btn btn-primary" value="View" onclick="document.location='xxxxxxxxServlet?doctorNumber=<%=tempDoctor.getUserIDnumber()%>'">
			      </form>
			      </td>
			    </tr>
			   <%  i++;} %>
			  </tbody>
			</table>
		 </div> 
     

<jsp:include page="footer.jsp" />