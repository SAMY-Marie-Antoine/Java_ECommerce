package fr.doranco.ecommerce.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="ligne_de_commande")
public class LigneDeCommande implements Serializable  {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false)
	private Integer id;
	
	@NotNull
	@Column(name = "quantite", length = 4, nullable = false)
	private Integer quantite;
	
	@NotNull
	@Column(name = "prix", length = 25, nullable = false)
	private Float prix;
	
	@NotNull
	@Column(name = "prix_total", length = 25, nullable = false)
	private Float prixTotal;
	
	@OneToOne
	@JoinColumn(name = "article_id", nullable = false)
	private Article article;
	
	@ManyToOne
	@JoinColumn(name = "commande_id", nullable = false)
	private Commande commande;
	
	public LigneDeCommande() {
	
	}

	public LigneDeCommande(@NotNull Integer quantite, @NotNull Float prix,@NotNull Float prixTotal, @NotNull Article article) {
		
		this.quantite = quantite;
		this.prix = prix;
		this.prixTotal = prixTotal;
		this.article = article;
		
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getQuantite() {
		return quantite;
	}

	public void setQuantite(Integer quantite) {
		this.quantite = quantite;
	}

	public Float getPrix() {
		return prix;
	}

	public void setPrix(Float prix) {
		this.prix = prix;
	}

	public Float getPrixTotal() {
		return prixTotal;
	}

	public void setPrixTotal(Float prixTotal) {
		this.prixTotal = prixTotal;
	}

	public Article getArticle() {
		return article;
	}

	public void setArticle(Article article) {
		this.article = article;
	}

	public Commande getCommande() {
		return commande;
	}

	public void setCommande(Commande commande) {
		this.commande = commande;
	}

	@Override
	public String toString() {
		return "LigneDeCommande [id=" + id + ", quantite=" + quantite + ", prix=" + prix + ", prixTotal=" + prixTotal
				+ ", article=" + article + ", commande=" + commande + "]";
	}
	
	
	
	
}
