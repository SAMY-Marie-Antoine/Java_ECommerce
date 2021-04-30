package fr.doranco.ecommerce.model;

import java.util.List;

import fr.doranco.ecommerce.entity.LigneDeCommande;



public interface ILigneDeCommandeDao extends IEntityDao<LigneDeCommande>{
	
	void cancelLigneDeCommande(LigneDeCommande ligneDeCommande);

	List<LigneDeCommande> getLignesDeCommande(Integer commandId);

}
