# Hired_job_portal

This is a job portal named "HIRED & HIRE".
This is a dynamic web project which is a JOB PORTAL named "HIRED & HIRE" where the data shown is displayed and inserted from the "a_hired.sql" database.

JOB PORTAL FEATURES:
You can sign up as a company or employee and then sign in .
As an employee you can:
    1. Search for jobs posted by company and "SAVE" them to view later or "APPLY" for that job.
    2. Update your account information once signed in.
    3. You can delete your account.
    
As a company you can :
    1. "POST A JOB" and you can view all your posted jobs in the homepage. 
    2. View the applicants data that have applied to your company.
    3. Update your account information once signed in.
    4. You can delete your account.



JOB PORTAL DATA LOGIC:

Employee/Client means --> An individual person looking for a job.
Company means --> An organization looking to give a job to people.

Inside com.jobmarket there are two interfaces:
    1. File_name : It contains all the name of the files as a CONSTANT.
    2. DB_config : It contains all the Database Information and its properties like Table name, Stored Procedure, Column name, Callable Statement as a CONSTANT.

This project contains 3 aspects: 
    com.jobmarket.client(.controller/.model) --> this refers to all the action done in the client part of this project.
    com.jobmarket.company(.controller/.model) --> this refers to all the action done in the company part of this project.
    com.jobmarket.hired(.controller/.model) --> this contains the default value provided by the JobPortal HIRED & HIRE like "job_categories", "contract_type", "salary_amount", "country_list".
    
  In these aspects:
          "Controller" contains all the sevlets.
          "Model" contains all the respective Classes. " DB_helper_(employee/company/hired).java "  contains all the executing method like 'signing up' , 'log in verification', 'displaying jobs' etc.

   

There are 10 tables in the database:
"employee", "company", "job", "address", "city", "country", "job_category", "job_contract", "job_salary", "employee_saved_job".

All these tables have their respective relationship with another using Foreign-Key. 
    For example:
          company --> address --> city --> country
          employee --> address --> city --> country

