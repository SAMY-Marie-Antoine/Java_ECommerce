package fr.doranco.ecommerce.entity;


import java.io.Serializable;
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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="commande")
@NamedQueries({
	@NamedQuery(name="Commande.findAll", query="FROM Commande c"),
	@NamedQuery(name="Commande.findById",query="FROM Commande c WHERE c.id = :id"),
	@NamedQuery(name="Commande.findByDate",query="FROM Commande c WHERE c.date_creation = :date_creation"),
	@NamedQuery(name="Commande.findByUserId",query="FROM Commande c WHERE c.user_id = :user_id")
})

public class Commande implements Serializable{

	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false)
	private Integer id;

	@NotNull
	@Column(name = "numero", length = 10, nullable = false)
	private Integer numero;
	
	@NotNull
	@Column(name = "date_creation", nullable = false)
	@Temporal(TemporalType.TIME)
	private Date dateCreation;
	
	@NotNull
	@Column(name = "date_livraison")
	@Temporal(TemporalType.TIME)
	private Date dateLivraison;
	
	@NotNull  
	@Column(name = "total", nullable = false)
	private Float total;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "commande", fetch = FetchType.LAZY)
	private List<LigneDeCommande> LigneDecommandes;
	
	@ManyToOne
	@JoinColumn(name = "user_id", nullable = false)
	private User user;
	
	public Commande() {
		
		LigneDecommandes  =new ArrayList<LigneDeCommande>();
	}

	public Commande(@NotNull Integer numero, @NotNull Date dateCreation, @NotNull Date dateLivraison,
			@NotNull Float total) {
		
		this.numero = numero;
		this.dateCreation = dateCreation;
		this.dateLivraison = dateLivraison;
		this.total = total;
		
		LigneDecommandes  = new ArrayList<LigneDeCommande>();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public Date getDateCreation() {
		return dateCreation;
	}

	public void setDateCreation(Date dateCreation) {
		this.dateCreation = dateCreation;
	}

	public Date getDateLivraison() {
		return dateLivraison;
	}

	public void setDateLivraison(Date dateLivraison) {
		this.dateLivraison = dateLivraison;
	}

	public Float getTotal() {
		return total;
	}

	public void setTotal(Float total) {
		this.total = total;
	}

	
	

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<LigneDeCommande> getLigneDecommandes() {
		return LigneDecommandes;
	}

	@Override
	public String toString() {
		return "Commande [id=" + id + ", numero=" + numero + ", dateCreation=" + dateCreation + ", dateLivraison="
				+ dateLivraison + ", total=" + total + ", LigneDecommandes=" + LigneDecommandes + ", user=" + user
				+ "]";
	}

	
	
	
	
	
	
	
	
	

}
