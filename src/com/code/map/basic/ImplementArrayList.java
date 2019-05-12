package com.code.map.basic;

import java.util.Arrays;

public class ImplementArrayList {
	private Object[] element;
	private static final int INITIAL_CAPACITY = 10;
	private int capacity = 0;

	public ImplementArrayList() {
		element = new Object[INITIAL_CAPACITY];
	}

	public int size() {
		return capacity;
	}

	private void increaseListSize() {
		element = Arrays.copyOf(element, element.length * 2);
	}

	public void add(Object ele) {
		if (element.length - capacity <= 5) {
			increaseListSize();
		}
		element[capacity++] = ele;
	}

	public Object get(int index) {
		if (index < capacity) {
			return element[index];
		} else {
			throw new ArrayIndexOutOfBoundsException();
		}
	}

	public Object remove(int index) {
		if (index < capacity) {
			Object obj = element[index];
			int tmp = index;
			element[tmp] = null;
			while (tmp < capacity) {
				element[tmp] = element[index + 1];
				element[tmp + 1] = null;
				tmp++;
			}
			capacity--;
			return obj;

		} else {
			throw new ArrayIndexOutOfBoundsException();
		}

	}

	public static void main(String[] args) {
		ImplementArrayList al = new ImplementArrayList();
		al.add(12);
		al.add(13);
		al.add(14);
		al.add(15);
		System.out.println(al.size());
		System.out.println(al.get(3));
		System.out.println(al.remove(1));
	}
}
