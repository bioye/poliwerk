package ng.nectar.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Office {
	private String name;//
	private String level;
	//private ConstituencyInterface constituency;
	@ManyToOne
	private Constituency constituency;
	@ManyToOne
	private OfficeType type;	

	@Id
	@Column(name = "id")
	private int id;
}