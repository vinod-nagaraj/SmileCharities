package com.smile.donate.util;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.time.LocalDate;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.smile.donate.constant.ApplicationConstants;
import com.smile.donate.entity.Donation;

@Component
public class GeneratePdfReport {
	

    private static final Logger logger = LoggerFactory.getLogger(GeneratePdfReport.class);

    public static Document taxReport(Donation donation) throws FileNotFoundException, DocumentException {

    	//OutputStream file = new FileOutputStream(new File("taxreport.pdf"));
        Document document = new Document();
       // PdfWriter writer = PdfWriter.getInstance(document, file);
       // ByteArrayOutputStream out = new ByteArrayOutputStream();

        try {

            PdfPTable table = new PdfPTable(3);
            table.setWidthPercentage(60);
            table.setWidths(new int[]{1, 3, 3});

            Font headFont = FontFactory.getFont(FontFactory.HELVETICA_BOLD);

            PdfPCell hcell;
            hcell = new PdfPCell(new Phrase(ApplicationConstants.APP_NAME, headFont));
            hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
            table.addCell(hcell);

			/*
			 * hcell = new PdfPCell(new Phrase("Name", headFont));
			 * hcell.setHorizontalAlignment(Element.ALIGN_CENTER); table.addCell(hcell);
			 */
			/*
			 * hcell = new PdfPCell(new Phrase("Population", headFont));
			 * hcell.setHorizontalAlignment(Element.ALIGN_CENTER); table.addCell(hcell);
			 */

			/*
			 * PdfPCell cell;
			 * 
			 * cell = new PdfPCell(new Phrase(ApplicationConstants.APP_NAME));
			 * cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
			 * cell.setHorizontalAlignment(Element.ALIGN_CENTER); table.addCell(cell);
			 * 
			 * cell = new PdfPCell(new Phrase(LocalDate.now().toString()));
			 * cell.setPaddingLeft(5); cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
			 * cell.setHorizontalAlignment(Element.ALIGN_LEFT); table.addCell(cell);
			 */

			/*
			 * cell = new PdfPCell(new Phrase(String.valueOf(city.getPopulation())));
			 * cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
			 * cell.setHorizontalAlignment(Element.ALIGN_RIGHT); cell.setPaddingRight(5);
			 * table.addCell(cell);
			 */
            

            PdfWriter.getInstance(document, new FileOutputStream("C:\\Users\\User1\\Downloads\\taxreport.pdf"));
            document.open();
            document.add(table);
            document.add(new Paragraph("You have donated for a good cause"));
            document.add(new Paragraph("This is to certify that you are now eligible for tax reduction under 80C ACT"));
            document.add(new Paragraph("Thank you"));
            document.close();
           // writer.close();
            
        } catch (DocumentException ex) {

            logger.error("Error occurred: {0}", ex);
        }
        return  document;
    }
}
