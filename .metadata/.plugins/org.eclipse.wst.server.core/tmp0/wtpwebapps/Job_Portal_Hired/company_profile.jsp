<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="styles/company_profile.css">
</head>
<body>
	<%@include file="includes/company_homepage_header.jsp" %>

	<main>
		<div class= "container">
	
			<section class="profile_picture">
				<img src="images/job_image.png">
			</section>	
			
			<section class="profile_details">
				<h3>YOUR COMPANY PROFILE DETAILS</h3>
				
				<article class=row1>	
					<p class="title"><b>Company Name : </b>  <%=session_company_name %></p>
					</article>
				
				<article class=row2>
					<p class="title"> <b>Email : </b><%=session_company_email %></p>
					<p class="telephone"> <b>Telephone :</b> <%=session_company_telephone %></p>
				</article>
				
				<article class=row3>
					<p class="title"> <b>Address :</b> <%=session_company_address %></p>
					<p class="city"> <b>City :</b> <%=session_company_city %></p>
				</article>
				
				<article class=row4>
					<p class="title"> <b>Country : </b> <%=session_company_country %></p>	
				</article>	
			</section>
			
			<section class="cv_details">
				This contains some other things.	
			</section>
			
		</div>	


		<section class="update">
				<button><a href="Company_account_settings">Update Account</a></button>
		</section>
			
		


	
	
	</main>

	
	<%@include file="includes/index_footer.jsp" %>
</body>

</html>