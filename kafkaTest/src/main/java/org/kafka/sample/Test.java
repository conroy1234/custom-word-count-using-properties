package org.kafka.sample;

import java.util.Properties;

import org.apache.kafka.clients.producer.Callback;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;
import org.apache.kafka.common.serialization.StringSerializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Test {
	private static final String SERVER_HOST = "127.0.0.1:9092";
	static Logger logger = LoggerFactory.getLogger(Test.class);

	public static void main(String[] args) {

		Properties properties = new Properties();

		properties.setProperty(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, SERVER_HOST);
		properties.setProperty(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
		properties.setProperty(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());

		KafkaProducer<String, String> producer = new KafkaProducer<String, String>(properties);

		ProducerRecord<String, String> records = new ProducerRecord<String, String>("first",
				" this is the self executing kafka test");

		producer.send(records, new Callback() {

			@Override
			public void onCompletion(RecordMetadata metadata, Exception exception) {
				if (exception == null) {
					logger.info("offset: " + metadata.offset() + "\n" + " partition: " + metadata.partition() +" \n "+
				"");
				}else {
					logger.error(exception.getMessage());
				}
			}
		});
		producer.flush();
		producer.close();

	}

}
