package ng.nectar.model;

import java.util.Date;

public class Tenure {
	private Date start;
	private Date end;
	private Election election;
	private enum ExitType{
		TENURE_ENDED, DIED, IMPEACHED, ANNULED, RESIGNED, RECALLED
	}
}