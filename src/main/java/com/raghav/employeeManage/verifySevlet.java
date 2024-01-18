package com.raghav.employeeManage;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/verifyuserServlet")
public class verifySevlet extends HttpServlet
{

	
	
	public void doPost(HttpServletRequest request,HttpServletResponse response) 
	{
		
		
		String uname = request.getParameter("username");

		String pass=request.getParameter("password");
		int userid = Integer.parseInt(request.getParameter("userid"));
		
		UserVerifyclass userdao=new UserVerifyclass ();
		Employee empDetails = userdao.getVerifyDetails(userid);
		
		
		// System.out.println(empDetails.getUsername());
		
		
		//1.	
		
		if(empDetails!=null) 
		{
		
		if(empDetails.getType().equals("admin")) 
		{
			
			
			try 
			{
				
			HttpSession session= request.getSession();
			session.setAttribute("adminemp", empDetails);
			RequestDispatcher rd = request.getRequestDispatcher("AdminsPage.jsp");
			rd.forward(request, response);
			
			}
			catch(Exception e)
			{
				System.out.println(e);
				e.printStackTrace();
			}
			
			
			
		} //Second if ends
		
		
		else 
		{
			
			System.out.println("you do not have permission to login to Admin portal");
			
			try 
			{
				
			RequestDispatcher rd = request.getRequestDispatcher("EmployeeNopermission.jsp");
			rd.forward(request, response);
			
			}
			catch(Exception e)
			{
				System.out.println(e);
				e.printStackTrace();
			}
		}
		
	
		}// First if ends
		
		
	//2.	
		else 
		{
			System.out.println("invalid credentials");
			
			try 
			{
				
			RequestDispatcher rd = request.getRequestDispatcher("ErrorPage.jsp");
			rd.forward(request, response);
			
			}
			catch(Exception e)
			{
				System.out.println(e);
				e.printStackTrace();
			}
			
		}
	
	} //method ends here
	
	
	
}//class ends here
