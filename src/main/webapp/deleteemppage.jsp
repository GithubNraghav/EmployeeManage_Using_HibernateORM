<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body style="background-color: #CDDCDC;
 background-image: radial-gradient(at 50% 100%, rgba(255,255,255,0.50) 0%, rgba(0,0,0,0.50) 100%), linear-gradient(to bottom, rgba(255,255,255,0.25) 0%, rgba(0,0,0,0.25) 100%);
 background-blend-mode: screen, overlay;">
 
 <div style="text-align:center">
Enter Userid of Employee to delete the Record<br>
<br>
<form action="Adminservlet" method="post">

Enter userid:<input type="text" name="uId"><br><br>

<button type="submit" value="deleteEmp" name="button">DeleteEmp</button>

</form>
</div>
</body>
</html>

