package org.sid.eboutique.entities;

import java.io.Serializable;
import javax.persistence.*;
@Entity
public class LigneCommande implements Serializable {
@Id
@GeneratedValue(strategy=GenerationType.IDENTITY)
private Long id;
@ManyToOne
@JoinColumn(name="idproduit")
private Produit produit;
private int quantite;
private double prix;
@ManyToOne
@JoinColumn(name="idCommande")
private Commande commande;
// Getters et Setters
// Cosntructeur sans param�tre
// Cosntructeur avec param�tres
public Long getId() {
	return id;
}
public void setId(Long id) {
	this.id = id;
}
public LigneCommande(Long id, Produit produit, int quantite, double prix) {
	super();
	this.id = id;
	this.produit = produit;
	this.quantite = quantite;
	this.prix = prix;
}
public Produit getProduit() {
	return produit;
}
public void setProduit(Produit produit) {
	this.produit = produit;
}
public int getQuantite() {
	return quantite;
}
public void setQuantite(int quantite) {
	this.quantite = quantite;
}
public LigneCommande() {
	super();
	// TODO Auto-generated constructor stub
}
public double getPrix() {
	return prix;
}
public void setPrix(double prix) {
	this.prix = prix;
}
}
