<%@page import="com.jobmarket.company.model.Job_wrapper"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.jobmarket.hired.model.Country"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    
   
    
     <%
		//THIS PART IS SO THAT YOU CAN SEE THE JOBS WITHOUT LOGGING IN:
			
				//ALL JOBS TO DISPLAY ON HOMEPAGE From "Employee_homepage" Servlet.
				List<Job_wrapper> job_list = new ArrayList<Job_wrapper>();
				if(request.getAttribute("attr_job_list")!=null){
					job_list = (List<Job_wrapper>) request.getAttribute("attr_job_list");
				}
				
				//List of saved job from "DISPLAY_SAVED_JOB"  servlet.
				List<Job_wrapper> saved_job_list = new ArrayList<Job_wrapper>();
				if(request.getAttribute("attr_saved_job_list")!=null){
					saved_job_list = (List<Job_wrapper>) request.getAttribute("attr_saved_job_list");
				}
				
				
				//this is the list of country to show in employee account settings.
				List<Country> country_list1 = new ArrayList<Country>();
				if(request.getAttribute("attr_country_list")!=null){
					country_list1 = (List<Country>) request.getAttribute("attr_country_list");
				}
				
				%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="css/style.css">

<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=Roboto:ital,wght@0,100;0,300;0,400;0,500;0,700;0,900;1,100;1,300;1,400;1,500;1,700;1,900&display=swap" rel="stylesheet">

<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=Montserrat:ital,wght@0,100..900;1,100..900&family=Roboto:ital,wght@0,100;0,300;0,400;0,500;0,700;0,900;1,100;1,300;1,400;1,500;1,700;1,900&display=swap" rel="stylesheet">

</head>
<body>

	<header>	
		

					<h1>HIRED & HIRE</h1>
		
	
	</header>
	
	<nav>
		<ul>
			<li><a href="index.jsp"> Home </a></li>
<!-- 			<li><a href="#"> Search companies </a></li> -->
			<li><a href="Index_jobs"> Search Jobs </a></li>
			<li><a href="about_us.jsp"> About us </a></li>
		</ul>
	</nav>




</body>
</html>