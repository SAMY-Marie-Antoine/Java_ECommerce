package fr.doranco.ecommerce.model;


import java.util.List;


import org.hibernate.Session;
import org.hibernate.query.Query;

import fr.doranco.ecommerce.entity.Categorie;

public class CategorieDao extends AbstractEntityDao<Categorie> implements ICategorieDao{

	public CategorieDao() {
		
	}
	
	@Override
	public List<Categorie> getCategories() throws Exception {
		Session session = HibernateConnector.getSession();
		
	//	Query<Categorie> query = session.createNamedQuery("Categorie.findAll", Categorie.class);
		Query<Categorie> query = session.createQuery("FROM Categorie u", Categorie.class);
		
		List<Categorie> categories = query.list();
		if (session != null && session.isOpen())
			session.close();
		return categories;

		
	}

}
