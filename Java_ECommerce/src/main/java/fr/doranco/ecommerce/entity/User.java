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
	private String genre;
	
	@NotEmpty
	@Column(name = "nom", length = 25, nullable = false)
	private String nom;
	
	@NotEmpty
	@Column(name = "prenom", length = 25, nullable = false)
	private String prenom;
	
	@NotEmpty
	@Column(name = "profil", length = 10, nullable = false)
	private String profil;
	
	@NotNull
	@Column(name = "date_naissance", nullable = false)
	@Temporal(TemporalType.DATE)
	private Date dateNaissance;
	
	@NotNull
	@Column(name = "actif", length = 1, nullable = false)
	private Boolean isActif;

	@NotEmpty
	@Column(name = "email", nullable = false,unique=true)
	@Size(min = 5, max = 20, message = "Le Email doit être compris entre 5 et 20 caractères")
	private String email;
	
	@NotEmpty
	@Column(name = "password", nullable = false)
	@Size(min = 2, max = 15, message = "Le mot de passe doit être compris entre 2 et 15 caractères")
	private String password;
	
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "user", fetch = FetchType.LAZY)
	private List<Adresse> adresses;
	
	public User() {
		adresses = new ArrayList<Adresse>();
	}

	public User(@NotEmpty String nom, @NotEmpty String prenom, @NotNull Date dateNaissance, @NotNull Boolean isActif,
			@NotEmpty @Size(min = 5, max = 20, message = "Le Email doit être compris entre 5 et 20 caractères") String email,
			@NotEmpty @Size(min = 2, max = 15, message = "Le mot de passe doit être compris entre 2 et 15 caractères") String password) {
		this.nom = nom;
		this.prenom = prenom;
		this.dateNaissance = dateNaissance;
		this.isActif = isActif;
		this.email = email;
		this.password = password;
		adresses = new ArrayList<Adresse>();
	}	

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	public Date getDateNaissance() {
		return dateNaissance;
	}



	public void setDateNaissance(Date dateNaissance) {
		this.dateNaissance = dateNaissance;
	}



	public Boolean getIsActif() {
		return isActif;
	}



	public void setIsActif(Boolean isActif) {
		this.isActif = isActif;
	}



	public List<Adresse> getAdresses() {
		return adresses;
	}


	@Override
	public String toString() {
		return "User [id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", dateNaissance=" + dateNaissance
				+ ", isActif=" + isActif + ", email=" + email + ", password=" + password + "]";
	}
	
}
