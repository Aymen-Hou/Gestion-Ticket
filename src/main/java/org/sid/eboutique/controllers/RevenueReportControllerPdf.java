package org.sid.eboutique.controllers;



import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.sid.eboutique.entities.Ticket;
import org.sid.eboutique.metier.IAdminCategoriesMetier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;
@Controller
@RequestMapping("/admin")
public class RevenueReportControllerPdf extends AbstractController{
	@Autowired
	private IAdminCategoriesMetier metier;
	@RequestMapping("/pdf")
	
	protected ModelAndView handleRequestInternal(HttpServletRequest request,
		HttpServletResponse response , Long idTick) throws Exception {
		Ticket revenueData = metier.getTicket(idTick);
		return new ModelAndView("PdfRevenueSummary","revenueData",revenueData);

	}

	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
}
