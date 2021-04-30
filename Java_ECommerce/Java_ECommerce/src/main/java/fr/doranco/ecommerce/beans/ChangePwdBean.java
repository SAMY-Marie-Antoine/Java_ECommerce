package fr.doranco.ecommerce.beans;

import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import fr.doranco.ecommerce.control.IUserMetier;
import fr.doranco.ecommerce.control.UserMetier;
import fr.doranco.ecommerce.entity.User;



@ManagedBean(name = "changePwdBean")
public class ChangePwdBean implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private final IUserMetier userMetier = new UserMetier();
	
	@ManagedProperty(name = "password", value = "")
	private String password;
	
	@ManagedProperty(name = "newPasswword", value = "")
	private String newPassword;
	
	@ManagedProperty(name = "confirmedpassword", value = "")
	private String confirmedPassword;
	
	@ManagedProperty(name = "email", value = "")
	private String email;
	
	@ManagedProperty(name = "messageSuccess", value = "")
	private static String messageSuccess;

	@ManagedProperty(name = "messageError", value = "")
	private static String messageError;

	static {
		messageSuccess = "";
		messageError = "";
	}
	//constructeur
	public ChangePwdBean() {
		
	}
	
	//methode
	public String changePwd() {
		
		try {
			User user = userMetier.getUserByEmail(email);
			if (newPassword.equals(confirmedPassword))
			{
				//userMetier.changePwd(user);
				messageSuccess = "votre mot de passe a été modifié avec succès !";
			}
		} catch (Exception e) {
			messageError = "Erreur lors de la mise à jour de l'utilisateur !" + e.getMessage();
		}

		return "";
	}

	
	//getters et setters
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getNewPasswword() {
		return newPassword;
	}

	public void setNewPasswword(String newPasswword) {
		this.newPassword = newPasswword;
	}

	public String getConfirmedPassword() {
		return confirmedPassword;
	}

	public void setConfirmedPassword(String confirmedPassword) {
		this.confirmedPassword = confirmedPassword;
	}

	public static String getMessageSuccess() {
		return messageSuccess;
	}

	public static void setMessageSuccess(String messageSuccess) {
		ChangePwdBean.messageSuccess = messageSuccess;
	}

	public static String getMessageError() {
		return messageError;
	}

	public static void setMessageError(String messageError) {
		ChangePwdBean.messageError = messageError;
	}
	
	
	
	

}
