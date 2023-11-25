package com.raghav.employeeManage;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/verifyuserServlet")
public class verifySevlet extends HttpServlet
{

	
	
	public void doPost(HttpServletRequest request,HttpServletResponse response) 
	{
		
		String uname = request.getParameter("username");

		String pass=request.getParameter("password");
		int userid = Integer.parseInt(request.getParameter("userid"));
		
		UserVerifyDao  userdao=new UserVerifyDao ();
		Employee empDetails = userdao.getVerifyDetails(userid);
		
		
		System.out.println(empDetails.getUsername());
		
		// need to complete the project
		// need to use session.save
		//session.get();
		// HQl Query
		//Sql SQLuery if needed.
	}
	
	
	
}
