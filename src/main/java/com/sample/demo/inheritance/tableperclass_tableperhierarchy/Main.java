package com.sample.demo.inheritance.tableperclass_tableperhierarchy;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.sample.demo.dao.PersonDao;
import com.sample.demo.util.HibernateUtil;

public class Main {
	public static void main(String[] args) {
		PersonDao.printEduCourse(PersonDao.read());
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session session = sf.openSession();
		session.beginTransaction();

		
		Person person = new Person("Stev1e", "Balmer1");
		session.save(person);

		Employee employee = new Employee("James1", "Gosling1", "Marketing", new Date());
		session.save(employee);
		
		session.getTransaction().commit();
		session.close();
		PersonDao.printEduCourse(PersonDao.read());
	}
}
