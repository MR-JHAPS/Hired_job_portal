<%@page import="com.jobmarket.hired.model.Country"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    
    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Account Settings</title>
<link rel="stylesheet" href="styles/index_header.css">
<link rel="stylesheet" href="styles/employee_account.css">
</head>
<body>
	<%@ include file="includes/employee_homepage_header.jsp" %>

	<main>
	
		<% 
		
		%>



		<section class="account_setting_header">
			<h3>ACCOUNT SETTINGS:</h3><br>
		</section>
				
		<div class="big_box">
		
				<form class="form" action="Employee_update_account" method="POST">
				
				
				
				
						<label class="form_header">Your Account Details</label><br>
						
						<label for="e_first_name">First name</label><br>
						<input type="text" id="e_first_name"  name="e_first_name" value="<%=session_employee_first_name %>"><br>
						
						<label for="e_last_name">Last name</label><br>
						<input type="text" id="e_last_name"  name="e_last_name" value="<%=session_employee_last_name %>"><br>
						
						<label for="e_email">Email</label><br>
						<input type="email" id="e_email"  name="e_email" value="<%=session_employee_email%>" ><br>
						
						<label for="e_telephone">Telephone</label><br>
						<input type="text" id="e_telephone"  name="e_telephone" value="<%=session_employee_telephone%>" ><br>
						
						<label for="e_password">Password</label><br>
						<input type="password"  name="e_password" id="e_password" value="<%=session_employee_password %>" ><br>
						
						<label for="e_address">Address</label><br>
						<input type="text" id="e_address"  name="e_address" value="<%=session_employee_address%>" ><br>
						
						<label for="e_city">City</label><br>
						<input type="text" id="e_city"  name="e_city" value="<%=session_employee_city%>" ><br>
						
		
						<label for="e_country">Country</label><br>
						<select name="e_country" id="country">
											<%	
		// 									for(Country element : country_list){
		// 										if(element.getId()==session_employee_country_id){
												%>
												<option value="<%=session_employee_country_id%>"> <%=session_employee_country %> </option>
											<%//}} %>
											</select>
											<br><br><br>
						
						
						
						
						<input type="submit" value="Update Account"><br>
						
						
				
				
				
				</form>
									<a  href="employee_delete_confirmation.jsp"><button>DELETE</button></a>
				
				
		
		
				<section class="cv_area">
							
						<form action="Upload_cv" method="POST"  enctype="multipart/form-data">
							
							<label for="cv_file" >Upload Your CV</label>		<br>
							<input type = "file" name="cv_file" id="cv_file" accept="application/pdf" ><br>
							
							<input type="submit" value="UPLOAD CV">
						
						
						</form>
		
					</section>
			</div>			

	</main>


<%@include file="includes/index_footer.jsp" %>

</body>
</html>