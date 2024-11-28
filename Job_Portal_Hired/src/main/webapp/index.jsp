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
    	String wrong_password = (String) request.getAttribute("attr_wrong_login_password");
    	
    	//FROM Servlet - "Employee_delete_account"
    	String delete_success = (String) request.getAttribute("attr_delete_success");
    
    %>
    
    
    
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="ISO-8859-1">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Hired/Hire</title>
    <link rel="stylesheet" href="styles/index_header.css">
    <link rel="stylesheet" href="styles/index_style.css">
</head>
<body>
    <!-- Include the header for the index page -->
    <%@ include file="includes/index_header.jsp" %>

    <main>
        <!-- Message after company sign-up completion -->
        <% if(company_signed_up != null) { %>
            <section class="signed_up">
                <h3><%= company_signed_up %></h3>       
            </section>
        <% } %>

        <!-- Message after company sign-up failure -->
        <% if(company_not_signed_up != null) { %>
            <section class="not_signed_up">
                <h3><%= company_not_signed_up %></h3>       
            </section>
        <% } %>

        <!-- Message after employee account deletion -->
        <% 
        String account_delete_message = request.getParameter("account_delete_message");	
        if(account_delete_message != null && !account_delete_message.isEmpty()) { %>
            <section class="delete_success_message">
                <h3><%= account_delete_message %></h3>
            </section>
        <% } %>
        
        <section class="form_header">
            <h3>Sign in as Employee</h3><br>
        </section>

        <section class="form_area">
            <form action="Sign_in_employee_verification" method="POST">
                <input type="text" name="email" id="email" placeholder="Enter your email" required>
                <br><br>
                <input type="password" name="password" id="password" placeholder="Password" required>
                <br><br>
                <input type="submit" value="Sign in">
            </form>
            <br>
            <hr>
            <div class="sign_in_company">
                <label>OR</label>
                <a href="company_sign_in.jsp" id="sign_in_company">
                    <button>Sign in as Company</button>
                </a>	
                <br><br>
            </div>
        </section>

        <!-- Message for incorrect sign-in data -->
        <% if(wrong_password != null) { %>
            <section class="wrong_password_message">
                <p><%= wrong_password %></p>
            </section>
        <% } %>
        
        <section class="sign_up">
            <article class="sign_up_employee">
                <h4>Are you looking for a job? Sign up here.</h4>
                <a href="Display_country_employee" id="sign_up_employee">
                    <button>Sign Up As Employee</button>
                </a>
            </article>
            <article class="sign_up_company">
                <h4>Are you a company looking to hire? Sign up here.</h4>
                <a href="Display_country_company" id="sign_up_company">
                    <button>Sign Up As Company</button>
                </a>
            </article>
        </section>
    </main>

    <!-- Include the footer for the index page -->
    <%@ include file="includes/index_footer.jsp" %>
</body>
</html>
