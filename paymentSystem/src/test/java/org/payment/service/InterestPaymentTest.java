package org.payment.service;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.math.BigDecimal;

import org.junit.jupiter.api.Test;
import org.payment.model.Payment;

class InterestPaymentTest {
	Payment currentPayment = new Payment(20, BigDecimal.valueOf(2.2));
	InterestPayment interestPayment = new InterestPayment(currentPayment);
	private static int PAYMENT_DAY_TOLERANCE = 5;
	private int paymentWithinDays = 5;
	
	/*
	 * the current payment should be todays date
	 * the way the code is written it always return true 
	 * because payment.getDayNumber()-currentPayment.getDayNumber()
	 * will always be 0
	 * we could minus 5 from todays date 
	 * we could declare a second variable initialises to five and do the condition like below
	 */
	@Test
	void updatePayment() {
		assertTrue(interestPayment.updatePayment(currentPayment));		
	}
	
	@Test
	void updatePaymentFixed() {		
		assertFalse(updatePayment(currentPayment));		
	}
	
	
	
	
	public boolean updatePayment(Payment payment) {
		 if (payment.getDayNumber() - paymentWithinDays <= PAYMENT_DAY_TOLERANCE) {
		 this.currentPayment = payment;
			System.out.println(payment.getDayNumber());
		 return true;
		 }
		 return false;
		 }

}
