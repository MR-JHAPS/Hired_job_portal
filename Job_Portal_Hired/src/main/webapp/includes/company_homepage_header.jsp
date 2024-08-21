<%@page import="com.jobmarket.company.model.Applied_job"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="com.jobmarket.Session_constants"%>
    
    <%
    		String session_name = (String) session.getAttribute("attr_company_email");
    
    
    session = request.getSession(false);
 	Integer session_employee_id = (Integer) session.getAttribute( Session_constants.COMPANY_SESSION_ID );
 	String session_employee_name = (String) session.getAttribute( Session_constants.COMPANY_SESSION_NAME );
 	String session_employee_email = (String) session.getAttribute(Session_constants.COMPANY_SESSION_EMAIL);
 	String session_employee_password = (String) session.getAttribute(Session_constants.COMPANY_SESSION_PASSWORD);
 	String session_employee_telephone = (String) session.getAttribute(Session_constants.COMPANY_SESSION_TELEPHONE);
 	String session_employee_address = (String) session.getAttribute(Session_constants.COMPANY_SESSION_ADDRESS);
 	String session_employee_country = (String) session.getAttribute(Session_constants.EMPLOYEE_SESSION_COUNTRY);
 	int session_employee_country_id = (Integer) session.getAttribute(Session_constants.COMPANY_SESSION_COUNTRY_ID);
 	String session_employee_city = (String) session.getAttribute(Session_constants.COMPANY_SESSION_CITY);

    
 	List<Applied_job> applied_job_info = (List<Applied_job>) session.getAttribute(Session_constants.COMPANY_SESSION_APPLIED_JOB);
 	
 	
 	
 	
    
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
				<li><a href="Display_company_posted_job">Home</a></li>
				<li><a href="Company_start_job_posting">Post Job</a></li>
				<li><a href="Display_job_applicant">Applicants</a></li>
<!-- 				<li><a href="company_message.jsp">Messages</a></li> -->
				<li class="float_right"><a href="Company_account_settings">My Account</a></li>		
				<li class="float_right"><a href="Company_log_out">Log out : <%=session_name  %></a></li>
			
		</ul>
	</nav>

</body>
</html>