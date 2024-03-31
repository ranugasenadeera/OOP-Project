<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="ISO-8859-1">
        <title>Support Dashboard</title>
        <link rel = "stylesheet" type = "text/css" href = "styles.css">
        
    </head>
    <body>
        
        
        <nav class = "profile"><!--side vertical bar to display profile-->
        <br><br>
        <center><h1>Customer Support<br>Dashboard</h1></center>
        <br><br>
        <h2>Welcome <% String names = (String)request.getAttribute("names");%>
	<%= names %></h2><br>
	
	      <div class="prof">
                    <h2 style = "margin-left:100px;">My profile</h2>
                    <c:forEach var="mee" items="${meDetails}">
                    <c:set var="id" value="${mee.id}"/>
	                <c:set var="name" value="${mee.name}"/>
	                <c:set var="email" value="${mee.email}"/>
	                <c:set var="phone" value="${mee.phone}"/>
	                <c:set var="username" value="${mee.userName}"/>
	                <c:set var="password" value="${mee.password}"/>

                    <img src="img/profile.jpg" alt="User Avatar" width="80" height="80" style = "margin-left:120px;">
                    <br><br>
                    <div style = "margin-left:70px;">
                    <h3 style = "text-align:left;">My ID : ${mee.id}</h3>
                    <h3 style = "text-align:left;">Name : ${mee.name}</h3>
                    <h3 style = "text-align:left;">Email : ${mee.email}</h3>
                    <h3 style = "text-align:left;">Phone_no : ${mee.phone}</h3>
                    <h3 style = "text-align:left;">User name : ${mee.userName}</h3>
                    </div>

		            <c:url value="updateprofile.jsp" var="profupdate">
		            <c:param name="id" value="${id}"/>
		            <c:param name="name" value="${name}"/>
		            <c:param name="email" value="${email}"/>
		            <c:param name="phone" value="${phone}"/>
		            <c:param name="username" value="${username}"/>
		            <c:param name="password" value="${password}"/>
	                </c:url>

                    <a href="${profupdate}">
	                   <input type="button" name="update" value="Update" style = "margin-left:80px;">
	                </a>
                    </c:forEach>
                </div>
            </nav>
            <div style = "background-color:light grey;
                          background-image: url('img/back1.jpg'); /* Replace with the URL of your background image */
                          background-size: cover; /* Adjust to fit your design */
                          background-repeat: no-repeat; /* Prevent repeating the image */
                          background-attachment: fixed; /* Fixed background image */">
	     
        <div style="margin-left:25.5%;height:1000px;margin-right:-2px;">
            <!-- Header of site -->
              <%@include file = "Header.jsp" %>
               <br>
        <div class="dashboard">
        <a href = "#inq" class="button open">
            <div class="icon">Payment Inquiries</div>
            <div class="label">Open Tickets</div>
        </a>
        <a href = "#agents" class="button agent">
            <div class="icon">Agents</div>
            <div class="label">Assign our support agents</div>
        </a>
        <a href = "#un" class="button unassigned">
            <div class="icon">Payment Inquiries</div>
            <div class="label">Unassigned Tickets</div>
        </a>
        <a href = "#fe" class="button user-feedback">
            <div class="icon">User Feedback</div>
            <div class="label">Customer Satisfaction</div>
        </a>
        <a href = "#mine" class="button my-tickets">
            <div class="icon">Payment Inquiries</div>
            <div class="label">My Tickets</div>
        </a>
    </div>
        
        <br><br><br>
        
        <center><h2 style = "color:white;" id = "inq">Payment Inquiries</h2></center><!--Display all payment inquiries-->
        <table style="width:100%;margin-top:-100px;">
	<c:forEach var="inq" items="${inqDetails}">
	
	<c:set var="id" value="${inq.id}"/>
	<c:set var="subject" value="${inq.subject}"/>
	<c:set var="desc" value="${inq.desc}"/>
	<c:set var="date" value="${inq.date}"/>
	<c:set var="status" value="${inq.status}"/>
	<c:set var="agent" value="${inq.agent}"/>
	<c:set var="solution" value="${inq.solution}"/>
	
	<tr>
		<th>Inquiry ID</th>
		<td>${inq.id}</td>
	</tr>
	<tr>
		<th>Subject</th>
		<td>${inq.subject}</td>
	</tr>
	<tr>
		<th>Description</th>
		<td>${inq.desc}</td>
	</tr>
	<tr>
		<th>Date</th>
		<td>${inq.date}</td>
	</tr>
	<tr>
		<th>Status</th>
		<td>${inq.status}</td>
	</tr>
	<tr>
		<th>Agent</th>
		<td>${inq.agent}</td>
	</tr>
    <tr>
		<th>Solution</th>
		<td>${inq.solution}</td>
	</tr>
	<tr><th>Edit</th>
	<td>
	<c:url value="updatecustomer.jsp" var="cusupdate">
		<c:param name="id" value="${id}"/>
		<c:param name="subject" value="${subject}"/>
		<c:param name="desc" value="${desc}"/>
		<c:param name="date" value="${date}"/>
		<c:param name="status" value="${status}"/>
		<c:param name="agent" value="${agent}"/>
		<c:param name="solution" value="${solution}"/>
	</c:url><a href="${cusupdate}">
	<input type="button" name="update" value="Update">
	</a></td></tr>
	<tr><th>Delete</th>
	<td>
	<c:url value="deleteinquiry.jsp" var="inqdelete">
		<c:param name="id" value="${id}"/>
		<c:param name="subject" value="${subject}"/>
		<c:param name="desc" value="${desc}"/>
		<c:param name="date" value="${date}"/>
		<c:param name="status" value="${status}"/>
		<c:param name="agent" value="${agent}"/>
		<c:param name="solution" value="${solution}"/>
	</c:url><a href="${inqdelete}">
	<input type="button" name="update" value="Delete">
	</a></td></tr>

	<br><br>

	</c:forEach>
	</table>
	<br><br>
	
	<center><h2 style = "color:white;" id = "agents">Customersupport agents</h2></center><!--Display Customer support agents-->
	<table class = "ag" style="width:100%;margin-left:10px;">
	<tr><th>Agent ID</th>
	    <th>Name</th>
	    <th>Email</th>
	    <th>Phone</th>
	    <th>User name</th>
	    <th>Delete</th>
	    </tr>
	
		<c:forEach var="cus" items="${cusDetails}">
	<tr>
	<c:set var="id" value="${cus.id}"/>
	<c:set var="name" value="${cus.name}"/>
	<c:set var="email" value="${cus.email}"/>
	<c:set var="phone" value="${cus.phone}"/>
	<c:set var="username" value="${cus.userName}"/>
	<c:set var="password" value="${cus.password}"/>
		<td>${cus.id}</td>
		<td>${cus.name}</td>
		<td>${cus.email}</td>
		<td>${cus.phone}</td>
		<td>${cus.userName}</td>
		<td>	
		<c:url value="deletecustomer.jsp" var="cusdelete">
	    <c:param name="id" value="${id}"/>
		<c:param name="name" value="${name}"/>
		<c:param name="email" value="${email}"/>
		<c:param name="phone" value="${phone}"/>
		<c:param name="username" value="${username}"/>
		<c:param name="password" value="${password}"/>
	    </c:url>
	    <a href = "${cusdelete}"><input type = "button" name = "delete" value = "Delete Agent"></a>
	    </td>
		</tr>
		
		</c:forEach>
	
	</table>
        
       <c:url value="customerinsert.jsp" var="cusinsert"></c:url>
       <a href="${cusinsert}">
	<input class = "add" type="button" name="update" value="Add agent">
	</a>
	
	<br><br>
	
	<center><h2 style = "color:white;" id = "mine">My Inquiries(Payment)</h2></center><!--Display my inquiries-->
        <table style="width:100%">
	<c:forEach var="my" items="${mine}">
	
	<c:set var="id" value="${my.id}"/>
	<c:set var="subject" value="${my.subject}"/>
	<c:set var="desc" value="${my.desc}"/>
	<c:set var="date" value="${my.date}"/>
	<c:set var="status" value="${my.status}"/>
	<c:set var="agent" value="${my.agent}"/>
	<c:set var="solution" value="${my.solution}"/>
	
	<tr>
		<th>Inquiry ID</th>
		<td>${my.id}</td>
	</tr>
	<tr>
		<th>Subject</th>
		<td>${my.subject}</td>
	</tr>
	<tr>
		<th>Description</th>
		<td>${my.desc}</td>
	</tr>
	<tr>
		<th>Date</th>
		<td>${my.date}</td>
	</tr>
	<tr>
		<th>Status</th>
		<td>${my.status}</td>
	</tr>
	<tr>
		<th>Agent</th>
		<td>${my.agent}</td>
	</tr>
    <tr>
		<th>Solution</th>
		<td>${my.solution}</td>
	</tr>
	<tr><th>Edit</th>
	<td>
	<c:url value="updatecustomer.jsp" var="cusupdate">
		<c:param name="id" value="${id}"/>
		<c:param name="subject" value="${subject}"/>
		<c:param name="desc" value="${desc}"/>
		<c:param name="date" value="${date}"/>
		<c:param name="status" value="${status}"/>
		<c:param name="agent" value="${agent}"/>
		<c:param name="solution" value="${solution}"/>
	</c:url><a href="${cusupdate}">
	<input type="button" name="update" value="Update Inquiry">
	</a></td></tr>

	</c:forEach>
	</table>
	
	<br><br>
	
	<center><h2 style = "color:white;" id = "un">Unassigned inquiries(Payment)</h2></center> <!--Display unassigned inquiries-->
        <table style="width:100%;">
	<c:forEach var="ot" items="${other}">
	
	<c:set var="id" value="${ot.id}"/>
	<c:set var="subject" value="${ot.subject}"/>
	<c:set var="desc" value="${ot.desc}"/>
	<c:set var="date" value="${ot.date}"/>
	<c:set var="status" value="${ot.status}"/>
	<c:set var="agent" value="${ot.agent}"/>
	<c:set var="solution" value="${ot.solution}"/>
	
	<tr>
		<th>Inquiry ID</th>
		<td>${ot.id}</td>
	</tr>
	<tr>
		<th>Subject</th>
		<td>${ot.subject}</td>
	</tr>
	<tr>
		<th>Description</th>
		<td>${ot.desc}</td>
	</tr>
	<tr>
		<th>Date</th>
		<td>${ot.date}</td>
	</tr>
	<tr>
		<th>Status</th>
		<td>${ot.status}</td>
	</tr>
	<tr>
		<th>Agent</th>
		<td>${ot.agent}</td>
	</tr>
    <tr>
		<th>Solution</th>
		<td>${ot.solution}</td>
	</tr>
	<tr><th>Edit</th>
	<td>
	<c:url value="updatecustomer.jsp" var="cusupdate">
		<c:param name="id" value="${id}"/>
		<c:param name="subject" value="${subject}"/>
		<c:param name="desc" value="${desc}"/>
		<c:param name="date" value="${date}"/>
		<c:param name="status" value="${status}"/>
		<c:param name="agent" value="${agent}"/>
		<c:param name="solution" value="${solution}"/>
	</c:url><a href="${cusupdate}">
	<input type="button" name="update" value="Update Inquiry">
	</a></td></tr>

	</c:forEach>
	</table>
	
	<br><br>
	  
	  <center><h2 id = "fe" style = "color:white;" id = "un">Customer feedback</h2></center> <!--Display unassigned inquiries-->
        <table style="width:100%;margin-bottom:50px;">
	<c:forEach var="f" items="${feed}">
	
	<c:set var="id" value="${f.id}"/>
	<c:set var="agid" value="${f.agid}"/>
	<c:set var="name" value="${f.name}"/>
	<c:set var="date" value="${f.date}"/>
	<c:set var="rate" value="${f.rate}"/>
	
	<tr>
		<th>Feedback ID</th>
		<td>${f.id}</td>
	</tr>
	<tr>
		<th>Agent ID</th>
		<td>${f.agid}</td>
	</tr>
	<tr>
		<th>Name</th>
		<td>${f.name}</td>
	</tr>
	<tr>
		<th>Date</th>
		<td>${f.date}</td>
	</tr>
	<tr>
		<th>Rating</th>
		<td>${f.rate}</td>
	</tr>
	<tr></tr>

	</c:forEach>
	</table>
	
	  </div>
	
	  </div>
	  
	  </div>
        
    </body>
</html>