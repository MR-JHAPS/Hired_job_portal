
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Your Profile</title>
<link rel="stylesheet" href="styles/employee_profile.css">
</head>
<body>
	
	<%@include file="includes/employee_homepage_header.jsp" %>

	<main>
		<div class= "container">
	
			<section class="profile_picture">
				<img src="images/job_image.png">
			</section>	
			
			<section class="profile_details">
				<h3>YOUR PROFILE DETAILS</h3>
				
				<article class=row1>	
					<p class="title"><b>First Name : </b>  <%=session_employee_first_name %></p>
					<p class="last_name"><b>Last Name :</b> <%=session_employee_last_name %></p>
				</article>
				
				<article class=row2>
					<p class="title"> <b>Email : </b><%=session_employee_email %></p>
					<p class="telephone"> <b>Telephone :</b> <%=session_employee_telephone %></p>
				</article>
				
				<article class=row3>
					<p class="title"> <b>Address :</b> <%=session_employee_address %></p>
					<p class="city"> <b>City :</b> <%=session_employee_city %></p>
				</article>
				
				<article class=row4>
					<p class="title"> <b>Country : </b> <%=session_employee_country %></p>	
				</article>	
			</section>
			
			<section class="cv_details">
				This contains the details of the cv.	
			</section>
			
		</div>	


		<section class="update">
				<button><a href="Employee_account_settings">Update Account</a></button>
		</section>
			
		


	
	
	</main>

	
	<%@include file="includes/index_footer.jsp" %>
</body>
</html>