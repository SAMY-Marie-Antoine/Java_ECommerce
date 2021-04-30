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
	public List<Categorie> getCategories() throws Exception {

		List<Categorie> categories= categorieDao.getCategories();
		if (categories!=null)
			return categories;
		
	return new ArrayList<Categorie>();
	}
	
	

}
