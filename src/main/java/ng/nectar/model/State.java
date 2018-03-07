package ng.nectar.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "state")
public class State implements Constituency{	
	public String getCode() {
		return code;
	}
	public String getName() {
		return name;
	}
	@Id
	@Column(name = "id")
	private int id;
	private String name;
	private String code;
	private String prefix;
	public GeoZone getGeoZone() {
		return GeoZone.getGeoZone(this);
	}
	public String getPrefix() {
		return prefix;
	}	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
}