package com.customer_leads_crm_main_project.model;

import java.sql.*;



public class ClassDAOimpl implements ClassDao {
	private Connection con;
	private Statement stmt;

	@Override
	public void establishConnection() {
		
		try {
			
		Class.forName("com.mysql.jdbc.Driver");
		 con = DriverManager.getConnection("jdbc:mysql://localhost:3306/customer_leads_crm", "root","test");
		 stmt = con.createStatement();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public boolean Login(String email, String password) {
		
		
		try {
			
			ResultSet results = stmt.executeQuery("select * from login where emailid = '"+email+"' and  password = '"+password+"'");
			System.out.println(results);
			return results.next();
			
			
		}catch(Exception e) {
			
			System.out.println(e);
		}
		
		
		return false;
	}

	@Override
	public void createLead(String firstName, String lastName, String emailId, String city, String mobile) {

		try {
		 int g = stmt.executeUpdate("insert into leads values('"+firstName+"','"+lastName+"','"+emailId+"','"+city+"','"+mobile+"')");
			System.out.println(g);
		
	
		}catch(Exception e) {
	
e.printStackTrace();	
}
	}

	@Override
	public ResultSet searchLead() {
		
	try {
		ResultSet results = stmt.executeQuery("select * from leads");
			return results;

		
	}catch(Exception e) {
	
	e.printStackTrace();
	}

		
		return null;

	}
	
	@Override
	public void reports() {
		
	
	}
	

	@Override
	public void destroyConnection() {

	}

	@Override
	public void deleteLead(String email) {

		try {
			stmt.executeUpdate("Delete from leads where emailid = '"+email+"'");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void updateLead(String email, String mobile) {

		try {
			
			stmt.executeUpdate("update  leads set mobile = '"+mobile+"' where emailid = '"+email+"'");
			
		}catch(Exception e) {
	
			e.printStackTrace();
			
		}
		}
		
	}

	


