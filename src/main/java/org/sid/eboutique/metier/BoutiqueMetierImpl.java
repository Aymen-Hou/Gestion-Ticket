package org.sid.eboutique.metier;

import java.util.Date;
import java.util.List;

import org.sid.eboutique.dao.IBoutiqueDAO;
import org.sid.eboutique.entities.Categorie;
import org.sid.eboutique.entities.Client;
import org.sid.eboutique.entities.Commande;
import org.sid.eboutique.entities.Commentaire;
import org.sid.eboutique.entities.HistProduit;
import org.sid.eboutique.entities.Panier;
import org.sid.eboutique.entities.Priorite;
import org.sid.eboutique.entities.Produit;
import org.sid.eboutique.entities.Role;
import org.sid.eboutique.entities.Site;
import org.sid.eboutique.entities.Statut;
import org.sid.eboutique.entities.Ticket;
import org.sid.eboutique.entities.User;
import org.sid.eboutique.entities.Localite;
import org.springframework.transaction.annotation.Transactional;
@Transactional
public class BoutiqueMetierImpl implements IAdminCategoriesMetier {
  private IBoutiqueDAO dao;
	@Override
	public Long ajouterProduit(Produit p, Long idCat) {
		// TODO Auto-generated method stub
		return dao.ajouterProduit(p, idCat);
	}

	@Override
	public void supprimerProduit(Long idP) {
		// TODO Auto-generated method stub
		dao.supprimerProduit(idP);
	}

	@Override
	public void modifierProduit(Produit p) {
		// TODO Auto-generated method stub
		dao.modifierProduit(p);
	}

	@Override
	public Categorie getCategorie(Long idCat) {
		// TODO Auto-generated method stub
		return dao.getCategorie(idCat);
	}

	@Override
	public List<Produit> listproduits(Long idSite) {
		// TODO Auto-generated method stub
		return dao.listproduits(idSite);
	}

	@Override
	public List<Produit> produitsParMotCle(String mc) {
		// TODO Auto-generated method stub
		return dao.produitsParMotCle(mc);
	}

	@Override
	public List<Produit> produitsParCategorie(Long idCat) {
		// TODO Auto-generated method stub
		return dao.produitsParCategorie(idCat);
	}

	@Override
	public List<Produit> produitsSelectionnes() {
		// TODO Auto-generated method stub
		return dao.produitsSelectionnes();
	}

	@Override
	public Produit getProduit(Long idP) {
		// TODO Auto-generated method stub
		return dao.getProduit(idP);
	}

	@Override
	public Commande enregistrerCommande(Panier p, Client c) {
		// TODO Auto-generated method stub
		return dao.enregistrerCommande(p, c);
	}

	@Override
	public Long ajouterCategorie(Categorie c) {
		// TODO Auto-generated method stub
		return dao.ajouterCategorie(c);
	}

	@Override
	public void supprimerCategrorie(Long idcat) {
		// TODO Auto-generated method stub
		dao.supprimerCategrorie(idcat);
	}

	@Override
	public void modifierCategorie(Categorie c) {
		// TODO Auto-generated method stub
		dao.modifierCategorie(c);
	}

	@Override
	public void ajouterUser(User u) {
		// TODO Auto-generated method stub
		dao.ajouterUser(u);
	}

	@Override
	public void attribuerRole(Role r, Long userID) {
		// TODO Auto-generated method stub
		dao.attribuerRole(r, userID);
	}

	public void setDao(IBoutiqueDAO dao) {
		this.dao = dao;
	}

	@Override
	public Long ajouterTicket(Ticket t) {
		// TODO Auto-generated method stub
		return dao.ajouterTicket(t);
	}

	@Override
	public List<Ticket> listTickets() {
		// TODO Auto-generated method stub
		return dao.listTickets();
	}

	@Override
	public Ticket getTicket(Long idTick) {
		// TODO Auto-generated method stub
		return dao.getTicket(idTick);
	}

	@Override
	public void supprimerTicket(Long idTick) {
		// TODO Auto-generated method stub
		dao.supprimerTicket(idTick);
	}

	@Override
	public void modifierTicket(Ticket t) {
		// TODO Auto-generated method stub
		dao.ajouterTicket(t);
	}

	@Override
	public List<Priorite> listPriorites() {
		// TODO Auto-generated method stub
		return dao.listPriorites();
	}

