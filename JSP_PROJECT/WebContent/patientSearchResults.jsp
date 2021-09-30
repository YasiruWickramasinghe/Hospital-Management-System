<jsp:include page="header.jsp" />
<%
 			if(session.getAttribute("userName") == null || session == null)
 				{
 				response.sendRedirect("login.jsp");
  				return;
  				}
  		
  		%>
<br>
<h3 class="font-weight-normal">Search Results</h3>
<hr>
<div class="container">
	<table class="table table-striped">
		<thead>
			<tr>
				<th scope="col">#</th>
				<th scope="col">Patient ID</th>
				<th scope="col">Patient Name</th>

				<th scope="col">Age</th>
			</tr>
		</thead>
		<tbody>
			<%--PATIENT_LIST --%>
			<%@ page import="java.util.ArrayList"%>
			<%@ page import="entities.Patient"%>
			<%-- Fetching the attributes of the request object 
             
        --%>
			<%
        ArrayList<Patient> print_patient = new ArrayList<Patient>();
        print_patient = null;
        try{
        print_patient =  (ArrayList<Patient>)request.getAttribute("PATIENT_LIST");
        }
        catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
        int i = 1; 
        
        %>

			<% for (Patient tempPatient : print_patient) {
				%>

			<tr
				onclick="document.location='GetPatientDetailsServlet?patientNumber=<%= tempPatient.getPatientIDnumber()  %>'">
				<td><%= i %></td>
				<td><%= tempPatient.getPatientIDnumber() %></td>
				<td><%= tempPatient.getfName() +" "+ tempPatient.getlName() %>
				</td>
				<td><%= tempPatient.getAge() %></td>
			</tr>

			<% i++; } %>
		
	</table>
</div>

<jsp:include page="footer.jsp" />