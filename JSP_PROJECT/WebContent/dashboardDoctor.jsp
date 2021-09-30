<jsp:include page="header.jsp" />
<%
	if (session.getAttribute("userName") == null || session == null) {
	response.sendRedirect("login.jsp");
	return;
}
%>
<br>
<h3 class="font-weight-normal">Dashboard</h3>
<hr>
<div class="container">
	<div class="row">
		<div class="col-lg-8">
			<div class="container">

				<div class="row mb-5 mt-2">
					<div class="col-lg-12">
						<div class="card">
							<div class="card-body">
								<span style="color: #333333;"><i
									class="far fa-file fa-4x"></i></span>
								<h5 class="card-title">Create New Prescription</h5>
								<p class="card-text">Enter patient number or patient name
									then click search to find patient's profile</p>
								<form method="post" action="DoctorSearchPatient" class="">
									<input class="form-control form-group" type="text"
										placeholder="enter patient number or patient name"
										name="p_name_id" required> <input type="submit"
										class="btn btn-primary" value="Search">
								</form>
							</div>
						</div>
					</div>
				</div>

				<div class="row mb-5">
					<div class="col-lg-12">
						<div class="card">
							<div class="card-body">
								<span style="color: #333333;"><i
									class="fas fa-history fa-4x"></i></span>
								<h5 class="card-title">Prescription History</h5>
								<p class="card-text">With supporting text below as a natural
									lead-in to additional content.</p>
								<form method="post" action="DoctorGivenPriscription">
									<input type="submit" class="btn btn-primary" value="View">
								</form>
							</div>
						</div>
					</div>
				</div>

				<div class="row mb-5">
					<div class="col-lg-12">
						<div class="card">
							<div class="card-body">
								<span style="color: #333333;"><i
									class="fas fa-flag fa-4x"></i></span>
								<h5 class="card-title">Create Special Notices</h5>
								<p class="card-text">With supporting text below as a natural
									lead-in to additional content.</p>
								<form method="post" action="DoctorCreateNewNotice">
									<input class="form-control" type="text" placeholder="title"
										name="noticeTitle">
									<textarea class="form-control" id="exampleFormControlTextarea1"
										rows="5" name="noticeInfo"></textarea>
									<br> <input type="submit" value="Create"
										class="btn btn-primary">

								</form>


							</div>
						</div>
					</div>
				</div>

				<div class="row mb-5">
					<div class="col-lg-12">
						<div class="card">
							<div class="card-body">
								<span style="color: #333333;"><i
									class="fas fa-tasks fa-4x"></i></span>
								<h5 class="card-title">Manage Notices</h5>
								<p class="card-text">With supporting text below as a natural
									lead-in to additional content.</p>
								<a href="DoctorManageNotices" class="btn btn-primary">Manage</a>
							</div>
						</div>
					</div>
				</div>
			</div>

		</div>

		<%
			int[] print_summary_data = new int[2];
		print_summary_data = null;

		try {
			print_summary_data = (int[]) request.getAttribute("SUMMARY_DATA");
		} catch (Exception e) {

			e.printStackTrace();
			response.sendRedirect("operationFaild.jsp");
		}

		int i = 1;
		%>

		<div class="col-lg-4">
			<div class="card">
				<div class="card-body">
					<H1 class="font-weight-normal">Summary</H1>
					<hr>
					<H4 class="font-weight-normal" id="clock"></H4>
					<hr>
					<p>
						Total Number of Prescriptions -
						<%=print_summary_data[0]%></p>
					<p>
						Total Number of Special Notices -
						<%=print_summary_data[1]%></p>
				</div>
			</div>
		</div>
	</div>
</div>
<script>
	function currentTime() {
		var today = new Date();
		var hr = today.getHours();
		var min = today.getMinutes();
		var sec = today.getSeconds();
		min = time(min);
		sec = time(sec);
		document.getElementById('clock').innerHTML = hr + ":" + min + ":" + sec;
		var t = setTimeout(currentTime, 500);
	}
	function time(i) {
		if (i < 10) {
			i = "0" + i
		}
		; // add zero in front of numbers < 10
		return i;
	}
</script>
<body onload="currentTime()">
	<jsp:include page="footer.jsp" />ml>