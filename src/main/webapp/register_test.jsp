



<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@page import ="java.util.*"%>
    
 <%@page import="cn.ShoppingCart.model.*"%>
    
    <%
    User auth = (User) request.getSession().getAttribute("auth");
    if (auth != null) {
        response.sendRedirect("index.jsp");
    }
    ArrayList<Cart> cart_list= (ArrayList<Cart> )session.getAttribute("cart-list");
    if(cart_list !=null){
    	request.setAttribute("cart_list",cart_list);
    } %>
<!DOCTYPE html>
<html>
<head>
	<title>User Registration Form</title>
	<%@include file="includes/head.jsp" %>
	
	<!-- Bootstrap CSS -->
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
	<!-- jQuery library -->
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
	<!-- Bootstrap JS -->
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</head>
<body>

    <%@include file="includes/navbar.jsp" %>

	<div class="container">
		<h1 class="mt-5">User Registration</h1>
		<form action="register-user" method="post">
			<div class="form-group">
				<label for="name">Name:</label>
				<input type="text" class="form-control" id="name" name="name" required>
			</div>
			<div class="form-group">
				<label for="email">Email:</label>
				<input type="email" class="form-control" id="email" name="email" required>
			</div>
			<div class="form-group">
				<label for="address">Address:</label>
				<input type="text" class="form-control" id="address" name="address">
			</div>
			<div class="form-group">
				<label for="phone">Phone:</label>
				<input type="tel" class="form-control" id="phone" name="phone">
			</div>
			<div class="form-group">
				<label for="password">Password:</label>
				<input type="password" class="form-control" id="password" name="password" required>
			</div>
			<button type="submit" class="btn btn-primary">Register</button>
		</form>
	</div>
	<%@include file="includes/footer.jsp" %>
	
</body>
</html>