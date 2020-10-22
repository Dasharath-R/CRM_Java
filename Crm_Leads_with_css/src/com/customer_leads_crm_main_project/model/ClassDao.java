package com.customer_leads_crm_main_project.model;
import java.sql.*;

public interface ClassDao {
    public void establishConnection();
	public boolean Login(String email ,String password);
	public void createLead(String firstName , String lastName , String emailId ,String city , String mobile);
	public ResultSet searchLead();
	public void reports();
	public void deleteLead(String email);
	public void updateLead(String email,String mobile);
	public void destroyConnection();
	
}
