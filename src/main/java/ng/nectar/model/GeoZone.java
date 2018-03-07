package ng.nectar.model;

public enum GeoZone {
	NORTH_WEST, NORTH_CENTRAL, NORTH_EAST, SOUTH_WEST, SOUTH_EAST, SOUTH_SOUTH;
	
	public static GeoZone getGeoZone(State state) {
		String name = state.getName();
		if(name.equals("Abia")||name.equals("Imo")||name.equals("Enugu")||name.equals("Anambra")||name.equals("Ebonyi"))
			return GeoZone.SOUTH_EAST;
		else if(name.equals("Bayelsa")||name.equals("Edo")||name.equals("Rivers")||name.equals("Cross River")||name.equals("Ebonyi")||name.equals("Delta"))
			return GeoZone.SOUTH_SOUTH;
		else if(name.equals("Ogun")||name.equals("Ondo")||name.equals("Oyo")||name.equals("Osun")||name.equals("Lagos")||name.equals("Ekiti"))
			return GeoZone.SOUTH_WEST;
		else if(name.equals("Kano")||name.equals("Sokoto")||name.equals("Jigawa")||name.equals("Kaduna")||name.equals("Katsina")||name.equals("Kebbi")||name.equals("Zamfara"))
			return GeoZone.NORTH_WEST;
		else if(name.equals("Benue")||name.equals("Niger")||name.equals("Kogi")||name.equals("FCT")||name.equals("Kwara")||name.equals("Nasarawa")||name.equals("Plateau"))
			return GeoZone.NORTH_CENTRAL;
		else if(name.equals("Adamawa")||name.equals("Bauchi")||name.equals("Borno")||name.equals("Taraba")||name.equals("Yobe")||name.equals("Gombe"))
			return GeoZone.NORTH_EAST;
		return null;
	}

}