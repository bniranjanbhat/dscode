package com.code.map.basic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;


public class ListExample1 {
	/*
	 * This method shows how to convert an array to a list
	 * It also uses the ListIterator which is an improvement over Iterator.
	 * Iterator can traverse the elements in a collection only in forward direction.
	 * ListIterator can traverse the elements in a collection in forward as well as the backwards direction.
	 * ListIterator can modify the elements in a collection using set().
	 */
	public void test1() {
		Integer[] arr = new Integer[10];
		for (int i = 0; i < 10; i++) {
			arr[i] = i;
		}
		List<Integer> list = Arrays.asList(arr);
		System.out.println(list);

		Iterator<Integer> it = list.iterator();
		while (it.hasNext()) {
			System.out.println(it.next());
		}

		ListIterator<Integer> list_it = list.listIterator();
		while (list_it.hasNext()) {
			System.out.println(list_it.next());
		}

	}

	public void test2() {
		List<String> li = new ArrayList<String>();
		li.add("Hi");
		li.add("Hello");
		li.add("how");
		li.add(0, "Hi:");
		System.out.println(li);

		String[] str = li.toArray(new String[0]);
		System.out.println(str.length);
		for (String s : str) {
			System.out.println(s);
		}

	}
}
