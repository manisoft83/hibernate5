package com.sample.hibernate.main.generatedtype;

import org.hibernate.Session;

import com.sample.demo.Generatedvalue.entity.EduCourseTable;
import com.sample.demo.dao.EduCourseTableDao;
import com.sample.demo.util.HibernateUtil;

public class EduCourseTableMain {
	public static void main(String... args) {
		EduCourseTableDao.printEduCourse(EduCourseTableDao.read());
		
	Session session =  HibernateUtil.getSessionFactory().openSession();
	session.beginTransaction();

	EduCourseTable course = new EduCourseTable();
	course.setCourseName("B.Sc");
	course.setDuration(3);
	session.save(course);
	
	session.getTransaction().commit();
	session.close();
	System.out.println("\nAfter New Course--->");
	EduCourseTableDao.printEduCourse(EduCourseTableDao.read());
	}
}
