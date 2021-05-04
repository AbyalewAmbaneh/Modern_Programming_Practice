package object;

import java.time.LocalTime;

public class Flight {

	private String id;
	private String number;
	private int capacity;	
	private LocalTime departureTime;
	private LocalTime arrivalTime;	
	private Airport departureAirport;
	private Airport arrivalAirport;

	public Flight(String id, String number, int capacity, 
			LocalTime departureTime, LocalTime arrivalTime,
			Airport departureAirport, 
			Airport arrivalAirport
			) {
		
		this.id = id;
		this.number = number;
		this.capacity = capacity;
		this.departureTime = departureTime;
		this.arrivalTime = arrivalTime;
		
		this.departureAirport = departureAirport;
		this.departureAirport.addFlight(this);
		
		
		this.arrivalAirport = arrivalAirport;
		this.arrivalAirport.addFlight(this);
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	public LocalTime getDepartureTime() {
		return departureTime;
	}

	public void setDepartureTime(LocalTime departureTime) {
		this.departureTime = departureTime;
	}

	public LocalTime getArrivalTime() {
		return arrivalTime;
	}

	public void setArrivalTime(LocalTime arrivalTime) {
		this.arrivalTime = arrivalTime;
	}

	public Airport getDepartureAirport() {
		return departureAirport;
	}

	public void setDepartureAirport(Airport departureAirport) {
		this.departureAirport = departureAirport;
		
		departureAirport.addFlight(this);
	}

	public Airport getArrivalAirport() {
		return arrivalAirport;
	}

	public void setArrivalAirport(Airport arrivalAirport) {
		this.arrivalAirport = arrivalAirport;
	}

	@Override
	public String toString() {
		return "Flight [id=" + id + ", number=" + number + ", capacity=" + capacity + ", departureTime=" + departureTime
				+ ", arrivalTime=" + arrivalTime + ", departureAirport=" + departureAirport + ", arrivalAirport="
				+ arrivalAirport + "]";
	}
	
	


}
