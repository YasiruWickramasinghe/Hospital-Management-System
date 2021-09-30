<jsp:include page="header.jsp" />
<%
	if (session.getAttribute("userName") == null || session == null) {
	response.sendRedirect("login.jsp");
	return;
}
%>
<br>
<h3 class="font-weight-normal">Priscription History</h3>
<hr>
<div class="container " style="margin-bottom: 5em;">
	<%@ page import="java.util.ArrayList"%>
	<%@ page import="entities.Prescription"%>
	<%-- Fetching the attributes of the request object 
             
        --%>
	<%
		ArrayList<Prescription> print_rescription_list = new ArrayList<Prescription>();
	print_rescription_list = null;
	try {
		print_rescription_list = (ArrayList<Prescription>) request.getAttribute("PRISCRIPTION_LIST");
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}

	int i = 1;
	%>

	<%
		for (Prescription temp_Prescription : print_rescription_list) {
	%>



	<div class="card m-3">
		<div class="card-body">
			<h4>
				Prescription :
				<%=temp_Prescription.getPriscriptionid()%></h4>
			<p class="font-weight-light">
				by Dr :
				<%=temp_Prescription.getGivenBy()%></p>
			<p class="font-weight-light">
				Date :
				<%=temp_Prescription.getDate()%></p>
			<p class="font-weight-light">
				Status :
				<%=temp_Prescription.getStatus()%></p>
			<p><%=temp_Prescription.getDetails()%></p>
			<br>

		</div>

	</div>


	<%
		i++;
	}
	%>



</div>

<jsp:include page="footer.jsp" />