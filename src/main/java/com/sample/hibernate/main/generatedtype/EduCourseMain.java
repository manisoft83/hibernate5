package com.sample.hibernate.main.generatedtype;

import org.hibernate.Session;

import com.sample.demo.Generatedvalue.entity.EduCourseIDENTITY;
import com.sample.demo.dao.EduCourseDao;
import com.sample.demo.util.HibernateUtil;

public class EduCourseMain {
	public static void main(String... args) {
		EduCourseDao.printEduCourse(EduCourseDao.read());
		
	Session session =  HibernateUtil.getSessionFactory().openSession();
	session.beginTransaction();

	EduCourseIDENTITY course = new EduCourseIDENTITY();
	course.setCourseName("B.Sc");
	course.setDuration(3);
	session.save(course);
	
	session.getTransaction().commit();
	session.close();
	System.out.println("\nAfter New Course--->");
	EduCourseDao.printEduCourse(EduCourseDao.read());
	}
}
