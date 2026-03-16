package com.cnu.utils;

import java.io.File;
import java.io.FileOutputStream;
import java.util.List;

import org.springframework.stereotype.Component;

import com.cnu.entity.CitizenPlan;
import com.itextpdf.text.Document;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class PdfGenerator {
	
	public void generate(HttpServletResponse response, List<CitizenPlan> plans, File file) throws Exception {
		
		Document document = new Document(PageSize.A4);
		//PdfWriter.getInstance(document, response.getOutputStream());
		PdfWriter.getInstance(document, new FileOutputStream(file));
	    
		document.open();

	    Font fontTitle = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
	    fontTitle.setSize(18);

	    Paragraph title = new Paragraph("Citizen Plans Info", fontTitle);
	    title.setAlignment(Paragraph.ALIGN_CENTER);

	    document.add(title);

	    PdfPTable table = new PdfPTable(7);
	    table.setWidthPercentage(100);
	    table.setSpacingBefore(10);

	    table.addCell("ID");
	    table.addCell("Citizen Name");
	    table.addCell("Plan Name");
	    table.addCell("Plan Status");
	    table.addCell("Gender");
	    table.addCell("Start Date");
	    table.addCell("End Date");

	    for (CitizenPlan plan : plans) {

	        table.addCell(String.valueOf(plan.getCitizenId()));
	        table.addCell(plan.getCitizenName());
	        table.addCell(plan.getPlanName());
	        table.addCell(plan.getPlanStatus());
	        table.addCell(plan.getGender());

	        table.addCell(plan.getPlanStartDate() != null ? plan.getPlanStartDate().toString() : "N/A");
	        table.addCell(plan.getPlanEndDate() != null ? plan.getPlanEndDate().toString() : "N/A");
	    }
	    
	    document.add(table);
	    document.close();
	    
	    ServletOutputStream outputStream = response.getOutputStream();
        java.nio.file.Files.copy(file.toPath(), outputStream);
        outputStream.close();
		
	}

}