	@Override
	public List<Statut> listStatut() {
		// TODO Auto-generated method stub
		return dao.listStatut();
	}

	@Override
	public List<Localite> listLocalite() {
		// TODO Auto-generated method stub
		return dao.listLocalite();
	}

	@Override
	public User getUser(String name) {
		// TODO Auto-generated method stub
		return dao.getUser(name);
	}

	@Override
	public Site getSite(Long idSite) {
		// TODO Auto-generated method stub
		return dao.getSite(idSite);
	}

	@Override
	public List<Categorie> listCategories(Long idSite) {
		// TODO Auto-generated method stub
		return dao.listCategories(idSite);
	}

	@Override
	public Long ajouterHistProduit(String modele, String operation, Date date
			,int type,boolean actif,Long idSite) {
		// TODO Auto-generated method stub
		dao.ajouterHistProduit(modele,operation, date, type,actif,idSite);
		return null;
	}

	@Override
	public List<HistProduit> listHistorique(int type) {
		// TODO Auto-generated method stub
		return dao.listHistorique(type);
	}

	@Override
	public long NbrHistorique(int type) {
		// TODO Auto-generated method stub
		return dao.NbrHistorique(type);
	}

	@Override
	public int ActifHistorique(int type) {
		// TODO Auto-generated method stub
		
		return dao.ActifHistorique(type);
	}

	@Override
	public long ListNewTicket() {
		// TODO Auto-generated method stub
		return dao.ListNewTicket();
	}

	@Override
	public long ListTraiTicket() {
		// TODO Auto-generated method stub
		return dao.ListTraiTicket();
	}

	@Override
	public long ListResolvedTicket() {
		// TODO Auto-generated method stub
		return dao.ListResolvedTicket();
	}

	@Override
	public int getMonth(String date) {
		// TODO Auto-generated method stub
		return dao.getMonth(date);
	}

	@Override
	public List<Integer> getMonthModele() {
		// TODO Auto-generated method stub
		return dao.getMonthModele();
	}

	@Override
	public Long AjouterCommentaire(Long idTick,String comment) {
		// TODO Auto-generated method stub
		return dao.AjouterCommentaire(idTick,comment);
	}

	@Override
	public List<Commentaire> AffichageComment(Long idTick) {
		// TODO Auto-generated method stub
		return dao.AffichageComment(idTick);
	}

	@Override
	public Long getIdSiteByName(String name) {
		// TODO Auto-generated method stub
		return dao.getIdSiteByName(name);
	}

	@Override
	public List<Ticket> listTicketsParSite(Long idSite) {
		// TODO Auto-generated method stub
		return dao.listTicketsParSite(idSite);
	}

	@Override
	public List<Produit> listproduitsForAdminG() {
		// TODO Auto-generated method stub
		return dao.listproduitsForAdminG();
	}

	@Override
	public List<Categorie> listcategoriesForAdminG() {
		// TODO Auto-generated method stub
		return dao.listcategoriesForAdminG();
	}

	@Override
	public List<Ticket> listticketsForAdminG() {
		// TODO Auto-generated method stub
		return dao.listticketsForAdminG();
	}

	@Override
	public String getNameSiteByName(String name) {
		// TODO Auto-generated method stub
		return dao.getNameSiteByName(name);
	}

	@Override
	public Long NumberTicket(Long idSite) {
		// TODO Auto-generated method stub
		return dao.NumberTicket(idSite);
	}

	@Override
	public Long NumberProduits(Long idSite) {
		// TODO Auto-generated method stub
		return dao.NumberProduits(idSite);
	}

	@Override
	public Long NumberTicket() {
		// TODO Auto-generated method stub
		return dao.NumberTicket();
	}

	@Override
	public Long NumberProduits() {
		// TODO Auto-generated method stub
		return dao.NumberProduits();
	}

	@Override
	public int UpdateSolution(Long idTicket, String Solution) {
		// TODO Auto-generated method stub
		return dao.UpdateSolution(idTicket, Solution);
	}

	@Override
	public int UpdateStatut(Long idTicket) {
		// TODO Auto-generated method stub
		return dao.UpdateStatut(idTicket);
	}

	@Override
	public List<HistProduit> NewHistorique(int type) {
		// TODO Auto-generated method stub
		return dao.NewHistorique(type);
	}






}
