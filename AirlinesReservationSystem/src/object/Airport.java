package object;

import java.util.ArrayList;
import java.util.List;

public class Airport {
	private String id;
	private String code;
	private String name;
	private Address address;
	
	private List<Flight> flights = new ArrayList<>();
	private List<Airline> airlines = new ArrayList<>();
	
	public Airport(String id, String code, String name, Address address) {
		this.id = id;
		this.code = code;
		this.name = name;
		this.address = address;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public List<Flight> getFlights() {
		return flights;
	}

	public void setFlights(List<Flight> flights) {
		this.flights = flights;
	}

	public List<Airline> getAirlines() {
		return airlines;
	}

	public void setAirlines(List<Airline> airlines) {
		this.airlines = airlines;
	}
	
	public void addAirLine(Airline airline) {
		this.airlines.add(airline);
	}
	
	public void addFlight(Flight flight) {
		this.flights.add(flight);
	}

	@Override
	public String toString() {
		return "Airport [id=" + id + ", code=" + code + ", name=" + name + ", address=" + address + "]";
	}	
	
	
	
	

	
	


}
