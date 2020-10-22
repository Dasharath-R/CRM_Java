package com.customer_leads_crm_main_project.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.customer_leads_crm_main_project.model.ClassDAOimpl;
@WebServlet("/createLeadServlet")
public class createLeadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ClassDAOimpl obj = new ClassDAOimpl();
       
    public createLeadServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	 RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/jsps/createLead.jsp");
	   rd.forward(request, response);
	
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	HttpSession session = request.getSession(false);
	
	
	if(session.getAttribute("email") != null) {
	String fname = request.getParameter("fname");
	String lname = request.getParameter("lname");
	String email = request.getParameter("email");
	String city = request.getParameter("city");
	String mobile = request.getParameter("mobile");
	
	
	obj.establishConnection();
	obj.createLead(fname,lname, email, city, mobile);
	request.setAttribute("msg_leads", "Lead has been stored");
	
	RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/jsps/createLead.jsp");
	rd.include(request, response);
	}else {
		RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/jsps/Logout.jsp");
		rd.include(request, response);
	}
	
	
	
	
	}

}
