package fr.doranco.ecommerce.control;

import java.util.ArrayList;
import java.util.List;

import fr.doranco.ecommerce.entity.Article;

import fr.doranco.ecommerce.model.ArticleDao;

import fr.doranco.ecommerce.model.IArticleDao;


public class ArticleMetier implements IArticleMetier {

	public ArticleMetier() {
		
	}
	private final IArticleDao articleDao = new ArticleDao();
	@Override
	public List<Article> getArticleByCategorie(Integer categorieId) throws Exception {
		
		if (categorieId == null)
			throw new NullPointerException("L'id de la cat�gorie � r�cup�rer ne doit pas �tre NULL !");
		
		List<Article> articles= articleDao.getArticleByCategorie(categorieId);
		if (articles!=null)
			return articles;
		
		return new ArrayList<Article>();
	

	}
}
