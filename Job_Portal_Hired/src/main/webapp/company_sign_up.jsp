<%@page import="java.util.ArrayList"%>
<%@page import="com.jobmarket.hired.model.Country"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%
    	//FROM Sign_up_company. repeat password wrong
    	String password_error = (String) request.getAttribute("attr_password_error");
    
		    
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
<title>Sign up - Company</title>
<link rel="stylesheet" href="styles/index_header.css">
<link rel="stylesheet" href="styles/sign_up_company_style.css">
</head>
<body>

	<%@ include file="includes/index_header.jsp" %>

	<main>
			<section class="form_outer_area">
				<form class="form_area" method="POST" action="Sign_up_company_insert">
					
						<article class="form_left">
								<label for="company_name">Company Name </label>
								<input type="text" name="company_name" id="company_name" placeholder="Company name"><br><br><br>
								
								<label for="company_telephone">Telephone  </label>
								<input type="text" name="company_telephone" id="company_telephone" placeholder="Company telephone"><br><br><br>
								
								<label for="country">Country </label>
								<select name="country" id="country">
									<%for(Country element : country_list){ %>
										<option value="<%=element.getId()%>"> <%=element.getCountry_name() %> </option>
									<%} %>
								</select>
								<br><br><br>
								
								<label for="city_name">City Name </label>
								<input type="text" name="city_name" id="city_name" placeholder="City name"><br><br><br>
								
								<label for="address">Address </label>
								<input type="text" name="address" id="address" placeholder="Address"><br><br><br>
								
								<label for="company_password">Your Password </label>
								<input type="password" name="company_password" id="company_password" placeholder="Password"><br><br><br>
								
								<input type ="reset" name="reset" id="reset" value="Reset">
								<input type="submit" name="sign_up_company" id="sign_up_company" value="Sign up">
						</article>
					
					
					
					
						<article class="form_right">
								<label for="company_email">Company Email </label>
								<input type="email" name="company_email" id="company_email" placeholder="Company email"><br><br><br>
							
								
								<label for="company_password_repeat">Repeat Your Password </label>
								<input type="password" name="company_password_repeat" id="company_password_repeat" placeholder="Password"><br><br><br><br><br><br><br><br><br><br><br>
								
								
									
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