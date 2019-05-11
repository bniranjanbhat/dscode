package com.code.map;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class TraverseListReverseOrder {
	public static void main(String[] args) {
		LinkedList<String> l = new LinkedList<String>();
		l.add("abc");
		l.add("def");
		l.add("ghi");
		List<String> l1 = new LinkedList<String>();
		l1.add("12");
		l1.add("10");
		l1.add("5");

		l.addAll(l1);// adding all the element of l1 t l
		System.out.println(l);
		System.out.println(l1);

		Iterator i = l.descendingIterator();
		while (i.hasNext()) {
			System.out.println(i.next());
		}

		ListIterator<String> lt = l.listIterator();
		while (lt.hasPrevious()) {
			System.out.println(lt.previous());
		}

	}
}
