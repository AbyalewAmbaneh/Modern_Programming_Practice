package object;

import java.util.List;

public class FlightInstanceFactory {
	
	public static FlightInstance buildAFlightInstance(
            FlightInstance flightInstance,
           
            List<Pilot> pilots,
            List<Crew> crew
            ) {
       
        flightInstance.setPilot(pilots);
        for (Pilot pilot : pilots) {
            pilot.addFlightInstance(flightInstance);
        }
       
        flightInstance.setCrew(crew);   
        for (Crew c : crew) {
            c.addFlightInstance(flightInstance);
        }
       
        return flightInstance;
    }
}
