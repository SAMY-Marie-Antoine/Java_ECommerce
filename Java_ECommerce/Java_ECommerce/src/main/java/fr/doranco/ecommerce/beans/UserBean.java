package fr.doranco.ecommerce.beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;

import fr.doranco.ecommerce.control.IUserMetier;
import fr.doranco.ecommerce.control.UserMetier;
import fr.doranco.ecommerce.entity.User;
import fr.doranco.ecommerce.entity.dto.AdresseDto;
import fr.doranco.ecommerce.entity.dto.CartePaiementDto;
import fr.doranco.ecommerce.entity.dto.UserDto;


@ManagedBean(name = "userBean")
public class UserBean implements Serializable {

	private static final long serialVersionUID = 1L;
	private final IUserMetier userMetier = new UserMetier();

	@ManagedProperty(name = "idUser", value = "")
	private String idUser;

	@ManagedProperty(name = "nom", value = "chebbat")
	private String nom;

	@ManagedProperty(name = "prenom", value = "nassima")
	private String prenom;
	
	@ManagedProperty(name = "profil", value = "Client")
	private String profil;

	@ManagedProperty(name = "email", value = "nassima@gmail.com")
	private String email;

	@ManagedProperty(name = "password", value = "nassima")
	private String password;
	
	@ManagedProperty(name = "telephone", value = "02153624")
	private String telephone;
	
	@ManagedProperty(name = "dateNaissance", value = "05/02/2015")
	private String dateNaissance;
	
	@ManagedProperty(name = "numero", value ="2")
	private String numero;

	@ManagedProperty(name = "rue", value = "rue de paris")
	private String rue;
	
	@ManagedProperty(name = "ville", value = "Paris")
	private String ville;
	
	@ManagedProperty(name = "codePostal", value = "75000")
	private String codePostal;
	
	@ManagedProperty(name = "nomProprietaire", value = "chebbatcccc")
	private String nomProprietaire;
	
	@ManagedProperty(name = "prenomProprietaire", value = "nassimacccc")
	private String prenomProprietaire;
	
	@ManagedProperty(name = "numeroCarte", value = "1201542877777777")
	private String numeroCarte;
	
	@ManagedProperty(name = "dateValidite", value = "02/12/2012")
	private String dateValidite;
	
	@ManagedProperty(name = "cryptogramme", value = "125")
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

	
	public UserBean() {
	}

	public String addUser() {
		
		UserDto userDto = new UserDto();
		AdresseDto adresseDto=new AdresseDto();
		CartePaiementDto cartePaiementDto =new CartePaiementDto();
		
		
		userDto.setNom(nom);
		userDto.setPrenom(prenom);
		userDto.setEmail(email);
		userDto.setDateNaissance(dateNaissance);
		userDto.setTelephone(telephone);
		userDto.setPassword(password);
		
		adresseDto.setNumero(numero);
		adresseDto.setRue(rue);
		adresseDto.setCodePostal(codePostal);
		adresseDto.setVille(ville);
		
		cartePaiementDto.setNomProprietaire(nomProprietaire);
		cartePaiementDto.setPrenomProprietaire(prenomProprietaire);
		cartePaiementDto.setNumero(numero);
		cartePaiementDto.setDateValidite(dateValidite);
		cartePaiementDto.setCryptogramme(cryptogramme);
		
		userDto.getAdresses().add(adresseDto);
		userDto.getCartesDePaiementDto().add(cartePaiementDto);
		
		try {
			userMetier.addUser(userDto);
			messageSuccess = "Inscription effectuée avec succès !";
			return "";
		} catch (Exception e) {
			e.printStackTrace();
			return "Erreur : " + e.getMessage();
		}
		
	}

	public List<User> getUsers() {
		try {
			return userMetier.getUsers();
		} catch (Exception e) {
			messageError = "Erreur lors de la récupération des utilisateurs !\n" + e.getMessage();
		}
		return new ArrayList<User>();
	}

	public String remove(Integer id) {
		try {
			userMetier.removeUser(id);
		} catch (Exception e) {
			messageError = "Erreur lors de la suppression de l'utilisateur !\n" + e.getMessage();
		}
		return "";
	}

	public String modifierUser(User user) {
		try {
			
			idUser = String.valueOf(user.getId());
			currentUserId = idUser;
			prenom = user.getPrenom();
			nom = user.getNom();
			email = user.getEmail();
		} catch (Exception e) {
			messageError = "Erreur lors de la modififcatoin  de l'utilisateur !\n" + e.getMessage();
		}
		return "";
	}

//	public String updateUser(Integer id) {
//		try {
//			
//		
//			UserDto userDto = userMetier.getUserById(id);
//			userDto.setNom(nom);
//			userDto.setPrenom(prenom);
//			userDto.setEmail(email);
//			userDto.setPassword(password);
//
//			userMetier.updateUser(userDto);;
//			messageSuccess = "la mise à jour effectuée avec succès !";
//		} catch (Exception e) {
//			System.out.println(e);
//			messageError = "Erreur lors de la mise a jour  de l'utilisateur !\n" + e.getMessage();
//		}
//		return "";
//	}

	public String getIdUser() {
		return idUser;
	}

	public void setIdUser(String idUser) {
		this.idUser = idUser;
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

	public String getProfil() {
		return profil;
	}

	public void setProfil(String profil) {
		this.profil = profil;
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

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getDateNaissance() {
		return dateNaissance;
	}

	public void setDateNaissance(String dateNaissance) {
		this.dateNaissance = dateNaissance;
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

	public String getNumeroCarte() {
		return numeroCarte;
	}

	public void setNumeroCarte(String numeroCarte) {
		this.numeroCarte = numeroCarte;
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
	

	public String getMessageSuccess() {
		return messageSuccess;
	}

	public void setMessageSuccess(String messageSuccess) {
		UserBean.messageSuccess = messageSuccess;
	}

	public String getMessageError() {
		return messageError;
	}

	public void setMessageError(String messageError) {
		UserBean.messageError = messageError;
	}

	public String getCurrentUserId() {
		return currentUserId;
	}

	public void setCurrentUserId(String currentUserId) {
		this.currentUserId = currentUserId;
	}


}
