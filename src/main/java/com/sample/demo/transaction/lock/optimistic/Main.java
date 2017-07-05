package com.sample.demo.transaction.lock.optimistic;

import org.hibernate.LockMode;
import org.hibernate.LockOptions;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.sample.demo.util.HibernateUtil;


class FirstThread extends Thread{  
	public void run(){  
		System.out.println("thread is running...");  
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session session = sf.openSession();
		Person i = (Person) session.get(Person.class, 1,LockMode.PESSIMISTIC_WRITE);
		Transaction tx = session.beginTransaction();
		session.lock(i, LockMode.PESSIMISTIC_WRITE);
		//this is just a basic read query from the database 
		i.setLastName("abc_abc");
		int id6 = (int) session.save(i);
		String description = (String)
				session.createQuery("select i.firstName FROM Person i " +
						" where i.id = :itemid")
						.setParameter("itemid", i.getId() )
						.uniqueResult();
		try {
			Thread.sleep(20000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} //10s
		tx.commit();
		session.close();
		System.out.println("Session Closed!!");

	}  

}  
class SecondThread extends Thread{  
	public void run(){  
		System.out.println("thread is running...");  
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session session = sf.openSession();
		Person i = (Person) session.get(Person.class, 1,LockMode.PESSIMISTIC_WRITE);
		Transaction tx = session.beginTransaction();
		//session.lock(i, LockMode.PESSIMISTIC_WRITE);
		//this is just a basic read query from the database 
		i.setLastName("abc_thread2");
		int id6 = (int) session.save(i);
		String description = (String)
				session.createQuery("select i.firstName FROM Person i " +
						" where i.id = :itemid")
						.setParameter("itemid", i.getId() )
						.uniqueResult();
		
		tx.commit();
		session.close();
		System.out.println("Session Closed!!");

	}  

}  
public class Main {



	public static void main(String[] args) throws InterruptedException {
		FirstThread t1=new FirstThread();  
		t1.start();  
		SecondThread t2=new SecondThread();  
		t2.start();  
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session session = sf.openSession();


		Session sessionAnother = sf.openSession();
		Transaction transaction = sessionAnother.beginTransaction();
		try {

			Person _transactionSequence =
					(Person) sessionAnother.get(Person.class, 1, new LockOptions(LockMode.PESSIMISTIC_WRITE));
			_transactionSequence.setLastName(_transactionSequence.getLastName() + 1);
			// newTransactionNumber = _transactionSequence.getLastTransactionNo();
			sessionAnother.save(_transactionSequence);
			sessionAnother.flush();
			transaction.commit();
		} catch(Exception e) {
			throw new RuntimeException("Problem getting next transaction number");
		} finally {
			//session.close();
		}  
	}

}
