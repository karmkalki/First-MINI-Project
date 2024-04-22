package in.ashokit.service;

import java.io.File;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;



import in.ashokit.binding.SearchCitizen;
import in.ashokit.email.EmailGenerator;
import in.ashokit.entity.Citizen;
import in.ashokit.excel.ExcelGenerator;
import in.ashokit.pdf.PdfGenerator;
import in.ashokit.repo.CitizenRepo;
import jakarta.servlet.http.HttpServletResponse;

@Service
public class CitizenImp implements CitizenService {

	@Autowired
private CitizenRepo repo;
	
	@Autowired
	private PdfGenerator pdf;
	@Autowired
	private ExcelGenerator excel;
	   @Autowired
	    private EmailGenerator email;
	
	@Override
	public List<String> getAllPlanName() {
	return repo.getAllPlanName();
	}

	@Override
	public List<String> getAllPlanStatus() {
		return repo.getAllPlanStatus();
		
	}

	@Override
	public List<Citizen> search(SearchCitizen search) {
	
		/*convert binding class obj to entity class bcz example.of() paramaater want entity clas object*/
		
/*if we use this than not work filter search functionality bcz when we not select anything on ui page "" empty data come bcz in ui select value=""
 * so query generated acording to empty so in our table doest have any value which empty("") value is null so when we convert binding class to entity
 * object and send entity object to Example.of()  query generated acording to empty("") so not a single record display
 * if null value come no problrm bcz null case query not generated 
 *	Citizen c=new Citizen();
		BeanUtils.copyProperties(search, c);
	    Example<Citizen> example=Example.of(c);
       List<Citizen> emp=repo.findAll(example);
return emp;
*/

		/*manually set planname,planstatus,gender when value is not empty "" then set or citizine c entity class object send to example.of()
		 * to generate dynamic query
		 * */
		Citizen c=new Citizen();
		if( !"".equals(search.getPlanName())){
		c.setPlanName(search.getPlanName());	
		}
		if(!"".equals(search.getPlanStatus())){
			c.setPlanStatus(search.getPlanStatus());	
			}
		if(!"".equals(search.getCitizenGender())){
			c.setCitizenGender(search.getCitizenGender());	
			}
		if(!"".equals(search.getStartingDate())){
			c.setStartingDate(search.getStartingDate());	
			}
		if(!"".equals(search.getEndingDate())){
			c.setEndingDate(search.getEndingDate());	
		}
		
		return repo.findAll(Example.of(c));	
	}
	
	@Override
	public boolean getexport(HttpServletResponse response) throws Exception {
//Generate and download the Excel file storing it on server means project folder
File F =new File("Insurance.xlsx");
	
		excel.generateExcelFile(response,F);
		
		String subject = "Welcome,!";
        String text = "email with attachment";
      String to="krishsharma9102@gmail.com";
      email.sendEmailWithAttachment(to, subject, text, F);

		
		return true;
	}
	
     	@Override
	public boolean getexportpdf(HttpServletResponse response) throws Exception {
     		File F =new File("Insurance.pdf");
		   pdf.export(response,F);
			
			String subject = "Welcome,!";
	        String text = "<h1>email with attachment</h1>";
	      String to="krishsharma9102@gmail.com";
      boolean report= email.sendEmailWithAttachment(to, subject, text, F);

		   
		   return report;
		   }


		
		
		
	}


