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
//@NamedQueries({
//	
//	@NamedQuery(name = "article.findByCategorie", query = "FROM Article u WHERE u.categorie_id = :categorieId")	
//})
public class Article implements Serializable{

	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false)
	private Integer id;
	
	@NotEmpty
	@Column(name = "nom", length = 25)
	private String nom;
	
	
	@Column(name = "description", length = 25)
	private String description;
	
	@NotNull
	@Column(name = "prix", length = 25)
	private Integer prix;
	
	  
	@Column(name = "remise")
	private Float remise;
	
	@NotNull
	@Column(name = "stock", length = 25, nullable = false)
	private Integer stock;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "article", fetch = FetchType.LAZY)
	private List<Commentaire> commentaires;
	
	
	@ManyToOne
	@JoinColumn(name = "categorie_id", nullable = false)
	private Categorie categorieId;

	
	public Article() {
	
	}


	public Article(String nom, String description, @NotNull Integer prix, @NotNull Float remise, @NotNull Integer stock,
			Categorie categorieId) {
		
		this.nom = nom;
		this.description = description;
		this.prix = prix;
		this.remise = remise;
		this.stock = stock;
		
		this.categorieId = categorieId;
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



	public Categorie getCategorieId() {
		return categorieId;
	}


	public void setCategorieId(Categorie categorieId) {
		this.categorieId = categorieId;
	}


	@Override
	public String toString() {
		return "Article [id=" + id + ", nom=" + nom + ", description=" + description + ", prix=" + prix + ", remise="
				+ remise + ", stock=" + stock + ", commentaires=" + commentaires + ", categorie=" + categorieId + "]";
	}



	
	
	
	
	
	
	
	
}
