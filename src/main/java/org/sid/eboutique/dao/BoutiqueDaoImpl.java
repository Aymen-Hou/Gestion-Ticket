package org.sid.eboutique.dao;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.*;


import org.hibernate.Session;
import org.sid.eboutique.entities.Categorie;
import org.sid.eboutique.entities.Client;
import org.sid.eboutique.entities.Commande;
import org.sid.eboutique.entities.Commentaire;
import org.sid.eboutique.entities.HistProduit;
import org.sid.eboutique.entities.LigneCommande;
import org.sid.eboutique.entities.Panier;
import org.sid.eboutique.entities.Priorite;
import org.sid.eboutique.entities.Produit;
import org.sid.eboutique.entities.Role;
import org.sid.eboutique.entities.Site;
import org.sid.eboutique.entities.Statut;
import org.sid.eboutique.entities.Ticket;
import org.sid.eboutique.entities.User;
import org.sid.eboutique.entities.Localite;

public class BoutiqueDaoImpl implements IBoutiqueDAO {
	@PersistenceContext
	private EntityManager em;

	@Override
	public Long ajouterCategorie(Categorie c) {
		// TODO Auto-generated method stub
		em.persist(c);
		return c.getIdCategorie();
	}

	@Override
	public List<Categorie> listCategories(Long idSite) {
		// TODO Auto-generated method stub
		Query req = em.createQuery("select c from Categorie c where c.site.idSite=:x");
		req.setParameter("x", idSite);
		return req.getResultList();
	}

	@Override
	public Categorie getCategorie(Long idCat) {
		// TODO Auto-generated method stub
		return em.find(Categorie.class, idCat);
	}

	@Override
	public void supprimerCategrorie(Long idcat) {
		// TODO Auto-generated method stub
		Categorie c = em.find(Categorie.class, idcat);
		em.remove(c);	
	}

	@Override
	public void modifierCategorie(Categorie c) {
		// TODO Auto-generated method stub
		em.merge(c);
	}

	@Override
	public Long ajouterProduit(Produit p, Long idCat) {
		// TODO Auto-generated method stub
		Categorie c = getCategorie(idCat);
		p.setCategorie(c);
		em.persist(p);
		return p.getIdProduit();
	}

	@Override
	public List<Produit> listproduits(Long idSite) {
		// TODO Auto-generated method stub
		Query req = em.createQuery("select p from Produit p where p.site.idSite=:x");
		req.setParameter("x", idSite);
		return req.getResultList();
	}

	@Override
	public List<Produit> produitsParMotCle(String mc) {
		Query req = em.createQuery("select p from Produit p where p.designation like :x or p.description like :x");
		req.setParameter("x","%"+mc+"%");
		return req.getResultList();
	}

	@Override
	public List<Produit> produitsParCategorie(Long idCat) {
		Query req = em.createQuery("select p from Produit p where p.categorie.idCategorie=:x");
		req.setParameter("x", idCat);
		return req.getResultList();
		
	}

	@Override
	public List<Produit> produitsSelectionnes() {
		Query req = em.createQuery("select p from produit where p.selected=true");
		return req.getResultList();
	}

	@Override
	public Produit getProduit(Long idP) {
		// TODO Auto-generated method stub
		return em.find(Produit.class,idP);
	}

	@Override
	public void supprimerProduit(Long idP) {
		// TODO Auto-generated method stub
		Produit p= getProduit(idP);
		em.remove(p);
	}

	@Override
	public void modifierProduit(Produit p) {
		// TODO Auto-generated method stub
		em.merge(p);
	}

	@Override
	public void ajouterUser(User u) {
		// TODO Auto-generated method stub
		em.persist(u);
	}

	@Override
	public void attribuerRole(Role r, Long userID) {
		// TODO Auto-generated method stub
		User u = em.find(User.class,userID);
		u.getRoles().add(r);
		em.persist(r);
	}
	@Override
	public Commande enregistrerCommande(Panier p, Client c) {
		// TODO Auto-generated method stub
		em.persist(c);
		Commande cmd = new Commande();
		cmd.setDateCommande(new Date());
		cmd.setLigneCommandes(p.getItems());
		for(LigneCommande lc:p.getItems()){
			em.persist(lc);
		}
		em.persist(cmd);
		return cmd;
	}

