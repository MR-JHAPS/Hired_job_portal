<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    
 <%
  //all the information is inside webapp/includes/employee_header.jsp. 
   		//I brought it here
   		List<Job_wrapper> employee_selected_job_info = new ArrayList<Job_wrapper>();
      	if(	request.getAttribute("attr_employee_selected_job_info")!=null){
      		employee_selected_job_info= (List<Job_wrapper>) request.getAttribute("attr_employee_selected_job_info");
      	}
      	
      	
      	
      	
      	
  %>
    	<%
    	for(Job_wrapper element : employee_selected_job_info){
    	%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="styles/index_header.css">
<link rel="stylesheet" href="styles/index_selected_job.css">
</head>
<body>

	<%@ include file="includes/index_header.jsp" %>

	<main>


			<section class="job_box">



				<article class="job_header">
							<figure class="image">	
								<img src="images/job_image.png">
							</figure>
							
							
							<div class="title">	
								<h2><%=element.getJob().getJob_name() %></h2>
								<p><%=element.getCompany().getName() %></p>
							</div>
							
							<div class="buttons">	
								
								<div class="save"><a href="index.jsp"><img src="images/save_icon_blue.png" width=16px> Not registered</a></div>
								
								<a href="index.jsp"><button class="apply">SIGN IN to Apply</button></a>
							</div>	
				</article>	
					
					
					
				
					
					
					
				<article class="job_body">	
						<!-- THIS IS FOR THE LOCATION TO GOOGLE MAPS -->
							<h5><img src="images/location_icon.png" width=16px> <%=element.getAddress().getAddress_name() + element.getCity().getCity_name()%> 
							<a href="https://www.google.com/maps/place/<%=element.getAddress() + element.getCity().getCity_name()%>" >
								<%=element.getAddress().getAddress_name() + element.getCity().getCity_name()%>
							</a>
								
							</h5>
							
							<div class="description">
									<h3>DESCRIPTION</h3>
									<p><%=element.getJob().getJob_descripcion() %></p>
							</div>
							
							<label>Contract </label> <p><%=element.getJob_contract().getContract_name() %> </p><br>
				
							<label>Salary </label> <p><%=element.getJob_salary().getSalary_amount() %> </p><br>
							
							<label>Vacancy   </label> <p><%=element.getJob().getJob_vacancy() %> </p><br>
							
							<label>Category </label> <p><%=element.getJob_category().getCategory_name() %> </p><br>							
				</article>	
					
					
			</section>
	
	<%} %>
	
	
	</main>


<%@include file="includes/index_footer.jsp" %>
</body>
</html>