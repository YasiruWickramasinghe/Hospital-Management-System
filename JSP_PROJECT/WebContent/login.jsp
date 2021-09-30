<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	response.setHeader("Pragma", "No-cache");
response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
response.setDateHeader("Expires", -1);
%>
<%@ page session="true"%>

<!DOCTYPE html>
<html style="width: 100%; height: 100%;">
<head>
<meta charset="UTF-8">
<link rel="icon" href="images/logoonly.png" type="icon">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">
<link href="css/all.css" rel="stylesheet">
<title>Hospital management system</title>
</head>
<body style="width: 100%; height: 100%;">
	<%
		//System.out.println(session.getAttribute("userName"));
	//System.out.println(session.getAttribute("userName") == "null");
	if (session.getAttribute("userName") != null) {
		//System.out.println("hi");
		response.sendRedirect("home.jsp");
		return;
	}
	%>

	<div style="width: 100%; height: 100%; position: relative;"
		class="text-center">
		<form class="form-signin text-center" action="LoginValidator"
			method="post"
			style="width: 4in; display: inline-block; padding-top: 8em;">
			<img class="mb-4" src="images/logoonly.png" alt="" width="72"
				height="72">
			<h1 class="h2 mb-3 font-weight-normal">Sign in</h1>
			<label for="inputEmail" class="sr-only">User Name</label> <input
				type="text" id="inputEmail" class="form-control"
				placeholder="User name" name="username" required autofocus>
			<br> <label for="inputPassword" class="sr-only">Password</label>
			<input type="password" id="inputPassword" class="form-control"
				placeholder="Password" name="password" required>
			<div class="checkbox mb-3">
				<br>
			</div>
			<button class="btn btn-lg btn-primary btn-block" type="submit">Sign
				in</button>
			<p class="mt-5 mb-3 text-muted">&copy;2020-HMS</p>
		</form>
	</div>

</body>





<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
	integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
	crossorigin="anonymous"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"
	integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
	crossorigin="anonymous"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"
	integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
	crossorigin="anonymous"></script>
</html>