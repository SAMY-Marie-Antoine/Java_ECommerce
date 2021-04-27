package fr.doranco.ecommerce.entity;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

public class ArticlePanier {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false)
	private Integer id;
	
	@ManyToOne
	@JoinColumn(name = "article_id", nullable = false)
	private Article article;

	@NotNull
	@Column(name = "quantite", length = 4, nullable = false)
	private Integer quantite;
	
	@ManyToOne
	@JoinColumn(name = "user_id", nullable = false)
	private User user;
	
	public ArticlePanier() {
		
	}

	public ArticlePanier(Article article, @NotNull Integer quantite, User user) {
	
		this.article = article;
		this.quantite = quantite;
		this.user = user;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Article getArticle() {
		return article;
	}

	public void setArticle(Article article) {
		this.article = article;
	}

	public Integer getQuantite() {
		return quantite;
	}

	public void setQuantite(Integer quantite) {
		this.quantite = quantite;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "ArticlePanier [id=" + id + ", article=" + article + ", quantite=" + quantite + ", user=" + user + "]";
	}
	
	
	
	

}
