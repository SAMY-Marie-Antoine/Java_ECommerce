package fr.doranco.ecommerce.entity.dto;

import fr.doranco.ecommerce.entity.User;

public class AdresseDto {


	
	private String numero;

	private String rue;

	private String ville;

	private String codePostal;
	
	private String isAdresseDeFacturation;
	
	private String isAdresseDeLivraison;
	
	private User user;

	public AdresseDto() {

	}
	
	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getRue() {
		return rue;
	}

	public void setRue(String rue) {
		this.rue = rue;
	}

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	public String getCodePostal() {
		return codePostal;
	}

	public void setCodePostal(String codePostal) {
		this.codePostal = codePostal;
	}

	public String getIsAdresseDeFacturation() {
		return isAdresseDeFacturation;
	}

	public void setIsAdresseDeFacturation(String isAdresseDeFacturation) {
		this.isAdresseDeFacturation = isAdresseDeFacturation;
	}

	public String getIsAdresseDeLivraison() {
		return isAdresseDeLivraison;
	}

	public void setIsAdresseDeLivraison(String isAdresseDeLivraison) {
		this.isAdresseDeLivraison = isAdresseDeLivraison;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	



}

