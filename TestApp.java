package com.test;

import java.util.ArrayList;
import java.util.List;

public class TestApp {

	
	public static void main(String[] args) {
		A a =new A();
		A b=a;
		List list=new ArrayList();
		a=null;
		
		System.out.println(list);
		for(int i=0;i<10000000;i++) {
			
			list.add(i);
		}int result=0;
		for(int i=0;i<1000000;i++) {
			result+=(Integer)list.get(i);
		}
		System.out.println("Result   :"+result);
		list=null;
	}

}
class A {
	int i;

	public A() {
		i=10;
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "A [i=" + i + "]";
	}
	
	
}