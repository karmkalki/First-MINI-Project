package in.ashokit.binding;

import java.time.LocalDate;

import org.springframework.stereotype.Component;

import lombok.Data;

/*Binding class for data come from form save in this class variable in real time we are not create binding and entity class same
 * it is called form binding class
 * */
@Component
@Data
public class SearchCitizen {
	private String planName;
    private String planStatus;
    private String citizenGender;
    private LocalDate startingDate;
    private LocalDate endingDate;

}
