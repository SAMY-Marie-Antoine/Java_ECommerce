package fr.doranco.ecommerce.beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;

import fr.doranco.ecommerce.control.CategorieMetier;
import fr.doranco.ecommerce.control.ICategorieMetier;

import fr.doranco.ecommerce.entity.Categorie;

@ManagedBean(name = "categorieBean")
public class CategorieBean implements Serializable {
	
	
	private static final long serialVersionUID = 1L;
	private final ICategorieMetier categorieMetier=new CategorieMetier();

	@ManagedProperty(name = "nom", value = "")
	private String nom;
	
	@ManagedProperty(name = "remise", value = "")
	private Float remise;
	
	
	@ManagedProperty(name = "messageSuccess", value = "")
	private static String messageSuccess;

	@ManagedProperty(name = "messageError", value = "")
	private static String messageError;

	static {
		messageSuccess = "";
		messageError = "";
	}

	public CategorieBean() {
		
	}
	
	
	public String addCategorie() {
		Categorie categorie=new Categorie();
		categorie.setNom(nom);
		categorie.setRemise(remise);
		
		try {
			categorieMetier.addCategorie(categorie);
			messageSuccess = "la catégorie " + '"' + nom + '"' +" est ajoutée avec succès !";
		} catch (Exception e) {
			
			e.printStackTrace();
			messageError = "Erreur lors de l'ajout de la catégorie !\n" + e.getMessage();
		}
		
		
		return "";
	}
	
		public List<Categorie> getCategories() {
		
		try {
			return categorieMetier.getCategories();
			
		} catch (Exception e) {
			messageError = "Erreur lors de la récupération des catégories !\n" + e.getMessage();
		}
		return new ArrayList<Categorie>();
	}
	

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public Float getRemise() {
		return remise;
	}

	public void setRemise(Float remise) {
		this.remise = remise;
	}

	public  String getMessageSuccess() {
		return messageSuccess;
	}

	public  void setMessageSuccess(String messageSuccess) {
		CategorieBean.messageSuccess = messageSuccess;
	}

	public String getMessageError() {
		return messageError;
	}

	public void setMessageError(String messageError) {
		CategorieBean.messageError = messageError;
	}

	

	
	
}
