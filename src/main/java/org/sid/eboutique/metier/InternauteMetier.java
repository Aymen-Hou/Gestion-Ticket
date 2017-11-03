package org.sid.eboutique.metier;

import java.util.Date;
import java.util.List;

import org.sid.eboutique.entities.*;

public interface InternauteMetier {
	public List<Categorie> listCategories(Long idSite);
	public Categorie getCategorie(Long idCat);
	public List<Produit> listproduits(Long idSite);
	public List<Produit> produitsParMotCle(String mc);
	public List<Produit> produitsParCategorie(Long idCat);
	public List<Produit> produitsSelectionnes();
	public Produit getProduit(Long idP);
	public Commande enregistrerCommande(Panier p,Client c);
	public Long ajouterTicket(Ticket t);
	public List<Ticket> listTickets();
	public Ticket getTicket(Long idTick);
	public void supprimerTicket(Long idTick);
	public void modifierTicket(Ticket t);
	public List<Priorite> listPriorites();
	public List<Statut> listStatut();
	public List<Localite> listLocalite();
	public User getUser(String name);
	public Site getSite(Long idSite);
	public Long ajouterHistProduit(String modele, String operation , Date date ,int type,boolean actif,Long idSite);
	public List<HistProduit> listHistorique(int type);
	public long NbrHistorique(int type);
	public int ActifHistorique(int type);
	public long ListNewTicket();
	public long ListTraiTicket();
	public long ListResolvedTicket();
	public int getMonth(String date);
	public List<Integer> getMonthModele();
	public Long AjouterCommentaire(Long idTick,String commment);
	public List<Commentaire> AffichageComment(Long idTick);
	public Long getIdSiteByName(String name);
	public List<Ticket> listTicketsParSite(Long idSite);
	public List<Produit> listproduitsForAdminG();
	public List<Categorie> listcategoriesForAdminG();
	public List<Ticket> listticketsForAdminG();
	public String getNameSiteByName(String name);
	public Long NumberTicket(Long idSite);
	public Long NumberProduits(Long idSite);
	public Long NumberTicket();
	public Long NumberProduits();
	public int UpdateSolution(Long idTicket , String Solution);
	public int UpdateStatut(Long idTicket);
	public List<HistProduit> NewHistorique(int type);
}
