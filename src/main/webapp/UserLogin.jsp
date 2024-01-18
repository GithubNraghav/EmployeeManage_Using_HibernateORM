<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body style="background-color: #8EC5FC">


<div style="text-align:center;margin:auto; width:400px;">

<h1>User Login</h1>

<form action="verifyuserServlet" method="post">
<table>

<tr>
<td><h3>Enter Username:</h3></td><td><input type="text" name="username"></td>
</tr><br>

<tr>
<td><h3>Enter Password:</h3></td><td><input type="password" name="password"></td>
</tr><br>

<tr>
<td><h3>Enter UserId:</h3></td><td><input type="text" name="userid"></td>
</tr><br>

</table>
<br><br>
<button type="submit" style="width:100px;height:30px;">Submit</button>
</form>


</div>

</body>
</html>