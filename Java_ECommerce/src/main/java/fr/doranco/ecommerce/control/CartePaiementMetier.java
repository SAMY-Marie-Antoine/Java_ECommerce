package fr.doranco.ecommerce.control;


import fr.doranco.ecommerce.entity.CarteDePaiement;
import fr.doranco.ecommerce.entity.dto.CartePaiementDto;
import fr.doranco.ecommerce.model.CartePaiementDao;
import fr.doranco.ecommerce.model.ICartePaiementDao;


public class CartePaiementMetier implements ICartePaiementMetier {

	private final ICartePaiementDao cartepaiementDao = new CartePaiementDao();

	@Override
	public CarteDePaiement getCartePaiementByUserId(Integer userId) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CarteDePaiement addCartePaiement(CartePaiementDto cartePaiementDto, Integer userId) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	
	}

	


