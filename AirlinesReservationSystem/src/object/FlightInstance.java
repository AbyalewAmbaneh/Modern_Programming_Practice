package object;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class FlightInstance {

	private String id;
	private Flight flight;
	private LocalDate date;
	
	private List<Crew> crew = new ArrayList<>();
	private List<Pilot> pilots = new ArrayList<>();
	private List<Reservation> reservations = new ArrayList<>();
	private List<Ticket> tickets = new ArrayList<>();

	public FlightInstance(String id, Flight flight, LocalDate date) {	
		this.id = id;
		this.flight = flight;
		this.date = date;
	}
	
	
	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	public Flight getFlight() {
		return flight;
	}
	
	public void setFlight(Flight flight) {
		this.flight = flight;
	}
	
	public LocalDate getDate() {
		return date;
	}
	
	public void setDate(LocalDate date) {
		this.date = date;
	}
	
	public List<Crew> getCrew() {
		return crew;
	}
	
	public void setCrew(List<Crew> crew) {
		this.crew = crew;
	}
	
	public List<Pilot> getPilot() {
		return pilots;
	}
	
	public void setPilot(List<Pilot> pilots) {
		this.pilots = pilots;		
	}
	
	public List<Reservation> getReservations() {
		return reservations;
	}
	
	public void setReservations(List<Reservation> reservations) {
		this.reservations = reservations;
	}
	
	public List<Ticket> getTickets() {
		return tickets;
	}
	
	public void addTicket(Ticket ticket) {
		this.tickets.add(ticket);
	}


	@Override
	public String toString() {
		return "FlightInstance [id=" + id + ", flight=" + flight + ", date=" + date + "]";
	}






}
