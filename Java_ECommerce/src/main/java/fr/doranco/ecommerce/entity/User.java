package fr.doranco.ecommerce.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;


@Entity
//@Table(name = "user", schema = "db_hibernate")
@Table(name = "user")
@NamedQueries({
	@NamedQuery(name = "User.findAll", query = "FROM User u"),
	@NamedQuery(name = "User.findByEmail", query = "FROM User u WHERE u.email = :email"),
	@NamedQuery(name = "User.findByVille", query = "SELECT u FROM User u JOIN u.adresses a ON a.ville = :ville")	
})

public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false)
	private Integer id;
	
	@NotEmpty
	@Column(name = "nom", length = 25, nullable = false)
	private String nom;
	
	@NotEmpty
	@Column(name = "prenom", length = 25, nullable = false)
	private String prenom;
	
	@NotNull
	@Column(name = "actif", length = 1, nullable = false)
	private Boolean isActif;
	
	@NotEmpty
	@Column(name = "profil", length = 10, nullable = false)
	private String profil;
	
	@NotEmpty
	@Column(name = "email", nullable = false,unique=true)
	@Size(min = 5, max = 20, message = "Le Email doit être compris entre 5 et 20 caractères")
	private String email;
	
	@NotEmpty
	@Column(name = "password", nullable = false)
	@Size(min = 2, max = 15, message = "Le mot de passe doit être compris entre 2 et 15 caractères")
	private byte[] password;
	
	@NotNull
	@Column(name = "date_naissance", nullable = false)
	@Temporal(TemporalType.DATE)
	private Date dateNaissance;
	
	@NotNull
	@Column(name = "telephone",length = 11, nullable = false)
	private String telephone;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "user", fetch = FetchType.LAZY)
	private List<Adresse> adresses;
	
	@NotNull
	@Column(name = "adresse_facturation_id", nullable = false)
	private Integer AdresseFacturationId;
	
	@NotNull
	@Column(name = "adresse_livraison_id", nullable = false)
	private Integer AdresseLivraisonId;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "user", fetch = FetchType.LAZY)
	private List<Commande> commandes;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "user", fetch = FetchType.LAZY)
	private List<CarteDePaiement> CartesDePaiement;
	
	@NotNull
	@Column(name = "Cartes_paiement_default_id", nullable = false)
	private Integer CartesPaiementDefaultId;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "user", fetch = FetchType.LAZY)
	private List<Commentaire> commentaires;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "user", fetch = FetchType.LAZY)
	private List<ArticlePanier> panier;
	
	
	public User() {
		adresses = new ArrayList<Adresse>();
	}

	
	

	public User(String nom, String prenom, @NotNull Boolean isActif, String profil,
			@Size(min = 5, max = 20, message = "Le Email doit être compris entre 5 et 20 caractères") String email,
			@Size(min = 2, max = 15, message = "Le mot de passe doit être compris entre 2 et 15 caractères") byte[] password,
			@NotNull Date dateNaissance, @NotNull String telephone, List<Adresse> adresses,
			@NotNull Integer adresseFacturationId, @NotNull Integer adresseLivraisonId, List<Commande> commandes,
			List<CarteDePaiement> cartesDePaiement, @NotNull Integer cartesPaiementDefaultId,
			List<Commentaire> commentaires, List<ArticlePanier> panier) {
		
		this.nom = nom;
		this.prenom = prenom;
		this.isActif = isActif;
		this.profil = profil;
		this.email = email;
		this.password = password;
		this.dateNaissance = dateNaissance;
		this.telephone = telephone;
		this.adresses = adresses;
		AdresseFacturationId = adresseFacturationId;
		AdresseLivraisonId = adresseLivraisonId;
		this.commandes = commandes;
		CartesDePaiement = cartesDePaiement;
		CartesPaiementDefaultId = cartesPaiementDefaultId;
		this.commentaires = commentaires;
		this.panier = panier;
	}




	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	public Boolean getIsActif() {
		return isActif;
	}

	public void setIsActif(Boolean isActif) {
		this.isActif = isActif;
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

	public byte[] getPassword() {
		return password;
	}

	public void setPassword(byte[] password) {
		this.password = password;
	}

	public Date getDateNaissance() {
		return dateNaissance;
	}

	public void setDateNaissance(Date dateNaissance) {
		this.dateNaissance = dateNaissance;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public Integer getAdresseFacturationId() {
		return AdresseFacturationId;
	}

	public void setAdresseFacturationId(Integer adresseFacturationId) {
		AdresseFacturationId = adresseFacturationId;
	}

	public Integer getAdresseLivraisonId() {
		return AdresseLivraisonId;
	}

	public void setAdresseLivraisonId(Integer adresseLivraisonId) {
		AdresseLivraisonId = adresseLivraisonId;
	}

	public Integer getCartesPaiementDefaultId() {
		return CartesPaiementDefaultId;
	}

	public void setCartesPaiementDefaultId(Integer cartesPaiementDefaultId) {
		CartesPaiementDefaultId = cartesPaiementDefaultId;
	}

	public List<Adresse> getAdresses() {
		return adresses;
	}

	public List<Commande> getCommandes() {
		return commandes;
	}

	public List<CarteDePaiement> getCartesDePaiement() {
		return CartesDePaiement;
	}

	public List<Commentaire> getCommentaires() {
		return commentaires;
	}

	public List<ArticlePanier> getPanier() {
		return panier;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", isActif=" + isActif + ", profil=" + profil
				+ ", email=" + email + ", password=" + password + ", dateNaissance=" + dateNaissance + ", telephone="
				+ telephone + ", adresses=" + adresses + ", AdresseFacturationId=" + AdresseFacturationId
				+ ", AdresseLivraisonId=" + AdresseLivraisonId + ", commandes=" + commandes + ", CartesDePaiement="
				+ CartesDePaiement + ", CartesPaiementDefaultId=" + CartesPaiementDefaultId + ", commentaires="
				+ commentaires + ", panier=" + panier + "]";
	}	

	
}
