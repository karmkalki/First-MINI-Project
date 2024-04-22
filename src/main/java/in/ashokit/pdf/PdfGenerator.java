package in.ashokit.pdf;


import java.awt.Color;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import jakarta.servlet.http.HttpServletResponse;


import com.lowagie.text.*;
import com.lowagie.text.pdf.*;

import in.ashokit.entity.Citizen;
import in.ashokit.repo.CitizenRepo;
 
 @Component
public class PdfGenerator {
   @Autowired
   private CitizenRepo repo;
   
 
    private void writeTableHeader(PdfPTable table) {
        PdfPCell cell = new PdfPCell();
        cell.setBackgroundColor(Color.BLUE);
        cell.setPadding(5);
         
        Font font = FontFactory.getFont(FontFactory.HELVETICA);
        font.setColor(Color.WHITE);
         
        cell.setPhrase(new Phrase("User ID", font));
         
        table.addCell(cell);
         
        cell.setPhrase(new Phrase("Citizen Name", font));
        table.addCell(cell);
         
        cell.setPhrase(new Phrase("Citizen Plan", font));
        table.addCell(cell);

        cell.setPhrase(new Phrase("Plan Status", font));
        table.addCell(cell);
       
        cell.setPhrase(new Phrase("Gender", font));
        table.addCell(cell);
       
        
        cell.setPhrase(new Phrase("Plan Benifite", font));
        table.addCell(cell);
         
        cell.setPhrase(new Phrase("Start Date", font));
        table.addCell(cell);       
   

        cell.setPhrase(new Phrase("End Date", font));
        table.addCell(cell);
         
        cell.setPhrase(new Phrase("Terminate Reason", font));
        table.addCell(cell);       
    
        cell.setPhrase(new Phrase("Terminate Date", font));
        table.addCell(cell);
       
        cell.setPhrase(new Phrase("Denied Reason", font));
        table.addCell(cell);
       
    }
     
    private void writeTableData(PdfPTable table) {
        for (Citizen user : repo.findAll()) {
            table.addCell(String.valueOf(user.getId()));
            
            table.addCell(user.getCitizenName());

            table.addCell(user.getPlanName());

            table.addCell(user.getPlanStatus());
            
            table.addCell(user.getCitizenGender());
            
            table.addCell(user.getPlanBenefit()+"");
            
            table.addCell(user.getStartingDate()+"");
            
            table.addCell(user.getEndingDate()+"");
            
            table.addCell(user.getPlanTerminate());
            
            table.addCell(user.getTerminateDate()+"");
            
            table.addCell(user.getPlanDenied());
            
        }
    }
     
    public void export(HttpServletResponse response,File filePath) throws DocumentException, IOException {
        Document document = new Document(PageSize.A3);
        /*file is create in your given path*/
        FileOutputStream outputStream = new FileOutputStream(filePath);
        PdfWriter.getInstance(document, outputStream);
        
        PdfWriter.getInstance(document, response.getOutputStream());
        
        document.open();
        Font font = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
        font.setSize(8);
        font.setColor(Color.BLUE);
         
        Paragraph p = new Paragraph("List of Users", font);
        p.setAlignment(Paragraph.ALIGN_CENTER);
         
        document.add(p);
         
        PdfPTable table = new PdfPTable(11);
        table.setWidthPercentage(100f);
        table.setSpacingBefore(20);
         
        writeTableHeader(table);
        writeTableData(table);
         
        document.add(table);
         
        document.close();
        
        outputStream.close();
        
        
    }
}