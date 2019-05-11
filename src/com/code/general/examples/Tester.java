package com.code.general.examples;

import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.HashSet;
import java.util.Set;

public class Tester {
	int i = 0;
	static int j = 5;
	Set s = new HashSet();
	public void testSetter() {
		
	}
	public static void main(String [] args) {
		long l = Long.parseLong("68610922784252");	
//		DatagramSocket soct = new DatagramSocket(8000, InetAddress.getByName("192.168.0.100"));
		Tester t1 = new Tester();
		Tester t2 = new Tester();
		if ( t1 instanceof Object) {
			
		}
		if ( t1 instanceof Tester) {
			
		}
		Class<Tester> t;
//		t.getDeclaredFields();
		
		t1.i = 4;
		t2.i = 7;
		
		System.out.println("T1's i is :"+t1.i);//4
		System.out.println("T2's i is :"+t2.i);//7
		
		System.out.println("T1's j is: "+Tester.j);//5
		System.out.println("T2's j is: "+Tester.j);//5
		
		Tester.j = 50;
		
		System.out.println("T1's j is: "+Tester.j);//5
		System.out.println("T2's j is: "+Tester.j);//50
	}
	
}
