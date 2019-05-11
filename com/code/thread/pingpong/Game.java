package com.code.thread.pingpong;
/*
The question related to the code: write a program to print Ping pong, where Ping is printed by one thread and pong is printed
by another thread.
*/

public class Game{
	
	public static void main(String args[]){
		PingPong table = new PingPong();
		Thread alice = new Thread(new Player("PONG", table));
		Thread bob = new Thread(new Player("PING", table));
		
		alice.setName("PING");
		bob.setName("PONG");
		
		alice.start();
		bob.start();
		
		try{
				
				Thread.currentThread().sleep(500);
			}catch(InterruptedException e){}
				
				table.hit("DONE");
		}
	
	}