package com.sample.demo.association.cascade.remove.entity;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;

import com.sample.demo.dao.StockDailyRecordDao;
import com.sample.demo.dao.StockDao;
import com.sample.demo.util.HibernateUtil;

public class StockRemoveMain {

	public static void main(String[] args) {

        System.out.println("Hibernate one to many (Annotation)");
	Session session = HibernateUtil.getSessionFactory().openSession();
	StockDailyRecordDao.printStockDailyRecord(StockDailyRecordDao.read());
	session.beginTransaction();

	StockRemoveEntity stock = new StockRemoveEntity();
      stock.setStockCode("3004");
        stock.setStockName("abc19");
       session.save(stock);

        StockDailyRecordRemove stockDailyRecords = new StockDailyRecordRemove();
        stockDailyRecords.setPriceOpen(new Float("1.2"));
        stockDailyRecords.setPriceClose(new Float("1.1"));
        stockDailyRecords.setPriceChange(new Float("10.0"));
        stockDailyRecords.setVolume(3000005L);
        stockDailyRecords.setDate(new Date());

        stockDailyRecords.setStockPersist(stock);
        
        StockDailyRecordRemove stockDailyRecords1 = new StockDailyRecordRemove();
        stockDailyRecords1.setPriceOpen(new Float("1.2"));
        stockDailyRecords1.setPriceClose(new Float("1.1"));
        stockDailyRecords1.setPriceChange(new Float("10.0"));
        stockDailyRecords1.setVolume(3000006L);
        stockDailyRecords1.setDate(new Date());

        stockDailyRecords1.setStockPersist(stock);
        
        Set<StockDailyRecordRemove> children = new HashSet<StockDailyRecordRemove>();
        children.add(stockDailyRecords);
        children.add(stockDailyRecords1);
        stock.getStockDailyRecordsRemove().addAll(children);
      //  stock.getStockDailyRecordsRemove().add(stockDailyRecords1);
       // session.save(stockDailyRecords);
        //session.save(stockDailyRecords1);
       session.merge(stock);
	StockDao.printStockPersistEntity(StockDao.read());
	
	
	StockDailyRecordRemove sdr1 = (StockDailyRecordRemove)session.get(StockDailyRecordRemove.class,
            new Integer(3));
	

	/*StockRemoveEntity stockRemove = (StockRemoveEntity)session.get(StockRemoveEntity.class, new Integer(2));
	stockRemove.getStockDailyRecordsRemove().remove(sdr1);*/
//stock.getStockDailyRecordsRemove().remove(sdr2);
	

//session.saveOrUpdate(stockRemove);

//session.merge(stockRemove);
	session.getTransaction().commit();
	System.out.println("Done");
	StockDao.printStockPersistEntity(StockDao.read());
	StockDailyRecordDao.printStockDailyRecord(StockDailyRecordDao.read());
	}

}
