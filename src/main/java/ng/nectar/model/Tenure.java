package ng.nectar.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;

@Entity
public class Tenure {
	private String name;
	private LocalDate start;
	private LocalDate end;
	
	@Enumerated(EnumType.STRING)
	private Exit exit;
	
	@Id
	@Column(name = "id")
	private int id;
	
	private enum Exit{
		TENURE_ENDED, DIED, IMPEACHED, ANNULED, RESIGNED, RECALLED
	}
}