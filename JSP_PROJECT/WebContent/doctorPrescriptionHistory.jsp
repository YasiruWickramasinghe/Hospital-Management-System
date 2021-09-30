<jsp:include page="header.jsp" />
  		<%
 			if(session.getAttribute("userName") == null || session == null)
 				{
 				response.sendRedirect("login.jsp");
  				return;
  				}
  		
  		%>
<br>
 <h3 class="font-weight-normal">Given Prescription History</h3>
 <hr>
	<div class="container " style="margin-bottom:5em;">
	
		<%@ page import="java.util.ArrayList" %>
		<%@ page import="entities.Prescription" %>
 
        <%
        ArrayList<Prescription> print_prescription = new ArrayList<Prescription>();
        print_prescription = null;
        try{
        print_prescription =  (ArrayList<Prescription>)request.getAttribute("PRISCRIPTION_LIST");
        }
        catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
        int i = 1; 
        
        %> 
        
			<% for (Prescription tempPrescription : print_prescription) {
				%>
		 	 <div class="card m-3">
			<div class="card-body">
				<h4 class="font-weight-light">Prescription ID : <%= tempPrescription.getPriscriptionid()%> </h4>
				<p class="font-weight-light"> <%=tempPrescription.getDate()%></p><hr>
				<form method="post" action="">
					  <textarea class="form-control" id="presTextarea<%=i%>" rows="5" name="priscription_data<%=i%>" required
					   <%if(!(tempPrescription.getStatus().equals("pending")))
							   {out.println(" disabled");
							   } %> > <%=tempPrescription.getDetails()%></textarea>
					  
					  
					  <input type="hidden" value=" <%=tempPrescription.getPriscriptionid()%>" name="prescriptionID<%=i%>">

					 
					  
					 <br>
					 <div class="container " style="">
					 <div class="row">
					 	
					    <div class="col-1">
					      <input type="submit" class="btn btn-success  m-2" value="Update" formaction="DoctorUpdatePrescription?sequenceNum=<%=i%>" 
					       <%if(!(tempPrescription.getStatus().equals("pending")))
							   {out.println(" disabled");
							   } %> >
					    </div>			 
					    <div class="col-11 d-flex justify-content-end">
					      <input type="submit" class="btn btn-danger m-2" value="Delete" formaction="DoctorDeletePrescription?sequenceNum=<%=i%>"
					       <%if(!(tempPrescription.getStatus().equals("pending")))
							   {out.println(" disabled");
							   } %> >
					    </div>
					 </div>
						
						<br>
				   </div>
			  </form>

		
		</div>
	   </div>
   
   	<% i++; } %>

   
</div>

<jsp:include page="footer.jsp" />