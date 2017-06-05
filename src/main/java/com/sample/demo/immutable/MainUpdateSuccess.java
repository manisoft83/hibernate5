package com.sample.demo.immutable;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.sample.demo.util.HibernateUtil;

public class MainUpdateSuccess {

	public static void main(String[] args) {
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session session = sf.openSession();
		session.beginTransaction();
		ContactNumber c1=new ContactNumber(1,1,"7777777777");
    	session.persist(c1);
    	session.getTransaction().commit();
    	session.refresh(c1);
    	c1.setMobileNumber("8888888888");
    	session.beginTransaction();
       	session.update(c1);
       	session.getTransaction().commit();
		session.close();
	}

}
