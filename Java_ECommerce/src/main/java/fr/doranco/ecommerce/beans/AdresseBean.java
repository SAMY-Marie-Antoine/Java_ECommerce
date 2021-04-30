package fr.doranco.ecommerce.beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;

import fr.doranco.ecommerce.control.AdresseMetier;
import fr.doranco.ecommerce.control.IAdresseMetier;
import fr.doranco.ecommerce.entity.Adresse;
import fr.doranco.ecommerce.entity.User;
import fr.doranco.ecommerce.entity.dto.AdresseDto;


@ManagedBean(name = "adresseBean")
public class AdresseBean implements Serializable {

	private static final long serialVersionUID = 1L;
	private final IAdresseMetier adresseMetier = new AdresseMetier();

	@ManagedProperty(name = "idUser", value = "")
	private String idUser;

	
	@ManagedProperty(name = "numero", value = "")
	private String numero;

	
	@ManagedProperty(name = "rue", value = "")
	private String rue;
	
	
	@ManagedProperty(name = "codePostal", value = "")
	private String codePostal;
	
	@ManagedProperty(name = "ville", value = "")
	private String ville;

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

	
	public AdresseBean() {
	}

	
	public String addAdresse() {
		AdresseDto adresseDto = new AdresseDto();
		adresseDto.setNumero(numero);
		adresseDto.setRue(rue);
		adresseDto.setCodePostal(codePostal);
		adresseDto.setVille(ville);
		try {
			adresseMetier.addAdresse(adresseDto);
			messageSuccess = "Inscription effectuée avec succès !";
		} catch (Exception e) {
			System.out.println(e);
			messageError = "Erreur lors de l'inscription de l'utilisateur !\n" + e.getMessage();
		}
		return "";
	}

	public List<Adresse> getAdresses(Class<Adresse> adresse, Integer UserId) {
		try {
			return adresseMetier.getAdresses(adresse, UserId);
		} catch (Exception e) {
			messageError = "Erreur lors de la récupération des utilisateurs !\n" + e.getMessage();
		}
		return new ArrayList<Adresse>();
	}

	public String remove(AdresseDto adresseDto) {
		try {
			adresseMetier.removeAdresse(adresseDto);
		} catch (Exception e) {
			messageError = "Erreur lors de la suppression de l'utilisateur !\n" + e.getMessage();
		}
		return "";
	}

	public String modifierAdresse(AdresseDto adresseDto,User user) {
		try {
			
			idUser = String.valueOf(user.getId());
			currentUserId = idUser;
			numero=adresseDto.getNumero();
			rue=adresseDto.getRue();
			codePostal=adresseDto.getCodePostal();
			ville=adresseDto.getVille();
			
		} catch (Exception e) {
			messageError = "Erreur lors de la modififcatoin  de l'utilisateur !\n" + e.getMessage();
		}
		return "";
	}

	public String updateAdresse(AdresseDto adresseDto,User user) {
		try {
			
			adresseMetier.getAdresseById(adresseDto, Integer.parseInt(currentUserId));
			adresseDto.setNumero(numero);
			adresseDto.setRue(rue);
			adresseDto.setCodePostal(codePostal);
			adresseDto.setVille(ville);

			adresseMetier.updateAdresse(adresseDto);
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
		AdresseBean.messageSuccess = messageSuccess;
	}

	public String getMessageError() {
		return messageError;
	}

	public void setMessageError(String messageError) {
		AdresseBean.messageError = messageError;
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

	public String getCodePostal() {
		return codePostal;
	}

	public void setCodePostal(String codePostal) {
		this.codePostal = codePostal;
	}

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	
}
