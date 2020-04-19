package com.firstgroupapp.aktutorial;

import java.time.Duration;
import java.util.Collections;
import java.util.Properties;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.serialization.StringDeserializer;

public class Consumer {

	private static final String BOOTSTRAP_SERVER = "127.0.0.1:9092";

	public static void main(String[] args) {
		Properties prop = new Properties();
		prop.setProperty(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, BOOTSTRAP_SERVER);
		prop.setProperty(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
		prop.setProperty(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());

		prop.setProperty(ConsumerConfig.GROUP_ID_CONFIG, "testing");
		prop.setProperty(ConsumerConfig.ALLOW_AUTO_CREATE_TOPICS_CONFIG, "true");

		KafkaConsumer<String, String> consumer = new KafkaConsumer<String, String>(prop);
		consumer.subscribe(Collections.singleton("conroy"));

		ConsumerRecords<String, String> records = consumer.poll(Duration.ofMillis(100));
		int index = records.count();
		while(true) {
			records.forEach(record->{
				System.out.println(">>> value " + record.value()+" >>> key  "+record.key()+">>> id "+record.offset());
			});
		
		
	}

	}

	private static KafkaConsumer<String, String> clientConsumer() {

		return null;
	}

}