package com.customer;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/UpdateCustomerServlet")
public class UpdateCustomerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;//Encapsulation used to retrieve user data

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String id = request.getParameter("id");
		String subject = request.getParameter("subject");
		String desc = request.getParameter("desc");
		String date = request.getParameter("date");
		String status = request.getParameter("status");
		String agent = request.getParameter("agent");
		String solution = request.getParameter("solution");
		String username = request.getParameter("username");
		
		boolean isTrue;
		
		isTrue = CustomerDBUtil.updatecustomer(id, subject, desc, date, status, agent, solution);
		
		
		if(isTrue == true) {
			
			List<Customer> meDetails = CustomerDBUtil.getMeee();
			request.setAttribute("meDetails", meDetails);
			
			List<Feedback> feed = CustomerDBUtil.getFeed();
			request.setAttribute("feed", feed);
			
			List<Inquiry> other = CustomerDBUtil.getOther();
			request.setAttribute("other", other);
			
			List<Inquiry> mine = CustomerDBUtil.getMine();
			request.setAttribute("mine", mine);
			
			List<Customer> cusDetails = CustomerDBUtil.getCustomer();
			request.setAttribute("cusDetails", cusDetails);
			
			List<Inquiry> inqDetails = CustomerDBUtil.getInquiry();
			request.setAttribute("inqDetails", inqDetails);
			
			String names = CustomerDBUtil.getName();
			request.setAttribute("names", names);
			
			RequestDispatcher dis = request.getRequestDispatcher("useraccount.jsp");
			dis.forward(request, response);
		}
		else {	
			List<Inquiry> inqDetails = CustomerDBUtil.getInquiryDetails(id);
			request.setAttribute("inqDetails", inqDetails);
			
			RequestDispatcher dis = request.getRequestDispatcher("unsuccess.jsp");
			dis.forward(request, response);
		}
		
	}

}
