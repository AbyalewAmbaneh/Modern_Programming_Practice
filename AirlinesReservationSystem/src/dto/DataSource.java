package dto;

import java.nio.charset.Charset;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import object.Address;
import object.Agent;
import object.AirPortFactory;
import object.Airline;
import object.Airport;
import object.Crew;
import object.Flight;
import object.FlightInstance;
import object.FlightInstanceFactory;
import object.Passenger;
import object.Pilot;
import object.Reservation;
import object.ReservationFactory;
import object.Ticket;

public class DataSource {

	private List<Airline> _airlines = new ArrayList<>();
	private List<Airport> _airports = new ArrayList<>();
	private List<Reservation> _reservations = new ArrayList<>();
	private List<Pilot> _pilots = new ArrayList<>();
	private List<Crew> _crew = new ArrayList<>();
	private List<Agent> _agents = new ArrayList<>();
	private List<Passenger> _passengers = new ArrayList<>();
	
	private List<Ticket> _tickets = new ArrayList<>();
	
	private List<FlightInstance> _flightInstances = new ArrayList<>();
	private List<Flight> _flights = new ArrayList<>();

/*Rajeev*/	
	DataSource() {		
		createAirlineData();
	}
	
	private void createAirlineData() {
		Airline airline1 = new Airline("AL1", "AL1", "AL1", "history AL1");
		this._airlines.add(airline1);
		Airline airline2 = new Airline("AL2", "AL2", "AL2", "history AL2");
		this._airlines.add(airline2);
		Airline airline3 = new Airline("AL3", "AL3", "AL3", "history AL3");
		this._airlines.add(airline3);
		
		
		this._airports = createAirport();		
		int[][] idx = new int[3][2];
		idx[0][0] = 0;
		idx[0][1] = 1;
		
		idx[1][0] = 1;
		idx[1][1] = 2;
		
		idx[2][0] = 0;
		idx[2][1] = 2;		
		int countX = 0;
		for (Airport airport : this._airports) {			
			AirPortFactory.buildAirPort(airport, Arrays.asList(this._airlines.get(idx[countX][0]), this._airlines.get(idx[countX][1])));			
			countX++;
		}
		
		this._flights = createFlights(this._airports);
		
		this._pilots = createPilots();
		this._crew = createCrews();				
		this._agents = createAgents();
		
		this._passengers = createPassengers();		
		this._tickets = createTickets(this._passengers);		
		
		
		this._flightInstances = createFlightInstaces(this._flights.get(0), this._flights.get(1));
		for (FlightInstance flightInstance : this._flightInstances) {
			FlightInstanceFactory.buildAFlightInstance(flightInstance, this._pilots, this._crew);
		}
		
		int count = 0;
		
		for (Passenger passenger : this._passengers) {
			Reservation res=ReservationFactory.buildAReservation(passenger, this._agents.get(count), this._flightInstances);
			System.out.println(res);
			count++;
		}
		
	}
/*Rajeev*/	


/*Eunice*/
	private List<Airport> createAirport() {
		List<Airport> airports = new ArrayList<Airport>();
		
		Airport airport = new Airport("A", "A1", "A1", new Address("01", "S1", "C1", "S1", "Z1") );	
		airports.add(airport);	
		
		Airport airport1 = new Airport("B", "B1", "B1", new Address("02", "S2", "C2", "S2", "Z2") );
		airports.add(airport1);
		
		Airport airport2 = new Airport("C", "C1", "C1", new Address("03", "S3", "C23", "S23", "Z3") );
		airports.add(airport2);
		
		return airports;
	}
	
	private List<Flight> createFlights(List<Airport> airports) {
		List<Flight> flights = new ArrayList<Flight>();
		
		Flight f1 = new Flight("F1", "F1", 40, LocalTime.now(), LocalTime.now(), airports.get(0), airports.get(1));
		flights.add(f1);		
		
		Flight f2 = new Flight("F2", "F2", 39, LocalTime.now(), LocalTime.now(), airports.get(1), airports.get(2));
		flights.add(f2);
		
		return flights;
	}
	
