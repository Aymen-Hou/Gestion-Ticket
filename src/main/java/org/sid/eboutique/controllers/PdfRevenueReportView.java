package org.sid.eboutique.controllers;

import java.awt.Color;
import java.util.Date;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.sid.eboutique.entities.Ticket;
import org.springframework.web.servlet.view.document.AbstractPdfView;
import com.lowagie.text.Document;
import com.lowagie.text.Font;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfWriter;


public class PdfRevenueReportView extends AbstractPdfView{

	@Override
	protected void buildPdfDocument(Map model, Document document,
		PdfWriter writer, HttpServletRequest request,
		HttpServletResponse response) throws Exception {

		Ticket revenueData = (Ticket) model.get("revenueData");
		  Font catFont = new Font(Font.TIMES_ROMAN, 18,
		            Font.BOLD);
		  Font redFont = new Font(Font.TIMES_ROMAN, 12,
		            Font.NORMAL,Color.red);
		  Font subFont = new Font(Font.TIMES_ROMAN, 16,
		            Font.BOLD);
		   Font smallBold = new Font(Font.TIMES_ROMAN, 12,
		            Font.BOLD);
		
		Paragraph preface = new Paragraph();
		addEmptyLine(preface, 1);
        // We add one empty line
        preface.add(new Paragraph(
                "Report generated by: "  + new Date(), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
                smallBold));
        
        addEmptyLine(preface, 3);
        // Lets write a big header
        preface.add(new Paragraph("Rapport du Ticket", catFont));

        
        // Will create: Report generated by: _name, _date
        addEmptyLine(preface, 2);
        preface.add(new Paragraph(
               "Titre                         :         "+ revenueData.getTitre(),
               smallBold));
        addEmptyLine(preface, 1);
        preface.add(new Paragraph(
               "Description              :         "+ revenueData.getDescription(),
               smallBold));
        addEmptyLine(preface, 1);
        preface.add(new Paragraph(
        		"Date Ouverture        :         "+ revenueData.getDateO(),
        		smallBold));
        addEmptyLine(preface, 1);
        preface.add(new Paragraph(
        		"Date Fermeture        :         "+ revenueData.getDateF(),
        		smallBold));
        addEmptyLine(preface, 1);
        preface.add(new Paragraph(
        		"Equipement             :         "+ revenueData.getProduit().getSerialNumber(),
        		smallBold));
        addEmptyLine(preface, 1);
        preface.add(new Paragraph(
        		"Statut                      :         "+ revenueData.getStatut().getNameStatut(),
        		smallBold));
        addEmptyLine(preface, 1);
        preface.add(new Paragraph(
        		"Priorit�                     :         "+ revenueData.getPriorite().getNamePrio(),
        		smallBold));

        addEmptyLine(preface, 1);

        preface.add(new Paragraph(
                "This document is a preliminary version and not subject to your license agreement or any other agreement with vogella.com ;-).",
                redFont));
        document.add(preface);
        
		
	}
	private static void addEmptyLine(Paragraph paragraph, int number) {
        for (int i = 0; i < number; i++) {
            paragraph.add(new Paragraph(" "));
        }
	}}
