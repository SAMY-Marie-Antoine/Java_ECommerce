package fr.doranco.ecommerce.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;


@Entity
@Table(name = "commentaire")
public class Commentaire {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false)
	private Integer id;
	
	@NotEmpty
	@Column(name = "texte",length = 300, nullable = false)
	@Size(min = 5, max = 300, message = "Le commentaire doit être compris entre 5 et 300 caractères")
	private String texte;
	
	
	@NotNull
	@Column(name = "note", nullable = false)
	private Integer note;
	
	@ManyToOne
	@JoinColumn(name = "user_id", nullable = false)
	private User user;
	
	@ManyToOne
	@JoinColumn(name = "article_id", nullable = false)
	private User article;
	
	public Commentaire() {
		
	}

	public Commentaire(
			@NotEmpty @Size(min = 5, max = 300, message = "Le commentaire doit être compris entre 5 et 300 caractères") String texte,
			@NotNull Integer note, User user, User article) {
		
		this.texte = texte;
		this.note = note;
		this.user = user;
		this.article = article;
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTexte() {
		return texte;
	}

	public void setTexte(String texte) {
		this.texte = texte;
	}

	public Integer getNote() {
		return note;
	}

	public void setNote(Integer note) {
		this.note = note;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public User getArticle() {
		return article;
	}

	public void setArticle(User article) {
		this.article = article;
	}

	@Override
	public String toString() {
		return "Commentaire [id=" + id + ", texte=" + texte + ", note=" + note + ", user=" + user + ", article="
				+ article + "]";
	}
	
	
	
	

}
