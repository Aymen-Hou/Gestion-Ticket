package org.sid.eboutique.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.sid.eboutique.entities.Categorie;
import org.sid.eboutique.metier.IAdminCategoriesMetier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

@Controller
@SessionAttributes("nameSite")
@RequestMapping("/admin")
public class AdminController {
	@Autowired
	private IAdminCategoriesMetier metier;
	@RequestMapping("/index")
	public String index(Model model){
	    Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	    String name = auth.getName();
	/*    UserDetails customUser = (UserDetails)auth.getPrincipal();
	    User u = metier.getUser(customUser.getUsername()); 
	    model.addAttribute("userId", u.getPassword());*/
	model.addAttribute("username", name);
	model.addAttribute("categorie", new Categorie());
	model.addAttribute("categories", metier.listCategories(metier.getIdSiteByName(getName())));
	
	return "admin";
	}
	public String getName(){
	    Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	    String name = auth.getName();
	    return name;
	}

	@RequestMapping("/saveCat")
	public String saveCat(@Valid Categorie c,BindingResult bindingResult,
	Model model,MultipartFile file) throws Exception{
		if(bindingResult.hasErrors()){
			model.addAttribute("categories", metier.listCategories(metier.getIdSiteByName(getName())));
			model.addAttribute("localites", metier.listLocalite());
			return "categories";
	}
		if(c.getIdCategorie()!= null)
		{	
			Categorie cat= metier.getCategorie(c.getIdCategorie());
			
			metier.modifierCategorie(c);
		}else
		metier.ajouterCategorie(c);
		model.addAttribute("categorie", new Categorie());
		model.addAttribute("categories", metier.listCategories(metier.getIdSiteByName(getName())));
		model.addAttribute("localites", metier.listLocalite());
		return "categories";
		
	}
	@RequestMapping("/suppCat")
	public String sup(Long idCat , Model model){
	metier.supprimerCategrorie(idCat);
	model.addAttribute("categorie", new Categorie());
	model.addAttribute("categories", metier.listCategories(metier.getIdSiteByName(getName())));
	model.addAttribute("localites", metier.listLocalite());
	return "categories";
	}
	@RequestMapping("/editCat")
	public String Edit( Long idCat , Model model){
	Categorie c = metier.getCategorie(idCat);
	model.addAttribute("categorie", c);
	model.addAttribute("categories", metier.listCategories(metier.getIdSiteByName(getName())));
	model.addAttribute("localites", metier.listLocalite());
	return "categories";
	}
	@RequestMapping("/modeleCat")
	public String Modeles(Long idCat , Model model){
		Categorie c = metier.getCategorie(idCat);
		model.addAttribute("categorie", c);
	    model.addAttribute("modele",metier.produitsParCategorie(c.getIdCategorie()));
			return "modele";
	}
	@RequestMapping("/addUser")
	public String AddUser(Long idCat , Model model){
	return "admin/adduser";
	}
	
	@RequestMapping("/dashboard")
	public String dashboard(Model model){
	model.addAttribute("NbrHistoriquesMod",metier.NbrHistorique(1));
	model.addAttribute("NbrHistoriquesTick",metier.NbrHistorique(3));
	model.addAttribute("NbrHistoriquesDevices",metier.NbrHistorique(2));
	model.addAttribute("NewTick",metier.ListNewTicket());
	model.addAttribute("TraitTick",metier.ListTraiTicket());
	model.addAttribute("ResolvedTick",metier.ListResolvedTicket());
	model.addAttribute("tickets", metier.listTicketsParSite(metier.getIdSiteByName(getName())));
	model.addAttribute("nameSite",metier.getNameSiteByName(getName()));
	model.addAttribute("NumberT",metier.NumberTicket(metier.getIdSiteByName(getName())));
	model.addAttribute("NumberP",metier.NumberProduits(metier.getIdSiteByName(getName())));
	//model.addAttribute("date",metier.getMonthModele());
	
	return "admin/dashboard";
	}
	@RequestMapping("/comment/{idTick}/{name}")
	public String ListTicket(Model model,@PathVariable Long idTick, @PathVariable String name){
		model.addAttribute("tickets", metier.listTicketsParSite(metier.getIdSiteByName(getName())));
		model.addAttribute("commentaire",metier.AjouterCommentaire(idTick,name));
	return "admin/listTicket";
	}



	@RequestMapping("/ListTicket")
	public String ListTicket(Model model){
		model.addAttribute("tickets", metier.listTicketsParSite(metier.getIdSiteByName(getName())));
	return "admin/listTicket";
	}
	@RequestMapping("/ListDevices")
	public String ListDevices(Model model){
		model.addAttribute("categories", metier.listCategories(metier.getIdSiteByName(getName())));
	return "admin/listdevices";
	}
	@RequestMapping("/ListModeles")
	public String ListModeles(Long idCat , Model model){
		model.addAttribute("produits",metier.listproduits(metier.getIdSiteByName(getName())));
	return "admin/listmodeles";
	}
	@RequestMapping("/historique")
	public String historique(int type , Model model){
	model.addAttribute("historiques",metier.listHistorique(type));
	model.addAttribute("historique",metier.ActifHistorique(type));
	//model.addAttribute("Newhistorique",metier.NewHistorique(type));
	return "admin/historique";
	
	}
	@RequestMapping("/graph")
	public String graph(Long idCat , Model model){
	return "admin/graph";
	}
	}