package ng.nectar.model;

import java.util.Date;
import java.util.List;

public class Election {
	String name;
	private ConstituencyInterface constituency;
	List<Candidate> candidates;
	Date date;
	int invalidVotes;//
	private enum Type{
		GENERAL, STANDALONE
	}
}