package com.sample.demo.dao;

import java.util.List;

import org.hibernate.Session;

import com.sample.demo.Generatedvalue.entity.EmployeeEntity;
import com.sample.demo.util.HibernateUtil;

public class EmployeeDao {
	public static List<EmployeeEntity> read() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		@SuppressWarnings("unchecked")
		List<EmployeeEntity> employees = session.createQuery("FROM EmployeeEntity").list();
		session.close();
		System.out.println("Employees: Count--> " + employees.size() );
		return employees;
	}
	public static void deleteEmployee(Integer id) {
		Session session =  HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		EmployeeEntity e = findByID(id);
		session.delete(e);
		session.getTransaction().commit();
		session.close();
		System.out.println("Successfully deleted " + e.toString());
	}

	public static EmployeeEntity findByID(Integer id) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		EmployeeEntity e = (EmployeeEntity) session.load(EmployeeEntity.class, id);
		session.close();
		return e;
	}

	public static void printEmployee(List<EmployeeEntity> employeeList){
		StringBuilder str=new StringBuilder();
		str.append("\nEmployeeId-->");
		str.append("	Email-->                  ");
		str.append("	FirstName-->          ");
		str.append("	LastName-->      ");
		str.append("\n---------------------------");
		for(EmployeeEntity employee:employeeList){
			str.append("\nEmployeeId-->"+employee.getEmployeeId());
			str.append("	Email-->"+employee.getEmail());
			str.append("	FirstName-->"+employee.getFirstName());
			str.append("	LastName-->"+employee.getLastName());
		}
		str.append("\n---------------------------");
		System.out.println(str.toString());
	}
}
