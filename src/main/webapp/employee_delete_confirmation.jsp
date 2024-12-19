<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="styles/employee_delete_confirmation.css">
</head>
<body>

<%@include file="includes/employee_homepage_header.jsp" %>

<main>

		<section class="delete_confirmation">
				<Label>Are you sure you want to delete your Account?</Label>
				<br>
				
				<a href="Employee_delete_account?id=<%=session_employee_id%>"><button class="yes">Yes</button></a>
				<a href="employee_account.jsp"><button class="no">No</button></a>
		
		</section>


</main>

<%@include file="includes/index_footer.jsp" %>

</body>
</html>