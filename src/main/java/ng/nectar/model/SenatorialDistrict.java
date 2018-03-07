package ng.nectar.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "senate")
public class SenatorialDistrict implements Constituency {

	public String getCode() {
		return code;
	}
	public String getName() {
		return name;
	}
	@Id
	@Column(name = "id")
	private int id;
	String name;
	String code;
	@ManyToOne
	State state;
}
