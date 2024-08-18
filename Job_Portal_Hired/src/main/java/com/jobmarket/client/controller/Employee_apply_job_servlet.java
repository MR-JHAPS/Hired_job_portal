package com.jobmarket.client.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.List;
import org.apache.tomcat.util.http.fileupload.disk.DiskFileItemFactory;
import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;
import org.apache.tomcat.util.http.fileupload.*;
import com.jobmarket.File_name;


public class Employee_apply_job_servlet extends HttpServlet implements File_name{
	private static final long serialVersionUID = 1L;
       

    public Employee_apply_job_servlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
		
		
		
		HttpSession session = request.getSession(false);
		if(session==null) {
			request.getRequestDispatcher(INDEX_JSP).forward(request, response);
		}
		
		//this values is imported from active session of employee/user.
		int employee_id = (Integer)session.getAttribute("attr_employee_id");
		String employee_name = (String) session.getAttribute("attr_employee_first_name");
		
		
		//cover letter from employee for Company.
		String employee_cover_letter = "";
		if(request.getParameter("cover_letter")!=null) {
			employee_cover_letter = request.getParameter("cover_letter");
		}
		
		
		
		
		if(ServletFileUpload.isMultipartContent(request)) {
			FileItemFactory factory = new DiskFileItemFactory();
			ServletFileUpload upload = new ServletFileUpload(factory);
			
			List<FileItem> items = upload.parseRequest((RequestContext) request);
			
			for(FileItem item:items) {
				
				
			}
			

		
		
		
		
		}
		
		
//		FileInputStream file = new FileInputStream(null);
		
		
	
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
