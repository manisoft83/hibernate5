package com.sample.demo.query.criteria;

import java.util.Iterator;
import java.util.List;



import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import com.sample.demo.inheritance.tableperconcrete.Regular_Employee;
import com.sample.demo.util.HibernateUtil;

public class CreateCriteria {
public static void main(String[] args){
	SessionFactory sf = HibernateUtil.getSessionFactory();
	Session session = sf.openSession();
	//select this_.id as id1_16_0_, this_.name as name2_16_0_, ..... from contractemployee_tableperconcrete this_
	Criteria cr = session.createCriteria(Regular_Employee.class);
	
	

	// To get records having salary more than 2000
	//this_.salary>? 
	cr.add(Restrictions.gt("salary", 2000f));

	// To get records having salary less than 2000
	//this_.salary<?
	cr.add(Restrictions.lt("salary", 2000f));

	// To get records having fistName starting with zara
	//this_.name like ?
	cr.add(Restrictions.like("name", "zara%"));

	// Case sensitive form of the above restriction.
	//lower(this_.name) like ?
	cr.add(Restrictions.ilike("name", "zara%"));

	// To get records having salary in between 1000 and 2000
	//this_.salary between ? and ? 
	cr.add(Restrictions.between("salary", 1000f, 2000f));

	// To check if the given property is null
	// this_.salary is null
	//cr.add(Restrictions.isNull("salary"));

	// To check if the given property is not null
	//this_.salary is not null
	cr.add(Restrictions.isNotNull("salary"));

	// To check if the given property is empty
	//cr.add(Restrictions.isEmpty("salary")); //not working

	// To check if the given property is not empty
	//cr.add(Restrictions.isNotEmpty("salary"));	//not working
	
	List results = cr.list();
	session.close();  
	
	session = sf.openSession();
	ProjectionList p1=Projections.projectionList();
    p1.add(Projections.property("name"));
    p1.add(Projections.property("salary"));
    //select 
    //	this_.name as y0_, this_.salary as y1_ 
    // from regularemployee_tableperconcrete this_
    Criteria crit = session.createCriteria(Regular_Employee.class);
crit.setProjection(p1);		

List l=crit.list();

Iterator it=l.iterator();

while(it.hasNext())
{
Object ob[] = (Object[])it.next();
System.out.println(ob[0]+"--------"+ob[1]);
}


	System.out.println("success");  
	
	
	session = sf.openSession();
	Criteria criteria = session.createCriteria(Regular_Employee.class);
	ProjectionList projectionList = Projections.projectionList();
	projectionList.add(Projections.groupProperty("id")); 
	projectionList.add(Projections.count("id"), "count"); //count on id column
	criteria.setProjection(projectionList);
	
	criteria.addOrder(Order.desc(("count"))); //order by
	//select this_.id as y0_, count(this_.id) as y1_ from 
	//	regularemployee_tableperconcrete this_ group by this_.id 
	//	order by y1_ desc
	criteria.list();
	
	
	Criteria crProj = session.createCriteria(Regular_Employee.class);

	// To get total row count.
	//crProj.setProjection(Projections.rowCount()); //count(*) 

	// To get average of a property.
	//crProj.setProjection(Projections.avg("salary")); //avg(this_.salary) 

	// To get distinct count of a property.
	crProj.setProjection(Projections.countDistinct("firstName"));

	// To get maximum of a property.
	//crProj.setProjection(Projections.max("salary"));

	// To get minimum of a property.
	//crProj.setProjection(Projections.min("salary"));

	// To get sum of a property.
	//crProj.setProjection(Projections.sum("salary"));
	
	crProj.list();
}
}
