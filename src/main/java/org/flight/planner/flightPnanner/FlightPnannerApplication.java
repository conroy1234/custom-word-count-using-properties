package org.flight.planner.flightPnanner;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import org.flight.planner.flightPnanner.model.Flight;
import org.flight.planner.flightPnanner.repository.FlightRepository;
import org.flight.planner.util.FlightUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FlightPnannerApplication implements CommandLineRunner {

	@Autowired
	FlightRepository flightRepository;

	
	String csvFile = "flightDataTest.csv";
	
	public static void main(String[] args) {
		SpringApplication.run(FlightPnannerApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		save();
	}

	public Flight save() {
		Flight model = new Flight();

		String line = "";

		try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {

			while ((line = br.readLine()) != null) {
				String[] country = line.split(",");

				Flight flight = FlightUtil.flightPlanner(model, country);
				
				flightRepository.save(flight);

				System.out.println(flight);
			}

		} catch (IOException e) {
			System.out.println("end of file");
		}
		System.out.println(model);
		return model;

	}

}
