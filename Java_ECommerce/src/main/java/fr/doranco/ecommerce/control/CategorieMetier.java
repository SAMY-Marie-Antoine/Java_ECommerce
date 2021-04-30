package fr.doranco.ecommerce.control;

import java.util.ArrayList;
import java.util.List;

import fr.doranco.ecommerce.entity.Categorie;
import fr.doranco.ecommerce.model.CategorieDao;
import fr.doranco.ecommerce.model.ICategorieDao;


public class CategorieMetier implements ICategorieMetier {


	private final ICategorieDao categorieDao = new CategorieDao();
	
	public CategorieMetier() {
		
	}
	
	@Override
	public Categorie addCategorie(Categorie categorie) throws Exception {
		if (categorie==null) {
			throw new NullPointerException("l'utilisateur à ajouter est NULL !");
		}
		
		if (categorie.getNom() == null || categorie.getNom().trim().isEmpty() 

		) {
			throw new IllegalArgumentException("Le nom de la catégorie est obligatoire!!");
		}
		categorie.setNom(categorie.getNom().toUpperCase());
		
		categorieDao.add(categorie);
		return categorie;
		
	}
	
	@Override
	public List<Categorie> getCategories() throws Exception {

		List<Categorie> categories= categorieDao.getCategories();
		if (categories!=null)
			return categories;
		return new ArrayList<Categorie>();
	}


	
	
	

}
