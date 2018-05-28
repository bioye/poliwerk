package ng.nectar.model;

import java.util.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Politician {
	public Party getParty() {
		Party party=null;
		if(null!=partyHistory&&partyHistory.size()>0) {
			PeriodParty partyAtPeriod = partyHistory.get((partyHistory.size()-1));
			party = partyAtPeriod.getParty();
		}
		return party;
	}
	//private Map<Office, List<Tenure>> officeTenures;//
	private String name;
	private String email;
	private String phoneNo;
	private String address;
	private Date dateOfBirth;
	private Date dateOfDeath;
	//private Object photo;
	private String twitter;
	private String facebook;
	private String website;
	
	@OneToMany
	private List<PeriodParty> partyHistory;

	@Enumerated(EnumType.STRING)
	private Gender gender;
	
	@Id
	@Column(name = "id")
	private int id;
	
	private enum Gender{
		MALE, FEMALE;
	}
}