	private List<FlightInstance> createFlightInstaces(Flight flight1, Flight flight2) {
		
		List<FlightInstance> res = new ArrayList<FlightInstance>();		
		
		FlightInstance f1 = new FlightInstance("FI1", flight1, LocalDate.now());
		res.add(f1);
		
		
		FlightInstance f2 = new FlightInstance("FI2", flight2, LocalDate.now());
		res.add(f2);
		
		return res;
	}
	
	
	private List<Pilot> createPilots() {		
		List<Pilot> pilots = new ArrayList<Pilot>();
		
		Pilot pilot1 = new Pilot("P1", "P1", "P1", "p1@gmail.com", LocalDate.now(), getRandomAdress(), 56.41f);
		pilots.add(pilot1);
		
		Pilot pilot2 = new Pilot("P2", "P2", "P2", "p2@gmail.com", LocalDate.now(), getRandomAdress(), 56.41f);
		pilots.add(pilot2);
		
		Pilot pilot3 = new Pilot("P3", "P3", "P3", "p3@gmail.com", LocalDate.now(), getRandomAdress(), 56.41f);
		pilots.add(pilot3);
		
		Pilot pilot4 = new Pilot("P4", "P4", "P4", "p4@gmail.com", LocalDate.now(), getRandomAdress(), 56.41f);
		pilots.add(pilot4);
		
		
		return pilots;
	}
	
	
	private List<Crew> createCrews() {		
		List<Crew> res = new ArrayList<Crew>();
		
		Crew o1 = new Crew("P1", "P1", "P1", "p1@gmail.com", LocalDate.now(), getRandomAdress(), 56.41f);
		res.add(o1);
		
		Crew o2 = new Crew("P2", "P2", "P2", "p2@gmail.com", LocalDate.now(), getRandomAdress(), 56.41f);
		res.add(o2);
		
		Crew o3 = new Crew("P3", "P3", "P3", "p3@gmail.com", LocalDate.now(), getRandomAdress(), 56.41f);
		res.add(o3);
		
		Crew o4 = new Crew("P4", "P4", "P4", "p4@gmail.com", LocalDate.now(), getRandomAdress(), 56.41f);
		res.add(o4);
		
		return res;
	}
	
	
	private List<Agent> createAgents() {		
		List<Agent> res = new ArrayList<Agent>();
		
		Agent o1 = new Agent("Agent1", "Agent1", "Agent1", "Agent1@gmail.com", LocalDate.now(), getRandomAdress());
		res.add(o1);
		
		Agent o2 = new Agent("Agent2", "Agent2", "Agent2", "Agent2@gmail.com", LocalDate.now(), getRandomAdress());
		res.add(o2);
		
		Agent o3 = new Agent("Agent3", "Agent3", "Agent3", "Agent3@gmail.com", LocalDate.now(), getRandomAdress());
		res.add(o3);
		
		Agent o4 = new Agent("Agent4", "PAgent4", "Agent4", "Agent4@gmail.com", LocalDate.now(), getRandomAdress());
		res.add(o4);
		
		return res;
	}
	
	
	private List<Reservation> createReservations() {	
		List<Reservation> res = new ArrayList<Reservation>();
		
		Reservation reservation1 = new Reservation();
		res.add(reservation1);
		
		Reservation reservation2 = new Reservation();
		res.add(reservation2);
		
		return res;
	}
	
	private List<Passenger> createPassengers() {		
		List<Passenger> res = new ArrayList<Passenger>();
		
		Passenger o1 = new Passenger("Passenger1", "Pass1", "Pass1", "pass1@gmail.com", LocalDate.now(), getRandomAdress());
		res.add(o1);
		
		Passenger o2 = new Passenger("Passenger2", "Pass2", "Pass2", "pass2@gmail.com", LocalDate.now(), getRandomAdress());
		res.add(o2);
		
		Passenger o3 = new Passenger("Passenger3", "Pass3", "Pass3", "pass3@gmail.com", LocalDate.now(), getRandomAdress());
		res.add(o3);
		
		Passenger o4 = new Passenger("Passenger4", "Pass4", "Pass4", "pass4@gmail.com", LocalDate.now(), getRandomAdress());
		res.add(o4);
		
		return res;
	}
	
	
	private List<Ticket> createTickets(List<Passenger> passengers) {
		List<Ticket> tickets = new ArrayList<Ticket>();
		for (Passenger p : passengers) {
			Ticket ticket = new Ticket(p);
			tickets.add(ticket);
		}
		
		return tickets;
	}
	
	
	
	private Address getRandomAdress() {
		return new Address(getRandomString(), getRandomString(), getRandomString(), getRandomString(), getRandomString());
	}
	
	private static String getRandomString() 
    { 
  
        // chose a Character random from this String 
        String AlphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
                                    + "abcdefghijklmnopqrstuvxyz"; 
  
        // create StringBuffer size of AlphaNumericString 
        StringBuilder sb = new StringBuilder(5); 
  
        for (int i = 0; i < 5; i++) { 
  
            // generate a random number between 
            // 0 to AlphaNumericString variable length 
            int index 
                = (int)(AlphaNumericString.length() 
                        * Math.random()); 
  
            // add Character one by one in end of sb 
            sb.append(AlphaNumericString 
                          .charAt(index)); 
        } 
  
        return sb.toString(); 
    }
/*Eunice*/
	
	public List<Airline> getAirlines() {
		return _airlines;
	}

	public List<Airport> getAirports() {
		return _airports;
	}

	public List<Reservation> getReservations() {
		return _reservations;
	}

	public List<Agent> getAgents() {
		return _agents;
	}

	public List<Passenger> getPassengers() {
		return _passengers;
	}



	 public List<FlightInstance> getFlightInstances() { return _flightInstances; }
	 

	
}














