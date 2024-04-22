package in.ashokit.repo;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


import in.ashokit.entity.Citizen;

public interface CitizenRepo extends JpaRepository<Citizen, Integer>{
	/*this query is find all different value find in particular column
	 * this sql query (table name or column name write)
	 * this method is create beacause we display table data(to get planname) in ui page
	 * */
	@Query(value="select distinct plan_name from insurance_citizen",nativeQuery=true)
	public List<String> getAllPlanName();
	
	/*this query is find all different value find in particular column
	 * this Hql query (class name or column variable name write)
	 * this method is create beacause we display table data(to get planStatus) in ui page
	 * */
	@Query("select distinct planStatus from Citizen")
	public List<String> getAllPlanStatus();


}
