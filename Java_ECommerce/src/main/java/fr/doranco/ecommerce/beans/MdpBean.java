package fr.doranco.ecommerce.beans;

import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.context.FacesContext;

import org.apache.catalina.User;

import fr.doranco.ecommerce.control.IUserMetier;
import fr.doranco.ecommerce.control.UserMetier;



@ManagedBean(name = "mdpBean")
public class MdpBean implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private IUserMetier userMetier = new UserMetier();
	
	@ManagedProperty(name = "ancienMdp", value = "")
	private String ancienMdp;
	
	@ManagedProperty(name = "nouveauMdp", value = "")
	private String nouveauMdp;
	
	@ManagedProperty(name = "confirmationMdp", value = "")
	private String confirmationMdp;

	@ManagedProperty(name = "email", value = "")
	private String email;

	@ManagedProperty(name = "messageColor", value = "")
	private String messageColor;

	public MdpBean() {
	}

	public String changeMdp(String email) {
		this.email = email;
		return "update_password"; // forward vers la page update_password.html
	}
	
	public String updatePassword( ) {
	
		this.messageColor = "red";
		FacesContext context = FacesContext.getCurrentInstance();
		
		// 1) on vérifie si le nouveau mdp et le mdp de confirmation sont identiques
		if (!nouveauMdp.equals(confirmationMdp)) {
			context.addMessage(null, new FacesMessage("Le nouveau mot de passe et le mot de passe de confirmation ne sont pas identiques"));
		} 
		
		// 2) on vérifie si le nouveau mot de passe est différent du mot de passe actuel
		else if (ancienMdp.equals(nouveauMdp)) {
			context.addMessage(null, new FacesMessage("Le nouveau mot de passe ne doit pas être identique au mot de passe actuel !"));
		}
		else {
			// 3) vérifier si le mot de passe actuel saisi correspond bien à celui de la base de données
			try {
				System.out.println("Email : " + email);
				User user = (User) userMetier.getUserByEmail(email);
				if (user == null) {
					context.addMessage(null, new FacesMessage("L'utilisateur avec l'email '" + email + "' n'a pas été trouvé !"));
					return "";
				}
				user.setPassword(nouveauMdp);
				//userMetier.updateUser((fr.doranco.ecommerce.entity.User) user);
				this.messageColor = "green";
				context.addMessage(null, new FacesMessage("Mot de passe modifié avec succès !"));
				return "";
			} catch (Exception e) {
				context.addMessage(null, new FacesMessage("Erreur lors de la mise à jour du mot de passe !\n" + e.getMessage()));
			}
		}
		
		return "";
	}
	
	public String getAncienMdp() {
		return ancienMdp;
	}

	public void setAncienMdp(String ancienMdp) {
		this.ancienMdp = ancienMdp;
	}

	public String getNouveauMdp() {
		return nouveauMdp;
	}

	public void setNouveauMdp(String nouveauMdp) {
		this.nouveauMdp = nouveauMdp;
	}

	public String getConfirmationMdp() {
		return confirmationMdp;
	}

	public void setConfirmationMdp(String confirmationMdp) {
		this.confirmationMdp = confirmationMdp;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMessageColor() {
		return messageColor;
	}

	public void setMessageColor(String messageColor) {
		this.messageColor = messageColor;
	}
	
}
