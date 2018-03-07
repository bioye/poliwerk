package ng.nectar.model;

import javax.persistence.Transient;

import com.google.maps.model.LatLng;

public class Location {

	public LatLng getCoords() {
		return coords;
	}

	public void setCoords(LatLng coords) {
		this.coords = coords;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}
	@Transient
	LatLng coords;
	Address address;
}