package fr.doranco.ecommerce.beans;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;

import fr.doranco.ecommerce.control.CartePaiementMetier;
import fr.doranco.ecommerce.control.ICartePaiementMetier;
import fr.doranco.ecommerce.entity.dto.CartePaiementDto;


@ManagedBean(name = "CartePaiementBean")
public class CartePaiementBean implements Serializable {

	private static final long serialVersionUID = 1L;
	private final ICartePaiementMetier cartePaiementMetier = new CartePaiementMetier();

	@ManagedProperty(name = "idCartePaiement", value = "")
	private String idCartePaiement;

	
	@ManagedProperty(name = "nomProprietaire", value = "")
	private String nomProprietaire;
	
	@ManagedProperty(name = "prenomProprietaire", value = "")
	private String prenomProprietaire;
	
	@ManagedProperty(name = "numero", value = "")
	private String numero;
	
	@ManagedProperty(name = "dateValidite", value = "")
	private String dateValidite;
	
	@ManagedProperty(name = "cryptogramme", value = "")
	private String cryptogramme;

	@ManagedProperty(name = "messageSuccess", value = "")
	private static String messageSuccess;

	@ManagedProperty(name = "messageError", value = "")
	private static String messageError;

	@ManagedProperty(name = "currentUserId", value = "")
	private String currentUserId;
	
	
	static {
		messageSuccess = "";
		messageError = "";
	}

	
	public CartePaiementBean() {
	}

	public String addCartePaiement(CartePaiementDto cartePaiementDto, Integer userId) {
		

		cartePaiementDto.setNomProprietaire(nomProprietaire);
		cartePaiementDto.setPrenomProprietaire(prenomProprietaire);
		cartePaiementDto.setNumero(numero);
		cartePaiementDto.setDateValidite(dateValidite);
		cartePaiementDto.setCryptogramme(cryptogramme);
				
		try {
			cartePaiementMetier.addCartePaiement(cartePaiementDto,userId);
			messageSuccess = "Inscription effectuée avec succès !";
		} catch (Exception e) {
			System.out.println(e);
			messageError = "Erreur lors de l'enregistrement de la carte !\n" + e.getMessage();
		}
		return "";
	}
	
	
//	public String getCartePaiementByUserId(Integer userId) {
//	try {
//		return CartePaiementMetier.getCartePaiementByUserId(userId);
//	} catch (Exception e) {
//		messageError = "Erreur lors de la récupération de la carte !\n" + e.getMessage();
//	}
//	return "";
//	}

	public String getIdCartePaiement() {
		return idCartePaiement;
	}

	public void setIdCartePaiement(String idCartePaiement) {
		this.idCartePaiement = idCartePaiement;
	}

	public String getNomProprietaire() {
		return nomProprietaire;
	}

	public void setNomProprietaire(String nomProprietaire) {
		this.nomProprietaire = nomProprietaire;
	}

	public String getPrenomProprietaire() {
		return prenomProprietaire;
	}

	public void setPrenomProprietaire(String prenomProprietaire) {
		this.prenomProprietaire = prenomProprietaire;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getDateValidite() {
		return dateValidite;
	}

	public void setDateValidite(String dateValidite) {
		this.dateValidite = dateValidite;
	}

	public String getCryptogramme() {
		return cryptogramme;
	}

	public void setCryptogramme(String cryptogramme) {
		this.cryptogramme = cryptogramme;
	}

	public static String getMessageSuccess() {
		return messageSuccess;
	}

	public static void setMessageSuccess(String messageSuccess) {
		CartePaiementBean.messageSuccess = messageSuccess;
	}

	public static String getMessageError() {
		return messageError;
	}

	public static void setMessageError(String messageError) {
		CartePaiementBean.messageError = messageError;
	}

	public String getCurrentUserId() {
		return currentUserId;
	}

	public void setCurrentUserId(String currentUserId) {
		this.currentUserId = currentUserId;
	}

	public ICartePaiementMetier getCartePaiementMetier() {
		return cartePaiementMetier;
	}

	

	

		

}

