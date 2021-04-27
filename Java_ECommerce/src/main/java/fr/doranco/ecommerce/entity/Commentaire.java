package fr.doranco.ecommerce.entity;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


public class Commentaire {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false)
	private Integer id;
	
	@NotNull
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
			@NotNull @Size(min = 5, max = 300, message = "Le commentaire doit être compris entre 5 et 300 caractères") String texte,
			@NotNull Integer note, User user, User article) {
		
		this.texte = texte;
		this.note = note;
		this.user = user;
		this.article = article;
	}

	@Override
	public String toString() {
		return "Commentaire [id=" + id + ", texte=" + texte + ", note=" + note + ", user=" + user + ", article="
				+ article + "]";
	}
	
	
	
	

}
