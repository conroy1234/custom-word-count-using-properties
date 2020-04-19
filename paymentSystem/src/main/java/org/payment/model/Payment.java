package org.payment.model;

import java.math.BigDecimal;

public class Payment {
	/**
	 * The number of days after 1/1/1970
	 */
	private long dayNumber;
	private BigDecimal rate;

	public Payment(long dayNumber, BigDecimal rate) {
		this.dayNumber = dayNumber;
		this.rate = rate;
	}

	public long getDayNumber() {
		return dayNumber;
	}

	public void setDayNumber(long dayNumber) {
		this.dayNumber = dayNumber;
	}

	public BigDecimal getRate() {
		return rate;
	}

	public void setRate(BigDecimal rate) {
	 this.rate = rate;
	 }
}
