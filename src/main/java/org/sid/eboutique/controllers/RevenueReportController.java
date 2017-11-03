package org.sid.eboutique.controllers;



import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.sid.eboutique.entities.Produit;
import org.sid.eboutique.metier.IAdminCategoriesMetier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;
@Controller
@RequestMapping("/admin")

public class RevenueReportController extends AbstractController{
	@Autowired
	private IAdminCategoriesMetier metier;
	@RequestMapping("/excel")
	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest request,
		HttpServletResponse response) throws Exception {

		String output =
			ServletRequestUtils.getStringParameter(request, "output");

		//dummy data
	List<Produit>	revenueData = metier.listproduits(metier.getIdSiteByName(getName()));

	 if("EXCEL".equals(output.toUpperCase())){
			//return excel view
			return new ModelAndView("ExcelRevenueSummary","revenueData",revenueData);

		}
			//return normal view
		return	new ModelAndView("ExcelRevenueSummary","revenueData",revenueData);

		}
	public String getName(){
	    Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	    String name = auth.getName();
	    return name;
	}

	}

