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
import fr.doranco.ecommerce.entity.Categorie;
import fr.doranco.ecommerce.entity.dto.ArticleDto;

@ManagedBean(name = "articleBean")
public class ArticleBean implements Serializable{
	
	private final ICategorieMetier categorieMetier = new CategorieMetier();
	private final IArticleMetier articleMetier = new ArticleMetier();
	
	private static final long serialVersionUID = 1L;
	

	@ManagedProperty(name = "nom", value = "")
	private String nom;
	
	@ManagedProperty(name = "description", value = "")
	private String description;
	
	@ManagedProperty(name = "prix", value = "")
	private String prix;
	
	@ManagedProperty(name = "remise", value = "")
	private String remise;
	
	@ManagedProperty(name = "stock", value = "")
	private String stock;
	
	@ManagedProperty(name = "categorie", value = "cat")
	private String categorieId;
	
	@ManagedProperty(name = "categories", value = "cat")
	private List<Categorie> categories;
	
	@ManagedProperty(name = "messageSuccess", value = "")
	private static String messageSuccess;
	
	@ManagedProperty(name = "messageError", value = "")
	private static String messageError;

	
	static {
		messageSuccess = "";
		messageError = "";
	}
	
	public ArticleBean() {
		categories = new ArrayList<Categorie>();
		
	}
	
		public List<Categorie> getCategories() {
		
		try {
			return categorieMetier.getCategories();
			
		} catch (Exception e) {
			messageError = "Erreur lors de la récupération des catégories !\n" + e.getMessage();
		}
		return new ArrayList<Categorie>();
	}
	
	public String addArticle() {
		
		ArticleDto articleDto=new ArticleDto();
		
		articleDto.setNom(nom);
		articleDto.setDescription(description);
		articleDto.setPrix(prix);
		articleDto.setStock(stock);
		articleDto.setRemise(remise);
		articleDto.setCategorieId(categorieId);
		
		try {
			articleMetier.AddArticle(articleDto);
			messageSuccess = "L'Article " + nom + " est ajouté avec succès !";
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "Erreur : " + e.getMessage();
		}
		return "";
		
		
		 
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getPrix() {
		return prix;
	}

	public void setPrix(String prix) {
		this.prix = prix;
	}

	public String getRemise() {
		return remise;
	}

	public void setRemise(String remise) {
		this.remise = remise;
	}

	public String getStock() {
		return stock;
	}

	public void setStock(String stock) {
		this.stock = stock;
	}

	public static String getMessageSuccess() {
		return messageSuccess;
	}

	public  void setMessageSuccess(String messageSuccess) {
		ArticleBean.messageSuccess = messageSuccess;
	}

	public  String getMessageError() {
		return messageError;
	}

	public  void setMessageError(String messageError) {
		ArticleBean.messageError = messageError;
	}

	public String getCategorieId() {
		return categorieId;
	}

	public void setCategorieId(String categorieId) {
		this.categorieId = categorieId;
	}

	

	
	
	
	
	
	
	

	

}
