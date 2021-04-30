package fr.doranco.ecommerce.control;

import java.util.List;

import fr.doranco.ecommerce.entity.Categorie;

public interface ICategorieMetier {
	
	List<Categorie> getCategories() throws Exception;

}
