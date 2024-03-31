package com.customer;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;//Encapsulation used to retrieve user data

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		
		String userName = request.getParameter("username");
		String password = request.getParameter("password");
		
		boolean isTrue;
		
		isTrue = CustomerDBUtil.validate(userName, password);
		
		if (isTrue == true) {
			String names = CustomerDBUtil.getName();
			request.setAttribute("names", names);
			
			List<Feedback> feed = CustomerDBUtil.getFeed();
			request.setAttribute("feed", feed);
			
			List<Customer> meDetails = CustomerDBUtil.getMeee();
			request.setAttribute("meDetails", meDetails);
			
			List<Inquiry> other = CustomerDBUtil.getOther();
			request.setAttribute("other", other);
			
			List<Customer> cusDetails = CustomerDBUtil.getCustomer();
			request.setAttribute("cusDetails", cusDetails);
			
			List<Inquiry> mine = CustomerDBUtil.getMine();
			request.setAttribute("mine", mine);
			
			int records = CustomerDBUtil.getCount();
			request.setAttribute("records", records);
			
			List<Inquiry> inqDetails = CustomerDBUtil.getInquiry();
			request.setAttribute("inqDetails", inqDetails);
			
			RequestDispatcher dis = request.getRequestDispatcher("useraccount.jsp");
			dis.forward(request, response);
		} else {
			out.println("<script type='text/javascript'>");
			out.println("alert('Your username or password is incorrect');");
			out.println("location='login.jsp'");
			out.println("</script>");
		}
		
	}

}
