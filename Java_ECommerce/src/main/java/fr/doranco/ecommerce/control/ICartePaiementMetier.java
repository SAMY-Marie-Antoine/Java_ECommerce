package fr.doranco.ecommerce.control;

import fr.doranco.ecommerce.entity.CarteDePaiement;
import fr.doranco.ecommerce.entity.dto.CartePaiementDto;

public interface ICartePaiementMetier {
	
	CarteDePaiement getCartePaiementByUserId(Integer userId) throws Exception;
	CarteDePaiement addCartePaiement(CartePaiementDto cartePaiementDto, Integer userId) throws Exception;

}
