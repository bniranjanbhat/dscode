package com.code.thread.pingpong;
public class Player implements Runnable{
	PingPong table = null;
	String myOpponent;
	
public Player(String opponent, PingPong table){
	this.table = table;
	myOpponent = opponent;
	
	
	}
	
	
	public void run(){
		while(table.hit(myOpponent)){
			
			
			
			}
		
		
		}
	
	}