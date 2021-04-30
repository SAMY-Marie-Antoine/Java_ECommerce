package fr.doranco.ecommerce.beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;

import fr.doranco.ecommerce.control.ArticleMetier;
import fr.doranco.ecommerce.control.CategorieMetier;
import fr.doranco.ecommerce.control.IArticleMetier;
import fr.doranco.ecommerce.control.ICategorieMetier;
import fr.doranco.ecommerce.entity.Article;
import fr.doranco.ecommerce.entity.Categorie;


@ManagedBean(name="achatBean")
public class AchatBean implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private final ICategorieMetier categorieMetier = new CategorieMetier();
	private final IArticleMetier articleMetier = new ArticleMetier();
	
	@ManagedProperty(name = "messageSuccess", value = "")
	private static String messageSuccess;

	@ManagedProperty(name = "messageError", value = "")
	private static String messageError;
	
	

	static {
		messageSuccess = "";
		messageError = "";
	}
	
	public AchatBean() {
		
	}
	
	public List<Categorie> getCategories() {
		try {
			return categorieMetier.getCategories();
			
		} catch (Exception e) {
			messageError = "Erreur lors de la récupération des catégories !\n" + e.getMessage();
		}
		return new ArrayList<Categorie>();
	}
	
	public List<Article> getArticlesByCategorie(Integer categorieId) {
		try {
			return articleMetier.getArticleByCategorie(categorieId);
			
		} catch (Exception e) {
			messageError = "Erreur lors de la récupération des articles !\n" + e.getMessage();
		}
		return new ArrayList<Article>();
	}
	
	public  String getMessageSuccess() {
		return messageSuccess;
	}

	public  void setMessageSuccess(String messageSuccess) {
		AchatBean.messageSuccess = messageSuccess;
	}

	public  String getMessageError() {
		return messageError;
	}

	public  void setMessageError(String messageError) {
		AchatBean.messageError = messageError;
	}
	

}
