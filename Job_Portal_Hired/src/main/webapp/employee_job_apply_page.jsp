<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Apply Job</title>
<link rel="stylesheet" href="styles/index_header.css">
<link rel="stylesheet" href="styles/employee_apply_job_style.css">
</head>
<body>
		
		<%@ include file="includes/company_homepage_header.jsp"%>
		
		
		
		<main>
		
			<section class="form_header">
				<h3>Apply For Job_name</h3><br>
			</section>
		
			<section class="form_area">
					
				<form action="" method="GET"  enctype="multipart/form-data">
					
					<label>Select Your CV</label>		<br>
					<input type = "file" name="file"><br>
					
					<label class="text_area_label" for="">Cover Letter Text</label><br>
					<textarea  >Write Your Cover Letter Here</textarea><br>
					
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