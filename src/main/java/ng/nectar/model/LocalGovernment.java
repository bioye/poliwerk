package ng.nectar.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "localgov")
public class LocalGovernment implements Constituency{
	
	public State getState() {
		return state;
	}
	public String getName() {
		return name;
	}
	public String getCode() {
		return code;
	}
	@Id
	@Column(name = "id")
	private int id;
	@ManyToOne
	State state;
	String name;
	String code;
}
