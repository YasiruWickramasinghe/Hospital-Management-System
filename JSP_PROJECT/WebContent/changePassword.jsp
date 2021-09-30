<jsp:include page="header.jsp" />
<%
	if (session.getAttribute("userName") == null || session == null) {
	response.sendRedirect("login.jsp");
	return;
}
%>
<br>
<h3 class="font-weight-normal">Change Password</h3>
<hr>
<div class="container " style="margin-bottom: 5em;">
	<form method="post" action="ChangePassword">
		<div class="form-group">
			<label for="exampleInputEmail1">New Password</label> <input
				type="password" class="form-control" id="InputPassword"
				placeholder="Password" onkeyup="myFunction()" name="InputPassword">
			<small id="emailHelp" class="form-text text-muted">password
				must be at least 8 characters</small>
		</div>
		<div class="form-group">
			<label for="exampleInputPassword1">Confirm New Password</label> <input
				type="password" class="form-control" id="ReInputPassword"
				placeholder="Password" onkeyup="myFunction()" name="ReInputPassword">
		</div>

		<input type="submit" class="btn btn-primary" id="Submitpw"
			value="Submit">
	</form>
</div>
<script>
	function validate() {
		var p1count = document.getElementById("InputPassword").value.length;
		var p2count = document.getElementById("ReInputPassword").value.length;
		var p1 = document.getElementById("InputPassword").value;
		var p2 = document.getElementById("ReInputPassword").value;
		const button = document.getElementById("Submitpw");

		if (p1count >= 8 && p2count >= 8 && p1 == p2) {
			button.disabled = false;
		} else {
			button.disabled = true;
		}

	}

	function currentpw() {
		validate();
		var t = setTimeout(currentpw, 500);
	}
</script>
<body onload="currentpw()">
	<jsp:include page="footer.jsp" />