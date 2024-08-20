<%@page import="com.jobmarket.client.model.Cv_file"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%	
	//session = request.getSession(false);
	//String file_name = (String) request.getAttribute("attr_file_name");
	List<Cv_file> cv_list = (List<Cv_file>) session.getAttribute("attr_employee_cv_list");
	
	int job_id = 0;
	if(request.getAttribute("attr_job_id")!=null){
		job_id = (Integer) request.getAttribute("attr_job_id");
	}
	int company_id = 0;
	if(request.getAttribute("attr_company_id")!=null){
		company_id = (Integer) request.getAttribute("attr_company_id");
	}
	
	System.out.println("job_id : " + job_id  + " company_id :  " + company_id);

%>    
    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Apply Job</title>
<link rel="stylesheet" href="styles/index_header.css">
<link rel="stylesheet" href="styles/employee_apply_job_style.css">
</head>
	
	<body>
		
		<%@ include file="includes/employee_homepage_header.jsp"%>

		<main>
		
				<%
					String message = request.getParameter("message");
					if(message!=null && !message.isEmpty()){
				%>
					<section class="job_apply_message">
					
							<p><%= message%></p>
					
					</section>
			
				<%} %>
		
		
		
		
		
		
		
		
			<section class="form_header">
				<h3>Apply For Job_name</h3><br>
			</section>
		
		
		
		
		
			<section class="form_area">
					
					<form action="Employee_apply_job_servlet" method="GET" >
						
						<% if(cv_list.isEmpty()){%>
									<a href="Employee_account_settings">Upload your CV</a><br>
							
							<% }%>		
<!-- 						job_id and company_id is sent from here as a hidden -->
						<input type="text" hidden="" value="<%=job_id %>" name="job_id">	<br>
						<input type="text" hidden="" value="<%=company_id %>" name="company_id">    <br>
						
						<% if(cv_list!=null){   for(Cv_file element : cv_list){ %>
							
							<label>Send your CV</label>		<br>
							
								<label for="yes"> Yes</label>
									<input type = "checkbox" name="send_cv" id="yes" value = "<%=element.getCv_id() %>" ><br>
								<label for="no"> No</label>
									<input type = "checkbox" name="send_cv" id="no" value = "" ><br>
							<% }
							}%>
							
						
						<label class="text_area_label" for="cover_letter" >Cover Letter Text</label><br>
							<textarea id="cover_letter" name="cover_letter" placeholder="Write Your Cover Letter Here"></textarea><br>
						
						<input type="submit" value="APPLY FOR THIS JOB">
			
					</form>

			</section>
			
			
			
			
			
			
			<section class="job_descripcion">
				here will be the descripcion of the Job.
			
			</section>

		</main>
		
		
		
		<%@ include file="includes/index_footer.jsp"%>
	
</body>
</html>