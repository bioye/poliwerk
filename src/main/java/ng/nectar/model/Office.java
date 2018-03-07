package ng.nectar.model;

public class Office {
	private String name;//
	private String level;
	private Tenure tenure;
	private Type type;	
	
	private enum Type{
		ELECTED, APPOINTED
	}
}