	@Override
	public Long ajouterTicket(Ticket t) {
		// TODO Auto-generated method stub
		em.persist(t);
		return t.getIdTicket();
	}

	@Override
	public List<Ticket> listTickets() {
		// TODO Auto-generated method stub
		Query req = em.createQuery("select t from Ticket t");
		return req.getResultList();
	}

	@Override
	public Ticket getTicket(Long idTick) {
		// TODO Auto-generated method stub
		return em.find(Ticket.class, idTick);
	}

	@Override
	public void supprimerTicket(Long idTick) {
		// TODO Auto-generated method stub
		Ticket t= getTicket(idTick);
		em.remove(t);
	}

	@Override
	public void modifierTicket(Ticket t) {
		// TODO Auto-generated method stub
		em.merge(t);
	}

	@Override
	public List<Priorite> listPriorites() {
		// TODO Auto-generated method stub
		Query req = em.createQuery("select p from Priorite p");
		return req.getResultList();
	}

	@Override
	public List<Statut> listStatut() {
		// TODO Auto-generated method stub
		Query req = em.createQuery("select s from Statut s");
		return req.getResultList();
	}

	@Override
	public List<Localite> listLocalite() {
		// TODO Auto-generated method stub
		Query req = em.createQuery("select l from Localite l");
		return req.getResultList();
	}

	@Override
	public User getUser(String name) {
		// TODO Auto-generated method stub
		return em.find(User.class,name);
	}

	@Override
	public Site getSite(Long idSite) {
		// TODO Auto-generated method stub
		return em.find(Site.class,idSite);
	}

	@Override
	public Long ajouterHistProduit(String modele, String operation, Date date,
			int type,boolean actif,Long idSite) {
		// TODO Auto-generated method stub
		HistProduit hProd = new HistProduit(date,actif,operation,modele,type,idSite);
		em.persist(hProd);
		return null;
	}

	@Override
	public List<HistProduit> listHistorique(int type) {
		Query req = em.createQuery("select h from HistProduit h where h.type=:x");
		req.setParameter("x", type);
		return req.getResultList();
	}
	@Override
	public List<HistProduit> NewHistorique(int type) {
		long n = NbrHistorique(type);
		Query req = em.createQuery("select HistProduit from(select h from HistProduit h where h.type=:x order by idHProd asc limit 3) order by idHProd");

		req.setParameter("x", type);
		
		return req.getResultList();
		
		
	}

	@Override
	public long NbrHistorique(int type) {
		Query req =  em.createQuery("select count(h) from HistProduit h where h.type=:x and h.actif=:y");
		req.setParameter("x", type);
		req.setParameter("y", false);
		long count = (Long) req.getSingleResult();
		return count;
	}

	@Override
	public int ActifHistorique(int type) {
		// TODO Auto-generated method stub
		Query req =  em.createQuery("update HistProduit set actif =:y where type=:x");
		req.setParameter("x", type);
		req.setParameter("y", true);
		req.setHint("javax.persistence.query.timeout", 6000);
		return req.executeUpdate();
	}

	@Override
	public long ListNewTicket() {
		// TODO Auto-generated method stub
		Query req =  em.createQuery("select count(t) from Ticket t where t.statut.idStatut=:x");
		req.setParameter("x", 1L);
		long count = (Long) req.getSingleResult();
		return count;
	}

	@Override
	public long ListTraiTicket() {
		// TODO Auto-generated method stub
		Query req =  em.createQuery("select count(t) from Ticket t where t.statut.idStatut=:x");
		req.setParameter("x", 2L);
		long count = (Long) req.getSingleResult();
		return count;
	}

	@Override
	public long ListResolvedTicket() {
		// TODO Auto-generated method stub
		Query req =  em.createQuery("select count(t) from Ticket t where t.statut.idStatut=:x");
		req.setParameter("x", 3L);
		long count = (Long) req.getSingleResult();
		return count;
	}

