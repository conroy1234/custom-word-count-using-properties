package org.payment.service;

import java.math.BigDecimal;

import org.payment.model.Trade;

public class TradeParser {

	private static String UNWANTED_VALUES[] = { "p123.34", "v1000", "t1;", ";", "i" };
	private static final String PRICE = UNWANTED_VALUES[0].substring(1);
	private static String TYPE = UNWANTED_VALUES[2].substring(1);

	public static Trade parse(String line) throws Exception {
		Trade trade = new Trade();

		trade.setIsin(extractedIsin(line));
		trade.setType(type());
		trade.setPrice(new BigDecimal(PRICE));
		System.out.println(trade.getIsin());

		if (!trade.getPrice().equals(PRICE) && !trade.getType().equals(1)) {
			throw new RuntimeException("onpopulated trade ");
		}
		return trade;
	}

	private static int type() {
		String type = TYPE.replaceAll(";", "");
		System.out.println(type);
		return Integer.valueOf(type);

	}

	private static String extractedIsin(String line) {

		String replacement = line.replaceAll(UNWANTED_VALUES[0], "");
		replacement = replacement.replaceAll(UNWANTED_VALUES[1], "");
		replacement = replacement.replaceAll(UNWANTED_VALUES[2], "");
		replacement = replacement.replaceAll(UNWANTED_VALUES[3], "");
		replacement = replacement.replaceAll(UNWANTED_VALUES[4], "");

		return replacement;
	}

}
