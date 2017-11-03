package org.sid.eboutique.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Ticket implements Serializable {

	public Ticket(Long idTicket, String description, String dateO,
			String dateF, String titre, String solution, Produit produit,
			Priorite priorite, Statut statut, Site site) {
		super();
		this.idTicket = idTicket;
		this.description = description;
		this.dateO = dateO;
		this.dateF = dateF;
		this.titre = titre;
		this.solution = solution;
		this.produit = produit;
		this.priorite = priorite;
		this.statut = statut;
		this.site = site;
	}

	
	public Ticket() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ticket_id")
	private Long idTicket;
	private String description;
	private String dateO;
	private String dateF;
	private String titre;
    private String solution;
//	private String DateM;
	@ManyToOne
	@JoinColumn(name="ID_PROD")
	private Produit produit ;
	@ManyToOne
	@JoinColumn(name="ID_PRIO")
	private Priorite priorite ;
	@ManyToOne
	@JoinColumn(name="ID_STATUT")
	private Statut statut ;
	@ManyToOne
	@JoinColumn(name="id_Site")
	private Site site;
	public Produit getProduit() {
		return produit;
	}
	public void setProduit(Produit produit) {
		this.produit = produit;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getDateO() {
		return dateO;
	}
	public void setDateO(String dateO) {
		this.dateO = dateO;
	}
	public String getDateF() {
		return dateF;
	}
	public void setDateF(String dateF) {
		this.dateF = dateF;
	}
	public String getTitre() {
		return titre;
	}
	public void setTitre(String titre) {
		this.titre = titre;
	}
	public Long getIdTicket() {
		return idTicket;
	}
	public void setIdTicket(Long idTicket) {
		this.idTicket = idTicket;
	}

	public Priorite getPriorite() {
		return priorite;
	}
	public void setPriorite(Priorite priorite) {
		this.priorite = priorite;
	}
	public String getSolution() {
		return solution;
	}
	public void setSolution(String solution) {
		this.solution = solution;
	}
	public Statut getStatut() {
		return statut;
	}
	public void setStatut(Statut statut) {
		this.statut = statut;
	}
	public Site getSite() {
		return site;
	}
	public void setSite(Site site) {
		this.site = site;
	}

}
