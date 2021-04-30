package fr.doranco.ecommerce.model;

import java.util.List;


import org.hibernate.Session;
import org.hibernate.query.Query;

import fr.doranco.ecommerce.entity.Article;
import fr.doranco.ecommerce.entity.Categorie;

public class ArticleDao extends AbstractEntityDao<Article> implements IArticleDao {

	public ArticleDao() {
	}

	
	@Override
	public List<Article> getArticleByCategorie(Integer categorieId) throws Exception {
		
		Session session = HibernateConnector.getSession();
		//Query<Article> query = session.createNamedQuery("Article.findByCategorie", Article.class); 
		Query<Article> query = session.createQuery("FROM Article u", Article.class);
		query.setParameter("categorie_id", categorieId);
	
		List<Article> articles = query.list();	
		if (session != null && session.isOpen())
			session.close();
		return articles;
		
	}


	@Override
	public List<Article> getArticles() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
