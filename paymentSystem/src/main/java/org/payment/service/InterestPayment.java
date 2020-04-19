package org.payment.service;

import org.payment.model.Payment;

public class InterestPayment {
	 private static int PAYMENT_DAY_TOLERANCE = 5;
	 private Payment currentPayment;

	 public InterestPayment(Payment currentPayment) {
	this.currentPayment = currentPayment;
	 }
	 /**
	 * Update the payment if the new payment is within 5 days of the current payment.
	 *
	 * @param payment
	 * The new payment
	 * @return True if the payment was updated, false otherwise.
	 */
	 public boolean updatePayment(Payment payment) {
	 if (payment.getDayNumber() - currentPayment.getDayNumber() <= PAYMENT_DAY_TOLERANCE) {
	 this.currentPayment = payment;
	 return true;
	 }
	 return false;
	 }
	}