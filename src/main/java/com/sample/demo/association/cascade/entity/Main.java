package com.sample.demo.association.cascade.entity;

import org.hibernate.Session;

import com.sample.demo.util.HibernateUtil;

public class Main {
	 public static void main(String[] a) throws Exception {
		 createProfessorAndAddress(1, "name", 1, "street", "city", "state");

	 }
	  public static Professor createProfessorAndAddress(int id, String name, int addrId, String street,
		      String city, String state) {
		  Session session = HibernateUtil.getSessionFactory().openSession();

			session.beginTransaction();
			
		    Professor emp = new Professor();
		    emp.setId(id);
		    emp.setName(name);
		    Address addr = new Address();
		    addr.setId(addrId);
		    addr.setStreet(street);
		    addr.setCity(city);
		    addr.setState(state);
		    emp.setAddress(addr);
		    session.persist(emp);
		    session.getTransaction().commit();
		    

		    return emp;
		  }
}
