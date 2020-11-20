<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<style>

body{

background-image: url("/ECsite/images/Limeade.jpg");
background-size: cover;
}

.a{
position: absolute;
top: 50%;
left: 50%;

transform: translate(-50%,-50%);

}
h1{
text-align: center;
}



</style>

</head>
<body>

<h1>Make Account</h1>


<div class="a">

<form action="http://localhost:8080/ECsite/makeaccount" method="POST">


<input type="text" name="createname" placeholder="In 50 words or less">
<input type="Password" name="createpassword" placeholder="In 50 words or less">
<input type="submit" name="" value="Register">

</form>

<form action="http://localhost:8080/ECsite/login" method="GET">


<input type="submit" name="" value="Back to login">

</form>

</div>

</body>
</html>