	@Override
	public int getMonth(String date) {
		java.sql.Date dat = java.sql.Date.valueOf(date);
		Calendar cal = Calendar.getInstance();
		cal.setTime(dat);
		int month = cal.get(Calendar.MONTH);
		return month;
	}

	@Override
	public List<Integer> getMonthModele() {
		// TODO Auto-generated method stub
		Query req =  em.createQuery("select dateAM from Produit");
		int [] monTableau = new int[12];
		List<String> item = req.getResultList();
		List<Integer> intList = new ArrayList<Integer>();
		for(String i : item)
		{
           intList.add(new Integer(getMonth(i)));
		}
		return intList;
	}

	@Override
	public Long AjouterCommentaire(Long idTick , String comment) {
		// TODO Auto-generated method stub
		Commentaire com = new Commentaire();
		com.setId_Tick(idTick);
		com.setCommentaire(comment);
		em.persist(com);
		return com.getIdCom();
	}

	@Override
	public List<Commentaire> AffichageComment(Long idTick) {
		// TODO Auto-generated method stub
		Query req = em.createQuery("select c from Commentaire c where c.id_Tick=:x");
		req.setParameter("x", idTick);
		return req.getResultList();
	}

	@Override
	public Long getIdSiteByName(String name) {
		// TODO Auto-generated method stub
		Query req = em.createQuery("select u.site.idSite from User u where u.userName =:x");
		req.setParameter("x", name);
		return (Long) req.getSingleResult();
	}

	@Override
	public List<Ticket> listTicketsParSite(Long idSite) {
		// TODO Auto-generated method stub
		Query req = em.createQuery("select t from Ticket t where t.site.idSite=:x");
		req.setParameter("x", idSite);
		return req.getResultList();
	}

	@Override
	public List<Produit> listproduitsForAdminG() {
		// TODO Auto-generated method stub
		Query req = em.createQuery("select p from Produit p ");
		return req.getResultList();
	}

	@Override
	public List<Categorie> listcategoriesForAdminG() {
		// TODO Auto-generated method stub
		Query req = em.createQuery("select c from Categorie c ");
		return req.getResultList();
	}

	@Override
	public List<Ticket> listticketsForAdminG() {
		// TODO Auto-generated method stub
		Query req = em.createQuery("select t from Ticket t ");
		return req.getResultList();
	}

	@Override
	public String getNameSiteByName(String name) {
		// TODO Auto-generated method stub
		Query req = em.createQuery("select u.site.nameSite from User u where u.userName =:x");
		req.setParameter("x", name);
		return (String) req.getSingleResult();
	}

	@Override
	public Long NumberTicket(Long idSite) {
		// TODO Auto-generated method stub
		Query req =  em.createQuery("select count(t) from Ticket t where t.site.idSite=:x");
		req.setParameter("x", idSite);
		long count = (Long) req.getSingleResult();
		return count;
	}

	@Override
	public Long NumberProduits(Long idSite) {
		// TODO Auto-generated method stub
		Query req =  em.createQuery("select count(p) from Produit p where p.site.idSite=:x");
		req.setParameter("x", idSite);
		long count = (Long) req.getSingleResult();
		return count;
	}

	@Override
	public Long NumberTicket() {
		// TODO Auto-generated method stub
		Query req =  em.createQuery("select count(p) from Produit p");
		long count = (Long) req.getSingleResult();
		return count;
	}

	@Override
	public Long NumberProduits() {
		// TODO Auto-generated method stub
		Query req =  em.createQuery("select count(p) from Produit p");
		long count = (Long) req.getSingleResult();
		return count;
	}

	@Override
	public int UpdateSolution(Long idTicket , String Solution) {
		// TODO Auto-generated method stub
		Query req =  em.createQuery("update Ticket set solution =:y where idTicket=:x");
		req.setParameter("x", idTicket);
		req.setParameter("y", Solution);
		return req.executeUpdate();
	}

	@Override
	public int UpdateStatut(Long idTicket) {
		// TODO Auto-generated method stub
		Query req =  em.createQuery("update Ticket t set t.statut.idStatut =:y where idTicket=:x");
		req.setParameter("x", idTicket);
		req.setParameter("y", 3L);
		return req.executeUpdate();
	}

			
	}




