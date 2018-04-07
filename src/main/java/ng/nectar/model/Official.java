package ng.nectar.model;

import java.util.List;

public class Official {

	public Office getCurrentOffice() {
		if(null!=offices&&offices.size()>0) return offices.get(offices.size()-1);
		return null;
	}
	private Politician politician;
	private Party party;
	private List<Office> offices;
	private String name;
}