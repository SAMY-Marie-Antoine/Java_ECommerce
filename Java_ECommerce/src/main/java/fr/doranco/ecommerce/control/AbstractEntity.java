package fr.doranco.ecommerce.control;

import org.hibernate.Session;
import org.hibernate.Transaction;

import fr.doranco.ecommerce.model.HibernateConnector;

public abstract class AbstractEntity<T> implements IEntity<T> {

	public AbstractEntity() {
	}

	@Override
	public void add(T entity) throws Exception {
		
		Transaction tx = null;
		Session session = null;
		try {
			session = HibernateConnector.getSession();
			tx = session.beginTransaction();
			session.save(entity);
			tx.commit();
		} catch (Exception ex) {
			if (tx != null)
				tx.rollback();
			ex.printStackTrace();
		} finally {
			if (session != null && session.isOpen())
				session.close();
		}
	}

	@Override
	public T get(Class<T> entity, Integer id) throws Exception {
		
		Session session = HibernateConnector.getSession();
		T entityT = session.get((Class<T>) entity, id);
		if (session != null && session.isOpen())
			session.close();
		return entityT;
	}

	@Override
	public void update(T entity) throws Exception {
		
		Transaction tx = null;
		Session session = null;
		try {
			session = HibernateConnector.getSession();
			tx = session.beginTransaction();
			session.update(entity);
			tx.commit();
		} catch (Exception ex) {
			if (tx != null)
				tx.rollback();
			ex.printStackTrace();
		} finally {
			if (session != null && session.isOpen())
				session.close();
		}
	}

	@Override
	public void remove(T entity) throws Exception {
	
		Transaction tx = null;
		Session session = null;
		try {
			session = HibernateConnector.getSession();
			tx = session.beginTransaction();
			session.remove(entity);
			tx.commit();
		} catch (Exception ex) {
			if (tx != null)
				tx.rollback();
			ex.printStackTrace();
		} finally {
			if (session != null && session.isOpen())
				session.close();
		}

	}
}
