<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<style>
body{
 background: -moz-linear-gradient(left, #FFC778 50%, #FFF);
  background: -webkit-linear-gradient(left, #FFC778 50%, #FFF);
  background: linear-gradient(to right, #FFC778 50%, #FFF);
}

.a{
display: flex;
justify-content: center;
align-items: center;


}

</style>
</head>
<body>




<div class="a">

<div class="b">

<h1>Thank you for purchasing our goods</h1>


<form action="http://localhost:8080/ECsite/back" method="POST">

<input type="submit" value="continue">

</form>

<form action="http://localhost:8080/ECsite/logout" method="POST">
<input type="submit" value="logout">

</form>

</div>


</div>
</body>
</html>