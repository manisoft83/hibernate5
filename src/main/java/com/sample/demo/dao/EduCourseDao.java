package com.sample.demo.dao;

import java.util.List;

import org.hibernate.Session;

import com.sample.demo.Generatedvalue.entity.EduCourseIDENTITY;
import com.sample.demo.util.HibernateUtil;

public class EduCourseDao {
	public static List<EduCourseIDENTITY> read() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		@SuppressWarnings("unchecked")
		List<EduCourseIDENTITY> lists = session.createQuery("FROM EduCourseIDENTITY").list();
		session.close();
		System.out.println("EduCourse: Count--> " + lists.size() );
		return lists;
	}
	
	public static void printEduCourse(List<EduCourseIDENTITY> list){
		StringBuilder str=new StringBuilder();
		str.append("\nCourseId-->");
		str.append("	Course Name-->       ");
		str.append("	Duration-->          ");
		str.append("\n---------------------------");
		for(EduCourseIDENTITY aCourse:list){
			str.append("\nCourseId-->"+aCourse.getId());
			str.append("	Course Name-->"+aCourse.getCourseName());
			str.append("	Duration-->"+aCourse.getDuration());
			str.append("\n---------------------------");
		}
		System.out.println(str.toString());
	}
}
