package object;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Passenger extends Person{
	
	private List<Reservation> reservations = new ArrayList<>();
	private List<Ticket> tickets = new ArrayList<>();
	
	
	public Passenger(String id, String firstName, String lastName, String email, LocalDate dateOfbirth, Address address) {
		super(id, firstName, lastName, email, dateOfbirth, address);
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
	
	public void addReservation(Reservation reservation) {
		reservations.add(reservation);
	}
	
	
	@Override
	public String toString() {
		return "Passenger [" + super.toString();
	}
	

}
