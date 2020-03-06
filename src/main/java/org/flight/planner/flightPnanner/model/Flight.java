package org.flight.planner.flightPnanner.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "FLIGHT")
public class Flight implements Serializable {

	private static final long serialVersionUID = 384192068590808611L;

	@Id
	private String departureTime;
	private String destination;
	private String destinationAirportIATA;

	private String flightNo;
	private String sunday;
	private String monday;
	private String tuesday;
	private String wednesday;
	private String thursday;
	private String friday;
	private String saturday;

	public Flight() {

	}

	public Flight(String flightNo, String departureTime, String destination, String destinationAirportIATA,
			String sunday, String monday, String tuesday, String wednesday, String thursday, String friday,
			String saturday) {

		this.flightNo = flightNo;
		this.departureTime = departureTime;
		this.destination = destination;
		this.destinationAirportIATA = destinationAirportIATA;
		this.sunday = sunday;
		this.monday = monday;
		this.tuesday = tuesday;
		this.wednesday = wednesday;
		this.thursday = thursday;
		this.friday = friday;
		this.saturday = saturday;
	}

	public String getDepartureTime() {
		return departureTime;
	}

	public void setDepartureTime(String departureTime) {
		this.departureTime = departureTime;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public String getDestinationAirportIATA() {
		return destinationAirportIATA;
	}

	public void setDestinationAirportIATA(String destinationAirportIATA) {
		this.destinationAirportIATA = destinationAirportIATA;
	}

	public String getFlightNo() {
		return flightNo;
	}

	public void setFlightNo(String flightNo) {
		this.flightNo = flightNo;
	}

	public String getSunday() {
		if (this.sunday.isEmpty()) {
			this.setSunday(" ");
		}
		return sunday;
	}

	public void setSunday(String sunday) {
		this.sunday = sunday;
	}

	public String getMonday() {
		if (this.monday.isEmpty()) {
			this.setMonday(" ");
		}
		return monday;
	}

	public void setMonday(String monday) {
		this.monday = monday;
	}

	public String getTuesday() {
		if (this.tuesday.isEmpty()) {
			this.setTuesday(" ");
		}
		return tuesday;
	}

	public void setTuesday(String tuesday) {
		this.tuesday = tuesday;
	}

	public String getWednesday() {
		if (this.wednesday.isEmpty()) {
			this.setWednesday(" ");
		}
		return wednesday;
	}

	public void setWednesday(String wednesday) {
		this.wednesday = wednesday;
	}

	public String getThursday() {
		if (this.thursday.isEmpty()) {
			this.setThursday(" ");
		}
		return thursday;
	}

	public void setThursday(String thursday) {
		this.thursday = thursday;
	}

	public String getFriday() {
		if (this.friday.isEmpty()) {
			this.setFriday(" ");
		}
		return friday;
	}

	public void setFriday(String friday) {
		this.friday = friday;
	}

	public String getSaturday() {
		if (this.saturday.isEmpty()) {
			this.setSaturday(" ");
		}
		return saturday;
	}

	public void setSaturday(String saturday) {
		this.saturday = saturday;
	}

	

	@Override
	public String toString() {
		return "{departureTime :"+ departureTime + ", destination:" + destination + ", destinationAirportIATA:"
				+ destinationAirportIATA + ", flightNo:" + flightNo + ", sunday:" + sunday + ", monday:" + monday
				+ ", tuesday:" + tuesday + ", wednesday:" + wednesday + ", thursday:" + thursday + ", friday:" + friday
				+ ", saturday:" + saturday + "}";
		
		
	}

}
