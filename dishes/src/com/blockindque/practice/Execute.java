package com.blockindque.practice;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Execute {

	public static void main(String[] args) {
		ExecutorService service = Executors.newFixedThreadPool(10);
		BlockingQueue<Integer> questionQueue = new ArrayBlockingQueue<Integer>(5);
		Runnable ru = new MyBlockingProducer(questionQueue);
		Runnable ru2 = new MyBlockingConsumer(questionQueue);
		service.execute(ru);
		service.execute(ru2);
//		Thread producer = new Thread(new MyBlockingProducer(questionQueue));
//		Thread producer2 = new Thread(new MyBlockingProducer2(questionQueue));
//		Thread consumer = new Thread(new MyBlockingConsumer(questionQueue));
//		Thread consumer2 = new Thread(new MyBlockingConsumer2(questionQueue));
//		producer.start();
//		consumer.start();
//		producer2.start();
//		consumer2.start();
	}

}
