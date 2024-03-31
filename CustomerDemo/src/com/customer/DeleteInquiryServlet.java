package com.customer;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/DeleteInquiryServlet")
public class DeleteInquiryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;//Encapsulation used to retrieve user data

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String id = request.getParameter("id");

		boolean isTrue;
		
		isTrue = CustomerDBUtil.deleteInquiry(id);
		
		if (isTrue == true) {
			String names = CustomerDBUtil.getName();
			request.setAttribute("names", names);
			
			List<Feedback> feed = CustomerDBUtil.getFeed();
			request.setAttribute("feed", feed);
			
			List<Customer> meDetails = CustomerDBUtil.getMeee();
			request.setAttribute("meDetails", meDetails);
			
			List<Inquiry> other = CustomerDBUtil.getOther();
			request.setAttribute("other", other);
			
			List<Inquiry> mine = CustomerDBUtil.getMine();
			request.setAttribute("mine", mine);
			
			List<Customer> cusDetails = CustomerDBUtil.getCustomer();
			request.setAttribute("cusDetails", cusDetails);
			
			List<Inquiry> inqDetails = CustomerDBUtil.getInquiry();
			request.setAttribute("inqDetails", inqDetails);
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("useraccount.jsp");
			dispatcher.forward(request, response);
		}
		else {
			
			List<Customer> cusDetails = CustomerDBUtil.getCustomer();
			request.setAttribute("cusDetails", cusDetails);
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("useraccount.jsp");
			dispatcher.forward(request, response);
		}
	}

}
