package object;

import java.util.List;

public class ReservationFactory {
	
		
		public static Reservation buildAReservation( Passenger passenger, Agent agent, List<FlightInstance> flightInstances) {
       			
		Reservation reservation =new Reservation();
        reservation.setPassenger(passenger);

        passenger.addReservation(reservation);
        if(agent!=null) {
	        reservation.setAgents(agent);
	        agent.addReservation(reservation); 
        } 

        reservation.setFlightsinstances(flightInstances);

        for (FlightInstance flightInstance : flightInstances) {
            TicketFactory.buildTicket(passenger, reservation, flightInstance);
        }
       
       
        return reservation;
    }
	
}
