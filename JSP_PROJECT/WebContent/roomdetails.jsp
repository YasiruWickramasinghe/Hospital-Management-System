
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
<div class="container">

 <%String name = (String)request.getAttribute("roomDetails"); %>
<%= name%>



   

  
</div>

<jsp:include page="footer.jsp" />