package object;

public class TicketFactory {
	public static Ticket buildTicket(Passenger passenger, Reservation reservation, FlightInstance flightInstance) {
		   
        
        Ticket ticket = new Ticket(passenger);       
        

        passenger.addTicket(ticket);
       
        ticket.setReservation(reservation);
        reservation.addTicket(ticket);
       
        ticket.setFlightinstance(flightInstance);
        flightInstance.addTicket(ticket);
       
       
        return ticket;
    }

}
