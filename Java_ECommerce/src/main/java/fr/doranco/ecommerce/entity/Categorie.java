package fr.doranco.ecommerce.entity;

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
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name = "categorie")
@NamedQueries({
	@NamedQuery(name = "Categorie.findAll", query = "FROM Categorie u")
})
public class Categorie {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false)
	private Integer id;
	
	@NotEmpty
	@Column(name = "nom", length = 25, nullable = false)
	private String nom;
	
	@NotNull  
	@Column(name = "remise", nullable = false)
	private Float remise;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "categorie", fetch = FetchType.LAZY)
	private List<Article> articles;
	
	
	
	public Categorie() {
		// TODO Auto-generated constructor stub
	}

	public Categorie(String nom) {
		
		this.nom = nom;
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

	public Float getRemise() {
		return remise;
	}

	public void setRemise(Float remise) {
		this.remise = remise;
	}

	public List<Article> getArticles() {
		return articles;
	}
	
	
	

}
