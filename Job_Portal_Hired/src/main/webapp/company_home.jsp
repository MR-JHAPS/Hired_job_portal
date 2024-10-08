<%@page import="com.jobmarket.company.model.Job_wrapper"%>
<%@page import="com.jobmarket.hired.model.Country"%>
<%@page import="com.jobmarket.hired.model.City"%>
<%@page import="com.jobmarket.hired.model.Address"%>
<%@page import="com.jobmarket.hired.model.Job_salary"%>
<%@page import="com.jobmarket.hired.model.Job_contract"%>
<%@page import="com.jobmarket.hired.model.Job_category"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.jobmarket.company.model.Job"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%
// 		String session_name = (String) session.getAttribute("attr_company_name");


//Only shows job information of Company with active session id.	
		List<Job_wrapper> job_list_by_company_id = new ArrayList<Job_wrapper>();
		if((request.getAttribute("attr_job_list_by_company_id"))!=null){
			job_list_by_company_id = (List<Job_wrapper>) request.getAttribute("attr_job_list_by_company_id");
		}

%>    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Homepage-Company</title>
<link rel="stylesheet" href="styles/index_header.css">
<link rel="stylesheet" href="styles/company_home_style.css">
</head>
<body>
		
	<%@ include file="includes/company_homepage_header.jsp" %>
	
	<main>
	

	
	
	<section class="search_bar">
		<form method="GET" action="Company_job_search">
		<label for="company_job_search">Search</label><br>
			<input type="text" name="company_job_search" id="company_job_search" placeholder="Search your offers">
			
			<input type="submit" value="Search">
		
		</form>
	
	</section>
	




<%for(Job_wrapper element : job_list_by_company_id){ %>
		<section class="job_posted">
			<a href="Company_selected_job?job_id=<%=element.getJob().getJob_id()%>" >
							<div class="job_datas">		
						<h3><%=element.getJob().getJob_name() %></h3>
					
						
								<h5> <%= element.getJob_contract().getContract_name()%> &nbsp;| &nbsp;<%= element.getCompany().getName()%> </h5>
						
					
					<p><%=element.getJob().getJob_descripcion()%></p>
					
			</a>	
		</section>

<%} %>	






	</main>
	
	<%@include file="includes/index_footer.jsp" %>
	
</body>
</html>