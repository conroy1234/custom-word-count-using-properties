package com.blockindque.practice;

import java.util.concurrent.BlockingQueue;

public class MyBlockingProducer implements Runnable {

	BlockingQueue<Integer> questionQueue = null;
	private int questionNo;

	public MyBlockingProducer(BlockingQueue<Integer> questionQueue) {

		this.questionQueue = questionQueue;
	}

	@Override
	public void run() {
		while(true) {
		synchronized (this) {
			int questionResult= questionNo++;
			try {
				questionQueue.put(questionResult);
				System.out.println("new question producer 1>>>="+questionResult);
			} catch (InterruptedException e) {
				
			}
		}
		}
	}
}
