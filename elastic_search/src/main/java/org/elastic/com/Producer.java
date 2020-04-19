package org.elastic.com;

import java.util.Arrays;
import java.util.List;
import java.util.Properties;

import org.apache.kafka.clients.producer.Callback;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;
import org.apache.kafka.common.serialization.StringSerializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Producer {
static Logger logger = LoggerFactory.getLogger(Producer.class);
	public static void main(String[] args) {
		String BOOTSTRAP_SERVER = "127.0.0.1:9092";
		Properties properties = new Properties();

		properties.setProperty(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, BOOTSTRAP_SERVER);
		properties.setProperty(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
		properties.setProperty(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
for(int i=0;i<10;i++) {
		KafkaProducer<String, String> producer = new KafkaProducer<String, String>(properties);
		List<String> list = Arrays.asList("the first message","the second message","the third message","the fourth message");
		for(String str:list) {
		ProducerRecord<String, String> record = new ProducerRecord<String, String>("conroy","id_"+1,str+i);
		producer.send(record, new Callback() {
			
			@Override
			public void onCompletion(RecordMetadata metadata, Exception e) {
				if(e!=null) {
					logger.info(e.getMessage());
				}else {
					logger.info("topic .\n"+ metadata.topic());
					logger.info("partition .\n"+ metadata.partition());
					logger.info("offset .\n"+ metadata.offset());
				}
				
			}
		});
		producer.flush();
		
		}
		
	}

	}
}
