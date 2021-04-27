package fr.doranco.ecommerce.model;

import java.util.List;

import fr.doranco.ecommerce.entity.Commande;



public interface ICommandeDao extends IEntityDao<Commande>{
	
	void cancelCommande(Integer id) throws Exception;

	List<Commande> getCommandes() throws Exception; // avec createNamedQuery

	List<Commande> getCommandesByUtilisateurId(Integer utilisateurId) throws Exception;

	List<Commande> getCommandesByVille(String ville) throws Exception;

}
