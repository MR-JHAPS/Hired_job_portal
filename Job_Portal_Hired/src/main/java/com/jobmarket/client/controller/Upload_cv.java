package com.jobmarket.client.controller;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.servlet.http.Part;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Connection;

import com.jobmarket.client.model.DB_helper_employee;

@WebServlet("/upload_cv")
@MultipartConfig(
	    fileSizeThreshold = 1024 * 1024 * 2, // 2MB
	    maxFileSize = 1024 * 1024 * 50,      // 50MB
	    maxRequestSize = 1024 * 1024 * 100 )


public class Upload_cv extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public Upload_cv() {
        super();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    	boolean is_cv_uploaded = false;
    	DB_helper_employee db = new DB_helper_employee();
    	Connection db_connection = null;
    	
        try {
            // Get the context and file directory
            ServletContext context = getServletContext();
            String file_directory = context.getRealPath("/");
            String folder_name = "uploads";

            // Determine upload location
            File upload_location = new File(file_directory + File.separator + folder_name);

            // Create the folder if it does not exist
            if (!upload_location.exists()) {
                if (upload_location.mkdir()) {
                    System.out.println("Upload folder created");
                } else {
                    System.out.println("Failed to create upload folder");
                    response.getWriter().println("Failed to create upload folder");
                    return;
                }
            }

            HttpSession session = request.getSession(false);	
            
            int user_id = (Integer) session.getAttribute("attr_employee_id");
            String user_name = (String) session.getAttribute("attr_employee_first_name"); 
            
            // Retrieve the file part
            Part filePart = request.getPart("cv_file");
           // String fileName = filePart.getSubmittedFileName();

            //setting specific filename as per user.
            String file_name = user_name + "_" + user_id  + ".pdf";
            
            
            // Define the full file path
            File fileToSave = new File(upload_location, file_name);

            // Save the file
            try (InputStream fileContent = filePart.getInputStream();
                 OutputStream saveFile = new FileOutputStream(fileToSave)) {

                byte[] buffer = new byte[1024];
                int bytesRead;
                while ((bytesRead = fileContent.read(buffer)) != -1) {
                    saveFile.write(buffer, 0, bytesRead);
                }
                System.out.println("CV file uploaded to server/folder.");
                
            }
                //inserting the file name in the sql table to relate it with respective user/employee:
                
                
                db_connection = db.connect_db();
                is_cv_uploaded = db.insert_cv_name(db_connection, file_name, user_id);
                
                System.out.println("CV name insert in table Status : " + is_cv_uploaded);
                
                
                System.out.println("File name: " + file_name + " Location: " + fileToSave.getAbsolutePath());
            

           
        
            
        } catch (Exception e) {
            
            e.printStackTrace();
            response.getWriter().println("File upload failed: " + e.getMessage());
        } finally {
            // Forward the request to the JSP page
        	
        	System.out.println("CV upload status : " + is_cv_uploaded);
        	
        	if(is_cv_uploaded == true) {
        		String upload_status = "CV uploaded successfully";
        		request.setAttribute("attr_upload_status", upload_status);
        		 request.getRequestDispatcher("employee_account.jsp").forward(request, response);
        	}
        	else {
        		 request.getRequestDispatcher("error.jsp").forward(request, response);
        	}
        	
        	
           
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}

