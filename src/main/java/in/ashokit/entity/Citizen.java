package in.ashokit.entity;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name="Insurance_Citizen")
public class Citizen {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String citizenName;
    private String planName;
    private String planStatus;
    private Integer planBenefit;
    private String citizenGender;
    private LocalDate startingDate;
    private LocalDate endingDate;
	private String planDenied;
	private String planTerminate;
	private LocalDate terminateDate;
	
}
