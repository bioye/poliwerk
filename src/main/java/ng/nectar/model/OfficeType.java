package ng.nectar.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;

@Entity
public class OfficeType {
	private String name;
	private String office;
	private String leader;
	private String codePrefix;
	
	@Enumerated(EnumType.STRING)
	private Type type;
	
	@Id
	@Column(name = "id")
	private int id;
	
	private enum Type{
		ELECTED, APPOINTED
	}
}