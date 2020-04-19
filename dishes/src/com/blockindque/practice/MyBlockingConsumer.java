package com.blockindque.practice;

import java.util.concurrent.BlockingQueue;

public class MyBlockingConsumer implements Runnable{
	
	BlockingQueue<Integer> questionQueue = null;
	private int questionNo;

	public MyBlockingConsumer(BlockingQueue<Integer> questionQueue) {
	
		this.questionQueue = questionQueue;
	}


	@Override
	public void run() {
		while(true) {
		synchronized (this) {
			int questionResult= questionNo++;
			
			try {
				Thread.sleep(5000);				
				System.out.println("answering question consumer 0ne >>> ="+questionQueue.take());
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		}
	}

}
