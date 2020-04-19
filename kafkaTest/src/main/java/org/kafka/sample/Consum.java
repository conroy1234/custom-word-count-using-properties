package org.kafka.sample;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Consum {

	private static final String BOOTSTRAP_SERVER = "127.0.0.1:9092";
	static Logger logger = LoggerFactory.getLogger(Consum.class);

	public static void main(String[] args) throws InterruptedException {
		
		KafkaConsumerExample.runConsumer();
	}

}
