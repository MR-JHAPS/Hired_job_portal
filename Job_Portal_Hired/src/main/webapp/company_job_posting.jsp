
<%@page import="com.jobmarket.hired.model.Country"%>
<%@page import="com.jobmarket.hired.model.Job_salary"%>
<%@page import="com.jobmarket.hired.model.Job_contract"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.jobmarket.hired.model.Job_category"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%
//     		session = request.getSession(false);
    
        //THIS ATTRIBUTES ARE SENT FROM "com.jobmarket.hired.controller/Display_work_category.java" .
                            	//Its function is to display the drop down box with predetermined values.
                         			   
                            	List<Job_category> job_category_list = new ArrayList<Job_category>();
                            	if(request.getAttribute("attr_job_category_list")!=null){
                            		job_category_list = (List<Job_category>) request.getAttribute("attr_job_category_list");
                            	}
                            	List<Country> job_country_list = new ArrayList<Country>();
                            	if(request.getAttribute("attr_job_country_list")!=null){
                            		job_country_list = (List<Country>) request.getAttribute("attr_job_country_list");
                            	}
                            	List<Job_contract> job_contract_list = new ArrayList<Job_contract>();
                            	if(request.getAttribute("attr_job_contract_list")!=null){
                            		job_contract_list = (List<Job_contract>) request.getAttribute("attr_job_contract_list");
                            	}
                            	List<Job_salary> job_salary_list = new ArrayList<Job_salary>();
                            	if(request.getAttribute("attr_job_salary_list")!=null){
                            		job_salary_list = (List<Job_salary>) request.getAttribute("attr_job_salary_list");
                            	}
                            	
        %>
    
    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Post your job</title>
<link rel="stylesheet" href="styles/index_header.css">
<link rel="stylesheet" href="styles/job_posting_style.css">
</head>
<body>
		
	<%@ include file="includes/company_homepage_header.jsp" %>	
		
	<main>
		<section class="form_section">
	
				<form method="GET" action="Job_posting">
				
				
					<article class="company_id">
					<label for="company_id">COMPANY ID </label>
					<input type="text" name="company_id" value="<%=session.getAttribute("attr_company_id")%>" readonly="readonly" >
					
					</article>
					
					<article class="country_id">
					<label for="country_id">COUNTRY ID </label>
					<input type="text" name="country_id" value="<%=session.getAttribute("attr_company_country")%>" readonly="readonly" >
					
					</article>
				
				<!-- change value of select to id from name -->
					<article class="job_category">
							<label for="job_category">JOB CATEGORY </label><br>
							<select  name="job_category" id="job_category">
							<%
							for(Job_category element : job_category_list){
							%>
								<option value="<%=element.getCategory_id()%>"> <%=element.getCategory_name()%></option>
								<%
								}
								%>
							</select>	
					</article>
					
					
					<article class="job_name">
						<label for="job_name">JOB NAME </label><br>
						<input type = "text" name="job_name" id="job_name" placeholder="Job Name">
					</article>
					<br><br>
					
					<article class="job_vacancy">
						<label for="job_vacancy">JOB VACANCY </label><br>
						<input type = "number" min="0" max="100" name="job_vacancy" id="job_vacancy" placeholder="Job Vacancy">
					</article>
					<br><br>
					

					
					<article class="job_descripcion">
						<label for="job_descripcion">JOB DESCRIPTION </label><br>
						<textarea  name="job_descripcion" id="job_descripcion" placeholder="Job Description" ></textarea>
					</article>
					<br><br>
					
					<article class="job_address">
						<label for="job_address">JOB ADDRESS </label><br>
						<input type = "text" name="job_address" id="job_address" placeholder="Job Address">
					</article>
					<br><br>	
					
					<article class="job_city">
						<label for="job_city">JOB CITY</label><br>
						<input type = "text" name="job_city" id="job_city" placeholder="Job City" >
					</article>
					<br><br>
					
					

					
					
					<article class="job_contract">
						<label for="job_contract">JOB CONTRACT TYPE </label><br>
						<select  name="job_contract" id="job_contract">
							<%
							for(Job_contract element : job_contract_list){
							%>
								<option value="<%=element.getContract_id()%>"> <%=element.getContract_name()%></option>
								<%
								}
								%>
						</select>	
					</article>
					<br>
					
					
					<article class="job_salary">
						<label for="job_salary"> BRUTE ANUAL SALARY </label><br>
						<select  name="job_salary" id="job_salary">
								<%
								for(Job_salary element : job_salary_list){
								%>
								<option value="<%=element.getSalary_id() %>"> <%=element.getSalary_amount()%></option>
								<%} %>
						</select>	
					</article>
					<br>
					
				
					
					
					<article class="buttons">
						<input type="reset" id="reset" name= "reset" value="Reset">
						<input type="submit" id="submit" name="submit" value="Post">
					</article><br><br>
					
				
				
				</form>
	
		</section>
	</main>
	
	<%@include file="includes/index_footer.jsp" %>
	
</body>
</html>