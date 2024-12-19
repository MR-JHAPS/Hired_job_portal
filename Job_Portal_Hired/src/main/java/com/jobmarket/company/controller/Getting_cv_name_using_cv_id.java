package com.jobmarket.company.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import com.jobmarket.File_name;
import com.jobmarket.Session_constants;
import com.jobmarket.client.model.Cv_file;
import com.jobmarket.company.model.DB_helper_company;


public class Getting_cv_name_using_cv_id extends HttpServlet implements File_name, Session_constants{
	private static final long serialVersionUID = 1L;
       
   
    public Getting_cv_name_using_cv_id() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession(false);
		if(session== null) {
			response.sendRedirect(COMPANY_SIGN_IN_JSP);
		}
		
		int cv_id = 0;
		if(request.getParameter("cv_id")!=null) {
			cv_id = Integer.parseInt(request.getParameter("cv_id"));
		}
		
		
		DB_helper_company db = new DB_helper_company();
		Connection db_connection = null;
		boolean is_cv_name_obtained = false;
		List<Cv_file> getting_cv_file_name_by_id = new ArrayList<Cv_file>();
		
		
		try {
				//connecting DB:
				db_connection = db.connect_db();
				
				/*although we have the name of the CV_file from the applied job portion and can directly
				 *  import in company_applicant.jsp using element.getCv().getcv_name(); 
				 *  IT is good practice to fetch the cv_name using cv_id from employee_CV table.
				 *  To prevent future issues if something goes wrong or If i need to change codes.
				 */
				
				getting_cv_file_name_by_id = db.get_cv_name_by_cv_id(db_connection, cv_id);
				is_cv_name_obtained = true;
				
				
				
				
				
		} catch (Exception e) {

			e.printStackTrace();
		
		}finally {
			//Disconnecting DB:
			if(db_connection != null) {
				db.disconnect(db_connection);
			}
			
			if(is_cv_name_obtained == true) {
				request.setAttribute("attr_cv_list", getting_cv_file_name_by_id);
				request.getRequestDispatcher("Getting_cv_from_uploads").forward(request, response);
			}
			else {
				response.sendError(500, "Unable to get the cv list using cv_id");
			}
			
			
			
			
		}//ends finally
		
		
		
		
		
		
	
	
	
	}//ends doGet

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
