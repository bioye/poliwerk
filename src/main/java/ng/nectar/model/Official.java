package ng.nectar.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "office_tenure")
public class Official {
	@ManyToOne
	private Politician politician;
	@ManyToOne
	private Tenure tenure;
	@ManyToOne
	private Office office;
	private String name;

	@Id
	@Column(name = "id")
	private int id;
}