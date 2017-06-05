package com.sample.demo.query.criteria.projection;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Property;
import org.hibernate.criterion.Restrictions;
import org.hibernate.criterion.Subqueries;

import com.sample.demo.util.HibernateUtil;

public class MainSubQuery {

	public static void main(String[] args) {
		String villainName = "villain1";
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session session = sf.openSession();
		Avenger avenger = null;
		
		DetachedCriteria subCrit = DetachedCriteria.forClass ( Avenger.class, "e" );
		subCrit.setProjection ( Projections.distinct ( Projections.id () ) );
		
		//select this_.villain_id as villain_1_27_0_, this_.is_awesome as is_aweso2_27_0_, this_.villain_name as villain_3_27_0_ from Villains this_ 
		//		where this_.villain_id in (select distinct e_.avenger_id as y0_ from Avengers e_) 
		//	order by this_.villain_name desc
		
		session.createCriteria ( Villain.class )
		.add ( Property.forName ( "id" ).in ( subCrit ) )
		.addOrder ( Order.desc ( "villainName" ) )
		.list ();
		
		  /**
		   * Selected a detached criteria so we do not need a session to run it
		   * within.
		   */
		  DetachedCriteria criteria = DetachedCriteria.forClass(Avenger.class);

		  /**
		   * Here we are doing an inner join with the Villain table in order to do
		   * a name comparison with the villainName passed in as a method
		   * parameter
		   */
		  DetachedCriteria villainCriteria = criteria.createCriteria("enemyList");

		  villainCriteria.add(Restrictions.eq("villainName", villainName));

		  villainCriteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);

		  Criteria mainCriteria=session.createCriteria(Villain.class, "villain");
		  mainCriteria.add(Subqueries.propertyNotIn("villain.villaiId", villainCriteria));
		  mainCriteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
		  mainCriteria.addOrder(Order.asc("villain.villainName"));
			
		 // mainCriteria.list();
		
		  session.close();
	}

}
