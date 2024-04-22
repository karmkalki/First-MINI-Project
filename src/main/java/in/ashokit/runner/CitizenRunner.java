package in.ashokit.runner;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import in.ashokit.entity.Citizen;
import in.ashokit.repo.CitizenRepo;

@Component
public class CitizenRunner implements ApplicationRunner {
	
	@Autowired
	private CitizenRepo repo;

	@Override
	public void run(ApplicationArguments args) throws Exception {
		/*to delete all data in database otherwise same record save again and again when application start*/
		
		repo.deleteAll();
		/*to inset data in database for retrival*/

		Citizen c1=new Citizen();
		c1.setCitizenName("Abhi");
		c1.setCitizenGender("Male");
		c1.setPlanName("Cash");
		c1.setPlanBenefit(5000);
		c1.setPlanStatus("Approved");
		c1.setStartingDate(LocalDate.now());
		c1.setEndingDate(LocalDate.now().plusMonths(6));

		Citizen c2=new Citizen(null,"Krish","Cash","Denied",null,"Male", null, null, "Employed", null, null);
		Citizen c3=new Citizen(null,"Harshita","Cash","Terminate",null,"Fe-Male",LocalDate.now().minusMonths(2) , LocalDate.now().plusMonths(4), null, "Job Confirm", LocalDate.now());


		Citizen c4=new Citizen(null,"Gourav","Food","Approved",5000,"Male",LocalDate.now() ,LocalDate.now().plusMonths(6), null, null, null);
		Citizen c5=new Citizen(null,"Nitesh","Food","Denied",null,"Male", null, null, "Gov Employe", null, null);
		Citizen c6=new Citizen(null,"Sakshi","Food","Terminate",null,"Fe-Male",LocalDate.now().minusMonths(2) , LocalDate.now().plusMonths(4), null, "Job Confirm", LocalDate.now());

		Citizen c7=new Citizen(null,"Ritesh","Medical","Approved",5000,"Male",LocalDate.now().minusMonths(1) ,LocalDate.now().plusMonths(5), null, null, null);
		Citizen c8=new Citizen(null,"kirtan","Medical","Denied",null,"Male", null, null, "Gov Employe", null, null);
		Citizen c9=new Citizen(null,"Neha","Medical","Terminate",null,"Fe-Male",LocalDate.now().minusMonths(2) , LocalDate.now().plusMonths(4), null, "Job Confirm", LocalDate.now());
		

		Citizen c10=new Citizen(null,"Chandan","Employment","Approved",5000,"Male",LocalDate.now().minusMonths(1) ,LocalDate.now().plusMonths(5), null, null, null);
		Citizen c11=new Citizen(null,"sumit","Employment","Denied",null,"Male", null, null, "Gov Employe", null, null);
		Citizen c12=new Citizen(null,"kritika","Employment","Terminate",null,"Fe-Male",LocalDate.now().minusMonths(2) , LocalDate.now().plusMonths(4), null, "Job Confirm", LocalDate.now());
		
	List<Citizen> list=	Arrays.asList(c1,c2,c3,c4,c5,c6,c7,c8,c9,c10,c11,c12);
	repo.saveAll(list);
		
	}

}
