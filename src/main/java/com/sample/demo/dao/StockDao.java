package com.sample.demo.dao;

import java.util.List;

import org.hibernate.Session;

import com.sample.demo.Generatedvalue.entity.EduCourseIDENTITY;
import com.sample.demo.association.cascade.entity.StockPersistEntity;
import com.sample.demo.util.HibernateUtil;

public class StockDao {
	public static List<StockPersistEntity> read() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		@SuppressWarnings("unchecked")
		List<StockPersistEntity> lists = session.createQuery("FROM StockPersistEntity").list();
		session.close();
		System.out.println("StockPersistEntity: Count--> " + lists.size() );
		return lists;
	}
	
	public static void printStockPersistEntity(List<StockPersistEntity> list){
		StringBuilder str=new StringBuilder();
		str.append("\nId-->    ");
		str.append("	stockCode-->       ");
		str.append("	stockName-->          ");
		str.append("\n---------------------------");
		for(StockPersistEntity aEntity:list){
			str.append("\nId-->"+aEntity.getStockId());
			str.append("	stockCode-->"+aEntity.getStockCode());
			str.append("	stockName-->"+aEntity.getStockName());
		}
		str.append("\n---------------------------");
		System.out.println(str.toString());
	}
}
