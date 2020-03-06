package org.flight.planner.util;

import org.flight.planner.flightPnanner.model.Flight;


public class FlightUtil {
	public static Flight flightPlanner(Flight flight, String[] country) {
		
		flight.setDepartureTime(country[0]);
		flight.setDestination(country[1]);
		flight.setDestinationAirportIATA(country[2]);
		flight.setFlightNo(country[3]);
		flight.setSunday(country[4]);
		flight.setMonday(country[5]);
		flight.setTuesday(country[6]);
		flight.setWednesday(country[7]);
		flight.setThursday(country[8]);
		flight.setFriday(country[9]);
		flight.setSaturday(country[10]);		
		
		
		return flight;
	}

	
	

	
}
