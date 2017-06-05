package com.sample.demo.dao;

import java.util.List;

import org.hibernate.Session;

import com.sample.demo.Generatedvalue.entity.EduCourseIDENTITY;
import com.sample.demo.association.cascade.entity.StockPersistEntity;
import com.sample.demo.association.entity.StockDailyRecord;
import com.sample.demo.util.HibernateUtil;

public class StockDailyRecordDao {
	public static List<StockDailyRecord> read() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		@SuppressWarnings("unchecked")
		List<StockDailyRecord> lists = session.createQuery("FROM StockDailyRecord").list();
		session.close();
		System.out.println("StockPersistEntity: Count--> " + lists.size() );
		return lists;
	}
	
	public static void printStockDailyRecord(List<StockDailyRecord> list){
		StringBuilder str=new StringBuilder();
		str.append("\nId-->    ");
		str.append("	Volume-->       ");
		str.append("	Date-->          ");
		str.append("\n---------------------------");
		for(StockDailyRecord aEntity:list){
			str.append("\nId-->"+aEntity.getRecordId());
			str.append("    ParentId-->"+aEntity.getStock().getStockId());
			str.append("	Volume-->"+aEntity.getVolume());
			str.append("	Date-->"+aEntity.getDate());
		}
		str.append("\n---------------------------");
		System.out.println(str.toString());
	}
}
