package org.sid.eboutique.controllers;


import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.sid.eboutique.entities.Categorie;
import org.sid.eboutique.entities.Site;
import org.sid.eboutique.entities.Statut;
import org.sid.eboutique.entities.Ticket;
import org.sid.eboutique.metier.IAdminProduitsMetier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/adminTick")
public class AdminTicketController {
	@Autowired
	private IAdminProduitsMetier metier;
	@RequestMapping("/index")
	public String index(Model model){
		
		model.addAttribute("ticket", new Ticket());
		model.addAttribute("tickets", metier.listTicketsParSite(metier.getIdSiteByName(getName())));
		model.addAttribute("priorites", metier.listPriorites());
		model.addAttribute("produits", metier.listproduits(metier.getIdSiteByName(getName())));
		model.addAttribute("statuts", metier.listStatut());
		return "createTicket";
	}
	public String getName(){
	    Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	    String name = auth.getName();
	    return name;
	}

@RequestMapping("/saveTick")
public String saveCat(@Valid Ticket t,
Model model,HttpServletResponse response,BindingResult bindingResult) throws Exception{
	Site s = new Site();
	if(t.getIdTicket()!= null)
	{
		
		Ticket tick= metier.getTicket(t.getIdTicket());	
		s.setIdSite(metier.getIdSiteByName(getName()));
		t.setSite(s);
		metier.modifierTicket(t);
		metier.ajouterHistProduit(t.getTitre(), "Edition", new Date(),3,false,metier.getIdSiteByName(getName()));
	}else if(t.getIdTicket()== null){
	
	s.setIdSite(metier.getIdSiteByName(getName()));
	t.setSite(s);
	metier.ajouterTicket(t);
	metier.ajouterHistProduit(t.getTitre(), "Ajout", new Date(),3,false,metier.getIdSiteByName(getName()));

	}
	model.addAttribute("ticket", new Ticket());
	model.addAttribute("priorites", metier.listPriorites());
	model.addAttribute("produits", metier.listproduits(metier.getIdSiteByName(getName())));
	model.addAttribute("statuts", metier.listStatut());
    String redirectURL = "/eboutique/adminTick/index";
    response.sendRedirect(redirectURL);
	return "createTicket";
	
}

@RequestMapping("/suppTick")
public String sup(Long idTick , Model model){
Ticket t = metier.getTicket(idTick);	
metier.ajouterHistProduit(t.getTitre(), "Suppression", new Date(),3,false,metier.getIdSiteByName(getName()));
metier.supprimerTicket(idTick);
model.addAttribute("tickets", metier.listTicketsParSite(metier.getIdSiteByName(getName())));
model.addAttribute("priorites", metier.listPriorites());
model.addAttribute("produits", metier.listproduits(metier.getIdSiteByName(getName())));
model.addAttribute("statuts", metier.listStatut());
return "createTicket";
}
@RequestMapping("/editTick")
public String Edit( Long idTick , Model model){
Ticket t = metier.getTicket(idTick);
model.addAttribute("ticket", t);
model.addAttribute("priorites", metier.listPriorites());
model.addAttribute("produits", metier.listproduits(metier.getIdSiteByName(getName())));
model.addAttribute("statuts", metier.listStatut());
model.addAttribute("tickets", metier.listTicketsParSite(metier.getIdSiteByName(getName())));
return "createTicket";
}
@RequestMapping("/listTickets")
public String ListTickets(Model model){
	model.addAttribute("tickets", metier.listTicketsParSite(metier.getIdSiteByName(getName())));
	return "tickets";
}
@RequestMapping("/detailTickets")
public String DetailTickets( Long idTick , Model model){
	Ticket t = metier.getTicket(idTick);
	model.addAttribute("ticket", t);
	
	return "detailTickets";
}
@RequestMapping("/solutionTickets")
public String SolutionTickets( Long idTick , Model model){	
	Ticket t = metier.getTicket(idTick);
	model.addAttribute("ticket", t);
	model.addAttribute("commentaire",metier.AffichageComment(idTick));
	return "solution";
}
@RequestMapping("/saveSolution")
public String SaveSolution(@Valid Ticket t ,BindingResult bindingResult,
Model model ,HttpServletResponse response ,MultipartFile file) throws Exception{
	if(bindingResult.hasErrors()){
		model.addAttribute("tickets", metier.listTicketsParSite(metier.getIdSiteByName(getName())));
		return "createTicket";
}
	if(t.getIdTicket()!= null)
	{
		
		Ticket tick= metier.getTicket(t.getIdTicket());
		
		metier.UpdateSolution(t.getIdTicket(), t.getSolution());
		metier.UpdateStatut(t.getIdTicket());
	}
	model.addAttribute("ticket", new Ticket());
    String redirectURL = "/eboutique/adminTick/listTickets";
    response.sendRedirect(redirectURL);
	return "createTicket";
}

@RequestMapping("/optTickets")
public String OptTickets(Model model){
	model.addAttribute("tickets", metier.listTicketsParSite(metier.getIdSiteByName(getName())));
	return "operationsTickets";
}
}
