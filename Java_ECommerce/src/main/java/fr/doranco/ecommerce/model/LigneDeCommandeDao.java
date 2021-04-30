package fr.doranco.ecommerce.model;

import java.util.List;
import fr.doranco.ecommerce.entity.LigneDeCommande;



public class LigneDeCommandeDao extends AbstractEntityDao<LigneDeCommande> implements ILigneDeCommandeDao{

	
	public LigneDeCommandeDao() {
	}
	
	@Override
	public void cancelLigneDeCommande(LigneDeCommande ligneDeCommande) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<LigneDeCommande> getLignesDeCommande(Integer commandId) {
		// TODO Auto-generated method stub
		return null;
	}

}
