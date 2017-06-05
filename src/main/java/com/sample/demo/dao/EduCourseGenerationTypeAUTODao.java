package com.sample.demo.dao;

import java.util.List;

import org.hibernate.Session;

import com.sample.demo.Generatedvalue.entity.EduCourseGenerationTypeAUTO;
import com.sample.demo.Generatedvalue.entity.EmployeeEntity;
import com.sample.demo.util.HibernateUtil;

public class EduCourseGenerationTypeAUTODao {
	public static List<EduCourseGenerationTypeAUTO> read() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		@SuppressWarnings("unchecked")
		List<EduCourseGenerationTypeAUTO> list = session.createQuery("FROM EduCourseGenerationTypeAUTO").list();
		session.close();
		System.out.println("EduCourseGenerationTypeAUTO: Count -> " + list.size() );
		return list;
	}
	public static void deleteEmployee(Integer id) {
		Session session =  HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		EduCourseGenerationTypeAUTO e = findByID(id);
		session.delete(e);
		session.getTransaction().commit();
		session.close();
		System.out.println("Successfully deleted " + e.toString());
	}

	public static EduCourseGenerationTypeAUTO findByID(Integer id) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		EduCourseGenerationTypeAUTO e = (EduCourseGenerationTypeAUTO) session.load(EduCourseGenerationTypeAUTO.class, id);
		session.close();
		return e;
	}

	public static void printEduCourseGenerationTypeAUTO(List<EduCourseGenerationTypeAUTO> aList){
		StringBuilder str=new StringBuilder();
		str.append("\nID-->");
		str.append("	Course Name-->                  ");
		str.append("	Duration-->          ");
		str.append("\n---------------------------------------------------------");
		for(EduCourseGenerationTypeAUTO item:aList){
			str.append("\nID-->"+item.getId());
			str.append("	Course Name-->"+item.getCourseName());
			str.append("	Duration-->"+item.getDuration());
			str.append("\n-----------------------------------------------------------");
		}
		System.out.println(str.toString());
	}
}
