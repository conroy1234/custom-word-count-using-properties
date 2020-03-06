package org.flight.planner.flightPnanner.service;

import java.util.Collections;
import java.util.List;

import org.flight.planner.flightPnanner.model.Flight;
import org.flight.planner.flightPnanner.repository.FlightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FlightService {

	@Autowired
	FlightRepository flightRepository;

	public List<Flight> findAll() {
		List<Flight> flights = flightRepository.findAll();
		try {
			if (flights.contains(null) || flights.contains("")) {
				flights.removeAll(Collections.singleton(null));
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return flights;
	}

	public Flight findDepertureTime(String depertureTime) {
		return flightRepository.findByDepartureTime(depertureTime);
	}

	public String findBySunday(String day) {
		return flightRepository.findBySunday(day);
	}

}
