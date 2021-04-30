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
	@Column(name = "total_remise", nullable = false)
	private Float totalRemise;
	
	@NotNull  
	@Column(name = "frais_expedition", nullable = false)
	private Float fraisExpedition;
	
	@NotNull  
	@Column(name = "total_general", nullable = false)
	private Float totalGeneral;
	
	@ManyToOne
	@JoinColumn(name = "user_id", nullable = false)
	private User user;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "commande", fetch = FetchType.LAZY)
	private List<LigneDeCommande> LigneDecommandes;
	
	
	public Commande() {
		
		LigneDecommandes  =new ArrayList<LigneDeCommande>();
	}


	public Commande(@NotNull Integer numero, @NotNull Date dateCreation, @NotNull Date dateLivraison,
			@NotNull Float totalRemise, @NotNull Float fraisExpedition, @NotNull Float totalGeneral, User user,
			List<LigneDeCommande> ligneDecommandes) {
		
		this.numero = numero;
		this.dateCreation = dateCreation;
		this.dateLivraison = dateLivraison;
		this.totalRemise = totalRemise;
		this.fraisExpedition = fraisExpedition;
		this.totalGeneral = totalGeneral;
		this.user = user;
		LigneDecommandes = ligneDecommandes;
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


	public Float getTotalRemise() {
		return totalRemise;
	}


	public void setTotalRemise(Float totalRemise) {
		this.totalRemise = totalRemise;
	}


	public Float getFraisExpedition() {
		return fraisExpedition;
	}


	public void setFraisExpedition(Float fraisExpedition) {
		this.fraisExpedition = fraisExpedition;
	}


	public Float getTotalGeneral() {
		return totalGeneral;
	}


	public void setTotalGeneral(Float totalGeneral) {
		this.totalGeneral = totalGeneral;
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
				+ dateLivraison + ", totalRemise=" + totalRemise + ", fraisExpedition=" + fraisExpedition
				+ ", totalGeneral=" + totalGeneral + ", user=" + user + ", LigneDecommandes=" + LigneDecommandes + "]";
	}
	

	

	
	
	
	
	
	
	
	
	
	

}
