package service;

import java.time.LocalDate;
import java.util.List;

import object.Agent;
import object.Airline;
import object.Airport;
import object.FlightInstance;
import object.Passenger;
import object.Reservation;
import object.Ticket;

public interface ReservationSystemFacade {
	
	List<Airport> findAllAirports();	
	Airport findAirportByAirportCode(String airportCode);
	
	
	List<Airport> findAirportsByCity(String city); // Airport(s) of a city, e.g. Chicago has two major airports	
	List<Airline> findAirlinesByAirportCode(String airportCode);
	
	List<FlightInstance> findFlightsFromTo(String departureAirPortCode, String arrivalAirportCode, LocalDate date);	
	List<Reservation> findReservationsByPassengerId(String passengerId);
	
	List<Passenger> findPassengersByAgentCode(String agentCode);	
	
	Reservation createReservation(String passenger, List<FlightInstance> flightInstances); // Passenger reserves
	Reservation createReservation(String agent, String passenger, List<FlightInstance> flightInstances); // Agent reserves
	
	List<Ticket> confirmReservation(String reservationCode);	
	boolean cancelReservation(String reservationCode);
	List<Reservation> findReservationsByAgentId(String passengerId);
	
	
}
