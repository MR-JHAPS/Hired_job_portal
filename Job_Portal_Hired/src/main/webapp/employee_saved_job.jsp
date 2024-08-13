<%-- <%@page import="com.jobmarket.company.model.Job_information"%> --%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%
   
    
    
    %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Hired-Homepage</title>
<link rel="stylesheet" href="styles/index_header.css">
<link rel="stylesheet" href="styles/employee_home_style.css">
</head>
<body>

	<%@ include file="includes/employee_homepage_header.jsp" %>

	<main>
		
	
			<section class="search_bar">
					<form method="GET" action="Employee_job_search">
					<label for="employee_job_search">Search Jobs</label><br>
						<input type="text" name="employee_job_search" id="employee_job_search" placeholder="Job, company name">
						
						<input type="submit" value="Search">
					</form>
	
			</section>
	
	
		<!--  THIS MESSAGE IS ONLY AFTER UPDATING THE ACCOUNT DETAILS IS DONE-->	
		<%if (employee_update_success!=null){ %>
		<section class="account_update_message">
			
			<p><%=employee_update_success %></p>
		</section>
		<%} %>

		
		<h2 >Your Saved Jobs</h2>

		<%for(Job_wrapper element : saved_job_list){ %>
				<section class="all_jobs">
					<a href="Employee_selected_job?id=<%=element.getJob().getJob_id()%>" class="job_link">
							<div class="job_datas">	
									
										
										<h3><%=element.getJob().getJob_name() %></h3>
										<h5><%=element.getJob_contract().getContract_name()%>  &nbsp;|&nbsp; <%=element.getCompany().getName() %></h5>
										<p><%=element.getJob().getJob_descripcion() %></p>
										
								</div>
						</a>
<!-- 						<div class="job_buttons">		 -->
						
<%-- 								<div class="save"><a href="Employee_saved_job_servlet?job_id=<%=element.getJob().getJob_id()%>"><img src="images/save_icon_blue.png" width=16px> Save</a></div> --%>
								
<!-- 						</div>	 -->
						 
				</section>
		<%} %>
		
	
	
	
	
	
	
	
	
	</main>
	
	<%@include file="includes/index_footer.jsp" %>
	
</body>
</html>