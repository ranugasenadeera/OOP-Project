<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>PixelPulse</title>
<link rel = "stylesheet" type = "text/css" href = "styles.css">

<style>
body {margin: 0;
    background-image: url('img/back1.jpg'); /* Replace with the URL of your background image */
    background-size: cover; /* Adjust to fit your design */
    background-repeat: no-repeat; /* Prevent repeating the image */
    background-attachment: fixed;
}

ul.topnav {
  list-style-type: none;
  margin: 0;
  padding: 0;
  overflow: hidden;
  background-color: #333;
}

ul.topnav li {float: left;}

ul.topnav li a {
  display: block;
  color: white;
  text-align: center;
  padding: 14px 16px;
  text-decoration: none;
}

ul.topnav li a:hover:not(.active) {background-color: #111;}

ul.topnav li a.active {background-color: #04AA6D;}



@media screen and (max-width: 600px) {
  ul.topnav li.right, 
  ul.topnav li {float: none;}
}
* {
  box-sizing: border-box;
}

input[type=text], select, textarea {
  width: 100%;
  padding: 12px;
  border: 1px solid #ccc;
  border-radius: 4px;
  resize: vertical;
}

label {
  padding: 12px 12px 12px 0;
  display: inline-block;
}

input[type=submit] {
  background-color: #04AA6D;
  color: white;
  padding: 12px 20px;
  border: none;
  border-radius: 4px;
  cursor: pointer;
  float: right;
}

input[type=submit]:hover {
  background-color: #45a049;
}

.container {
  border-radius: 5px;
  background-color: #f2f2f2;
  padding: 20px;
  max-width:600px;
  margin-left:500px;
  background:transparent;
  backdrop-filter:blur(10px);
  color:white;
  margin-top:-60px;
}

.col-25 {
  float: left;
  width: 25%;
  margin-top: 6px;
}

.col-75 {
  float: left;
  width: 75%;
  margin-top: 6px;
}

/* Clear floats after the columns */
.row::after {
  content: "";
  display: table;
  clear: both;
}

/* Responsive layout - when the screen is less than 600px wide, make the two columns stack on top of each other instead of next to each other */
@media screen and (max-width: 600px) {
  .col-25, .col-75, input[type=submit] {
    width: 100%;
    margin-top: 0;
  }
}

</style>

</head>
<body>

    <%
		String id = request.getParameter("id");
		String subject = request.getParameter("subject");
		String desc = request.getParameter("desc");
		String date = request.getParameter("date");
		String status = request.getParameter("status");
		String agent = request.getParameter("agent");
		String solution = request.getParameter("solution");
	%>
	 <%@include file = "Header.jsp" %>
  <br><br>
  
	<div class="container"><!--Display payment inquiry in a form before deleting-->
	
	<h2><center>Payment Inquiry</center></h2><br>
        <br><br>
        
  <form action="deletes" method = "post">
  <div class="row">
    <div class="col-25">
      <label for="id">Inquiry ID</label>
    </div>
    <div class="col-75">
      <input type="text" id="id" name="id" value="<%= id %>" readonly>
    </div>
  </div>
  <div class="row">
    <div class="col-25">
      <label for="subject">Subject</label>
    </div>
    <div class="col-75">
      <input type="text" id="subject" name="subject" value="<%= subject %>" readonly>
    </div>
  </div>
  <div class="row">
    <div class="col-25">
      <label for="desc">Description</label>
    </div>
    <div class="col-75">
      <input type="text" id="desc" name="desc" value="<%= desc %>" readonly>
    </div>
  </div>
  <div class="row">
    <div class="col-25">
      <label for="date">Date</label>
    </div>
    <div class="col-75">
      <input type = "date" id="date" name="date" value="<%= date %>" readonly>
    </div>
  </div>
  <div class="row">
    <div class="col-25">
      <label for="status">Status</label>
    </div>
    <div class="col-75">
      <input type="text" id="status" name="status" value="<%= status %>" readonly>
    </div>
  </div>
  <div class="row">
    <div class="col-25">
      <label for="agent">Agent</label>
    </div>
    <div class="col-75">
      <input type="text" id="agent" name="agent" value="<%= agent %>" readonly>
    </div>
  </div>
  <div class="row">
    <div class="col-25">
      <label for="solution">Solution</label>
    </div>
    <div class="col-75">
      <input type="text" id="solution" name="solution" value="<%= solution %>" readonly>
    </div>
  </div>
  <br>
  <div class="row">
    <input type="submit" name = "submit" value="Delete inquiry"><!-- Delete button -->
  </div>
  </form>
</div>
<!-- Footer site of site -->
<%@include file = "Footer.jsp" %>

</body>
</html>