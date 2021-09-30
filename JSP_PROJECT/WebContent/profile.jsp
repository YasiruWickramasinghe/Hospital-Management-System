<jsp:include page="header.jsp" />
<%
	if (session.getAttribute("userName") == null || session == null) {
	response.sendRedirect("login.jsp");
	return;
}
%>
<%
	response.setHeader("Pragma", "No-cache");
response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
response.setDateHeader("Expires", -1);
%>
<br>
<h3 class="font-weight-normal">Profile</h3>
<hr>
<div class="container">
	<%@ page import="java.sql.*"%>
	<%@ page import="databaseConnection.dbConn"%>
	<%
		Connection dbConnection = dbConn.returnConn();

	Statement stmt = (Statement) dbConnection.createStatement();
	String sqlStatement = "SELECT * FROM user WHERE username='" + session.getAttribute("userName") + "'";
	ResultSet rs = stmt.executeQuery(sqlStatement);
	rs.first();
	%>

	<%@ page import="entities.User"%>


	<%
		User print_user = null;
	try {
		print_user = (User) request.getAttribute("USER_DATA");
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	%>

	<div class="jumbotron jumbotron-fluid container">
		<div class="row">
			<div class="col-3 justify-content-center">
				<img src="images/user.png" alt="user" class="rounded-circle"
					style="height: 8em;">

			</div>
			<div class="col-9">

				<h1 class="display-4"><%=print_user.getfName() + " " + print_user.getlName()%></h1>
				<p class="lead">
					User Name :
					<%=print_user.getUserName()%></p>
				<p class="lead">
					Date of Birth :
					<%=print_user.getDob()%></p>
				<p class="lead">
					Profession :
					<%=print_user.getUserType()%></p>
				<form action="" method="post">
					<button type="submit" class="btn btn-primary" formaction="Logout">Logout</button>
					<button type="submit" class="btn btn-warning"
						formaction="changePassword.jsp">Change Password</button>
				</form>
			</div>
		</div>
	</div>




</div>

<jsp:include page="footer.jsp" />