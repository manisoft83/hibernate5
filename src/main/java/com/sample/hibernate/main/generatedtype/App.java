package com.sample.hibernate.main.generatedtype;

import java.util.Date;

import org.hibernate.Session;

import com.sample.demo.Generatedvalue.entity.EduCourseGenerationTypeAUTO;
import com.sample.demo.Generatedvalue.entity.EmployeeEntity;
import com.sample.demo.dao.EduCourseGenerationTypeAUTODao;
import com.sample.demo.dao.EmployeeDao;
import com.sample.demo.util.HibernateUtil;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        Session session = HibernateUtil.getSessionFactory().openSession();
        try{
        	EmployeeDao.printEmployee(EmployeeDao.read());
        	//EmployeeDao.deleteEmployee(2);
        	//EmployeeDao.deleteEmployee(3);
        	session.beginTransaction();
            // Add new Employee object
            EmployeeEntity emp = new EmployeeEntity();
            emp.setEmployeeId(4);
            emp.setEmail("demo-user6@mail.com");
            emp.setFirstName("demo1");
            emp.setLastName("user1");
            session.save(emp);
            
            EmployeeDao.printEmployee(EmployeeDao.read());
            EduCourseGenerationTypeAUTO course = new EduCourseGenerationTypeAUTO();
    		course.setCourseName("B.Sc");
    		course.setDuration(3);
    		session.save(course);
    		
    		
            session.getTransaction().commit();
            System.out.println("Committed Successfully");
            EmployeeDao.printEmployee(EmployeeDao.read());
           EduCourseGenerationTypeAUTODao.printEduCourseGenerationTypeAUTO(EduCourseGenerationTypeAUTODao.read());
        }
        catch(Exception ex){
        	ex.printStackTrace();
        	 session.getTransaction().rollback();
        	 
        }
        finally{
        HibernateUtil.shutdown();
        }
    
    Date itv1=new Date(1479880800000L);
    Date itv2=new Date(1479708000000L);
    
    System.out.println(itv1);
    System.out.println(itv2);
    }
}
