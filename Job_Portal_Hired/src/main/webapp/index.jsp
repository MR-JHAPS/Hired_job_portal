<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
    %>   
    
    <%
 		//THIS IS MESSAGE FOR THE SIGN_UP:   
    	String company_signed_up = (String) request.getAttribute("attr_company_signed_up") ;
   		String company_not_signed_up = (String) request.getAttribute("attr_company_not_signed_up") ;
   		String employee_signed_up = (String) request.getAttribute("attr_employee_signed_up") ;
   		String employee_not_signed_up= (String) request.getAttribute("attr_employee_not_signed_up") ;
   		
   		//
    	String wrong_password = (String) request.getAttribute(":password_wrong");
    	
    	//FROM Servlet - "Employee_delete_account"
    	String delete_success = (String) request.getAttribute("attr_delete_success");
    
    %>
    
    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Hired/Hire</title>
<link rel="stylesheet" href="styles/index_header.css">
<link rel="stylesheet" href="styles/index_style.css">
</head>
<body>
	
	<!-- THIS WILL INCLUDE THE HEADER FOR INDEX PAGE THAT IS LOCATED IN webapp/includes -->
	<%@ include file="includes/index_header.jsp" %>
	
	<main>
		
		<!--THIS IS TO SHOW A MESSAGE IN A SECTION AFTER THE company SIGN UP IS COMPLETED  -->
		<% if(company_signed_up!=null){ %>
<!-- 	        	<section class="signed_up_message"> -->
	        	<section class="signed_up">
			           <h3><%=company_signed_up %></h3>       
	        	</section>
		<%} %>
		<!--THIS IS TO SHOW A MESSAGE IN A SECTION AFTER THE company SIGN UP IS FAILED  -->
		<% if(company_not_signed_up!=null){ %>
	        	<section class="not_signed_up">
			           <h3><%=company_not_signed_up %></h3>       
	        	</section>
		<%} %>
		
		
		<% if(delete_success!=null){ %>
	        	<section class="delete_success_message">
			           <h3><%=delete_success %></h3>
			           
	        	</section>
  	
		<%} %>
			
	
		<section class="form_header">
		<h3>Sign in as employee</h3><br>
		</section>
		
		<section class="form_area">
							
				<form  action="Sign_in_employee_verification" method="POST">
				
				
					<input type="text" name="email" id="email" placeholder="Enter your email">
					<br><br>
					
					<input type="password" name="password" id="password" placeholder="Password">
					<br><br>
			
					<input type="submit" value="Sign in">
						
				</form>
				<br><hr>
				<div class="sign_in_company">
						<label> OR</label>
						<a href ="company_sign_in.jsp" id="sign_in_company"><button>Sign in as Company</button></a>	
						<br><br>
				</div>
		</section>
		
<!--THIS IS TO SHOW A MESSAGE IN A SECTION AFTER THE SIGN IN DATA IS WRONG  -->
							<% if(wrong_password!=null){ %>
						        	<section class="wrong_password_message">
								           <p><%=wrong_password %></p>
								           
						        	</section>
							<%} %>
		
		
		
		
		<section class="sign_up">
	
					<article class="sign_up_employee">
						<h4>Are you a person looking for a Job? Look no further and sign up.</h4>
	<!-- 				<label for="sign_up_employee">Sign up as an Employee</label><br> -->
						<a href = "Display_country_employee" id="sign_up_employee"><button>Sign Up As Employee</button></a>
					</article>
					
		
					<article class="sign_up_company">
						<h4>Are you a Company looking for an Employee to hire? Sign up here.</h4>
	<!-- 				<label for="sign_up_company">Sign up as a Company</label><br> -->
						<a href = "Display_country_company" id="sign_up_company"><button>Sign Up As Company</button></a>
					</article>
					
					
		</section>
	
	
		
							
							
							
	
	
	</main>
	
	
	<!-- THIS WILL INCLUDE THE FOOTER FOR INDEX PAGE THAT IS LOCATED IN webapp/includes -->
	<%@ include file="includes/index_footer.jsp" %>
	
</body>
</html>