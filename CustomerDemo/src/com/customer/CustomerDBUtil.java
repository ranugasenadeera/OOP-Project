package com.customer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class CustomerDBUtil {
	
	private static boolean isSuccess;
	private static Connection con = null;
	private static Statement stmt = null;
	private static ResultSet rs = null;
    
	public static boolean validate(String username, String password) {
		
		try {
			con = DBConnect.getConnection();
			stmt = con.createStatement();
			String sql = "select * from customer_support where Username='"+username+"' and Password='"+password+"'";
			rs = stmt.executeQuery(sql);
			
			if (rs.next()) {
				isSuccess = true;
			} else {
				isSuccess = false;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return isSuccess;
	}
	
	public static List<Customer> getCustomer() {//Return all customer support agents
		
		ArrayList<Customer> customer = new ArrayList<>();
		
		try {
			
			con = DBConnect.getConnection();
			stmt = con.createStatement();
			String sql = "select * from customer_support";
			rs = stmt.executeQuery(sql);
			
			while (rs.next()) {
				int id = rs.getInt(1);
				String name = rs.getString(2);
				String email = rs.getString(3);
				String phone = rs.getString(4);
				String username = rs.getString(5);
				String password = rs.getString(6);
				
	    	 Customer cus = new Customer(id,name,email,phone,username,password);
				customer.add(cus);
			}
			
		} catch (Exception e) {
			
		}
		
		return customer;	
	}
	
	public static int getCount() {
		int count = 0;
		
		try {
			con = DBConnect.getConnection();
			String sql = "select count(*) from paymentinquiry";
			PreparedStatement pS = con.prepareStatement(sql);
			rs = pS.executeQuery();
			
			if(rs.next()) {
				count = rs.getInt(1);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return count;
	}
	
	public static String getName() {
		String name = "";
		
		try {
			con = DBConnect.getConnection();
			String sql = "select Name from customer_support where Cus_id = 1";
			PreparedStatement pS = con.prepareStatement(sql);
			rs = pS.executeQuery();
			
			if(rs.next()) {
				name = rs.getString(1);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return name;
	}
	
    public static List<Inquiry> getInquiry() {//Return all payment inquiries
		
		ArrayList<Inquiry> customer = new ArrayList<>();
		
		try {
			
			con = DBConnect.getConnection();
			stmt = con.createStatement();
			String sql = "select * from paymentinquiry";
			rs = stmt.executeQuery(sql);
			
			while (rs.next()) {
				int id = rs.getInt(1);
				String subject = rs.getString(2);
				String desc = rs.getString(3);
				String date = rs.getString(4);
				String status = rs.getString(5);
				String agent = rs.getString(6);
				String solution = rs.getString(7);
				
				Inquiry inq = new Inquiry(id,subject,desc,date,status,agent, solution);
				customer.add(inq);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return customer;	
	}
    
public static List<Feedback> getFeed() {//Return all payment inquiries
		
		ArrayList<Feedback> feed = new ArrayList<>();
		
		try {
			
			con = DBConnect.getConnection();
			stmt = con.createStatement();
			String sql = "select * from feedback";
			rs = stmt.executeQuery(sql);
			
			while (rs.next()) {
				int id = rs.getInt(1);
				int agid = rs.getInt(2);
				String name = rs.getString(3);
				String date = rs.getString(4);
				int rate = rs.getInt(5);
				
				Feedback fe = new Feedback(id,agid,name,date,rate);
				feed.add(fe);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return feed;	
	}
    
    public static List<Inquiry> getMine() {//Return my payment inquiries
		
		ArrayList<Inquiry> customer = new ArrayList<>();
		
		try {
			
			con = DBConnect.getConnection();
			stmt = con.createStatement();
			String sql = "select * from paymentinquiry where agent = 'Ranuga Senadeera'";
			rs = stmt.executeQuery(sql);
			
			while (rs.next()) {
				int id = rs.getInt(1);
				String subject = rs.getString(2);
				String desc = rs.getString(3);
				String date = rs.getString(4);
				String status = rs.getString(5);
				String agent = rs.getString(6);
				String solution = rs.getString(7);
				
				Inquiry inq = new Inquiry(id,subject,desc,date,status,agent, solution);
				customer.add(inq);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return customer;	
	}
    
    public static List<Inquiry> getOther() {
		
		ArrayList<Inquiry> customer = new ArrayList<>();
		
		try {
			
			con = DBConnect.getConnection();
			stmt = con.createStatement();
			String sql = "select * from paymentinquiry where agent is NULL";
			rs = stmt.executeQuery(sql);
			
			while (rs.next()) {
				int id = rs.getInt(1);
				String subject = rs.getString(2);
				String desc = rs.getString(3);
				String date = rs.getString(4);
				String status = rs.getString(5);
				String agent = rs.getString(6);
				String solution = rs.getString(7);
				
				Inquiry inq = new Inquiry(id,subject,desc,date,status,agent, solution);
				customer.add(inq);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return customer;	
	}
    
        public static List<Customer> getMeee() {
		
		ArrayList<Customer> customer = new ArrayList<>();
		
		try {
			
			con = DBConnect.getConnection();
			stmt = con.createStatement();
			String sql = "select * from customer_support where Name = 'Ranuga Senadeera'";
			rs = stmt.executeQuery(sql);
			
			while (rs.next()) {
				int id = rs.getInt(1);
				String name = rs.getString(2);
				String email = rs.getString(3);
				String phone = rs.getString(4);
				String username = rs.getString(5);
				String password = rs.getString(6);
				
				Customer cus = new Customer(id,name,email,phone,username,password);
				customer.add(cus);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return customer;	
	}
    
    public static boolean insertcustomer(String name, String email, String phone, String username, String password) {
    	//Insert data to agent table
    	boolean isSuccess = false;
    	
    	try {
    		con = DBConnect.getConnection();
    		stmt = con.createStatement();
    	    String sql = "insert into customer_support values (0,'"+name+"','"+email+"','"+phone+"','"+username+"','"+password+"')";
    		int rs = stmt.executeUpdate(sql);
    		
    		if(rs > 0) {
    			isSuccess = true;
    		} else {
    			isSuccess = false;
    		}
    		
    	}
    	catch (Exception e) {
    		e.printStackTrace();
    	}
 	
    	return isSuccess;
    }
    
    public static boolean updatecustomer(String id, String subject, String desc, String date, String status, String agent, String solution) {
    	//Update data in the payment inquiry table
    
    	
    	try {
    		
    		con = DBConnect.getConnection();
    		stmt = con.createStatement();
    		String sql = "update paymentinquiry set subject='"+subject+"', Description='"+desc+"', date='"+date+"', status='"+status+"', agent='"+agent+"',solution='"+solution+"'"
    				+ "where inq_id='"+id+"'";
    		int rs = stmt.executeUpdate(sql);
    		
    		if(rs > 0) {
    			isSuccess = true;
    		}
    		else {
    			isSuccess = false;
    		}
    		
    	}
    	catch(Exception e) {
    		e.printStackTrace();
    	}
    	
    	return isSuccess;
    }
    
    public static boolean updateprofile(String id, String name, String email, String phone, String username, String password) {
    	//Update data in my profile
    	
    	try {
    		
    		con = DBConnect.getConnection();
    		stmt = con.createStatement();
    		String sql = "update customer_support set Name='"+name+"', Email='"+email+"', Phone_no='"+phone+"', Username='"+username+"', Password='"+password+"'"
    				+ "where Cus_id='"+id+"'";
    		int rs = stmt.executeUpdate(sql);
    		
    		if(rs > 0) {
    			isSuccess = true;
    		}
    		else {
    			isSuccess = false;
    		}
    		
    	}
    	catch(Exception e) {
    		e.printStackTrace();
    	}
    	
    	return isSuccess;
    }
 
   public static List<Inquiry> getInquiryDetails(String Id){
	   
	   int convertedID = Integer.parseInt(Id);
	   
	   ArrayList<Inquiry> inq = new ArrayList<>();
	   
	   try {
		   con = DBConnect.getConnection();
		   stmt = con.createStatement();
		   String sql = "select * from paymentinquiry where id = '"+convertedID+"'";
		   rs = stmt.executeQuery(sql);
		   
		   while(rs.next()) {
			   int id = rs.getInt(1);
			   String subject = rs.getString(2);
			   String desc = rs.getString(3);
			   String date = rs.getString(4);
			   String status = rs.getString(5);
			   String agent = rs.getString(6);
			   String solution = rs.getString(7);
			   
			   Inquiry i = new Inquiry(id, subject, desc, date, status, agent, solution);
			   inq.add(i);
		   }
	   }
	   catch(Exception e) {
		   e.printStackTrace();  
	 }
	   return inq;
   }
   
   public static boolean deleteInquiry(String id) {//Delete data in the payment inquiry table
   	
   	int convId = Integer.parseInt(id);
   	
   	try {
   		
   		con = DBConnect.getConnection();
   		stmt = con.createStatement();
   		String sql = "delete from paymentinquiry where inq_id='"+convId+"'";
   		int r = stmt.executeUpdate(sql);
   		
   		if (r > 0) {
   			isSuccess = true;
   		}
   		else {
   			isSuccess = false;
   		}
   		
   	}
   	catch (Exception e) {
   		e.printStackTrace();
   	}
   	
   	return isSuccess;
   }
    
    
    public static boolean deleteCustomer(String id) {//Delete data in the agent table
    	
    	int convId = Integer.parseInt(id);
    	
    	try {
    		
    		con = DBConnect.getConnection();
    		stmt = con.createStatement();
    		String sql = "delete from customer_support where Cus_id='"+convId+"'";
    		int r = stmt.executeUpdate(sql);
    		
    		if (r > 0) {
    			isSuccess = true;
    		}
    		else {
    			isSuccess = false;
    		}
    		
    	}
    	catch (Exception e) {
    		e.printStackTrace();
    	}
    	
    	return isSuccess;
    }
}
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    

