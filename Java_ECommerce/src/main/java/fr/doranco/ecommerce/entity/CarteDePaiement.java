package fr.doranco.ecommerce.entity;

import java.util.Arrays;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name = "carte_de_paiement")
public class CarteDePaiement {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false)
	private Integer id;
	
	@NotEmpty
	@Column(name = "nom_proprietaire", length = 25, nullable = false)
	private String nomProprietaire;
	
	@NotEmpty
	@Column(name = "prenom_proprietaire", length = 25, nullable = false)
	private String prenomProprietaire;
	
	@NotEmpty
	@Column(name = "numero", nullable = false)
	//@Size(min = 16, max = 16, message = "Le numéro de carte doit contenir 16 chiffre!!")
	private byte[] numero;
	
	@NotNull
	@Column(name = "date_validite", nullable = false)
	@Temporal(TemporalType.DATE)
	private Date dateValidite;
	
	@NotEmpty
	@Column(name = "cryptogramme", nullable = false)
	//@Size(min = 3, max = 3, message = "Le numéro de carte doit contenir 3 chiffre!!")
	private byte[] cryptogramme;
	
	@ManyToOne
	@JoinColumn(name = "user_id", nullable = false)
	private User user;
	
	public CarteDePaiement() {
		
	}

	public CarteDePaiement(String nomProprietaire, String prenomProprietaire,
			@Size(min = 16, max = 16, message = "Le numéro de carte doit contenir 16 chiffre!!") byte[] numero,
			@NotNull Date dateValidite,
			@Size(min = 3, max = 3, message = "Le numéro de carte doit contenir 3 chiffre!!") byte[] cryptogramme,
			User user) {
		
		this.nomProprietaire = nomProprietaire;
		this.prenomProprietaire = prenomProprietaire;
		this.numero = numero;
		this.dateValidite = dateValidite;
		this.cryptogramme = cryptogramme;
		this.user = user;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	public byte[] getNumero() {
		return numero;
	}

	public void setNumero(byte[] numero) {
		this.numero = numero;
	}

	public Date getDateValidite() {
		return dateValidite;
	}

	public void setDateValidite(Date dateValidite) {
		this.dateValidite = dateValidite;
	}

	public byte[] getCryptogramme() {
		return cryptogramme;
	}

	public void setCryptogramme(byte[] cryptogramme) {
		this.cryptogramme = cryptogramme;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "CarteDePaiement [id=" + id + ", nomProprietaire=" + nomProprietaire + ", prenomProprietaire="
				+ prenomProprietaire + ", numero=" + Arrays.toString(numero) + ", dateValidite=" + dateValidite
				+ ", cryptogramme=" + Arrays.toString(cryptogramme) + ", user=" + user + "]";
	}
	
	
	
	
}
