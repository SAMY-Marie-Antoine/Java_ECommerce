package fr.doranco.ecommerce.entity.dto;

import java.util.List;

import fr.doranco.ecommerce.entity.Categorie;
import fr.doranco.ecommerce.entity.Commentaire;

public class ArticleDto {
	
	
	private String nom;
	
	
	private String description;
	
	
	private String prix;
	
	
	private String remise;
	
	
	private String stock;
	
	
	private List<Commentaire> commentaires;
	
	
	private String categorieId;
	
	public ArticleDto() {
		
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

	
	public String getCategorieId() {
		return categorieId;
	}

	public void setCategorieId(String categorieId) {
		this.categorieId = categorieId;
	}

	public List<Commentaire> getCommentaires() {
		return commentaires;
	}
	
	

}
