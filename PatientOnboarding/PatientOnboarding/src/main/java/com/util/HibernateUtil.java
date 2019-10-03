//package com.util;
//
//import org.hibernate.Session;
//import org.hibernate.SessionFactory;
//import org.hibernate.cfg.Configuration;

/*Hibernate's important objects and interfaces
 * 
 * Configuration (class)
 * 	Configuration's job is to gather information from the hibernate.cfg.xml and
 * 	use that information to create a session factory.
 * 
 * SessionFactory (interface)
 * 	SessionFactory's job is to create sessions and store information on how to
 * 	make connections to your database. Once it's configured it's immutable.
 * 
 * Session (interface)
 * 	Session manages the connection to your database and provides
 * 	create, read, update, and delete operations.
 * 
 * Transaction (interface)
 * 	Transaction manages....well...your transactions (and cache). Must be ACID.
 * 
 * What is ACID?
 * Atomicity- transactions are "all or nothing". YOu cannot have PART of a transaction happen
 * Consistent- after a transaction the database schema will be intact, and correctly model
 * 		the actual state of the models.
 * Isolation- transactions cannot interfere with one another
 * Durability- data will persist through issues (like power loss)
 * 
 */
//public class HibernateUtil {
//	
//	private static Session ses;
//	private static Configuration conf=
//			new Configuration().configure("hibernate.cfg.xml");
//
//	static {
//		conf.setProperty("hibernate.connection.username", System.getenv("DBUSE"));
//		conf.setProperty("hibernate.connection.password", System.getenv("DBPASS"));
//		conf.setProperty("hibernate.connection.url", System.getenv("DBURL"));
//	}
//	
//	private static SessionFactory sf= conf.buildSessionFactory();
//	
//	public static Session getSession() {
//		
//		if(ses==null)
//			ses= sf.openSession();
//		return ses;
//	}
//	
//	public static void closeSes() {
//		ses.close();
//		sf.close();
//	}
//
//}
