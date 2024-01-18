package com.raghav.employeeManage;

import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/Adminservlet")
public class AdminServlet extends HttpServlet {

	public void doPost(HttpServletRequest request, HttpServletResponse response) {

		// System.out.println("inside admin servelt");

		Admindao adao = new AdminDaoImpl();
		String button = request.getParameter("button");

		// buttons string will be its value

		// 1.
		if (button.equals("fetch")) {
			try {
				int userid = Integer.parseInt(request.getParameter("userid"));
				Employee employee = adao.getEmployee(userid);
				RequestDispatcher rd = request.getRequestDispatcher("displayemp.jsp");
				request.setAttribute("emp", employee);

				rd.forward(request, response);

			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		// 2
		else if (button.equals("inseretEmp")) {

			String uname = request.getParameter("uname");
			String upass = request.getParameter("upass");
			String utype = request.getParameter("utype");
			int uId = Integer.parseInt(request.getParameter("uId"));

			Employee emp = new Employee();
			emp.setUsername(uname);
			emp.setPassword(upass);
			emp.setType(utype);
			emp.setUserid(uId);
			try {

				int insertemployee = adao.insertemployee(emp);

				request.setAttribute("noofRowinsetred", insertemployee);
				RequestDispatcher rd = request.getRequestDispatcher("dispalyinsertedemp.jsp");
				rd.forward(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		// 3
		else if (button.equals("updateEmp")) {
			String uname = request.getParameter("uname");
			String upass = request.getParameter("upass");
			String utype = request.getParameter("utype");
			int uId = Integer.parseInt(request.getParameter("uId"));

			Employee emp = new Employee();
			emp.setUsername(uname);
			emp.setPassword(upass);
			emp.setType(utype);
			emp.setUserid(uId);

			try {
				int updateemployee = adao.updateemployee(emp);

				request.setAttribute("noofempupdated", updateemployee);

				RequestDispatcher rd = request.getRequestDispatcher("displayupdatedpage.jsp");
				rd.forward(request, response);

			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		// 4

		else if (button.equals("deleteEmp")) {
			int userid = Integer.parseInt(request.getParameter("uId"));

			try {
				int deleteemployee = adao.deleteemployee(userid);

				request.setAttribute("noofempDeleted", deleteemployee);
				RequestDispatcher rd = request.getRequestDispatcher("displayDeletedrecords.jsp");
				rd.forward(request, response);
			} catch (Exception e) {

				e.printStackTrace();

			}

		}
		
		// 5
		else if (button.equals("fetchAll")) {
			try {

				List<Employee> allEmployee = adao.getAllEmployee();
				request.setAttribute("allemp", allEmployee);

				RequestDispatcher rd = request.getRequestDispatcher("displayAllemp.jsp");
				rd.forward(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		else {
			System.out.println("Please select the proper operation!! invalid opration");
		}

	}

}
