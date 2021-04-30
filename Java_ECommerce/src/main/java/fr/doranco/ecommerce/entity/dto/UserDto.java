package fr.doranco.ecommerce.entity.dto;

import java.util.ArrayList;
import java.util.List;

public class UserDto {

	private String nom;

	private String prenom;

	private String email;

	private String password;

	private String dateNaissance;

	private String telephone;
	
	private String adresseDeFacturationId;

	private String adresseDeLivraisonId;

	private List<AdresseDto> adresses;

	private List<CartePaiementDto> cartesDePaiementDto;

	public UserDto() {
		adresses = new ArrayList<AdresseDto>();
		cartesDePaiementDto = new ArrayList<CartePaiementDto>();
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getDateNaissance() {
		return dateNaissance;
	}

	public void setDateNaissance(String dateNaissance) {
		this.dateNaissance = dateNaissance;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getAdresseDeFacturationId() {
		return adresseDeFacturationId;
	}

	public void setAdresseDeFacturationId(String adresseDeFacturationId) {
		this.adresseDeFacturationId = adresseDeFacturationId;
	}

	public String getAdresseDeLivraisonId() {
		return adresseDeLivraisonId;
	}

	public void setAdresseDeLivraisonId(String adresseDeLivraisonId) {
		this.adresseDeLivraisonId = adresseDeLivraisonId;
	}

	public List<AdresseDto> getAdresses() {
		return adresses;
	}

	public List<CartePaiementDto> getCartesDePaiementDto() {
		return cartesDePaiementDto;
	}

}
