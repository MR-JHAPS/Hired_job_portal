/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/10.1.33
 * Generated at: 2024-12-02 10:27:17 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.jsp.*;
import java.util.ArrayList;
import java.util.List;
import com.jobmarket.Session_constants;
import com.jobmarket.hired.model.Country;
import com.jobmarket.company.model.Job_wrapper;
import com.jobmarket.client.model.Employee;
import com.jobmarket.Session_constants;
import java.util.ArrayList;
import java.util.List;

public final class employee_005fhome_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports,
                 org.apache.jasper.runtime.JspSourceDirectives {

  private static final jakarta.servlet.jsp.JspFactory _jspxFactory =
          jakarta.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(2);
    _jspx_dependants.put("/includes/employee_homepage_header.jsp", Long.valueOf(1730375240992L));
    _jspx_dependants.put("/includes/index_footer.jsp", Long.valueOf(1723760577040L));
  }

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.LinkedHashSet<>(4);
    _jspx_imports_packages.add("jakarta.servlet");
    _jspx_imports_packages.add("jakarta.servlet.http");
    _jspx_imports_packages.add("jakarta.servlet.jsp");
    _jspx_imports_classes = new java.util.LinkedHashSet<>(8);
    _jspx_imports_classes.add("com.jobmarket.company.model.Job_wrapper");
    _jspx_imports_classes.add("java.util.List");
    _jspx_imports_classes.add("com.jobmarket.Session_constants");
    _jspx_imports_classes.add("com.jobmarket.client.model.Employee");
    _jspx_imports_classes.add("com.jobmarket.hired.model.Country");
    _jspx_imports_classes.add("java.util.ArrayList");
  }

  private volatile jakarta.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public java.util.Set<java.lang.String> getPackageImports() {
    return _jspx_imports_packages;
  }

  public java.util.Set<java.lang.String> getClassImports() {
    return _jspx_imports_classes;
  }

  public boolean getErrorOnELNotFound() {
    return false;
  }

  public jakarta.el.ExpressionFactory _jsp_getExpressionFactory() {
    if (_el_expressionfactory == null) {
      synchronized (this) {
        if (_el_expressionfactory == null) {
          _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        }
      }
    }
    return _el_expressionfactory;
  }

  public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
    if (_jsp_instancemanager == null) {
      synchronized (this) {
        if (_jsp_instancemanager == null) {
          _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
        }
      }
    }
    return _jsp_instancemanager;
  }

  public void _jspInit() {
  }

  public void _jspDestroy() {
  }

  public void _jspService(final jakarta.servlet.http.HttpServletRequest request, final jakarta.servlet.http.HttpServletResponse response)
      throws java.io.IOException, jakarta.servlet.ServletException {

    if (!jakarta.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
      final java.lang.String _jspx_method = request.getMethod();
      if ("OPTIONS".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        return;
      }
      if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSPs only permit GET, POST or HEAD. Jasper also permits OPTIONS");
        return;
      }
    }

    final jakarta.servlet.jsp.PageContext pageContext;
    jakarta.servlet.http.HttpSession session = null;
    final jakarta.servlet.ServletContext application;
    final jakarta.servlet.ServletConfig config;
    jakarta.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    jakarta.servlet.jsp.JspWriter _jspx_out = null;
    jakarta.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=ISO-8859-1");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("    ");

   
    
    
    
      out.write("\r\n");
      out.write("    \r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta charset=\"ISO-8859-1\">\r\n");
      out.write("<title>Hired-Homepage</title>\r\n");
      out.write("<link rel=\"stylesheet\" href=\"styles/index_header.css\">\r\n");
      out.write("<link rel=\"stylesheet\" href=\"styles/employee_home_style.css\">\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("\r\n");
      out.write("	");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("    \r\n");
      out.write("     ");

//         
				//ALL JOBS TO DISPLAY ON HOMEPAGE From "Employee_homepage" Servlet.
				List<Job_wrapper> job_list = new ArrayList<Job_wrapper>();
				if(request.getAttribute("attr_job_list")!=null){
					job_list = (List<Job_wrapper>) request.getAttribute("attr_job_list");
				}
				
				//List of saved job from "DISPLAY_SAVED_JOB"  servlet.
				List<Job_wrapper> saved_job_list = new ArrayList<Job_wrapper>();
				if(request.getAttribute("attr_saved_job_list")!=null){
					saved_job_list = (List<Job_wrapper>) request.getAttribute("attr_saved_job_list");
				}
				
				
				//this is the list of country to show in employee account settings.
				List<Country> country_list = new ArrayList<Country>();
				if(request.getAttribute("attr_country_list")!=null){
					country_list = (List<Country>) request.getAttribute("attr_country_list");
				}
             	
             	String employee_update_success = (String) request.getAttribute("attr_employee_update_success");
              
              	session = request.getSession(false);
             	Integer session_employee_id = (Integer) session.getAttribute( Session_constants.EMPLOYEE_SESSION_ID );
             	String session_employee_first_name = (String) session.getAttribute( Session_constants.EMPLOYEE_SESSION_FIRST_NAME );
             	String session_employee_last_name = (String) session.getAttribute(Session_constants.EMPLOYEE_SESSION_LAST_NAME);
             	String session_employee_email = (String) session.getAttribute(Session_constants.EMPLOYEE_SESSION_EMAIL);
             	String session_employee_password = (String) session.getAttribute(Session_constants.EMPLOYEE_SESSION_PASSWORD);
             	String session_employee_telephone = (String) session.getAttribute(Session_constants.EMPLOYEE_SESSION_TELEPHONE);
             	String session_employee_address = (String) session.getAttribute(Session_constants.EMPLOYEE_SESSION_ADDRESS);
             	String session_employee_country = (String) session.getAttribute(Session_constants.EMPLOYEE_SESSION_COUNTRY);
             	int session_employee_country_id = (Integer) session.getAttribute(Session_constants.EMPLOYEE_SESSION_COUNTRY_ID);
             	String session_employee_city = (String) session.getAttribute(Session_constants.EMPLOYEE_SESSION_CITY);
         
      out.write("\r\n");
      out.write("    \r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta charset=\"ISO-8859-1\">\r\n");
      out.write("<title>Insert title here</title>\r\n");
      out.write("<link rel=\"stylesheet\" href=\"styles/index_header.css\">\r\n");
      out.write("\r\n");
      out.write("<link rel=\"preconnect\" href=\"https://fonts.googleapis.com\">\r\n");
      out.write("<link rel=\"preconnect\" href=\"https://fonts.gstatic.com\" crossorigin>\r\n");
      out.write("<link href=\"https://fonts.googleapis.com/css2?family=Roboto:ital,wght@0,100;0,300;0,400;0,500;0,700;0,900;1,100;1,300;1,400;1,500;1,700;1,900&display=swap\" rel=\"stylesheet\">\r\n");
      out.write("\r\n");
      out.write("<link rel=\"preconnect\" href=\"https://fonts.googleapis.com\">\r\n");
      out.write("<link rel=\"preconnect\" href=\"https://fonts.gstatic.com\" crossorigin>\r\n");
      out.write("<link href=\"https://fonts.googleapis.com/css2?family=Montserrat:ital,wght@0,100..900;1,100..900&family=Roboto:ital,wght@0,100;0,300;0,400;0,500;0,700;0,900;1,100;1,300;1,400;1,500;1,700;1,900&display=swap\" rel=\"stylesheet\">\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("\r\n");
      out.write("		<header>	\r\n");
      out.write("		\r\n");
      out.write("\r\n");
      out.write("					<h1>HIRED & HIRE</h1>\r\n");
      out.write("\r\n");
      out.write("		\r\n");
      out.write("	\r\n");
      out.write("		</header>\r\n");
      out.write("	\r\n");
      out.write("	<nav>\r\n");
      out.write("		<ul>\r\n");
      out.write("				<li><a href=\"Employee_homepage\">Home</a></li>\r\n");
      out.write("				<li><a href=\"Display_saved_job\">Saved Job</a></li>\r\n");
      out.write("				\r\n");
      out.write("<!-- 				<li><a href=\"#\">Messages</a></li> -->\r\n");
      out.write("				<li class=\"float_right\"><a href=\"To_employee_profile\">My Account</a></li>		\r\n");
      out.write("				<li class=\"float_right\"><a href=\"Employee_log_out\">Log out :  ");
      out.print(session_employee_email );
      out.write("</a></li>\r\n");
      out.write("			\r\n");
      out.write("		</ul>\r\n");
      out.write("	</nav>\r\n");
      out.write("\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
      out.write("\r\n");
      out.write("\r\n");
      out.write("	<main>\r\n");
      out.write("\r\n");
      out.write("					\r\n");
      out.write("					\r\n");
      out.write("					\r\n");
      out.write("				<!--  THIS MESSAGE IS ONLY AFTER UPLOADING CV IS DONE-->	\r\n");
      out.write("				");

					String cv_upload_message = (String) request.getAttribute("attr_upload_status");	
				if (cv_upload_message!=null && !cv_upload_message.isEmpty()){ 
      out.write("\r\n");
      out.write("				<section class=\"cv_upload_message\">\r\n");
      out.write("					\r\n");
      out.write("					<p>");
      out.print(cv_upload_message );
      out.write("</p>\r\n");
      out.write("				</section>\r\n");
      out.write("				");
} 
      out.write("\r\n");
      out.write("				\r\n");
      out.write("				\r\n");
      out.write("		\r\n");
      out.write("				<!--  THIS MESSAGE IS ONLY AFTER UPDATING THE ACCOUNT DETAILS IS DONE-->	\r\n");
      out.write("				");

					String account_update_message = request.getParameter("account_update_message");	
				if (account_update_message!=null && !account_update_message.isEmpty()){ 
      out.write("\r\n");
      out.write("				<section class=\"account_update_message\">\r\n");
      out.write("					\r\n");
      out.write("					<p>");
      out.print(account_update_message );
      out.write("</p>\r\n");
      out.write("				</section>\r\n");
      out.write("				");
} 
      out.write("\r\n");
      out.write("				\r\n");
      out.write("		\r\n");
      out.write("	\r\n");
      out.write("			<section class=\"search_bar\">\r\n");
      out.write("					<form method=\"POST\" action=\"Employee_job_search\">\r\n");
      out.write("					<label for=\"employee_job_search\">Search Jobs</label><br>\r\n");
      out.write("						<input type=\"text\" name=\"employee_job_search\" id=\"employee_job_search\" placeholder=\"Job, company name\">\r\n");
      out.write("						\r\n");
      out.write("						<input type=\"submit\" value=\"Search\">\r\n");
      out.write("					</form>\r\n");
      out.write("	\r\n");
      out.write("			</section>\r\n");
      out.write("	\r\n");
      out.write("	\r\n");
      out.write("	\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("		");
for(Job_wrapper element : job_list){ 
      out.write("\r\n");
      out.write("				<section class=\"all_jobs\">\r\n");
      out.write("					<a href=\"Employee_selected_job?job_id=");
      out.print(element.getJob().getJob_id());
      out.write("\" class=\"job_link\">\r\n");
      out.write("							<figure class=\"image\">	\r\n");
      out.write("								<img src=\"images/job_image.png\">\r\n");
      out.write("							</figure>\r\n");
      out.write("					\r\n");
      out.write("							<div class=\"job_datas\">	\r\n");
      out.write("									\r\n");
      out.write("										\r\n");
      out.write("										<h3>");
      out.print(element.getJob().getJob_name() );
      out.write("</h3>\r\n");
      out.write("										<h5>");
      out.print(element.getJob_contract().getContract_name());
      out.write("  &nbsp;|&nbsp; ");
      out.print(element.getCompany().getName() );
      out.write("</h5>\r\n");
      out.write("										<p>");
      out.print(element.getJob().getJob_descripcion() );
      out.write("</p>\r\n");
      out.write("										\r\n");
      out.write("								</div>\r\n");
      out.write("						</a>\r\n");
      out.write("						<div class=\"job_buttons\">		\r\n");
      out.write("						\r\n");
      out.write("								<div class=\"save\"><a href=\"Employee_save_job_servlet?job_id=");
      out.print(element.getJob().getJob_id());
      out.write("\"><img src=\"images/save_icon_blue.png\" width=16px> Save</a></div>\r\n");
      out.write("								\r\n");
      out.write("						</div>	\r\n");
      out.write("						 \r\n");
      out.write("				</section>\r\n");
      out.write("		");
} 
      out.write("\r\n");
      out.write("		\r\n");
      out.write("	\r\n");
      out.write("	\r\n");
      out.write("	\r\n");
      out.write("	\r\n");
      out.write("	\r\n");
      out.write("	\r\n");
      out.write("	\r\n");
      out.write("	\r\n");
      out.write("	</main>\r\n");
      out.write("	\r\n");
      out.write("	");
      out.write("\r\n");
      out.write("    \r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta charset=\"ISO-8859-1\">\r\n");
      out.write("<title>Insert title here</title>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("		\r\n");
      out.write("	<footer>\r\n");
      out.write("			\r\n");
      out.write("			<div class=\"footer_left\">\r\n");
      out.write("					\r\n");
      out.write("					<ul>\r\n");
      out.write("						<li><a href=\"#\">About Hired</a></li>\r\n");
      out.write("						<li><a href=\"#\">Our Motive</a></li>\r\n");
      out.write("						<li><a href=\"#\">Work with us</a></li>\r\n");
      out.write("						\r\n");
      out.write("					</ul>\r\n");
      out.write("			</div>\r\n");
      out.write("			\r\n");
      out.write("			<div class=\"footer_center\">\r\n");
      out.write("					\r\n");
      out.write("					<ul>\r\n");
      out.write("						\r\n");
      out.write("						<li><a href=\"#\">Legal Conditions</a></li>\r\n");
      out.write("						<li><a href=\"#\">Privacy Policy</a></li>\r\n");
      out.write("					</ul>\r\n");
      out.write("			</div>\r\n");
      out.write("			\r\n");
      out.write("			<div class=\"footer_right\">\r\n");
      out.write("					\r\n");
      out.write("					<ul>\r\n");
      out.write("						<li><a href=\"#\">Use of Services</a></li>\r\n");
      out.write("						<li><a href=\"#\">Manage Cookies</a></li>\r\n");
      out.write("						\r\n");
      out.write("					</ul>\r\n");
      out.write("			</div>\r\n");
      out.write("			\r\n");
      out.write("	</footer>\r\n");
      out.write("	\r\n");
      out.write("</body>\r\n");
      out.write("</html>\r\n");
      out.write("		\r\n");
      out.write("\r\n");
      out.write("	\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof jakarta.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
