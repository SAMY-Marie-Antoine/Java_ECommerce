package fr.doranco.ecommerce.control;

import java.util.List;

import fr.doranco.ecommerce.entity.Article;

public interface IArticleMetier {

	List<Article> getArticleByCategorie(Integer categorieId) throws Exception;
}
