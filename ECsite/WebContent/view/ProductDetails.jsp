<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="model.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>




    <% ProductBean productbean = (ProductBean)request.getAttribute("product"); %>



    <% CategoryBean categorybean = (CategoryBean) request.getAttribute("Category"); %>



<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<style>


*{
margin: 0;
padding: 0;
box-sizing: border-box;
}

.logout{
position: absolute;
bottom: 0;
right: 0;
}

body{

background-image: url("images/Limeade.jpg");
background-size: cover;
}

.a{
display: flex;
justify-content: center;
align-items: center;

margin: 0 auto;
}

img{
height: 300px;
width: 300px;

padding: 10px;
}


.image:hover img{
transform: scale(1.4) rotate(15deg);
}


</style>
</head>



<body>



<form name ="Logout"  action="http://localhost:8080/ECsite/logout" method="POST">

<table>

<div class="logout">
<input type="submit" value="Logout">
</div>

</table>


</form>

<div class="a">

<a href="<%= productbean.getProImg()%>" class="image"><img src="<%= productbean.getProImg()%> " ></a>

<div class="b">
<table border="1">
<tr><td>Product Name</td><td><%= productbean.getProName()%></td></tr>
<tr><td>Category</td><td><%= categorybean.getCatName()%></td></tr>
<tr><td>Price</td><td>
 <fmt:formatNumber value="<%= productbean.getProPrice()%>"
     type="CURRENCY" currencySymbol="￡" /></td></tr>
<tr><td>Stock</td><td><%= productbean.getProStock()%></td></tr>
<tr><td>Description</td><td><%= productbean.getProMsg()%></td></tr>


</table>







<table border="0" cellspacing="4" cellpadding="0">
<tr>


<td>
<form action="http://localhost:8080/ECsite/product" method="POST">
Stock
<input type= "number" name="number" value="1" min="1" max=<%= productbean.getProStock() %> >
<input type="submit" value="Cart">

<input type="hidden" name="name" value="<%=productbean.getProName()%>">
<input type="hidden" name="price" value="<%=productbean.getProPrice()%>">
<input type="hidden" name="code" value="<%=productbean.getProCd()%>">
</form></td>

<form action="http://localhost:8080/ECsite/back" method="POST">
<td><input type="submit" value="Back"></td>
</form>

</tr>
</table>
<input type="hidden" name="goodsNo" value="1">




</div>




</body>
</html>