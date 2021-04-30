package fr.doranco.ecommerce.model;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateConnector {
	
	private static HibernateConnector instance;
	private static SessionFactory sessionFactory;
	private static Session session;
	
	
	private HibernateConnector() throws HibernateException  {
		if (sessionFactory == null)
			sessionFactory = new Configuration().configure().buildSessionFactory();
		if (session == null || !session.isOpen())
			session = sessionFactory.openSession();
	}
	
	public static Session getSession() throws HibernateException {
		if (instance == null)
			instance = new HibernateConnector();
		if (!session.isOpen())
			session = sessionFactory.openSession();
		
		return session;
	}
	
	public static void shutdown() throws HibernateException {
		if (session != null && session.isOpen())
			session.close();
		if (sessionFactory != null && sessionFactory.isOpen())
			sessionFactory.close();
	}

}
