package com.raghav.employeeManage;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class UserVerifyclass 
{

	
	public Employee getVerifyDetails(int userid)
	{
		
		
		Configuration cfg=new Configuration().configure("Myhibernate.cfg.xml").addAnnotatedClass(Employee.class);
		SessionFactory sf=cfg.buildSessionFactory();
		Session hibSession=sf.openSession();// got the connection object in the session object  //
		
		Transaction tx = hibSession.beginTransaction();
		//Employee emp=hibSession.get(Employee.class, userid);
		
		Query hquery = hibSession.createQuery("from Employee e where e.userid=:b");
		
		
		hquery.setParameter("b", userid);
		
		// positional parameter works// 
		
		Employee emp = (Employee)hquery.uniqueResult();
		tx.commit();
		
		System.out.println(emp);
		
		return emp;
		
		
		
		
	}
	
	
	
	
}
