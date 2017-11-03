package org.sid.eboutique.controllers;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Date;
import java.util.List;

import javax.imageio.ImageIO;
import javax.imageio.stream.ImageOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.apache.commons.io.IOUtils;
import org.sid.eboutique.entities.Categorie;
import org.sid.eboutique.entities.Produit;
import org.sid.eboutique.entities.Site;
import org.sid.eboutique.entities.User;
import org.sid.eboutique.metier.IAdminCategoriesMetier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

@Controller
@SessionAttributes("nameSite")
@RequestMapping("/adminCat")
public class AdminCategoriesController implements HandlerExceptionResolver{
@Autowired
private IAdminCategoriesMetier metier;
static int i=0;
@RequestMapping("/index")
public String index(Model model){
i++;
/*    UserDetails customUser = (UserDetails)auth.getPrincipal();
    User u = metier.getUser(customUser.getUsername()); 
    model.addAttribute("userId", u.getPassword());*/
model.addAttribute("username", getName());
model.addAttribute("categorie", new Categorie());
model.addAttribute("categories", metier.listCategories(metier.getIdSiteByName(getName())));
model.addAttribute("localites", metier.listLocalite());
Long valueIdSite = metier.getIdSiteByName(getName());
model.addAttribute("idSite",valueIdSite);
model.addAttribute("nameSite",metier.getNameSiteByName(getName()));
return "categories";
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
}    Site s = new Site();
	if(c.getIdCategorie()!= null)
	{	
		Categorie cat= metier.getCategorie(c.getIdCategorie());
		s.setIdSite(metier.getIdSiteByName(getName()));
	    c.setSite(s);
		metier.modifierCategorie(c);
		metier.ajouterHistProduit(c.getNomCategorie(),"Edition", new Date(),2,false,metier.getIdSiteByName(getName()));
	}else if(c.getIdCategorie()== null){
		
		s.setIdSite(metier.getIdSiteByName(getName()));
	    c.setSite(s);
	    metier.ajouterCategorie(c);
	metier.ajouterHistProduit(c.getNomCategorie(), "Ajout", new Date(),2,false,metier.getIdSiteByName(getName()));
	}
	model.addAttribute("categorie", new Categorie());
	model.addAttribute("categories", metier.listCategories(metier.getIdSiteByName(getName())));
	model.addAttribute("localites", metier.listLocalite());
	return "categories";
	
}

@Override
public ModelAndView resolveException(HttpServletRequest request,
		HttpServletResponse response, Object obj, Exception ex) {
	ModelAndView mv = new ModelAndView();
	mv.addObject("categorie", new Categorie());
	mv.addObject("categories", metier.listCategories(metier.getIdSiteByName(getName())));
	mv.addObject("exception",ex.getMessage());
	mv.setViewName("categories");
	return mv;
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
}