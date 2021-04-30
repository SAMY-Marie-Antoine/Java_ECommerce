package fr.doranco.ecommerce.model;

import java.util.List;
import fr.doranco.ecommerce.entity.Commande;



public class CommandeDao extends AbstractEntityDao<Commande> implements ICommandeDao {
	
	public CommandeDao() {
	}
	
	@Override
	public void cancelCommande(Integer id) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Commande> getCommandes() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Commande> getCommandesByUtilisateurId(Integer utilisateurId) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Commande> getCommandesByVille(String ville) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
