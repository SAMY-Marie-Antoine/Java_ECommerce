package fr.doranco.ecommerce.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name = "article")
public class Article implements Serializable{

	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false)
	private Integer id;
	
	@NotEmpty
	@Column(name = "nom", length = 25, nullable = false)
	private String nom;
	
	@NotEmpty
	@Column(name = "description", length = 25, nullable = false)
	private String description;
	
	@NotNull
	@Column(name = "prix", length = 25, nullable = false)
	private Integer prix;
	
	@NotNull
	@Column(name = "stock", length = 25, nullable = false)
	private Integer stock;
	
	@OneToOne
	@JoinColumn(name = "ligne_de_commande_id", nullable = false)
	private LigneDeCommande ligneDeCommande;

	
	public Article() {
	
	}
	
	public Article(String nom, String description, @NotNull Integer prix) {
		
		this.nom = nom;
		this.description = description;
		this.prix = prix;
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getPrix() {
		return prix;
	}

	public void setPrix(Integer prix) {
		this.prix = prix;
	}

	public Integer getStock() {
		return stock;
	}

	public void setStock(Integer stock) {
		this.stock = stock;
	}

	public LigneDeCommande getLigneDeCommande() {
		return ligneDeCommande;
	}

	public void setLigneDeCommande(LigneDeCommande ligneDeCommande) {
		this.ligneDeCommande = ligneDeCommande;
	}

	@Override
	public String toString() {
		return "Article [id=" + id + ", nom=" + nom + ", description=" + description + ", prix=" + prix + ", "
				+ "stock=" + stock + ", ligneDeCommande=" + ligneDeCommande + "]";
	}
	
	
	
	
	
}
