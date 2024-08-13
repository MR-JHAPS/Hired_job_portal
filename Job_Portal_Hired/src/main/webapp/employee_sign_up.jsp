<%@page import="com.jobmarket.hired.model.Country"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%
    	String password_error = (String) request.getAttribute(":password_error");
    	
    
    	//FROM hired_controller/Display_country.
    	List<Country> country_list = new ArrayList<Country>();
    	if(request.getAttribute("attr_country_list")!=null){
    		country_list = (List<Country>) request.getAttribute("attr_country_list"); 
    	}
    
    %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Sign up - Employee </title>
<link rel="stylesheet" href="styles/index_header.css">
<link rel="stylesheet" href="styles/sign_up_company_style.css">
</head>
<body>

		<%@ include file="includes/index_header.jsp" %>

	<main>
			<section class="form_outer_area">
				<form class="form_area" method="GET" action="Sign_up_employee_insert">
					
						<article class="form_left">
								<label for="first_name">First name </label>
								<input type="text" name="first_name" id="first_name" placeholder="First name"><br><br><br>
								
								<label for="last_name">Last name </label>
								<input type="text" name="last_name" id="last_name" placeholder="Last name"><br><br><br>
								
								<label for="telephone">Telephone </label>
								<input type="text" name="telephone" id="telephone" placeholder=" telephone "><br><br><br>
								
								<label for="country">Country </label>
								
									<select name="country" id="country">
									<%for(Country element : country_list){ %>
										<option value="<%=element.getId()%>"> <%=element.getCountry_name() %> </option>
									<%} %>
									</select>
									<br><br><br>
								
<!-- 								<input type="text" name="country" id="country" placeholder="Country"><br><br><br> -->
								
								
								
								<label for="password">Your Password </label>
								<input type="password" name="password" id="password" placeholder="Password"><br><br><br>
								
								<label for="password_repeat">Repeat Password </label>
								<input type="password" name="password_repeat" id="password_repeat" placeholder="Repeat Password"><br><br><br>
								
								
								<input type ="reset" name="reset" id="reset" value="Reset">
								<input type="submit" name="sign_up_employee" id="sign_up_employee" value="Sign up">
						</article>
					
					
					
					
						<article class="form_right">
						
								<label for="address">Address </label>
								<input type="text" name="address" id="address" placeholder="Address"><br><br><br>
								
								<label for="email">Email </label>
								<input type="email" name="email" id="email" placeholder="Email"><br><br><br>
							
								<label for="date_of_birth">Date of Birth</label>
								<input type="date" name="date_of_birth" id="date_of_birth" placeholder="Date of Birth"><br><br><br>
								
								
								<label for="city">City Name </label>
								<input type="text" name="city" id="city" placeholder="City"><br><br><br>
								
												<%if(password_error!=null){ %>
														<div class="password_error">
														
															<p><%=password_error %></p>
														</div>
												<%} %>	
								
								
						</article>
						
						
				</form>
			
			
			</section>
	</main>

	<%@ include file="includes/index_footer.jsp" %>
		

</body>
</html>