<jsp:include page="header.jsp" />
<%
	if (session.getAttribute("userName") == null || session == null) {
	response.sendRedirect("login.jsp");
	return;
}
%>

<%
	int patientId = 0;
patientId = Integer.parseInt(request.getParameter("patientId"));
%>
<br>
<h3 class="font-weight-normal">Create New Prescription</h3>
<hr>
<div class="container " style="margin-bottom: 5em;">
	<div class="jumbotron jumbotron-fluid container">
		<div class="row">
			<div class="col-3 justify-content-center">
				<img src="images/user.png" alt="user" class="rounded-circle"
					style="height: 8em;">
				<button class="btn btn-primary "
					onclick="document.location='DoctorViewPatientPrescriptionHistory?patientId=<%=patientId%>'">View
					Prescription History</button>
			</div>
			<div class="col-9">


				<%@ page import="entities.Patient"%>
				<%-- Fetching the attributes of the request object 
             
        --%>


				<%
					Patient print_patient = null;
				try {
					print_patient = (Patient) request.getAttribute("PATIENT_DATA");
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				%>

				<h1 class="display-4"><%=print_patient.getfName() + " " + print_patient.getlName()%></h1>
				<p class="lead"><%=print_patient.getAge()%>
					years old
				</p>
				<p class="lead">
					special conditions :
					<%=print_patient.getSpecialNote()%></p>
				<p class="lead">
					Patient ID NUmber :
					<%=print_patient.getPatientIDnumber()%></p>

			</div>
		</div>
	</div>

	<div class="card">
		<div class="card-body">
			Add New Prescription
			<form action="InsertPrescription" method="post">
				<textarea class="form-control" id="exampleFormControlTextarea1"
					rows="8" name="priscription_data" required></textarea>
				<br> <input type="hidden"
					value="<%=print_patient.getPatientIDnumber()%>" name="patient_id">
				<input type="hidden" value="<%=session.getAttribute("userid")%>"
					name="doctor_id"> <input type="submit"
					class="btn btn-primary" value="Save">
			</form>
		</div>

	</div>



</div>

<jsp:include page="footer.jsp" />