package org.sid.eboutique.controllers;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Date;

import javax.imageio.ImageIO;
import javax.imageio.stream.FileImageInputStream;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import javax.xml.ws.Response;

import org.apache.commons.io.IOUtils;
import org.sid.eboutique.entities.Categorie;
import org.sid.eboutique.entities.Produit;
import org.sid.eboutique.entities.Site;
import org.sid.eboutique.metier.IAdminCategoriesMetier;
import org.sid.eboutique.metier.IAdminProduitsMetier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.HandlerExceptionResolver;

	@Controller
	@RequestMapping("/adminProd")
	public class AdminProduitsController  {
	@Autowired
	private IAdminProduitsMetier metier;
	@RequestMapping("/index")
	public String index(Model model){
	model.addAttribute("produit", new Produit());
	model.addAttribute("produits", metier.listproduits(metier.getIdSiteByName(getName())));
	model.addAttribute("categories", metier.listCategories(metier.getIdSiteByName(getName())));
	return "produits";
}
	public String getName(){
	    Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	    String name = auth.getName();
	    return name;
	}

@RequestMapping("/saveProd")
public String saveProd(@Valid Produit p,BindingResult bindingResult,
Model model, HttpServletResponse response) throws Exception{
Site s = new Site();
if(p.getIdProduit()!= null)
{	
	Produit pr= metier.getProduit(p.getIdProduit());
	s.setIdSite(metier.getIdSiteByName(getName()));
    p.setSite(s);
	metier.modifierProduit(p);
	metier.ajouterHistProduit(p.getSerialNumber(), "Edition", new Date(),1,false,metier.getIdSiteByName(getName()));
}else if((p.getIdProduit()== null)){
	
	s.setIdSite(metier.getIdSiteByName(getName()));
    p.setSite(s);
	metier.ajouterProduit(p,  p.getCategorie().getIdCategorie());
    metier.ajouterHistProduit(p.getSerialNumber(), "Ajout", new Date(),1,false,metier.getIdSiteByName(getName()));

}
	model.addAttribute("produit", new Produit());
	model.addAttribute("produits", metier.listproduits(metier.getIdSiteByName(getName())));
	model.addAttribute("categories", metier.listCategories(metier.getIdSiteByName(getName())));

	return "produits";

}

@RequestMapping("/suppProd")
public String sup(Long idProd , Model model){
Produit p = metier.getProduit(idProd);
metier.ajouterHistProduit(p.getSerialNumber(), "Suppression", new Date(),1,false,metier.getIdSiteByName(getName()));
metier.supprimerProduit(idProd);
model.addAttribute("produit", new Produit());
model.addAttribute("produits", metier.listproduits(metier.getIdSiteByName(getName())));
model.addAttribute("categories", metier.listCategories(metier.getIdSiteByName(getName())));
return "produits";
}
@RequestMapping("/editProd")
public String Edit( Long idProd , Model model){
Produit p = metier.getProduit(idProd);
model.addAttribute("produit", p);
model.addAttribute("produits", metier.listproduits(metier.getIdSiteByName(getName())));
model.addAttribute("categories", metier.listCategories(metier.getIdSiteByName(getName())));
return "produits";
}

}
