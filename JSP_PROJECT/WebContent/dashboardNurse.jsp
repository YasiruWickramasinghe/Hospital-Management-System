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
 <h3 class="font-weight-normal">Dashboard</h3>
 <hr>
 
 
<div class="container">
				<div class="card">
			      <div class="card-body">
		        
		        <h5 class="card-title">Pending Prescriptions</h5>
				<form action ="NurseServelet" method="post">

					<input type = "submit" name="Details" value="Details" class="btn btn-primary">
				</form>
				</div>
				</div>	
	     
</div>

<jsp:include page="footer.jsp" />