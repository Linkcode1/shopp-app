package com.controller;

import java.io.IOException;
import java.io.PrintWriter;

import com.dao.*;
import java.util.*;
import com.model.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class CustomerProfileController
 */
@WebServlet("/CustomerProfileController")
public class CustomerProfileController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CustomerProfileController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		    HttpSession session = request.getSession();
		    String uname = (String) session.getAttribute("uname");
		    CustomerDao cdao = new CustomerDao();
		    Registration p =cdao.profile(uname);
		    PrintWriter pw = response.getWriter();
		    String htmlresponse="<html>\r\n"
					+ "<head>\r\n"
					+ "<meta charset=\"ISO-8859-1\">\r\n"
					+ "<title>Customer Dashborad</title>\r\n"
					+ "<link href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css\" rel=\"stylesheet\" integrity=\"sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC\" crossorigin=\"anonymous\">\r\n"
					+ "<script src=\"https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js\" integrity=\"sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM\" crossorigin=\"anonymous\"></script>\r\n"
					+ "\r\n"
					+ "<style>\r\n"
					+ "      body{\r\n"
					+ "        font-family: 'Poppins', sans-serif;\r\n"
					+ "      }\r\n"
					+ "      nav,\r\n"
					+ "      .top {\r\n"
					+ "        background-color: rgb(0,0,0)\r\n"
					+ "      }\r\n"
					+ "      .border {\r\n"
					+ "        border-radius: 20px;\r\n"
					+ "        border-color: rgb(0, 4, 5);\r\n"
					+ "        border-width: 100px;\r\n"
					+ "        border-style: solid;\r\n"
					+ "      }\r\n"
					+ "	    .nav-item{"
					+ "	      margin-left:30px;\\r\\n\"\r\n"
					+ "		   }\r\n"
					+ "      \r\n"
					+ "    </style>\r\n"
					+ "</head>\r\n"
					+ "<body>\r\n"
					+ "	\r\n"
					+ "<nav class=\"navbar navbar-expand-lg navbar-dark\">\r\n"
					+ "    <div class=\"container-fluid fw-bolder fs-4\">\r\n"
					+ "      <a class=\"navbar-brand\" href=\"CustomerDashboard.html\"><h1>BrandVilla</h1></a>\r\n"
					+ "      <button\r\n"
					+ "        class=\"navbar-toggler\"\r\n"
					+ "        type=\"button\"\r\n"
					+ "        data-bs-toggle=\"collapse\"\r\n"
					+ "        data-bs-target=\"#navbarTogglerDemo02\"\r\n"
					+ "        aria-controls=\"navbarTogglerDemo02\"\r\n"
					+ "        aria-expanded=\"false\"\r\n"
					+ "        aria-label=\"Toggle navigation\"\r\n"
					+ "      >\r\n"
					+ "        <span class=\"navbar-toggler-icon\"></span>\r\n"
					+ "      </button>\r\n"
					+ "      <div class=\"collapse navbar-collapse\" id=\"navbarTogglerDemo02\">\r\n"
					+ "        <ul class=\"navbar-nav me-auto mb-2 mb-lg-0 \">\r\n"

					+ "          <li class=\"nav-item\">\r\n"
					+ "            <a class=\"nav-link\" href=\"ShopController\">Shop Product</a>\r\n"
					+ "          </li>\r\n"
					+ "          <li class=\"nav-item\">\r\n"
					+ "            <a class=\"nav-link active\" href=\"CustomerProfileController\">Profile</a>\r\n"
					+ "          </li>\r\n"
					+ "          <li class=\"nav-item\">\r\n"
					+ "            <a class=\"nav-link\" href=\"LastTransactionController\">Last Transaction</a>\r\n"
					+ "          </li>\r\n"
					+ "          <li class=\"nav-item\">\r\n"
					+ "            <a class=\"nav-link\" href=\"CartController\">Cart</a>\r\n"
					+ "          </li>\r\n"
					+ "          <li class=\"nav-item\">\r\n"
					+ "            <a class=\"nav-link\" href=\"BillController\">Bill</a>\r\n"
					+ "          </li>\r\n"
					+ "          <li class=\"nav-item\">\r\n"
					+ "            <a class=\"nav-link\" href=\"CustomerLogoutController\">Logout</a>\r\n"
					+ "          </li>\r\n"
					+ "        </ul>\r\n"
					+ "      </div>\r\n"
					+ "    </div>\r\n"
					+ "  </nav>\r\n"
					+ "\r\n"
					+ "</body>\r\n"
					+ "</html>";
			htmlresponse+="<table class=\"table table-striped table-hover container\">\r\n"
					+ "<thead>\r\n"
					+ "    <tr>\r\n"
					+"<th>Profile</th>"
					+ "    </tr>\r\n"
					+ "  </thead>\r\n"
					+ "  <tbody>\r\n"
					+ "<tr>"
					+ "<td>Name</td>"
					+ "<td>"+p.getName()+"</td>"
					+ "</tr>"
					+ "<tr>"
					+ "<td>UserName</td>"
					+ "<td>"+p.getUname()+"</td>"
					+ "</tr>"
					+ "<tr>"
					+ "<td>Phone No. </td>"
					+ "<td>"+p.getPhone()+"</td>"
					+ "</tr>"
					+ "<tr>"
					+ "<td>Email id</td>"
					+ "<td>"+p.getEmail()+"</td>"
					+ "</tr>";
			htmlresponse+= "  </tbody>\r\n"
					+ "</table>";
           
	        htmlresponse+= "\r\n"
	        		+ "</body>\r\n"
	        		+ "</html>";
	            
            pw.print(htmlresponse);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
