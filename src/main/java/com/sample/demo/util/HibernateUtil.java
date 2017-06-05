package com.sample.demo.util;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
 
public class HibernateUtil
{
   private static SessionFactory sessionFactory = buildSessionFactory();
 
   private static SessionFactory buildSessionFactory()
   {
      try
      {
         if (sessionFactory == null)
         {
            Configuration configuration = new Configuration().configure(HibernateUtil.class.getResource("/hibernate.cfg.xml"));
            configuration.addAnnotatedClass(com.sample.demo.Generatedvalue.entity.EmployeeEntity.class);
            configuration.addAnnotatedClass(com.sample.demo.Generatedvalue.entity.EduCourseGenerationTypeAUTO.class);
            configuration.addAnnotatedClass(com.sample.demo.Generatedvalue.entity.EduCourseIDENTITY.class);
            configuration.addAnnotatedClass(com.sample.demo.Generatedvalue.entity.EduCourseSequence.class);
            configuration.addAnnotatedClass(com.sample.demo.Generatedvalue.entity.EduCourseTable.class);
            configuration.addAnnotatedClass(com.sample.demo.Generatedvalue.entity.EduCourseTable.class);
            configuration.addAnnotatedClass(com.sample.demo.association.entity.StockEntity.class);
            configuration.addAnnotatedClass(com.sample.demo.association.entity.StockDailyRecord.class);
            configuration.addAnnotatedClass(com.sample.demo.association.cascade.entity.StockDailyRecordPersist.class);
            configuration.addAnnotatedClass(com.sample.demo.association.cascade.entity.StockPersistEntity.class);
            configuration.addAnnotatedClass(com.sample.demo.association.cascade.entity.Address.class);
            configuration.addAnnotatedClass(com.sample.demo.association.cascade.entity.Professor.class);
            configuration.addAnnotatedClass(com.sample.demo.association.cascade.remove.entity.StockRemoveEntity.class);
            configuration.addAnnotatedClass(com.sample.demo.association.cascade.remove.entity.StockDailyRecordRemove.class);
            configuration.addAnnotatedClass(com.sample.demo.association.cascade.entity.EmployeeEntity.class);
            configuration.addAnnotatedClass(com.sample.demo.association.cascade.entity.AccountEntity.class);
            configuration.addAnnotatedClass(com.sample.demo.inheritance.tableperclass_tableperhierarchy.Employee.class);
            configuration.addAnnotatedClass(com.sample.demo.inheritance.tableperclass_tableperhierarchy.Person.class);
            configuration.addAnnotatedClass(com.sample.demo.association.jointable.Article.class);
            configuration.addAnnotatedClass(com.sample.demo.association.jointable.Category.class);
            configuration.addAnnotatedClass(com.sample.demo.immutable.ContactNumber.class);
            configuration.addAnnotatedClass( com.sample.demo.inheritance.tableperhierarchy.Employee.class);
            configuration.addAnnotatedClass( com.sample.demo.inheritance.tableperhierarchy.Regular_Employee.class);
            configuration.addAnnotatedClass( com.sample.demo.inheritance.tableperhierarchy.Contract_Employee.class);
            configuration.addAnnotatedClass( com.sample.demo.inheritance.tableperconcrete.Employee.class);
            configuration.addAnnotatedClass( com.sample.demo.inheritance.tableperconcrete.Regular_Employee.class);
            configuration.addAnnotatedClass( com.sample.demo.inheritance.tableperconcrete.Contract_Employee.class);
            configuration.addAnnotatedClass(com.sample.demo.inheritance.tablepersubclass.Employee.class);
            configuration.addAnnotatedClass(com.sample.demo.inheritance.tablepersubclass.Regular_Employee.class);
            configuration.addAnnotatedClass(com.sample.demo.inheritance.tablepersubclass.Contract_Employee.class);
            
            configuration.addAnnotatedClass( com.sample.demo.fetch.join.Person.class);
            configuration.addAnnotatedClass( com.sample.demo.fetch.join.Address.class);
            
            configuration.addAnnotatedClass( com.sample.demo.fetch.batchsize.Person.class);
            configuration.addAnnotatedClass(com.sample.demo.fetch.batchsize.Address.class);
            
            configuration.addAnnotatedClass(com.sample.demo.fetch.select.Address.class);
            configuration.addAnnotatedClass(com.sample.demo.fetch.select.Person.class);
            
            configuration.addAnnotatedClass(com.sample.demo.fetch.subselect.Address.class);
            configuration.addAnnotatedClass(com.sample.demo.fetch.subselect.Person.class);
            
            configuration.addAnnotatedClass(com.sample.demo.query.criteria.projection.Avenger.class);
            configuration.addAnnotatedClass(com.sample.demo.query.criteria.projection.Villain.class);
            
            StandardServiceRegistryBuilder serviceRegistryBuilder = new StandardServiceRegistryBuilder();
            serviceRegistryBuilder.applySettings(configuration.getProperties());
            ServiceRegistry serviceRegistry = serviceRegistryBuilder.build();
            sessionFactory = configuration.buildSessionFactory(serviceRegistry);
         }
         return sessionFactory;
      } catch (Throwable ex)
      {
         System.err.println("Initial SessionFactory creation failed." + ex);
         throw new ExceptionInInitializerError(ex);
      }
   }
 
   public static SessionFactory getSessionFactory()
   {
      return sessionFactory;
   }
 
   public static void shutdown()
   {
      getSessionFactory().close();
   }
}
