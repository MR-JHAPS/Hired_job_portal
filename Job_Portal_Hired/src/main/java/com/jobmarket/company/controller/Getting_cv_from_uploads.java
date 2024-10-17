package com.jobmarket.company.controller;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.File;
import java.io.IOException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

import com.jobmarket.File_name;
import com.jobmarket.Session_constants;
import com.jobmarket.client.model.Cv_file;


public class Getting_cv_from_uploads extends HttpServlet implements File_name, Session_constants {
	private static final long serialVersionUID = 1L;
       
 
    public Getting_cv_from_uploads() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession(false);
		if(session == null) {
			response.sendRedirect(COMPANY_SIGN_IN_JSP);
			return;
		}
		
		//this contains the "name" , "id"  of CV and "FK_employee" .
		List<Cv_file> cv_file_list = new ArrayList<Cv_file>();
		if(request.getAttribute("attr_cv_list")!=null) {
			cv_file_list = (List<Cv_file>) request.getAttribute("attr_cv_list");
		}
		
		String file_name = "";
			//Since we have only 1 file name we wont use array to store the name rather use "String".
			//getting file name from the cv_list
			for(Cv_file element : cv_file_list) {
				file_name = element.getCv_name();
			}
		
		
		
		
		ServletContext context = getServletContext();
		
		String project_directory = context.getRealPath("/");
		String folder_name = "uploads";
		
		System.out.println(project_directory);
		
		File upload_directory = new File(project_directory + File.separator + folder_name + File.separator + file_name);
		
//		//to check if the directory exists.
//		if(upload_directory.exists()) {
//			System.out.println("Directory named " + folder_name + " exists.");
//		}else {
//			System.out.println("Directory" + folder_name +"does not exists");
//		}
		
	
		
		
		
		//constructing the url for accessing.
		String file_url = request.getContextPath() + "/uploads/" + URLEncoder.encode(file_name, StandardCharsets.UTF_8.toString());
	
		response.sendRedirect(file_url);
		
		//System.out.println(base_url);
		
		
		
	
	}//ends doGet.

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
