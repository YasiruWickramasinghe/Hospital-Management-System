<jsp:include page="header.jsp" />
  		<%
 			if(session.getAttribute("userName") == null || session == null)
 				{
 				response.sendRedirect("login.jsp");
  				return;
  				}
  		
  		%>
<br>
 <h3 class="font-weight-normal">Empty page title</h3>
 <hr>
<div class="container " style="margin-bottom:5em;">
 <h1>Empty page</h1>
</div>

<jsp:include page="footer.jsp" />