package org.flight.planner.flightPnanner.api;

import java.util.List;

import org.flight.planner.flightPnanner.exception.FlightNotFoundException;
import org.flight.planner.flightPnanner.model.Flight;
import org.flight.planner.flightPnanner.service.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FlightAip {

	@Autowired
	FlightService flightService;

	@GetMapping("flights/planner/all-api")
	ResponseEntity<Flight> getAllFlights() {

		List<Flight> flights = flightService.findAll();

		return new ResponseEntity(flights, HttpStatus.OK);
	
	}

	@GetMapping("flights/planner/find-by-departure-/{time}")
	public Flight findByID(@PathVariable String time) {
		Flight flight= flightService.findDepertureTime(time);
		if(flight==null) {
			throw new FlightNotFoundException("DEPARTURE_TIME ="+time);
		}
		return flight;
	}
	
	@GetMapping("flights/planner/all-api/{day}")
	public String findBySunday(@PathVariable String day) {
		return flightService.findBySunday(day);
	}
}
