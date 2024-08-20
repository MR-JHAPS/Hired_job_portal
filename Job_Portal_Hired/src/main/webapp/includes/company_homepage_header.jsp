<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%
    		String session_name = (String) session.getAttribute("attr_company_email");
    
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