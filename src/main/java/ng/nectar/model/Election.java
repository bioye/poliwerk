package ng.nectar.model;

import java.util.Date;
import java.util.List;

public class Election {
	String name;
	private Constituency constituency;
	List<Candidate> candidates;
	Date date;
}