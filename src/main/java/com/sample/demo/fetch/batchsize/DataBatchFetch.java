package com.sample.demo.fetch.batchsize;

import java.util.List;

import org.hibernate.Session;

import com.sample.demo.util.HibernateUtil;

public class DataBatchFetch {
	 public static void main(String[] args) {
		  Session session = HibernateUtil.getSessionFactory().openSession();
	      
	         
		  List<Person> l = session.createQuery(" FROM com.sample.demo.fetch.batchsize.Person p ").list();
	         
	        System.out.println("Retrieving Data");
	        System.out.println("Data retrieved: " + l.size());
	        for (Object object : l) {
	            Person p = (Person) object;
	            System.out.println(p);
	            System.out.println("Address retrieval initiated.");
	            List<Address> addresses = p.getAddresses();
	            System.out.println("Address retrieval complete.");
	            int i=1;
	            for (Address address : addresses) {
	                System.out.println("#### individual address: " + i);
	                System.out.println(address);
	                System.out.println("#### Address complete");
	                i++;
	            }
	        }
	 
	    }
}
