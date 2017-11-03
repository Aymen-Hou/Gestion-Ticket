package org.sid.eboutique.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.*;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;
@Entity
public class Produit implements Serializable {
@Id
@GeneratedValue(strategy=GenerationType.IDENTITY)
private Long idProduit;
public Produit() {
	super();
	// TODO Auto-generated constructor stub
}
@OneToMany(mappedBy="produit")
private Collection<Ticket> tickets=new ArrayList<Ticket>();
public Long getIdProduit() {
	return idProduit;
}
public void setIdProduit(Long idProduit) {
	this.idProduit = idProduit;
}

public boolean isSelectionne() {
	return selectionne;
}
public void setSelectionne(boolean selectionne) {
	this.selectionne = selectionne;
}
public Categorie getCategorie() {
	return categorie;
}
public void setCategorie(Categorie categorie) {
	this.categorie = categorie;
}
private String modele; 
private String fonction;
private String serialNumber;
private String productNumber;
private String dateAM;
private boolean selectionne;
public Produit(String modele, String fonction,
		String serialNumber, String productNumber, String dateAM,
		boolean selectionne) {
	super();
	this.modele = modele;
	this.fonction = fonction;
	this.dateAM = dateAM;
	this.selectionne = selectionne;
	
}
public String getSerialNumber() {
	return serialNumber;
}
public void setSerialNumber(String serialNumber) {
	this.serialNumber = serialNumber;
}
public Collection<Ticket> getTickets() {
	return tickets;
}
public void setTickets(Collection<Ticket> tickets) {
	this.tickets = tickets;
}
public String getModele() {
	return modele;
}
public void setModele(String modele) {
	this.modele = modele;
}

public String getFonction() {
	return fonction;
}
public void setFonction(String fonction) {
	this.fonction = fonction;
}

public String getDateAM() {
	return dateAM;
}
public void setDateAM(String dateAM) {
	this.dateAM = dateAM;
}
@ManyToOne
@JoinColumn(name="id_Site")
private Site site;
@ManyToOne
@JoinColumn(name="ID_CAT")
private Categorie categorie;
// Getters et Setters
// Cosntructeur sans paramètre
// Cosntructeur avec paramètres
public String getProductNumber() {
	return productNumber;
}
public void setProductNumber(String productNumber) {
	this.productNumber = productNumber;
}
public Site getSite() {
	return site;
}
public void setSite(Site site) {
	this.site = site;
}

}