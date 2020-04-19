package org.kafka.sample;

import java.util.Properties;

import org.apache.kafka.clients.producer.Callback;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;
import org.apache.kafka.common.serialization.StringSerializer;

public class ProduceKafka {

	private static final String BOOTSTRAP_SERVERS ="127.0.0.1:9092";

	public static void main(String[] args) {
		
		Properties properties = new Properties();
		properties.setProperty(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, BOOTSTRAP_SERVERS);
		properties.setProperty(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
		properties.setProperty(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
		
		KafkaProducer<String, String> producer = new KafkaProducer<String, String>(properties);
		ProducerRecord<String, String> record = new ProducerRecord<String, String>("zulhra","hey zulhra how are you");
		producer.send(record, new Callback() {
			
			@Override
			public void onCompletion(RecordMetadata metadata, Exception exception) {
				if(exception ==null) {
					System.out.println(metadata.serializedKeySize());
					System.out.println(metadata.offset());
					System.out.println(metadata.partition());
					System.out.println(metadata.timestamp());
				}else {
					System.out.println(exception.getMessage());
				}
				
			}
		});

		producer.flush();
		producer.close();
	}

}
