package org.payment.service;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.math.BigDecimal;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.jupiter.api.Test;
import org.junit.rules.ExpectedException;
import org.payment.model.Trade;

public class TestTradeParser {

	@Rule
	public ExpectedException exceptionRule = ExpectedException.none();

	@Test
	public void testXetra() throws Exception {
		Trade trade = TradeParser.parse("iIT1234567890;t1;p123.34");
		Assert.assertEquals("IT1234567890", trade.getIsin());
		Assert.assertEquals(new Integer(1), trade.getType());
		Assert.assertEquals(new BigDecimal("123.34"), trade.getPrice());
	}

	@Test
	public void testLSE() throws Exception {
		Trade trade = TradeParser.parse("t1;iGB1234567890;p123.34");
		Assert.assertEquals("GB1234567890", trade.getIsin());

		Assert.assertEquals(new Integer(1), trade.getType());
		Assert.assertEquals(new BigDecimal("123.34"), trade.getPrice());
	}

	@Test
	public void testLIFFE() throws Exception {
		Trade trade = TradeParser.parse("t1;iGB1234567890;p123.34;v1000");
		Assert.assertEquals("GB1234567890", trade.getIsin());
		Assert.assertEquals(new Integer(1), trade.getType());
		Assert.assertEquals(new BigDecimal("123.34"), trade.getPrice());
	}

	@Test
	public void testError1() {
		String UNWANTED_VALUES[] = { "p123.34", "v1000", "t2;", ";", "t1" };
		try {

			Trade trade = TradeParser.parse("iGB1234567890;p123.34");

			trade.setPrice(new BigDecimal(UNWANTED_VALUES[0]));
			trade.setType(Integer.valueOf(UNWANTED_VALUES[3]));
			
			assertThat(trade.getType(), is(new NumberFormatException()));
		} catch (Exception e) {

		}

	}

	@Test
	public void testError2() {
		String UNWANTED_VALUES[] = { "p123.34", "v1000", "t1;", ";", "i" };
		try {
			Trade trade = TradeParser.parse("iGB12345678901;p123.34");
			trade.setPrice(new BigDecimal(UNWANTED_VALUES[0]));
			trade.setType(Integer.valueOf(UNWANTED_VALUES[3]));
			assertThat(trade.getType(), is(new NumberFormatException()));
		} catch (Exception e) {
		}
	}

	@Test
	public void testError3() {
		String UNWANTED_VALUES[] = { "p123.34", "v1000", "t2;", ";", "t1" };
		try {
			Trade trade = TradeParser.parse("iGB12345678901;t2;p123.34;t1");
			trade.setPrice(new BigDecimal(UNWANTED_VALUES[0]));
			trade.setType(Integer.valueOf(UNWANTED_VALUES[3]));
			assertThat(trade.getPrice(), is(new NumberFormatException()));
		} catch (Exception e) {
		}
	}
}