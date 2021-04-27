package fr.doranco.ecommerce.beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;

import fr.doranco.ecommerce.control.IUserMetier;
import fr.doranco.ecommerce.control.UserMetier;
import fr.doranco.ecommerce.entity.Adresse;
import fr.doranco.ecommerce.entity.User;
import fr.doranco.ecommerce.model.AbstractEntityDao;



@ManagedBean(name = "userBean")
public class UserBean implements Serializable {

	private static final long serialVersionUID = 1L;
	private final IUserMetier userMetier = new UserMetier();

	@ManagedProperty(name = "idUser", value = "")
	private String idUser;

	@ManagedProperty(name = "genre", value = "")
	private String genre;

	@ManagedProperty(name = "nom", value = "")
	private String nom;

	@ManagedProperty(name = "prenom", value = "")
	private String prenom;
	
	@ManagedProperty(name = "profil", value = "")
	private String profil;

	@ManagedProperty(name = "email", value = "")
	private String email;

	@ManagedProperty(name = "password", value = "")
	private String password;

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
		User user = new User();
		user.setGenre(genre);
		user.setNom(nom);
		user.setPrenom(prenom);
		user.setEmail(email);
		user.setPassword(password);
		
		try {
			userMetier.add(user);
			messageSuccess = "Inscription effectuée avec succès !";
		} catch (Exception e) {
			System.out.println(e);
			messageError = "Erreur lors de l'inscription de l'utilisateur !\n" + e.getMessage();
		}
		return "";
	}

	public List<User> getUsers() {
		try {
			return userMetier.getUsers();
		} catch (Exception e) {
			messageError = "Erreur lors de la récupération des utilisateurs !\n" + e.getMessage();
		}
		return new ArrayList<User>();
	}

	public String remove(User user) {
		try {
			userMetier.remove(user);
		} catch (Exception e) {
			messageError = "Erreur lors de la suppression de l'utilisateur !\n" + e.getMessage();
		}
		return "";
	}

	public String modifierUser(User user) {
		try {
			
			idUser = String.valueOf(user.getId());
			currentUserId = idUser;
			genre = user.getGenre();
			prenom = user.getPrenom();
			nom = user.getNom();
			email = user.getEmail();
		} catch (Exception e) {
			messageError = "Erreur lors de la modififcatoin  de l'utilisateur !\n" + e.getMessage();
		}
		return "";
	}

	public String updateUser() {
		try {
			

			User user = userMetier.getUserById(Integer.parseInt(currentUserId));
			user.setGenre(genre);
			user.setNom(nom);
			user.setPrenom(prenom);
			user.setEmail(email);
			user.setPassword(password);

			userMetier.update(user);;
			messageSuccess = "la mise à jour effectuée avec succès !";
		} catch (Exception e) {
			System.out.println(e);
			messageError = "Erreur lors de la mise a jour  de l'utilisateur !\n" + e.getMessage();
		}
		return "";
	}

	public String getIdUser() {
		return idUser;
	}

	public void setIdUser(String idUser) {
		this.idUser = idUser;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
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
	
	
	
	public String getCurrentUserId() {
		return currentUserId;
	}

	public void setCurrentUserId(String currentUserId) {
		this.currentUserId = currentUserId;
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

}
