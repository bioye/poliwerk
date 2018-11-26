package ng.nectar.model;

import java.util.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.springframework.transaction.annotation.Transactional;

@Entity
@Transactional
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
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}


	public String getSurname() {
		return surname;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}


	public String getPhoneNo() {
		return phoneNo;
	}


	
	public String getAddress() {
		return address;
	}

	/**
	 * @return the dateOfBirth
	 */
	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	/**
	 * @return the dateOfDeath
	 */
	public Date getDateOfDeath() {
		return dateOfDeath;
	}

	/**
	 * @return the twitter
	 */
	public String getTwitter() {
		return twitter;
	}

	/**
	 * @return the facebook
	 */
	public String getFacebook() {
		return facebook;
	}

	/**
	 * @return the website
	 */
	public String getWebsite() {
		return website;
	}

	/*
	public Gender getGender() {
		return gender;
	}
	 */

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}


	@Column(name = "last_name")
	private String surname;//
	private String email;
	@Column(name = "phone_number")
	private String phoneNo;
	@Column(name = "address_const")
	private String address;
	private Date dateOfBirth;
	private Date dateOfDeath;
	//private Object photo;
	private String twitter;
	private String facebook;
	private String website;
	
	@OneToMany
	private List<PeriodParty> partyHistory;

	//@Enumerated(EnumType.STRING)
	//private Gender gender;
	
	@Id
	@Column(name = "id")
	private int id;
	
	private enum Gender{
		MALE, FEMALE;
	}
}