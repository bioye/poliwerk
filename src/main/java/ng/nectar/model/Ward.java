package ng.nectar.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "ward")
public class Ward implements Constituency{	

	public int getId() {
		return id;
	}
	public SenatorialDistrict getDistrict() {
		return district;
	}
	public FedConstituency getFedConst() {
		return fedConst;
	}
	public String getName() {
		return name;
	}
	public String getCode() {
		return code;
	}
	public StateConstituency getStateConst() {
		return stateConst;
	}
	public LocalGovernment getLg() {
		return lg;
	}	

	@Id
	@Column(name = "id")
	private int id;

	@ManyToOne
	LocalGovernment lg;
	@ManyToOne
	@JoinColumn(name = "stateconst_id")
	StateConstituency stateConst;
	@ManyToOne
	@JoinColumn(name = "fedconst_id")
	FedConstituency fedConst;
	@ManyToOne
	@JoinColumn(name = "senate_id")
	SenatorialDistrict district;
	String name;
	String code;
}
