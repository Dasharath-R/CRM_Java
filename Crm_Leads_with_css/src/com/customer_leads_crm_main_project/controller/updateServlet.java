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

@WebServlet("/updateServlet")
public class updateServlet extends HttpServlet {
	private ClassDAOimpl obj = new ClassDAOimpl();
	private static final long serialVersionUID = 1L;
       
    public updateServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
HttpSession session = request.getSession(false);
		
		if(session.getAttribute("email") != null) {
		String email = request.getParameter("email");
		String mobile = request.getParameter("mobile");
		
		request.setAttribute("email", email);

		request.setAttribute("mobile", mobile);
		
		RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/jsps/updateLead.jsp");
		rd.forward(request, response);
		}else {

			RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
			rd.forward(request, response);
		}
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
HttpSession session = request.getSession(false);
		
		if(session.getAttribute("email") != null) {
		String email = request.getParameter("email");
		String mobile = request.getParameter("mobile");
		
		obj.establishConnection();
		obj.updateLead(email, mobile);
		
		ResultSet results = obj.searchLead();
		request.setAttribute("results", results);
		RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/jsps/searchLeads.jsp");
		rd.forward(request, response);
		
		
	}else {
		RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
		rd.forward(request, response);
		
	}
	}
}
