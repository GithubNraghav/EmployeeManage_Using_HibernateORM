package com.raghav.employeeManage;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class UserVerifyDao 
{

	// get the userdetails // here 
	
	
	
	// should get he hibernate Session here 
	// the data from table here // verify in the servlet//
	// I just need one table//Entity// to getthe details from database and verify and 
	//again use the same entity to fetch data and save data .
	
	// that entity /table already exists in database// employee
	
	public Employee getVerifyDetails(int userid)
	{
		
		
		Configuration cfg=new Configuration().configure("Myhibernate.cfg.xml").addAnnotatedClass(Employee.class);
		SessionFactory sf=cfg.buildSessionFactory();
		Session hibSession=sf.openSession();// got the connection object in the session object  //
		
		Transaction tx = hibSession.beginTransaction();
		Employee emp=hibSession.get(Employee.class, userid);
		
		tx.commit();
		
		System.out.println(emp);
		
		return emp;
		
		
		
		
	}
	
	
	
	
}
