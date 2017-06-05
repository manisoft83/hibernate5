package com.sample.demo.association.cascade.entity;

import java.util.Date;

import org.hibernate.Session;

import com.sample.demo.util.HibernateUtil;

public class StockPersistMain {

	public static void main(String[] args) {

        System.out.println("Hibernate one to many (Annotation)");
	Session session = HibernateUtil.getSessionFactory().openSession();

	session.beginTransaction();

	StockPersistEntity stock = new StockPersistEntity();
        stock.setStockCode("7052");
        stock.setStockName("PADINI");
       

        StockDailyRecordPersist stockDailyRecordPersists = new StockDailyRecordPersist();
        stockDailyRecordPersists.setPriceOpen(new Float("1.2"));
        stockDailyRecordPersists.setPriceClose(new Float("1.1"));
        stockDailyRecordPersists.setPriceChange(new Float("10.0"));
        stockDailyRecordPersists.setVolume(3000000L);
        stockDailyRecordPersists.setDate(new Date());
        stockDailyRecordPersists.setStockPersist(stock);
        stock.getStockDailyRecordsPersist().add(stockDailyRecordPersists);

       // session.merge(stock); //session.save() doesn't work, use persist method, get one insert for stock and one for stockdailyrecord 
       // session.persist(stockDailyRecordPersists);
        StockDailyRecordPersist stockDailyRecordPersists2 = new StockDailyRecordPersist();
        stockDailyRecordPersists2.setPriceOpen(new Float("1.2"));
        stockDailyRecordPersists2.setPriceClose(new Float("1.1"));
        stockDailyRecordPersists2.setPriceChange(new Float("10.0"));
        stockDailyRecordPersists2.setVolume(3000000L);
        stockDailyRecordPersists2.setDate(new Date());
        stockDailyRecordPersists2.setStockPersist(stock);
       session.persist(stockDailyRecordPersists2);//session.save() doesn't work, use persist method, get one for stockdailyrecord
        
	session.getTransaction().commit();
	System.out.println("Done");

	}

}
