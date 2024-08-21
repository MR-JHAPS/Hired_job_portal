<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="styles/index_header.css">
<link rel="stylesheet" href="styles/company_applicants_style.css">
</head>

<body>

	<%@ include file="includes/company_homepage_header.jsp" %>
	
	<main>

		<%for(Applied_job element : applied_job_info){ %>
			<section class = "outer_layer">
			
				<div class="job_info">	
					<h3><%=element.getJob().getJob_name() %></h3>
					<p><%=element.getJob().getJob_descripcion() %></p>
					<p><%=element.getCompany().getName() %></p>
				</div>	
				
				<div class="applicant_info">	
					<h3>First Name : </h3> <p><%=element.getEmployee().getFirst_name() %></p>
					<h3>Last Name : </h3>	<p><%=element.getEmployee().getLast_name() %></p>
					<h3>EMAIL : </h3>		<p><%=element.getEmployee().getEmail() %></p>
					<h3>Telephone : </h3>	<p><%=element.getEmployee().getTelephone() %></p>
					<h3>Address : </h3>		<p><%=element.getAddress().getAddress_name() %></p>
					<h3>City : </h3>		<p><%=element.getCity().getCity_name() %></p>
					<h3>Country : </h3>		<p><%=element.getCountry().getCountry_name() %></p>
					
					<h3>Cover Letter : </h3><p><%=element.getCover_letter() %></p>
					
					<h3>CV Name : </h3> <p><%=element.getCv().getCv_name() %></p>
					<!--  we will look for cv id and then get the cv name just to be sure for the future for hashing the name -->
					
					<a href="Getting_cv_from_uploads?cv_id=<%=element.getCv().getCv_id() %>">Download CV</a>
				</div>	
			
			
				
			</section>

		<%} %>

	
	</main>
	
	<%@include file="includes/index_footer.jsp" %>

</body>
</html>