<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
 <%
	//FROM Sign_up_company   if result inserted successfully in database. 
 	String sign_up_status = (String) request.getAttribute(":sign_up_status") ;
 
 //FROM Sign_in_company_verification, password doesnot match in the db.
 	String wrong_password = (String) request.getAttribute("attr_wrong_password");
 
 %> 
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="styles/index_header.css">
<link rel="stylesheet" href="styles/company_sign_in_style.css">
</head>
<body>

	
	<!-- THIS WILL INCLUDE THE HEADER FOR INDEX PAGE THAT IS LOCATED IN webapp/includes -->
	<%@ include file="includes/index_header.jsp" %>
	
	<main>
		
		<!--THIS IS TO SHOW A MESSAGE IN A SECTION AFTER THE SIGN UP IS COMPLETED/FAILED  -->
		<% if(sign_up_status!=null){ %>
	        	<section class="sign_up_status_message">
			           <h3><%=sign_up_status %></h3>
			           
	        	</section>
  	
		<%} %>
	
		<section class="form_header">
			<h3>Sign in as Company</h3><br>
		</section>
	
		<section class="form_area">
				
				
				<form  action="Sign_in_company_verification" method="GET">
				
					<input type="text" name="email" id="email" placeholder="Email">
					<br><br>
					
					<input type="password" name="password" id="password" placeholder="Password">
					<br><br>
			
					<input type="submit" value="Sign in">
						
				</form>
				<br>
				
		</section>
		
							<!--THIS IS TO SHOW A MESSAGE IN A SECTION AFTER THE SIGN IN DATA IS WRONG  -->
							<% if(wrong_password!=null){ %>
						        	<section class="wrong_password_message">
								           <h3><%=wrong_password %></h3>
								           
						        	</section>
							<%} %>
							
							
	
	
	</main>
	
	
	<!-- THIS WILL INCLUDE THE FOOTER FOR INDEX PAGE THAT IS LOCATED IN webapp/includes -->
	<%@ include file="includes/index_footer.jsp" %>
	
</body>
</html>
</body>
</html>