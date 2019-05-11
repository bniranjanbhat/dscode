package com.code.misc;

public class PassBYReference {
	public static void main(String[] args) {
		A a = new A("First A");
		A b = new A("Second A");
		System.out.println(a);
		System.out.println(b);
		System.out.println("___________________________________");
		swap(a, b);
		System.out.println("____________________________________");
		System.out.println(a);
		System.out.println(b);
	}

	static void swap(A a, A b) {
		A c = new A("");
		c = a;
		c.name = "Inside A";
		System.out.println(c	);
		System.out.println(b);
	}
}

class A {
	String name;

	A(String name) {
		this.name = name;
	}

	public String toString() {
		return this.name;
	}
}
