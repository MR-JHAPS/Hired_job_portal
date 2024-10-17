<%@page import="com.jobmarket.company.model.Job_wrapper"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>

<link rel="stylesheet" href="styles/index_header.css">
<link rel="stylesheet" href="styles/index_jobs.css">
</head>
<body>
	<%@ include file="includes/index_header.jsp" %>

	<main>

	
			<section class="search_bar">
					<form method="POST" action="Employee_job_search">
					<label for="employee_job_search">Search Jobs</label><br>
						<input type="text" name="employee_job_search" id="employee_job_search" placeholder="Job, company name">
						
						<input type="submit" value="Search">
					</form>
	
			</section>
	
	
	


		<%for(Job_wrapper element : job_list){ %>
				<section class="all_jobs">
					<a href="Index_selected_job?job_id=<%=element.getJob().getJob_id()%>" class="job_link">
							<figure class="image">	
								<img src="images/job_image.png">
							</figure>
							
							<div class="job_datas">	
									
										
										<h3><%=element.getJob().getJob_name() %></h3>
										<h5><%=element.getJob_contract().getContract_name()%>  &nbsp;|&nbsp; <%=element.getCompany().getName() %></h5>
										<p><%=element.getJob().getJob_descripcion() %></p>
										
								</div>
						</a>
						<div class="job_buttons">		
						
								<div class="save"><a href="Employee_save_job_servlet?job_id=<%=element.getJob().getJob_id()%>"><img src="images/save_icon_blue.png" width=16px> Save</a></div>
								
						</div>	
						 
				</section>
		<%} %>
		
	
	
	
	
	
	
	
	
	</main>
	
	<%@include file="includes/index_footer.jsp" %>


</body>
</html>