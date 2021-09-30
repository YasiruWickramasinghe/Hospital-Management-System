<jsp:include page="header.jsp" />
<%
 			if(session.getAttribute("userName") == null || session == null)
 				{
 				response.sendRedirect("login.jsp");
  				return;
  				}
  		
  		%>
<br>
<h3 class="font-weight-normal">Error</h3>
<hr>
<div class="container " style="margin-bottom: 5em;">


	<div class="jumbotron">
		<h1 class="display-4">Error</h1>
		<p class="lead">error occurred while processing your request</p>
		<hr class="my-4">

		<a class="btn btn-primary btn-lg" href="home.jsp" role="button">Goto
			Home age</a>
	</div>


</div>

<jsp:include page="footer.jsp" />