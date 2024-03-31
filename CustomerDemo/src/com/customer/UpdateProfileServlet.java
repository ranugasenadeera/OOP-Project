package com.customer;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/UpdateProfileServlet")
public class UpdateProfileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;//Encapsulation used to retrieve user data

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String phone = request.getParameter("phone");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		boolean isTrue;
		isTrue = CustomerDBUtil.updateprofile(id, name, email, phone, username, password);
		
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
