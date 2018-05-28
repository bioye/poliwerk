package ng.nectar.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Party {
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	private String name;
	private String acronym;
	private Date registered;
	//private List< String> chairmen;
	//private Object logo;
	private String slogan;
	
	@Id
	@Column(name = "id")
	private int id;
}
