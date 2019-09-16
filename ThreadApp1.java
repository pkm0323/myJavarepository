package com.test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ThreadApp1 {

	
	
	
	
	
	public static void main(String[] args) {
		ProducerConsumer p=new  ProducerConsumer();
	    int i=0;

		Thread t=new Thread() {
			public void run() {
				    int i=0;
					p.push(i);
			}
		};
		Thread t1=new Thread() {
			public void run() {
				   
					p.pop(i);
			}
		};
		t.start();t1.start();
	}

}

 class ProducerConsumer{
	Lock lock =new ReentrantLock();
	Condition notFull=lock.newCondition();
	Condition notEmpty=lock.newCondition();
	int i=0;List<Integer> list;
	public ProducerConsumer() {
		list=new ArrayList<>();
	}
	public void push(int i) {
		   lock.lock();
			try {
			if(list.size()==10) {
				notEmpty.await();
			}else {
				list.add(i);
				System.out.println("Thread  : "+Thread.currentThread().getName());

				System.out.println("Push     I value  : "+i);
	
				notFull.signal();
			}
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				lock.unlock();
			}
		
	}
	public void pop(int i) {
		   lock.lock();
			try {
				if(list.isEmpty()) {
					notFull.await();
				}else {
					System.out.println("Thread  : "+Thread.currentThread().getName());

					System.out.println("Pop     I value  : "+i);
					list.remove(i);
					notEmpty.signal();
				}
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			finally {
				lock.unlock();
			}
		}
	
}