package org.sid.eboutique.controllers;



import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.sid.eboutique.entities.Categorie;
import org.sid.eboutique.entities.Produit;
import org.springframework.web.servlet.view.document.AbstractExcelView;

public class ExcelRevenueReportView extends AbstractExcelView{

	@Override
	protected void buildExcelDocument(Map model, HSSFWorkbook workbook,
		HttpServletRequest request, HttpServletResponse response)
		throws Exception {

		List<Produit> revenueData = (List<Produit>) model.get("revenueData");
		//create a wordsheet
		HSSFSheet sheet = workbook.createSheet("Liste Des Produits");
		sheet.setDefaultColumnWidth(25);
		  
        // create style for header cells
        CellStyle style = workbook.createCellStyle();
        Font font = workbook.createFont();
        font.setFontName("Arial");
        style.setFillForegroundColor(HSSFColor.BLUE.index);
        style.setFillPattern(CellStyle.SOLID_FOREGROUND);
        font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
        font.setColor(HSSFColor.WHITE.index);
        style.setFont(font);

		HSSFRow header = sheet.createRow(0);
		header.createCell(0).setCellValue("ID Modèle");
		header.getCell(0).setCellStyle(style);
		header.createCell(1).setCellValue("Nom Modèle");
		header.getCell(1).setCellStyle(style);
		header.createCell(2).setCellValue("Device Name");
		header.getCell(2).setCellStyle(style);
		header.createCell(3).setCellValue("Serial Number");
		header.getCell(3).setCellStyle(style);
		header.createCell(4).setCellValue("Product Number");
		header.getCell(4).setCellStyle(style);
		header.createCell(5).setCellValue("Fonction");
		header.getCell(5).setCellStyle(style);
		header.createCell(6).setCellValue("Sous Contrat de maintenance ?");
		header.getCell(6).setCellStyle(style);
		header.createCell(7).setCellValue("Date d'ajout");
		header.getCell(7).setCellStyle(style);

		int rowNum = 1;
		for (Produit  prod: revenueData) {
			//create the row data
			HSSFRow row = sheet.createRow(rowNum++);
			row.createCell(0).setCellValue(prod.getIdProduit());
			row.createCell(1).setCellValue(prod.getModele());
			row.createCell(2).setCellValue(prod.getCategorie().getNomCategorie());
			row.createCell(3).setCellValue(prod.getSerialNumber());
			row.createCell(4).setCellValue(prod.getProductNumber());
			row.createCell(5).setCellValue(prod.getFonction());
			row.createCell(6).setCellValue(prod.isSelectionne());
			row.createCell(7).setCellValue(prod.getDateAM());
                }
	}
}
