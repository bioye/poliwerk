package ng.nectar.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "pollingunit")
public class PollingUnit implements Constituency {		
	
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getPuLocation() {
		return puLocation;
	}
	public void setPuLocation(String puLocation) {
		this.puLocation = puLocation;
	}
	public String getName() {
		return name;
	}
	public String getCode() {
		return code;
	}
	public Ward getWard() {
		return ward;
	}

	@Id
	@Column(name = "id")
	private int id;
	private String name;
	private String description;
	@Column(name = "pu_id")
	private String code;
	@Column(name = "pu_loc_id")
	private String puLocation;
	@ManyToOne
	private Ward ward;
}
