package fr.doranco.ecommerce.model;

import java.util.List;

import fr.doranco.ecommerce.entity.Article;



public interface IArticleDao extends IEntityDao<Article>{
	
	List<Article> getArticleByCategorie(Integer categorieId) throws Exception;
	List<Article> getArticles() throws Exception;
}
