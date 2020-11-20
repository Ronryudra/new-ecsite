<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<style>

body{
margin: 0;
padding: 0;
font-family: san-serif;
background-image: url(image/a.jpg);
background-size: cover;
background: #e1f5e6;
}


.box{
width: 300px;
padding: 40px;

position: absolute;
top: 50%;
left: 50%;
transform: translate(-50%, -50%);
text-align: center;
background: #191919;
box-shadow: 0 10px 25px 0 rgba(0, 0, 0, .5);
}



.box h1{
color: white;
font-weight: 500;
}

.box input[type="text"], .box input[type="password"]{
border: 0;
background: none;
display: block;
margin: 20px auto;
text-align: center;
border: 2px solid #3498db;
padding: 14px 10px;
width: 200px;
color: white;
outline: none;
border-radius: 24px;


}
</style>


</head>


<body>
<%String error = (String)request.getAttribute("error"); %>
<%if(error!=null){%>
	<%=error %>
<% }%>

<div>
<form class="box" action="http://localhost:8080/ECsite/login" method="POST">

<h1>Login</h1>
<input type="text" name="name" placeholder="Username">
<input type="Password" name="password" placeholder="Password">
<input type="submit" name="" value="Login">


</form>

<div>
<form class="box2" action="http://localhost:8080/ECsite/makeaccount" method="GET">

<input type="submit" name="" value="Make account">


</form>

</div>

</div>


</body>
</html>