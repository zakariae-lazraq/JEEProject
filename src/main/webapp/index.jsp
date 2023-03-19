<%@ page import = "cn.ShoppingCart.connection.DbCon" %>
<%@page import ="java.util.*"%>
<%@ page import = "cn.ShoppingCart.dao.ProductDao" %>
<%@page import="cn.ShoppingCart.model.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   
<%
User auth = (User) request.getSession().getAttribute("auth");
if (auth != null) {
    request.setAttribute("person", auth);
}
ProductDao pd= new ProductDao(DbCon.getConnection());
List<Product> products=pd.getAllProducts();

ArrayList<Cart> cart_list= (ArrayList<Cart> )session.getAttribute("cart-list");
if(cart_list !=null){
	request.setAttribute("cart_list",cart_list);
}
%>
<!DOCTYPE html>
<html>
<head>
<title>Welcome To Shopping Cart</title>
<%@include file="includes/head.jsp" %>
<style>
.card{
    box-shadow: rgba(149, 157, 165, 0.2) 0px 8px 24px;
    height:735px !important;
}
</style>
</head>
<body> 
<%@include file="includes/navbar.jsp" %>
<!-- <div class="bg-image"> -->
<div class="inBetween">
<div class="container">
<div class="card-header my-3">All Books</div>
<div class="row">
<%
if(!products.isEmpty()){
	for(Product p:products){%>
		<div class="col-md-3 my-3" >
		<div class="card w-100" style="width: 18rem;">
		  	<img class="card-img-top" src="product-image/<%=p.getImage() %>" alt ="Card image cap">
		  	<div class="card-body" >
		  	<h5 class="card-title"><%=p.getName() %></h5>
			<h6 class="price">Price: $ <%=p.getPrice() %></h6> 
			<h6 class="category">Category: <%= p.getCategory() %></h6> 
		    <h5 class="card-title">Card title</h5>
		    <p class="card-text">Some quick example text to build on the card title and make up the bulk of the card's content.<a href="detail-product?id=<%=p.getId()%>">Show more ...</a></p>
		   	<div class="mt-3 d-flex justify-content-between" > 
			<a href="add-to-cart?id=<%=p.getId() %>" class="btn btn-dark">Add to Cart</a>  
		 	<a href="order-now?quantity=1&id=<%=p.getId() %>" class="btn btn-primary" >Buy Now</a> 
		</div>
		</div>
		</div>
		</div>
	<% }
}
%>
</div>
</div>
</div>


<%@include file="includes/footer.jsp" %>
<!-- </div> -->
</body>
</html>