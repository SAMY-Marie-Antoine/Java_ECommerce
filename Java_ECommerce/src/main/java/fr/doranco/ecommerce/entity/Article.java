package fr.doranco.ecommerce.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
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
	@Column(name = "remise", nullable = false)
	private Float remise;
	
	@NotNull
	@Column(name = "stock", length = 25, nullable = false)
	private Integer stock;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "user", fetch = FetchType.LAZY)
	private List<Commentaire> commentaires;
	
	@ManyToOne
	@JoinColumn(name = "categorie_id", nullable = false)
	private Categorie categorie;

	
	public Article() {
	
	}


	public Article(String nom, String description, @NotNull Integer prix, @NotNull Float remise, @NotNull Integer stock,
			List<Commentaire> commentaires, Categorie categorie) {
		super();
		this.nom = nom;
		this.description = description;
		this.prix = prix;
		this.remise = remise;
		this.stock = stock;
		this.commentaires = commentaires;
		this.categorie = categorie;
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


	public Float getRemise() {
		return remise;
	}


	public void setRemise(Float remise) {
		this.remise = remise;
	}


	public Integer getStock() {
		return stock;
	}


	public void setStock(Integer stock) {
		this.stock = stock;
	}


	public List<Commentaire> getCommentaires() {
		return commentaires;
	}


	public void setCommentaires(List<Commentaire> commentaires) {
		this.commentaires = commentaires;
	}


	public Categorie getCategorie() {
		return categorie;
	}


	public void setCategorie(Categorie categorie) {
		this.categorie = categorie;
	}


	@Override
	public String toString() {
		return "Article [id=" + id + ", nom=" + nom + ", description=" + description + ", prix=" + prix + ", remise="
				+ remise + ", stock=" + stock + ", commentaires=" + commentaires + ", categorie=" + categorie + "]";
	}



	
	
	
	
	
	
	
	
}
