package com.raghav.employeeManage;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;



public class AdminDaoImpl implements Admindao
{

	// 1 Get Employee
	public Employee getEmployee(int userid)

	{

		String hquery = "from Employee where userid=:p";
		Configuration cfg = new Configuration().configure("Myhibernate.cfg.xml").addAnnotatedClass(Employee.class);
		SessionFactory sf = cfg.buildSessionFactory();
		Session hibernate_session = sf.openSession();

		Transaction tx = hibernate_session.beginTransaction();

		Employee employeeDetails = (Employee) hibernate_session.createQuery(hquery).setParameter("p", userid)
				.uniqueResult();

		tx.commit();

		hibernate_session.close();

		return employeeDetails;

	}

	// 2. get all employees list

	public List<Employee> getAllEmployee() {
		String hquery = "from Employee";
		Configuration cfg = new Configuration().configure("Myhibernate.cfg.xml").addAnnotatedClass(Employee.class);
		SessionFactory sf = cfg.buildSessionFactory();
		Session hibernate_session = sf.openSession();
		Transaction tx = hibernate_session.beginTransaction();

		List<Employee> listofemployee = (List<Employee>) hibernate_session.createQuery(hquery).list();

		tx.commit();
		hibernate_session.close();

		return listofemployee;

	}

	// 3. insert employee

	public int insertemployee(Employee emp) {
		int updatedrecord = 0;
		Transaction tx = null;
		try {
			// String hquery="from EmployeeTableClass";
			Configuration cfg = new Configuration().configure("Myhibernate.cfg.xml").addAnnotatedClass(Employee.class);
			SessionFactory sf = cfg.buildSessionFactory();
			Session hibernate_session = sf.openSession();

			tx = hibernate_session.beginTransaction();

			SQLQuery squery = hibernate_session.createNativeQuery("insert into employee values(:a,:b,:c,:d)");
			squery.setParameter("a", emp.getUsername());
			squery.setParameter("b", emp.getPassword());
			squery.setParameter("c", emp.getType());
			squery.setParameter("d", emp.getUserid());
			updatedrecord = squery.executeUpdate();

			// System.out.println(rowinserted);
			// note// Insert query with hql doesnt work // we need to create a new table//
			// write and from there we can put objects into the this table//
			// we cannot also use dual table // given by SYS//

			// we have to use// either save()//insert and select with HQL// or native SQL
			// query
			tx.commit();

			hibernate_session.close();
			sf.close();

		} catch (Exception e) {
//				if(tx!=null) 
//				{
//					tx.rollback();//   just reverse/undo  all the transaction happened 
//				}
			e.printStackTrace();
		}

		return updatedrecord;

	}
//		

	// 4 .update employee

	public int updateemployee(Employee emp) {

		int executeUpdate = 0;

		try {
			Configuration cfg = new Configuration().configure("Myhibernate.cfg.xml").addAnnotatedClass(Employee.class);
			SessionFactory sf = cfg.buildSessionFactory();
			Session hibernate_session = sf.openSession();
			hibernate_session.beginTransaction();
			Query hquery = hibernate_session
					.createQuery("update Employee set username=:a,password=:b,type=:c where userid=:d");
			hquery.setParameter("a", emp.getUsername());
			hquery.setParameter("b", emp.getPassword());
			hquery.setParameter("c", emp.getType());
			hquery.setParameter("d", emp.getUserid());

			executeUpdate = hquery.executeUpdate();

			// System.out.println(executeUpdate);
//			hibernate_session.flush();
//			hibernate_session.clear();

			hibernate_session.getTransaction().commit();
			System.out.println(executeUpdate);
			// hibernate_session.clear();

			// hibernate_session.close();
			// sf.close();

		}

		catch (Exception e)

		{

			e.printStackTrace();

		}

		return executeUpdate;
	}
//		
//		// 5.delete employee
//		

	public int deleteemployee(int userid) {

		int deletedrow = 0;
		try {
			Configuration cfg = new Configuration().configure("Myhibernate.cfg.xml").addAnnotatedClass(Employee.class);
			SessionFactory sf = cfg.buildSessionFactory();
			Session hibernate_session = sf.openSession();
			hibernate_session.beginTransaction();

			Query hquery = hibernate_session.createQuery("delete from Employee where userid=:a");
			hquery.setParameter("a", userid);
			deletedrow = hquery.executeUpdate();
			System.out.println(deletedrow);

			// hibernate_session.flush();
			// hibernate_session.clear();

			hibernate_session.getTransaction().commit();

			System.out.println(deletedrow);
			hibernate_session.close();
			sf.close();

		}

		catch (Exception e) {
//				if(tx!=null) 
//				{
//			
//					tx.rollback();
//				}
			e.printStackTrace();
		}

		return deletedrow;

	}
//		

}
