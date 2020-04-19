package org.kafka.sample;

import java.time.Duration;
import java.util.Collections;
import java.util.Properties;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.serialization.StringDeserializer;

public class KafkaConsumerExample {
	
	private static final String BOOTSTRAP_SERVERS = "127.0.0.1:9092";
	private static final String TOPIC = "first";

	static void runConsumer() throws InterruptedException {
        final KafkaConsumer<String, String> consumer = createConsumer();

        final int giveUp = 5;   int noRecordsCount = 0;

        while (true) {
            final ConsumerRecords<String, String> consumerRecords =
                    consumer.poll(Duration.ofMillis(100));

            if (consumerRecords.count()==0) {
                noRecordsCount++;
                if (noRecordsCount > giveUp) break;
                else continue;
            }

            consumerRecords.forEach(record -> {
                System.out.printf("Consumer Record:(%d, %s, %d, %d)\n",
                        record.key(), record.value(),
                        record.partition(), record.offset());
            });

            consumer.commitAsync();
        }
        consumer.close();
        System.out.println("DONE");
    }
	
	private static KafkaConsumer<String, String> createConsumer() {
	      final Properties props = new Properties();
	      	props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG,BOOTSTRAP_SERVERS);
	      	props.put(ConsumerConfig.GROUP_ID_CONFIG, "KafkaExampleConsumer");
	      	props.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "earliest");
	      	props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
	      	props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());

	      // Create the consumer using props.
	      final KafkaConsumer<String, String> consumer =  new KafkaConsumer<String,String>(props);

	      // Subscribe to the topic.
	      consumer.subscribe(Collections.singletonList(TOPIC));
	      return consumer;
	  }
}