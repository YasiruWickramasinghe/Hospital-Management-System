<jsp:include page="header.jsp" />
  		<%
 			if(session.getAttribute("userName") == null || session == null)
 				{
 				response.sendRedirect("login.jsp");
  				return;
  				}
  		
  		%>
<br>
 <h3 class="font-weight-normal">Dashboard</h3>
 <hr>
<div class="container">
	<div class="jumbotron" style="width: 70%;">
        <div class="container">
          
         <form action="checkroom" method="post">
 				ENTER ROOM TYPE 
 				<input class="form-control form-group" type="text" name="typeofroom" placeholder="emergency/normal">
 				<input type="submit" name="checkroomavailable" value="search" class="btn btn-primary">
 	
 		</form>
         
         
        </div>
      </div>
</div>
<jsp:include page="footer.jsp" />