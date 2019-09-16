package com.test;

public class Thread3 {

	public static void main(String[] args) {

		Runnable r=()->System.out.println("Thread3 run method :Tread_"+Thread.currentThread().getName());
		new Thread().start();
		new Thread(r,"2").start();
		new Thread(r,"3").start();
		new Thread(r1,"4").start();

	}
	
	static Runnable r1=()->{
		int addResult=0,oldResult=0;
		for(int i=0;i<1000;i++) {
			if(i%2==0)
				addResult+=i;
			else 
				oldResult +=i;
		}
		System.out.println("old Sum "+Thread.currentThread().getName()+"  :"+oldResult);

		System.out.println("Even Sum  "+Thread.currentThread().getName()+" :"+addResult);
	};

}
