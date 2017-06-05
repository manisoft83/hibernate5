package com.sample.demo.dao;

import java.util.List;

import org.hibernate.Session;

import com.sample.demo.Generatedvalue.entity.EduCourseSequence;
import com.sample.demo.Generatedvalue.entity.EduCourseTable;
import com.sample.demo.util.HibernateUtil;

public class EduCourseTableDao {
	public static List<EduCourseTable> read() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		@SuppressWarnings("unchecked")
		List<EduCourseTable> lists = session.createQuery("FROM EduCourseTable").list();
		session.close();
		System.out.println("EduCourse: Count--> " + lists.size() );
		return lists;
	}
	
	public static void printEduCourse(List<EduCourseTable> list){
		StringBuilder str=new StringBuilder();
		str.append("\nCourseId   ");
		str.append("	Course Name          ");
		str.append("	Duration             ");
		str.append("\n---------------------------");
		for(EduCourseTable aCourse:list){
			str.append("\nCourseId-->"+aCourse.getId());
			str.append("	Course Name-->"+aCourse.getCourseName());
			str.append("	Duration-->"+aCourse.getDuration());
			str.append("\n---------------------------");
		}
		System.out.println(str.toString());
	}
}
