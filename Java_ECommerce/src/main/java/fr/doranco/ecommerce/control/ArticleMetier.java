package fr.doranco.ecommerce.control;

import java.util.ArrayList;
import java.util.List;

import fr.doranco.ecommerce.entity.Article;
import fr.doranco.ecommerce.entity.Categorie;
import fr.doranco.ecommerce.entity.dto.ArticleDto;
import fr.doranco.ecommerce.model.ArticleDao;

import fr.doranco.ecommerce.model.IArticleDao;


public class ArticleMetier implements IArticleMetier {

	private final IArticleDao articleDao = new ArticleDao();
	private final Categorie categorie = new Categorie();
	
	public ArticleMetier() {
		
	}
	
	@Override
	public Article AddArticle(ArticleDto articleDto) throws Exception {
		
		
		Article article =new Article();
		article.setNom(articleDto.getNom());
        article.setDescription(articleDto.getDescription());	
        article.setPrix(new Integer (articleDto.getPrix()));
        article.setRemise(new Float (articleDto.getRemise()));
        article.setStock(new Integer(articleDto.getStock()));
       // article.setCategorieId(categorie.getId().articleDto.getCategorieId()));
        
        articleDao.add(article);
        
       
      
        
		
		return null;
	}
	
	
	@Override
	public List<Article> getArticleByCategorie(Integer categorieId) throws Exception {
		
		if (categorieId == null)
			throw new NullPointerException("L'id de la catégorie à récupérer ne doit pas être NULL !");
		
		List<Article> articles= articleDao.getArticleByCategorie(categorieId);
		if (articles!=null)
			return articles;
		
		return new ArrayList<Article>();
	

	}
	
}
