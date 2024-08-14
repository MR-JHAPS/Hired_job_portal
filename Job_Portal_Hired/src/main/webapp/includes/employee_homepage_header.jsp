<%@page import="com.jobmarket.hired.model.Country"%>
<%@page import="com.jobmarket.company.model.Job_wrapper"%>
<%@page import="com.jobmarket.client.model.Employee"%>
<%-- <%@page import="com.jobmarket.company.model.Job_information"%> --%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
     <%
//         

				List<Job_wrapper> job_list = new ArrayList<Job_wrapper>();
				if(request.getAttribute("attr_job_list")!=null){
					job_list = (List<Job_wrapper>) request.getAttribute("attr_job_list");
				}
				
				
				List<Job_wrapper> saved_job_list = new ArrayList<Job_wrapper>();
				if(request.getAttribute("attr_saved_job_list")!=null){
					saved_job_list = (List<Job_wrapper>) request.getAttribute("attr_saved_job_list");
				}
				
				
				//this is the list of country to show in employee account settings.
				List<Country> country_list = new ArrayList<Country>();
				if(request.getAttribute("attr_country_list")!=null){
					country_list = (List<Country>) request.getAttribute("attr_country_list");
				}
             	
             	String employee_update_success = (String) request.getAttribute("attr_employee_update_success");
              
              	session = request.getSession(false);
             	Integer session_employee_id = (Integer) session.getAttribute("attr_employee_id");
             	String session_employee_first_name = (String) session.getAttribute("attr_employee_first_name");
             	String session_employee_last_name = (String) session.getAttribute("attr_employee_last_name");
             	String session_employee_email = (String) session.getAttribute("attr_employee_email");
             	String session_employee_password = (String) session.getAttribute("attr_employee_password");
             	String session_employee_telephone = (String) session.getAttribute("attr_employee_telephone");
             	String session_employee_address = (String) session.getAttribute("attr_employee_address");
             	String session_employee_country = (String) session.getAttribute("attr_employee_country");
             	int session_employee_country_id = (Integer) session.getAttribute("attr_employee_country_id");
             	String session_employee_city = (String) session.getAttribute("attr_employee_city");
         %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="styles/index_header.css">

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
				<li><a href="Employee_homepage">Home</a></li>
				<li><a href="Display_saved_job">Saved Job</a></li>
				
<!-- 				<li><a href="#">Messages</a></li> -->
				<li class="float_right"><a href="Employee_account_settings">My Account</a></li>		
				<li class="float_right"><a href="Employee_log_out">Log out :  <%=session_employee_email %></a></li>
			
		</ul>
	</nav>

</body>
</html>