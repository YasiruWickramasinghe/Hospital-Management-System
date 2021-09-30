<jsp:include page="header.jsp" />
<%
	if (session.getAttribute("userName") == null || session == null) {
	response.sendRedirect("login.jsp");
	return;
}
%>

<div class="row">
	<div class="col">
		<center>
			<h1 class="text-success">Welcome to Admin Portal</h1>
		</center>
	</div>
</div>


<div class="col">
	<div class="nav justify-content-end">
		<nav class="navbar navbar-light bg-light">
			<form class="form-inline">
				<input class="form-control mr-sm-2" type="search"
					placeholder="Search" aria-label="Search">
				<button class="btn btn-primary type="submit">Search</button>
			</form>
		</nav>
	</div>
</div>

<div class="jumbotron text-center">



	<div class="row">
		<div class="col">
			<div class="card img-fluid" style="width: 200px">
				<img class="card-img-top" src="images\Admin\Dashboard\doctor.jpg"
					alt="Card image" style="width: 150%">
				<div class="card-img-overlay">
					<h3 class="card-title">Doctor</h3>
					<p class="card-text">skrh ojrksj rshio jpok posrk po js</p>
					<form method="get" action="AdminAllDoctorList">
						<input class="btn btn-primary" type="submit" value="Check">
					</form>

				</div>
			</div>
		</div>
		<div class="col">
			<div class="card img-fluid" style="width: 200px">
				<img class="card-img-top" src="images\Admin\Dashboard\nurse.jpg"
					alt="Card image" style="width: 150%">
				<div class="card-img-overlay">
					<h3 class="card-title">Nurse</h3>
					<p class="card-text">rksj ihkrsoihjs oijhps rskhoij rjoijsr pr
						kposj</p>
					<a href="#" class="btn btn-primary" style="width: 160%">Check</a>
				</div>
			</div>
		</div>
		<div class="col">
			<div class="card img-fluid" style="width: 200px">
				<img class="card-img-top"
					src="images\Admin\Dashboard\pharmacist.jpg" alt="Card image"
					style="width: 150%">
				<div class="card-img-overlay">
					<h3 class="card-title">Pharmacist</h3>
					<p class="card-text">soirj oirhoisjo ihjsrio rsoijhoi jior joi</p>
					<a href="#" class="btn btn-primary" style="width: 160%">Check</a>
				</div>
			</div>
		</div>

	</div>
	<div class="row">
		<div class="col">
			<div class="card img-fluid" style="width: 200px">
				<img class="card-img-top" src="images\Admin\Dashboard\reception.jpg"
					alt="Card image" style="width: 150%">
				<div class="card-img-overlay">
					<h3 class="card-title">Receptionist</h3>
					<p class="card-text">osirjo rosih rsoiho jhoi sroihosjo rois ji</p>
					<a href="#" class="btn btn-primary" style="width: 160%">Check</a>
				</div>
			</div>
		</div>
		<div class="col">
			<div class="card img-fluid" style="width: 200px">
				<img class="card-img-top" src="images\Admin\Dashboard\security.jpg"
					alt="Card image" style="width: 150%">
				<div class="card-img-overlay">
					<h3 class="card-title">Security</h3>
					<p class="card-text">siur rsiu hui rsiuh uisrj iusr hiusi</p>
					<a href="#" class="btn btn-primary" style="width: 160%">Check</a>
				</div>
			</div>
		</div>
		<div class="col">
			<div class="card img-fluid" style="width: 200px">
				<img class="card-img-top" src="images\Admin\Dashboard\cleaners.jpg"
					alt="Card image" style="width: 150%">
				<div class="card-img-overlay">
					<h3 class="card-title">Cleaners</h3>
					<p class="card-text">dsgnsfjdg iugji fohigdfjoh f klfdmhlk</p>
					<a href="#" class="btn btn-primary" style="width: 160%">Check</a>
				</div>
			</div>
		</div>
	</div>
</div>

<jsp:include page="footer.jsp" />