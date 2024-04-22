package in.ashokit.excel;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import in.ashokit.entity.Citizen;
import in.ashokit.repo.CitizenRepo;
import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class ExcelGenerator { 


    @Autowired
    private CitizenRepo repo;

  


   
/* ServletOutputStream outputStream = response.getOutputStream();
This line retrieves an OutputStream object from the HttpServletResponse object.
OutputStream is a general interface for writing data.
ServletOutputStream is a specialized OutputStream specifically designed for writing
 data to a servlet response (e.g., sending a file to the browser).
*/
    public void generateExcelFile(HttpServletResponse response ,File F) throws IOException {

    	HSSFWorkbook workbook=new HSSFWorkbook();
    	HSSFSheet sheet = workbook.createSheet("Citizen");;
    
    	HSSFRow headerRow = sheet.createRow(0);
            headerRow.createCell(0).setCellValue("ID");  

            headerRow.createCell(1).setCellValue("Citizen Name");  
            headerRow.createCell(2).setCellValue("Citizen plan");
            headerRow.createCell(3).setCellValue("PlanBenifite");
            headerRow.createCell(4).setCellValue("Start Date");
            headerRow.createCell(5).setCellValue("End Date ");
            headerRow.createCell(6).setCellValue("Terminate Reason");
            headerRow.createCell(7).setCellValue("Terminate Date.");
            headerRow.createCell(8).setCellValue("Denied Reason");
            headerRow.createCell(9).setCellValue("Gender");
            
int row=1;
            
 for(Citizen c:repo.findAll()) {
 	HSSFRow Rownum = sheet.createRow(row);
  Rownum.createCell(0).setCellValue(String.valueOf(c.getId()));
  Rownum.createCell(1).setCellValue(c.getCitizenName()+"");
  Rownum.createCell(2).setCellValue(c.getPlanName()+"");
  Rownum.createCell(3).setCellValue(c.getPlanBenefit()+"");
  Rownum.createCell(4).setCellValue(c.getStartingDate()+"");
  Rownum.createCell(5).setCellValue(c.getEndingDate()+"");
  Rownum.createCell(6).setCellValue(c.getPlanTerminate()+"");
  Rownum.createCell(7).setCellValue(c.getTerminateDate()+"");
  Rownum.createCell(8).setCellValue(c.getPlanDenied()+"");
  Rownum.createCell(9).setCellValue(c.getCitizenGender()+"");
 row++;
}
 /*file is create in your server(project folder) given path F is file location where to save that file*/
    	FileOutputStream F1=new FileOutputStream(F);
    	workbook.write(F1);
    F1.close(); 
    /*send file with browser not save in your server(project folder)*/
        ServletOutputStream outputStream = response.getOutputStream();
        workbook.write(outputStream);

        outputStream.close();
        workbook.close();
      
    }
}