<jsp:include page="header.jsp" />
<%
	if (session.getAttribute("userName") == null || session == null) {
	response.sendRedirect("login.jsp");
	return;
}
%>
<br>
<h3 class="font-weight-normal">Manage Notices</h3>
<hr>
<div class="container " style="margin-bottom: 5em;">
	<%@ page import="java.util.ArrayList"%>
	<%@ page import="entities.DoctorNotice"%>
	<%-- Fetching the attributes of the request object 
             
        --%>
	<%
		ArrayList<DoctorNotice> print_doc_notice = new ArrayList<DoctorNotice>();
	print_doc_notice = null;
	try {
		print_doc_notice = (ArrayList<DoctorNotice>) request.getAttribute("DOCTORNOTICE_LIST");
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}

	int i = 1;
	%>

	<%
		for (DoctorNotice temp_notice : print_doc_notice) {
	%>

	<div class="card m-3">
		<div class="card-body">
			<form method="post" action="">
				<input type="text" class="form-control"
					value="<%=temp_notice.getTitle()%>" name="noticeTitle<%=i%>">

				<textarea class="form-control" name="noticeContent<%=i%>"><%=temp_notice.getContent()%></textarea>
				<input type="hidden" name="noticeId<%=i%>"
					value="<%=temp_notice.getNoteid()%>"> <br>
				<div class="row">

					<div class="col-1">
						<input type="submit" class="btn btn-success  m-2" value="Update"
							formaction="DoctorUpdateNotice?sequenceNum=<%=i%>">
					</div>
					<div class="col-11 d-flex justify-content-end">
						<input type="submit" class="btn btn-danger m-2" value="Delete"
							formaction="DoctorDeleteNotice?sequenceNum=<%=i%>">
					</div>
				</div>
			</form>
		</div>
	</div>

	<%
		i++;
	}
	%>

</div>

<jsp:include page="footer.jsp" />