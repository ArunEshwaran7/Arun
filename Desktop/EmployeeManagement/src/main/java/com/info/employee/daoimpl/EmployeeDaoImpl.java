package com.info.employee.daoimpl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.info.employee.pojo.Employee;

public class EmployeeDaoImpl {
	public Boolean save(Employee emp) {
		Configuration con = new Configuration();
		con.configure("hibernate.cfg.xml");
		
		SessionFactory sf=con.buildSessionFactory();
		Session s=sf.openSession();
		
		Transaction tx=s.beginTransaction();
		
		s.save(emp);
		
		tx.commit();
		s.close();
		sf.close();
		return true;

	}

	public List<Employee> viewAllEmployees() {
		Configuration con = new Configuration();
		con.configure("hibernate.cfg.xml");
		
		SessionFactory sf=con.buildSessionFactory();
		Session s=sf.openSession();
		
		Transaction tx=s.beginTransaction();
		String Hql="from Employee";
		org.hibernate.Query query=s.createQuery(Hql);
		List employee=query.list();
		
		tx.commit();
		s.close();
		sf.close();
		return employee;
	}

	public int updatenewvalues(Employee emp) {
		Configuration con = new Configuration();
		con.configure("hibernate.cfg.xml");
		
		SessionFactory sf=con.buildSessionFactory();
		Session s=sf.openSession();
		Transaction tx=s.beginTransaction();
		System.out.println(emp.getId()+" " +emp.getUsername()+" " +emp.getPassword());
		String Hql="update Employee set username=:username,password=:password where id=:id";
		org.hibernate.Query query=s.createQuery(Hql);
		query.setParameter("username", emp.getUsername());
		query.setParameter("password", emp.getPassword());
		query.setParameter("id", emp.getId());
		
		int result=query.executeUpdate();
		System.out.println(result +" Row Updated");
		tx.commit();
		s.close();
		return result;
	}

	public List<Employee> updatebyid(int id) {
		Configuration con = new Configuration();
		con.configure("hibernate.cfg.xml");
		
		SessionFactory sf=con.buildSessionFactory();
		Session s=sf.openSession();
		Transaction tx=s.beginTransaction();
		
		String Hql="from Employee where id=:idsdhgfdk";
		org.hibernate.Query query=s.createQuery(Hql);
		query.setParameter("idsdhgfdk", id);
		
		List<Employee> emp=query.list();
		
		tx.commit();
		s.close();
		return emp;
	}

	public int deletebyid(int id) {
		Configuration con = new Configuration();
		con.configure("hibernate.cfg.xml");
		
		SessionFactory sf=con.buildSessionFactory();
		Session s=sf.openSession();
		Transaction tx=s.beginTransaction();
		
		String Hql="delete from Employee where id=:idsdhgfdk";
		org.hibernate.Query query=s.createQuery(Hql);
		query.setParameter("idsdhgfdk", id);
		
		int result=query.executeUpdate();
		System.out.println(result +" Row Deleted");
		
		
		tx.commit();
		s.close();
		return result;
	}

}
