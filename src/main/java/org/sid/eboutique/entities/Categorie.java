package org.sid.eboutique.entities;

import java.io.Serializable;
import java.util.*;

import javax.persistence.*;
import javax.validation.constraints.Size;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
public class Categorie implements Serializable {

public Categorie(String nomCategorie, String dateA, Site site,
		Collection<Produit> produits, Localite localite) {
	super();
	this.nomCategorie = nomCategorie;
	this.dateA = dateA;
	this.site = site;
	this.produits = produits;
	this.localite = localite;
}
public Categorie() {
		super();
		// TODO Auto-generated constructor stub
	}
@Id
@GeneratedValue
private Long idCategorie;

private String nomCategorie; private String dateA;

@ManyToOne
@JoinColumn(name="id_Site")
private Site site;
@OneToMany(mappedBy="categorie")
private Collection<Produit> produits=new ArrayList<Produit>();
@ManyToOne
@JoinColumn(name="ID_LOC")
private Localite localite = new Localite();
// Getters et Setters
// Constructeurs sans paramètre et avec paramètres
public Long getIdCategorie() {
	return idCategorie;
}
public void setIdCategorie(Long idCategorie) {
	this.idCategorie = idCategorie;
}
public String getNomCategorie() {
	return nomCategorie;
}
public void setNomCategorie(String nomCategorie) {
	this.nomCategorie = nomCategorie;
}
public Collection<Produit> getProduits() {
	return produits;
}
public void setProduits(Collection<Produit> produits) {
	this.produits = produits;
}
public String getDateA() {
	return dateA;
}
public void setDateA(String dateA) {
	this.dateA = dateA;
}
public Localite getLocalite() {
	return localite;
}
public void setLocalite(Localite Localite) {
	this.localite = Localite;
}
public Site getSite() {
	return site;
}
public void setSite(Site site) {
	this.site = site;
}

}