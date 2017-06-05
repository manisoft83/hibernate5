package com.sample.hibernate.main.generatedtype;

import org.hibernate.Session;

import com.sample.demo.Generatedvalue.entity.EduCourseSequence;
import com.sample.demo.dao.EduCourseSequenceDao;
import com.sample.demo.util.HibernateUtil;

public class EduCourseSeqMain {
	public static void main(String... args) {
		EduCourseSequenceDao.printEduCourse(EduCourseSequenceDao.read());
		
	Session session =  HibernateUtil.getSessionFactory().openSession();
	session.beginTransaction();

	EduCourseSequence course = new EduCourseSequence();
	course.setCourseName("B.Sc");
	course.setDuration(3);
	session.save(course);
	
	session.getTransaction().commit();
	session.close();
	System.out.println("\nAfter New Course--->");
	EduCourseSequenceDao.printEduCourse(EduCourseSequenceDao.read());
	}
}
