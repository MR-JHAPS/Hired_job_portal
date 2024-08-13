<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 
 <%
  //all the information is inside webapp/includes/employee_header.jsp. 
   		//I brought it here
   		List<Job_wrapper> job_list_by_job_id = new ArrayList<Job_wrapper>();
      	if(	request.getAttribute("attr_job_list_by_job_id")!=null){
      		job_list_by_job_id= (List<Job_wrapper>) request.getAttribute("attr_job_list_by_job_id");
      	}
  %>
    	<%
    	for(Job_wrapper element : job_list_by_job_id){
    	%>
    	  
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Job offer : <%=element.getJob().getJob_name()%></title>
<link rel="stylesheet" href="styles/index_header.css">
<link rel="stylesheet" href="styles/employee_selected_job_style.css">
</head>
<body>
	<%@ include file="includes/employee_homepage_header.jsp" %>

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
								<div class="save"><a href="#"><img src="images/save_icon_blue.png" width=16px> Save</a></div>
								<a href="#"><button class="apply">Apply</button></a>
							</div>	
				</article>	
					
					
					
					
					
					
					
				<article class="job_body">	
						<!-- THIS IS FOR THE LOCATION TO GOOGLE MAPS -->
							<h5><img src="images/location_icon.png" width=16px> <%=element.getAddress().getAddress_name() + element.getCity().getCity_name()%>, 
							<a href="https://www.google.com/maps/place/<%=element.getAddress() + element.getCity().getCity_name()%>" >
								<%=element.getAddress() + element.getCity().getCity_name()%>
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