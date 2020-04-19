package com.firstgroupapp.aktutorial;
import java.time.Duration;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicBoolean;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;

public class BasicConsumeLoop implements Runnable {
  private final KafkaConsumer<String, String> consumer;
  private final List<String> topics;
  private final AtomicBoolean shutdown;
  private final CountDownLatch shutdownLatch;

  public BasicConsumeLoop(Properties config, List<String> topics,KafkaConsumer<String, String> consumer) {
    this.consumer = consumer;
    this.topics = topics;
    this.consumer.subscribe(this.topics);
    this.shutdown = new AtomicBoolean(false);
    this.shutdownLatch = new CountDownLatch(1);
    
  }

  public  ConsumerRecord<String, String> process(ConsumerRecord<String, String> record) {
	  System.out.println(record.key());
	  System.out.println(record.value());
	  System.out.println(record.offset());
	return record;
	  
  }

  public void run() {
    try {
      consumer.subscribe(topics);

      while (!shutdown.get()) {
        ConsumerRecords<String, String> records = consumer.poll(Duration.ofMillis(100));
        records.forEach(record -> {
        	process(record);	
        });
      }
    } finally {
      consumer.close();
      shutdownLatch.countDown();
    }
  }

  public void shutdown() throws InterruptedException {
    shutdown.set(true);
    shutdownLatch.await();
  }
}