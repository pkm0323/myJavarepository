package com.test;

import java.util.Random;

public class ThreadApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Random random=new Random();

		Runnable  runnable=new Runnable() {
			
			@Override
			public void run() {
				try {
					Thread.sleep(10000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				if(random.nextInt()%2 ==0) {
					System.out.println("Random is a even  "+Thread.currentThread().getName());
				}else {
					System.out.println("Random is a old "+Thread.currentThread().getName());
				}
				
				
			}
		};
		
		Thread t=new Thread(runnable,"T");
		t.setPriority(Thread.MAX_PRIORITY);
		Thread t2=new Thread(runnable,"T2");	
		t.setPriority(Thread.MIN_PRIORITY );

				try {
					
			t2.join();
			//t.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				t.start();t2.start();

		System.out.println(" Main Thread  "+Thread.currentThread().getName());

	}

}

