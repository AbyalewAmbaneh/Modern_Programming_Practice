package object;

import java.util.ArrayList;
import java.util.List;

public class Airline {
	private String id;
	private String code;
	private String name;
	private String history;
	
	
	private List<Flight> flights = new ArrayList<>();
	private List<Airport> airports = new ArrayList<>();
	
	public Airline(String id, String code, String name, String history) {
		this.id = id;
		this.code = code;
		this.name = name;
		this.history = history;	
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
	public String getHistory() {
		return history;
	}
	public void setHistory(String history) {
		this.history = history;
	}
	public List<Flight> getFlights() {
		return flights;
	}
	public void setFlights(List<Flight> flights) {
		this.flights = flights;
	}
	public List<Airport> getAirports() {
		return airports;
	}
	public void setAirports(List<Airport> airports) {
		this.airports = airports;
	}
	
	
	public void addAirPort(Airport airport) {
		this.airports.add(airport);
	}
	
	public void addFlight(Flight flight) {
		this.flights.add(flight);
	}

	@Override
	public String toString() {
		return "Airline [id=" + id + ", code=" + code + ", name=" + name + ", history=" + history + "]";
	}
	
	
	
	
	
	
}




