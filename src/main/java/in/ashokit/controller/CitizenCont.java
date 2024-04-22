package in.ashokit.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;


import in.ashokit.binding.SearchCitizen;
import in.ashokit.service.CitizenImp;
import jakarta.servlet.http.HttpServletResponse;

@Controller
public class CitizenCont {
	@Autowired
CitizenImp service;	

	@GetMapping("/")
	public String firstPage(Model m) {
		SearchCitizen bind=new SearchCitizen();
		m.addAttribute("Citizenbinding",bind);
		sameOperation(m);
	return "index";
	}
	
	
	@PostMapping("/search")
	public String Search(@ModelAttribute("Citizenbinding")SearchCitizen se,Model mv) {
		sameOperation(mv);
		mv.addAttribute("msg","Data search");
	 mv.addAttribute("data",service.search(se));
		return "index";
	}

	
	
	public void sameOperation(Model mv) {
		mv.addAttribute("CName",service.getAllPlanName());
		mv.addAttribute("CStatus",service.getAllPlanStatus());

	}

	 @GetMapping("/export/excel")
	    public void exportIntoExcelFile(HttpServletResponse response) throws Exception {
	        response.setContentType("application/octet-stream");
	        response.setHeader("Content-Disposition","attachment; filename=Insurance.xls");
	  service.getexport(response);
	      }
	 
	  @GetMapping("/export/pdf")
	    public void exportToPDF(HttpServletResponse response) throws Exception {
	        response.setContentType("application/pdf");
	        DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
	        String currentDateTime = dateFormatter.format(new Date());
	         
	        response.setHeader("Content-Disposition", "attachment; filename=Insurance" + currentDateTime + ".pdf");
	         
	        service.getexportpdf(response);
	         
	    }
	}
	

