package fr.doranco.ecommerce.model;

import fr.doranco.ecommerce.entity.CarteDePaiement;

public interface ICartePaiementDao {
	CarteDePaiement getCartePaiementByUserId(Integer userId) throws Exception;
	CarteDePaiement addCartePaiement(CarteDePaiement cartePaiement, Integer userId) throws Exception;

}
