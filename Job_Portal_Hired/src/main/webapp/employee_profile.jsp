
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
					
					<p class="title"> First Name : Neraz</p>
					<p class="title"> Last Name : Oli</p>
				</article>
				
				<article class=row2>
					
					<p class="title"> Email : nirajoli@gmail.com</p>
					<p class="title"> Telephone : 798967868</p>
				</article>
				
				<article class=row3>
					
					<p class="title"> Address : Calle Irala</p>
					<p class="title"> City : Bilbao</p>
				</article>
				
				<article class=row4>
					
					<p class="title"> Country: Spain</p>
					
				</article>
					
				
			</section>
			
			
			<section class="cv_details">
				This contains the details of the cv.
				
			</section>
		</div>	




	
	
	</main>

	
	<%@include file="includes/index_footer.jsp" %>
</body>
</html>