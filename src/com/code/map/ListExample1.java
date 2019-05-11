package com.code.map;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import org.junit.Test;

public class ListExample1 {
	@Test
	// convert array to List
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

	@Test
	// list to array.
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
