<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page isELIgnored="false" %>
    
    <%@ page import="java.util.List" %>
    <%@ page import="com.raghav.employeeManage.Employee" %>
    
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
List of All employee!!

<%
List <Employee> listofemp =(List<Employee>)request.getAttribute("allemp");

%>

<br><br>

<% 
for(Employee emp :listofemp)
{
%>
	<% 
	out.println(emp);
	%><br><br>
	
<% 
}
%>



</div>
</body>
</html>