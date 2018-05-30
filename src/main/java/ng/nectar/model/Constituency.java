package ng.nectar.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;

@Entity
public class Constituency {
	
	private String name;
	private String code;
	@Enumerated(EnumType.STRING)
	private Type type;
	
	@Id
	@Column(name = "id")
	private int id;
	
	private enum Type{
		COUNTRY, SENATORIAL, FED_CONST, STATE, STATE_CONST, LOCAL_GOV, WARD
	}

}
