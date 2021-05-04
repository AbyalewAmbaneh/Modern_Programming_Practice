package object;

import java.util.List;

public class AirPortFactory {
	
	public static Airport buildAirPort(Airport airport, List<Airline> arilines) {	
		
		airport.setAirlines(arilines);
		for (Airline airline : arilines){
			airline.addAirPort(airport);
		}
		
		return airport;
	}
}
