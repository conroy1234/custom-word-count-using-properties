package org.exc.rev.model;

import java.time.LocalDate;

public class ExceptionProvider {
	private final String message;
	private final LocalDate date;
	private final String description;

	public ExceptionProvider(String message, LocalDate date, String description) {
		this.message = message;
		this.date = date;
		this.description = description;
	}

	public String getMessage() {
		return message;
	}

	public LocalDate getDate() {
		return date;
	}

	public String getDescription() {
		return description;
	}

	@Override
	public String toString() {
		return "ExceptionProvider [message=" + message + ", date=" + date + ", description=" + description + "]";
	}

}
