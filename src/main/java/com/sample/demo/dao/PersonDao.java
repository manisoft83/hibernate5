package com.sample.demo.dao;

import java.util.List;

import org.hibernate.Session;

import com.sample.demo.inheritance.tableperclass_tableperhierarchy.Employee;
import com.sample.demo.inheritance.tableperclass_tableperhierarchy.Person;
import com.sample.demo.util.HibernateUtil;

public class PersonDao {
	public static List<Employee> read() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		@SuppressWarnings("unchecked")
		List<Employee> lists = session.createQuery("FROM Employee").list();
		session.close();
		System.out.println("Employee: Count--> " + lists.size() );
		return lists;
	}
	
	public static void printEduCourse(List<Employee> list){
		StringBuilder str=new StringBuilder();
		str.append("\nPersonId-->");
		str.append("	First Name-->       ");
		str.append("	Last Name-->          ");
		str.append("	Dep Name-->          ");
		str.append("\n---------------------------");
		for(Employee aCourse:list){
			str.append("\nPersonId-->"+aCourse.getPersonId());
			str.append("	First Name-->"+aCourse.getFirstname());
			str.append("	Last Name-->"+aCourse.getLastname());
			str.append("	Dep Name-->"+aCourse.getDepartmentName());
		/*	str.append("	Dep Name-->"+aCourse.getDiscriminator());*/
			str.append("\n---------------------------");
		}
		System.out.println(str.toString());
	}
}
