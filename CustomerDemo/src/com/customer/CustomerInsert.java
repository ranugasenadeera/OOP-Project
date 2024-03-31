package com.customer;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/CustomerInsert")
public class CustomerInsert extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String phone = request.getParameter("phone");
		String userName = request.getParameter("username");
		String password = request.getParameter("password");
		
		boolean isTrue;
		
		isTrue = CustomerDBUtil.insertcustomer(name, email, phone, userName, password);
		
		if(isTrue == true) {
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
			
			int records = CustomerDBUtil.getCount();
			request.setAttribute("records", records);
			
			List<Inquiry> inqDetails = CustomerDBUtil.getInquiry();
			request.setAttribute("inqDetails", inqDetails);
			
			RequestDispatcher dis = request.getRequestDispatcher("useraccount.jsp");
			dis.forward(request, response);
		} else {
			RequestDispatcher dis2 = request.getRequestDispatcher("unsuccess.jsp");
			dis2.forward(request, response);
		}
		
		
	}

}
