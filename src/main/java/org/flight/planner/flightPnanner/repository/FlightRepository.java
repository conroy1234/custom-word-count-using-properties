package org.flight.planner.flightPnanner.repository;

import org.flight.planner.flightPnanner.model.Flight;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FlightRepository extends JpaRepository<Flight, String> {

	String findBySunday(String date);
	Flight findByDepartureTime(String depertureTime);
}
