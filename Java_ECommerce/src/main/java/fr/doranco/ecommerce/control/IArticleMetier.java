package fr.doranco.ecommerce.control;

import java.util.List;

import fr.doranco.ecommerce.entity.Article;
import fr.doranco.ecommerce.entity.dto.ArticleDto;

public interface IArticleMetier {

	List<Article> getArticleByCategorie(Integer categorieId) throws Exception;
	
	Article AddArticle(ArticleDto articleDto)throws Exception;
}
