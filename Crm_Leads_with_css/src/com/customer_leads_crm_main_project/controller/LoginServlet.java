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

@WebServlet("/LginServlet")
public class LoginServlet extends HttpServlet {
	private ClassDAOimpl  dao = new ClassDAOimpl();
	private static final long serialVersionUID = 1L;
    public LoginServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String email = request.getParameter("email");
		String pwd = request.getParameter("pwd");
		
		dao.establishConnection();
		
		boolean booleanval = dao.Login(email,pwd);
		HttpSession session = request.getSession(true);
	
		if(booleanval == true) {
			session.setAttribute("email", email);
			
			RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/jsps/createLead.jsp");
		  rd.forward(request, response);
			
		}else {
			
	       request.setAttribute("msg", "Enterd username/password is wrong");
			RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
			  rd.include(request, response);
		
		}
	
	}

}
