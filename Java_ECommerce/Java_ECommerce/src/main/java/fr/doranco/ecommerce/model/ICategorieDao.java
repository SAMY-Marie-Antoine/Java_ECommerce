package fr.doranco.ecommerce.model;

import java.util.List;

import fr.doranco.ecommerce.entity.Categorie;

public interface ICategorieDao extends IEntityDao<Categorie>{
	
	List<Categorie> getCategories() throws Exception;
	

	

}
