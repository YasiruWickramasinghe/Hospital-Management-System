<jsp:include page="header.jsp" />
<%
	if (session.getAttribute("userName") == null || session == null) {
	response.sendRedirect("login.jsp");
	return;
}
%>


<div class="jumbotron" style="idth: 100%;">
	<div class="container">
		<h1 class="display-3">H M S hospitals</h1>
		<p>HMS Hospital has been a famous name in Sri Lankan health care
			for over 6 years. Since being founded we have built a regional
			leadership in medical sector and innovation. We provide superior
			services to improve the health of our community</p>
		<p>
			<a class="btn btn-primary btn-lg" href="#" role="button">Learn
				more &raquo;</a>
		</p>
	</div>
</div>

<div class="container">

	<div class="row" style="margin-top: 2em;">
		<div class="col">
			<div class="card" style="width: 18rem;">
				<img class="card-img-top" src="images/bag.png" alt="Card image cap">
				<div class="card-body">
					<h5 class="card-title">Our Services</h5>
					<p class="card-text">HMS Hospital has been a famous name in Sri Lankan health care
			for over 6 years. Since being founded we have built a regional
			leadership in medical sector and innovation.</p>
					<a href="#" class="btn btn-primary">Learn more &raquo;</a>
				</div>
			</div>
		</div>
		<div class="col">
			<div class="card" style="width: 18rem;">
				<img class="card-img-top" src="images/bag.png" alt="Card image cap">
				<div class="card-body">
					<h5 class="card-title">Contact Us</h5>
					<p class="card-text">HMS Hospital has been a famous name in Sri Lankan health care
			for over 6 years. Since being founded we have built a regional
			leadership in medical sector and innovation.</p>
					<a href="#" class="btn btn-primary">Learn more &raquo;</a>
				</div>
			</div>
		</div>
		<div class="col">
			<div class="card" style="width: 18rem;">
				<img class="card-img-top" src="images/bag.png" alt="Card image cap">
				<div class="card-body">
					<h5 class="card-title">About Us</h5>
					<p class="card-text">HMS Hospital has been a famous name in Sri Lankan health care
			for over 6 years. Since being founded we have built a regional
			leadership in medical sector and innovation.</p>
					<a href="#" class="btn btn-primary">Learn more &raquo;</a>
				</div>
			</div>
		</div>
	</div>

</div>
<div style="width: 100%; height: 5em;"></div>

<jsp:include page="footer.jsp" />
