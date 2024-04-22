package in.ashokit.service;

import java.util.List;

import in.ashokit.binding.SearchCitizen;
import in.ashokit.entity.Citizen;
import jakarta.servlet.http.HttpServletResponse;

public interface CitizenService {
	
public List<String> getAllPlanName();
public List<String> getAllPlanStatus();
public List<Citizen> search(SearchCitizen search);
public boolean getexport(HttpServletResponse response)throws Exception ;
public boolean getexportpdf(HttpServletResponse response)throws Exception;

}
