package com.customer_leads_crm_main_project.controller;

import java.io.IOException;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.customer_leads_crm_main_project.model.ClassDAOimpl;
@WebServlet("/reportsServlet")
public class reportsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ClassDAOimpl obj = new ClassDAOimpl();
       
    public reportsServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
HttpSession session = request.getSession(false);
		
		if(session.getAttribute("email") != null) {
		obj.establishConnection();
	ResultSet results = (ResultSet)obj.searchLead();
		if(results != null) {
			request.setAttribute("results", results);
			RequestDispatcher rd1 = request.getRequestDispatcher("WEB-INF/jsps/searchLeads.jsp");
			rd1.forward(request, response);
		}else {
			

			RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/jsps/noSearchLeads.jsp");
			rd.forward(request, response);
		}
		}
		else {
		
			RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/jsps/Logout.jsp");
			rd.forward(request, response);
		
		}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	

	
	
	
	}

}
