package com.blockindque.practice;

import java.util.concurrent.BlockingQueue;

public class MyBlockingConsumer2 implements Runnable{
	
	BlockingQueue<Integer> questionQueue = null;
	private int questionNo;

	public MyBlockingConsumer2(BlockingQueue<Integer> questionQueue) {
	
		this.questionQueue = questionQueue;
	}


	@Override
	public void run() {
		while(true) {
		synchronized (this) {
			int questionResult= questionNo++;
			
			try {
				Thread.sleep(5000);				
				System.out.println("answering question consumer two >> ="+questionQueue.take());
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		}
	}

}
