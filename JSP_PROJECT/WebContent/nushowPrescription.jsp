<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="header.jsp" />
  		<%
 			if(session.getAttribute("userName") == null || session == null)
 				{
 				response.sendRedirect("login.jsp");
  				return;
  				}
  		
  		%>
  <link href="css/malith.css" rel="stylesheet">
<br>
 <h3 class="font-weight-normal">Prescription Details</h3>
 <hr>
 
 
<div class="container">
	<div class="jumbotron" style="idth: 100%;">
        <div class="container">
          <h1 class="display-4">Search</h1>
          <p>Enter patient name or Patient number</p>
           <input type="text" id="myInput" onkeyup="myFunction()" placeholder="Type Prescription ID here" title="Type in a name">
        </div>
      </div>
      
      	   <div class="row mb-5">
		   <div class="col-12">
		   	<div class="card">
		      <div class="card-body">
 
 
 <h2>Prescription Details</h2>
 <table id="nurse" class="table table-striped">
  <tr>
    <th>Prescription ID</th>
    <th>Patient Name</th>
    <th>Prescription Details</th>
  </tr>
 

<%@ page import="java.util.ArrayList" %>
<%@ page import="entities.Prescription" %>
		
        <%
        ArrayList<Prescription> print_Prescription = new ArrayList<Prescription>();
        print_Prescription = null;
        try{
        print_Prescription =  (ArrayList<Prescription>)request.getAttribute("presDetail");
        }
        catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
        int i = 1; 
        
        %> 
        
			<% for (Prescription tempPrescription : print_Prescription) {
				%>
				<tr>
				 <td><%=tempPrescription.getPriscriptionid() %></td>
			    <td><%=tempPrescription.getPatientName() %></td>
			    <td><%=tempPrescription.getDetails() %></td>
				</tr>
		
				<%i++; } %>
				

</table>
		       		
		      </div>
		    </div>
		  </div>
	   </div>
	

</div>
<script>
function myFunction() {
  var input, filter, table, tr, td, i, txtValue;
  input = document.getElementById("myInput");
  filter = input.value.toUpperCase();
  table = document.getElementById("nurse");
  tr = table.getElementsByTagName("tr");
  for (i = 0; i < tr.length; i++) {
    td = tr[i].getElementsByTagName("td")[0];
    if (td) {
      txtValue = td.textContent || td.innerText;
      if (txtValue.toUpperCase().indexOf(filter) > -1) {
        tr[i].style.display = "";
      } else {
        tr[i].style.display = "none";
      }
    }       
  }
}
</script>

<jsp:include page="footer.jsp" />