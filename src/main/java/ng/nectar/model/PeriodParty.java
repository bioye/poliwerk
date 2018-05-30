package ng.nectar.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "party_history")
public class PeriodParty {
	
	public Party getParty() {
		return party;
	}
	@ManyToOne
	private Party party;
	@Column(name="from")
	private LocalDate joined;
	@Column(name="till")
	private LocalDate left;
	private String reason;
	
	@Id
	@Column(name = "id")
	private int id;
}