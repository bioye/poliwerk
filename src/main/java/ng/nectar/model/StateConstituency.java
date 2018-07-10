package ng.nectar.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "stateconst")
public class StateConstituency implements ConstituencyInterface{

	public String getCode() {
		return code;
	}
	public String getName() {
		return name;
	}
	@Id
	@Column(name = "id")
	private int id;
	private String code;
	private String name;

	@ManyToOne
	State state;
}
