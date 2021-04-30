package fr.doranco.ecommerce.beans;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import fr.doranco.ecommerce.control.IUserMetier;
import fr.doranco.ecommerce.control.UserMetier;
import fr.doranco.ecommerce.entity.User;


@ManagedBean(name ="loginBean")
@SessionScoped
public class LoginBean implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private final IUserMetier userMetier = new UserMetier();
	
	@ManagedProperty(name = "email", value = "coucou")
	private String email;
	
	@ManagedProperty(name = "password", value = "coucou")
	private String password;
	
	@ManagedProperty(name = "messageSuccess", value = "")
	private static String messageSuccess;
	
	@ManagedProperty(name = "messageError", value = "")
	private static String messageError;

	static {
		messageSuccess = "";
		messageError = "";
	}
	
	public LoginBean() {
	}

	public String seConnecter() {
		initializeMessages();
		User user;
		try {
			user = userMetier.seConnecter(email, password);
			if (user != null) {
				messageSuccess = "Vous êtes bien connecté.";
				return "";
			}
			messageError = "Email et/ou Password incorrects ! Veuillez réessayer.";
		} catch (Exception e) {
			messageError = "Désolé ! Erreur technique, connexion impossible !\n Veuillez réessayer plus tard.\n" + e.getMessage();
			e.printStackTrace();
		}
		return "";
	}
	
	private void initializeMessages() {
		messageSuccess = "";
		messageError = "";
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

	public String getMessageSuccess() {
		return messageSuccess;
	}

	public void setMessageSuccess(String messageSuccess) {
		LoginBean.messageSuccess = messageSuccess;
	}

	public String getMessageError() {
		return messageError;
	}

	public void setMessageError(String messageError) {
		LoginBean.messageError = messageError;
	}
	
	
}
